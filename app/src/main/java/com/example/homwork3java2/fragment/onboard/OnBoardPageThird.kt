package com.example.homwork3java2.fragment.onboard

import android.app.backup.SharedPreferencesBackupHelper
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homwork3java2.R
import com.example.homwork3java2.databinding.FragmentOnBoardPageThirdBinding
import com.example.homwork3java2.utlis.PreferencesHelper
import java.util.prefs.Preferences

class OnBoardPageThird : Fragment(R.layout.fragment_on_board_page_third) {

    private var _binding: FragmentOnBoardPageThirdBinding? = null
    private val binding get() = _binding!!
    private val preferencesHelper: PreferencesHelper by lazy {
        PreferencesHelper(context ?: requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardPageThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onStartClick()
    }

    private fun onStartClick() {
        binding.start.setOnClickListener {
            preferencesHelper.isShownOnBoard = true
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}