package com.example.notesapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.model.Note
import com.example.notesapp.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app: Application, private  val noteRepo:NoteRepository):AndroidViewModel(app) {
    fun addNote(note: Note) =
        viewModelScope.launch {
            noteRepo.insertNote(note)
        }

    fun deleteNote(note: Note) =
        viewModelScope.launch {
            noteRepo.deleteNote(note)
        }
    fun updateNote(note: Note) =
        viewModelScope.launch {
            noteRepo.updateNote(note)
        }

    fun getAllNotes()=noteRepo.getAllNotes()
    fun searchNote(query:String?)=
        noteRepo.searchNote(query)
}