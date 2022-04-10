package com.example.tp6

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface CharactersDao {
    @Query("SELECT * FROM characters")
    fun getAll(): List<Characters>

    @Insert
    fun insertAll(vararg characters: Characters)
}