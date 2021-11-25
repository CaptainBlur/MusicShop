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
        Cart cart = cartTransfer.getParcelable(Cart.class.getSimpleName());

        TextView OrderInfo = findViewById(R.id.textView5);
        OrderInfo.setText("Order Info\n" + cart.UserName +
                "\n" + cart.Item +
                "\n" + cart.ItemsQ +
                "\n" + cart.ItemPrice +
                "\n" + cart.OrderPrice);
        OrderInfo.setTextSize(23);

    }
}