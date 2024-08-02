package com.codmari.noter.data_access

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.codmari.noter.entities.Note
import kotlinx.coroutines.flow.Flow
import androidx.room.*

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM Note WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?

    @Query("SELECT * FROM Note ORDER BY createdAt DESC")
    fun getAllNotes(): Flow<List<Note>>

}