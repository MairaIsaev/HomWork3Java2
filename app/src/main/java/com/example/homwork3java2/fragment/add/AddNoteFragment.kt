package com.example.homwork3java2.fragment.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homwork3java2.App
import com.example.homwork3java2.R
import com.example.homwork3java2.databinding.FragmentAddNoteBinding
import com.example.homwork3java2.room.entities.Note
import java.util.Calendar
import java.util.Date

class AddNoteFragment : Fragment() {

    private var _binding: FragmentAddNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addNoteToRoom()

    }
    private fun addNoteToRoom() = with(binding){
        btnNote.setOnClickListener{
            val title = etTitle.text.toString().trim()
            val declaration = etDesription.text.toString().trim()
            val date = Calendar.getInstance().time

            val note = Note(
                title = title,
                descriptor = declaration,
                date = date
            )

            App.db.nateDao().addNote(note)
            findNavController().navigateUp()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}