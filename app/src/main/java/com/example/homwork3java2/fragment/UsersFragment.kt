package com.example.homwork3java2.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.homwork3java2.R
import com.example.homwork3java2.adapter.UserAdapter
import com.example.homwork3java2.data.models.User
import com.example.homwork3java2.databinding.FragmentUsersBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class UsersFragment : Fragment() {
    private var _binding: FragmentUsersBinding? = null
    private val binding :FragmentUsersBinding get() = _binding!!
    private val userAdapter = UserAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRequest()
        initialize()
    }

    private fun initialize() {
        binding.rvUsers.adapter = userAdapter
    }

    private fun setupRequest() {
      getUsers().observe(viewLifecycleOwner){users ->
          userAdapter.setUsers(users)
      }

    }

    fun getUsers():LiveData <List <User>>{
        val usersLiveData = MutableLiveData<List<User>>()
        Firebase.firestore.collection("users")
            .get()
            .addOnSuccessListener { queryShapshot ->
                queryShapshot.let {
                    Log.i ("getUsers", "success")
                    val users = mutableListOf<User>()
                    it.toObjects(User::class.java).mapNotNull { user ->
                        users.add(user)
                    }
                    usersLiveData.value = users
                }
            }.addOnFailureListener { e ->
                Log.e("getUsers", e.message ?: "Unknown Error", e)
                e
            }
        return usersLiveData
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}