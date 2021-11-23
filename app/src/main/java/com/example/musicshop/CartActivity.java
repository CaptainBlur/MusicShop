package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Intent cartIntent = getIntent();
        Bundle cartTransfer = cartIntent.getExtras();
        Cart cart = new Cart (
                cartTransfer.getString("Person"),
                cartTransfer.getString("SelectedItem"),
                cartTransfer.getInt("Quantity", 999),
                cartTransfer.getInt("ItemPrice", 999),
                cartTransfer.getInt("Price", 999)
        );
        TextView OrderInfo = findViewById(R.id.textView5);
        OrderInfo.setText("Order Info\n" + cartTransfer.getString("Person" ) +
                cartTransfer.getString("SelectedItem") +
                cartTransfer.getInt("Quantity", 999) +
                cartTransfer.getInt("ItemPrice", 999) +
                cartTransfer.getInt("Price", 999));
        OrderInfo.setTextSize(23);

    }
}