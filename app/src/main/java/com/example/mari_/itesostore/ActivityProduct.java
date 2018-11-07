package com.example.mari_.itesostore;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.mari_.itesostore.beans.ItemProduct;

public class ActivityProduct extends Activity {
    EditText title;
    EditText store;
    EditText location;
    EditText phone;
    Button guardar;
    Button cancel;
    ImageView image;

    ItemProduct itemProduct = new ItemProduct();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        image = findViewById(R.id.item_product_image);
        title = findViewById(R.id.item_product_edit_text_brand);
        store = findViewById(R.id.item_product_edit_text_store);
        location = findViewById(R.id.item_product_edit_text_location);
        phone = findViewById(R.id.item_product_edit_text_phone);
        guardar = findViewById(R.id.item_product_button_save);
        cancel = findViewById(R.id.item_product_button_cancel);

        if(getIntent().getExtras() != null){
            itemProduct = getIntent().getParcelableExtra("ITEM");
            if(itemProduct.getImage() == 0){
                image.setImageResource(R.drawable.mac);
            }else{
                image.setImageResource(R.drawable.alienware);
            }
        }
        Log.e("AUX","Estoy guardando algo");
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("AUX","Estoy guardando algo");
                itemProduct.setTitle(title.getText().toString());
                itemProduct.setStore(store.getText().toString());
                itemProduct.setLocation(location.getText().toString());
                itemProduct.setPhone(phone.getText().toString());
                Intent intent = new Intent(view.getContext(), ActivityMain.class);
                intent.putExtra("ITEM", itemProduct);
                startActivity(intent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ActivityMain.class);
                startActivity(intent);
            }
        });
    }
}
