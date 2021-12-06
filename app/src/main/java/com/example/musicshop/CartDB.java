package com.example.musicshop;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Cart.class}, version = 1)
public abstract class CartDB extends RoomDatabase {
    public abstract CartDao getCartDao(); //Берём Дао и возвращаем его через абстрактный конструктор
}
