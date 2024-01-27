package com.example.homwork3java2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homwork3java2.data.NotesModel
import com.example.homwork3java2.databinding.NoteItemBinding
import com.example.homwork3java2.room.entities.Note

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var noteList = listOf<Note>()

    fun setNoteList(noteList: MutableList<NotesModel>) {
        this.noteList
    }

    class NoteViewHolder(private val binding: NoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(notesModel: Note) {
            binding.nate.text = notesModel.descriptor
            binding.tvTitle.text = notesModel.title
//            binding.tvTitleNote.text = notesModel.date.toString() 7
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.onBind(noteList[position])
    }
}