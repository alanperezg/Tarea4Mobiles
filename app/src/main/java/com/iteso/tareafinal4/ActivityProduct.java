package com.iteso.tareafinal4;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.iteso.tareafinal4.beans.ItemProduct;

public class ActivityProduct extends AppCompatActivity{
    ItemProduct product;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ImageView image = findViewById(R.id.activity_product_img);
        final EditText title = findViewById(R.id.activity_product_title);
        final EditText store = findViewById(R.id.activity_product_store);
        final EditText location = findViewById(R.id.activity_product_location);
        final EditText phone = findViewById(R.id.activity_product_phone);
        final Button saveBtn = findViewById(R.id.activity_product_save);
        final Button cancelBtn = findViewById(R.id.activity_product_cancel);
        if(getIntent()!=null){
            product = getIntent().getParcelableExtra("PRODUCTO");
            switch (product.getImage()){
                case 0:
                    image.setImageResource(R.drawable.mac);
                    break;
                case 1:
                    image.setImageResource(R.drawable.alienware);
                    break;
            }
            title.setText(product.getTitle());
            store.setText(product.getStore());
            location.setText(product.getLocation());
            phone.setText(product.getPhone());
        }
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                ItemProduct newproducto = new ItemProduct();
                newproducto.setCode(product.getCode());
                newproducto.setImage(product.getImage());
                newproducto.setTitle(title.getText().toString());
                newproducto.setStore(store.getText().toString());
                newproducto.setLocation(location.getText().toString());
                newproducto.setPhone(phone.getText().toString());
                data.putExtra("PRODUCTO", newproducto);
                setResult(RESULT_OK, data);
                finish();
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }

}
