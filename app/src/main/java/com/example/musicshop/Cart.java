package com.example.musicshop;

import android.util.Log;

public class Cart {

    private String UserName;
    private String Item;
    private int ItemsQ;
    private int ItemPrice;
    private int OrderPrice;

    Cart (String user, String item, int quantity, int itemPprice, int price) {

        this.UserName = user;
        this.Item = item;
        this.ItemsQ = quantity;
        this.ItemPrice = itemPprice;
        this.OrderPrice = price;

    }


}
