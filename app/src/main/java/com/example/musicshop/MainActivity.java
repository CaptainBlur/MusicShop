package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    ArrayList <String> Items;
    HashMap <String, Integer> Goods;
    ArrayAdapter ItemsAdapter;
    Spinner ItemsSpinner;
    EditText PersonName;
    short quantity = 0;
    String selectedItem;
    int itemPrice;
    int price;
    Cart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        DaggerCartGraph.builder().roomModule(new RoomModule(getApplication())).build();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView priceTV = findViewById(R.id.textView4);
        TextView Quantity = findViewById(R.id.quantityText);
        PersonName = findViewById(R.id.editName);
        Items = new ArrayList();
        Items.add("Guitar");
        Items.add("Cello");
        Items.add("Drums");
        Goods = new HashMap<>();
        Goods.put("Guitar", 100);
        Goods.put("Cello", 80);
        Goods.put("Drums", 120);
        ItemsAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Items);
        ItemsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ItemsSpinner = findViewById(R.id.ItemsList);
        ItemsSpinner.setAdapter(ItemsAdapter);
        ItemsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = (String) ItemsSpinner.getSelectedItem();
                itemPrice = Goods.get(selectedItem);
                price = itemPrice * quantity;
                priceTV.setText(price + "$");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                priceTV.setText("empty");

            }
        });

        Button increaseB = findViewById(R.id.button4);
        increaseB.isClickable();
        increaseB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quantity.setText("" + ++quantity);
                itemPrice = Goods.get(selectedItem);
                price = itemPrice * quantity;
                priceTV.setText(price + "$");

            }
        });

        Button decreaseB = findViewById(R.id.button2);
        decreaseB.isClickable();
        decreaseB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 0) Quantity.setText("" + --quantity);
                itemPrice = Goods.get(selectedItem);
                price = itemPrice * quantity;
                priceTV.setText(price + "$");
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {

    }

    public void addToCart(View view) {
        cart = new Cart (PersonName.getText().toString(), ItemsSpinner.getSelectedItem().toString(), quantity, itemPrice, price);
        Intent cartIntent = new Intent();
        ComponentName CartActivity = new ComponentName("com.example.musicshop", "com.example.musicshop.CartActivity");
        cartIntent.setComponent(CartActivity);
        cartIntent.putExtra (Cart.class.getSimpleName(), cart); // обращение к конструктору (класса class), который возвращает имя класса
        startActivity(cartIntent);                              // так как все интерфейсы и методы уже имплементированы в Cart, метод putExtra берёт название класса, его экземпляр, а
                                                                // методы автоматически создают экхемпляр Parcelable и записывают в него нужные данные для передачи

    }
}