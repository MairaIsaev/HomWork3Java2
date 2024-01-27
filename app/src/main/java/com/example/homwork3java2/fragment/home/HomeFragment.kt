package com.example.homwork3java2.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homwork3java2.data.NotesModel
import com.example.homwork3java2.R
import com.example.homwork3java2.adapter.NoteAdapter
import com.example.homwork3java2.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!
    private val noteAdapter = NoteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializ()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initializ() {
        noteAdapter.setNoteList(
            mutableListOf(
                NotesModel("Title", "Note", "Data \n time"),
                NotesModel("Title", "Note", "Data \n time"),
                NotesModel("Title", "Note", "Data \n time")
            )
        )
        binding.rvNotes.adapter = noteAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    }

