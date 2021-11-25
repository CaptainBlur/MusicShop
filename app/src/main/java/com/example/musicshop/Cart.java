package com.example.musicshop;

import android.util.Log;
import android.os.Parcel;
import android.os.Parcelable;

public class Cart implements Parcelable {

    String UserName;
    String Item;
    int ItemsQ;
    int ItemPrice;
    int OrderPrice;

    public static final Creator<Cart> CREATOR = new Creator<Cart>() {
        @Override
        public Cart createFromParcel(Parcel source) {
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(UserName);
        dest.writeString(Item);
        dest.writeInt(ItemsQ);
        dest.writeInt(ItemPrice);
        dest.writeInt(OrderPrice);

    }
}
