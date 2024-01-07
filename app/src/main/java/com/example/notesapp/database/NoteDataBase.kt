package com.example.notesapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesapp.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDataBase :RoomDatabase() {

    abstract fun getNoteDao() :NoteDao

    companion object{
        @Volatile
        private  var instance: NoteDataBase?=null
        private  val LOCK = Any()

        operator  fun invoke(context: Context) = instance ?:
        synchronized(LOCK){
            instance ?:
            createDatabase(context).also{
                instance = it
            }
        }

        private fun createDatabase(context: Context)=
            Room.databaseBuilder(
                context.applicationContext,
                NoteDataBase::class.java,
                name = "note_db"
            ).build()
    }
}