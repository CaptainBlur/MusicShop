package com.example.musicshop;

import static androidx.room.OnConflictStrategy.REPLACE;

import android.util.Log;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.RoomDatabase;
import androidx.room.Update;

import java.util.List;

@Entity //создаём Сущность (таблицу) для базы данных, не отходя от кассы
public class Cart implements Parcelable { // Parcelable - это интерфейс для классов, чьи экземпляры могет быть записаны и восстановленны

    @PrimaryKey int id;
    String UserName;
    String Item;
    int ItemsQ;
    int ItemPrice;
    int OrderPrice;

    public static final Parcelable.Creator<Cart> CREATOR = new Parcelable.Creator<Cart>() { // интерфейс, который небоходимо имплементировать
        @Override                                                                           // Он создаёт экземпляр моего класса Parcelable из Parcel
        public Cart createFromParcel(Parcel source) { // source - объект, из которого считывать информацию (мы имплементировали  Parcel в Cart)
            String UserName = source.readString();
            String Item = source.readString();
            int ItemsQ = source.readInt();
            int ItemPrice = source.readInt();
            int OrderPrice = source.readInt();
            return new Cart (UserName, Item, ItemsQ, ItemPrice, OrderPrice);
        }

        @Override
        public Cart[] newArray(int size) {
            return new Cart[size];
        }
    };

    Cart (String user, String item, int quantity, int itemPrice, int price) { //constructor

        this.UserName = user;
        this.Item = item;
        this.ItemsQ = quantity;
        this.ItemPrice = itemPrice;
        this.OrderPrice = price;

    }
    Cart (){}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) { // метод интерфейса Parcelable, который берёт данные полей класса Cart и записывает их в экземпляр Parcel (dest)
        dest.writeString(UserName);
        dest.writeString(Item);
        dest.writeInt(ItemsQ);
        dest.writeInt(ItemPrice);
        dest.writeInt(OrderPrice);

    }
}