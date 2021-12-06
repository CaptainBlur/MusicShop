package com.example.musicshop;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

    @Dao
    public interface CartDao {
        @Query("SELECT * FROM cart") // пишем название таблицы со строчной буквы, потому что в sqlite не важен регистр
        List<Cart> getAll (); //List - возвращаемое значение функции

        @Query ("SELECT * FROM cart WHERE id = :id")
        Cart getById (int id);

        @Insert
        void insert (Cart cart);

        @Update
        void update (Cart cart);

        @Delete
        void delete (Cart cart);
    }
