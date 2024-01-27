package com.example.homwork3java2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homwork3java2.R
import com.example.homwork3java2.databinding.FragmentNoteOnBinding

class NoteOnFragment : Fragment(R.layout.fragment_note_on) {

    private var _binding: FragmentNoteOnBinding? = null
    private val binding: FragmentNoteOnBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteOnBinding.inflate(inflater, container, false)
        return binding.root
    }
}