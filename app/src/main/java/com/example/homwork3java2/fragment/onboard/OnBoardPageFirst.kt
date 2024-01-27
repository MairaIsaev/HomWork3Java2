package com.example.homwork3java2.fragment.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homwork3java2.R
import com.example.homwork3java2.databinding.FragmentOnBoardPageFirstBinding


class OnBoardPageFirst : Fragment(R.layout.fragment_on_board_page_first) {

    private var _binding: FragmentOnBoardPageFirstBinding? = null
    private val binding: FragmentOnBoardPageFirstBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardPageFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}