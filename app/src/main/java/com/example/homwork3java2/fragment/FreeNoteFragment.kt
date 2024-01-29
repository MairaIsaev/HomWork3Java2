package com.example.homwork3java2.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homwork3java2.R
import com.example.homwork3java2.databinding.FragmentFreeNoteBinding
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.concurrent.TimeUnit

class FreeNoteFragment : Fragment() {

    private var _binding: FragmentFreeNoteBinding? = null
    private val binding: FragmentFreeNoteBinding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    private lateinit var storedVerificationId: String
    private lateinit var resendToken: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFreeNoteBinding.inflate(inflater, container, false)
        return binding.root
        auth = Firebase.auth
        auth.setLanguageCode("ru")
        verifyUserPhoneNumber()
    }
    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            currentUser.reload()
        }
    }
    private fun verifyUserPhoneNumber() = with(binding) {
        binding.btnGetCode.setOnClickListener{
            val phoneNumber = etPhoneNumber.text.toString().trim()
            if (validatePhoneNumber(phoneNumber)) {
                val options = PhoneAuthOptions.newBuilder(auth)
                    .setPhoneNumber(phoneNumber)
                    .setTimeout(60L, TimeUnit.SECONDS)
                    .setActivity(this@FreeNoteFragment.requireActivity())
                    .setCallbacks(callbacks)
                    .build()
                PhoneAuthProvider.verifyPhoneNumber(options)
            }
        }
    }
    private val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            Log.d("success", "onVerificationCompleted:$credential")
            auth.signInWithCredential(credential)
        }

        override fun onVerificationFailed(e: FirebaseException) {
            Log.w("failure", "onVerificationFailed", e)

            if (e is FirebaseAuthInvalidCredentialsException) {
            } else if (e is FirebaseTooManyRequestsException) {
            } else if (e is FirebaseAuthMissingActivityForRecaptchaException) {
            }
        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken,
        ) {
            Log.d("code", "onCodeSent:$verificationId")
            storedVerificationId = verificationId
            resendToken = token.toString()
        }
    }
    private fun validatePhoneNumber(phoneNumber: String) = with(binding) {
        if (phoneNumber.isEmpty()) {
            etPhoneNumber.isEnabled = true
            etPhoneNumber.error = getString(R.string.fill_filet_error_text)
            false
        }else {
            true
        }
    }
}