package com.example.projectmcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MedsDetail extends AppCompatActivity {
    private TextView namaObat,manufaktur,hargaObat, detailObat;
    private ImageView gambarObat,back;

    private String yNama, yManufaktur, yHargaObat, yDetailObat, price;
    private EditText qty;

    private Button buy;
    private int yGambarObat;

    private int harga, quantity;
    static ArrayList<TransSG> TransData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meds_detail);

        back = findViewById(R.id.back);
        namaObat = findViewById(R.id.nameObat);
        manufaktur = findViewById(R.id.manufcObat);
        hargaObat = findViewById(R.id.priceObat);
        detailObat = findViewById(R.id.descObat);
        gambarObat = findViewById(R.id.picObat);
        buy = findViewById(R.id.buy);
        qty = findViewById(R.id.qty);

        Intent intent = getIntent();
        yNama = intent.getStringExtra("xNamaObat");
        yManufaktur = intent.getStringExtra("Manufaktur");
        yGambarObat = intent.getIntExtra("xGambarObat",0);
        yHargaObat = intent.getStringExtra("xHargaObat");
        yDetailObat = intent.getStringExtra("xDetailObat");

        namaObat.setText(yNama);
        manufaktur.setText(yManufaktur);
        hargaObat.setText(yHargaObat);
        gambarObat.setImageResource(yGambarObat);
        detailObat.setText(yDetailObat);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(qty.getText().toString())){
                    Toast.makeText(MedsDetail.this, "Quantity must be filled", Toast.LENGTH_SHORT).show();
                }

                if (Integer.parseInt(qty.getText().toString())<1){
                    Toast.makeText(MedsDetail.this, "Quantity must be more than 0", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intentz = new Intent(getBaseContext(), Home.class);
                    intentz.putExtra("next", 1);
                    startActivity(intentz);
                }
                harga = Integer.parseInt(yHargaObat);
                quantity = Integer.parseInt(qty.getText().toString());
                price = String.valueOf(harga*quantity);

                DateFormat dateFormat = new SimpleDateFormat("dd MM yyyy - HH:mm");
                Calendar calendar = Calendar.getInstance();

                TransData.add(new TransSG(yNama,price, dateFormat.format(calendar.getTime()), qty.getText().toString(), yGambarObat));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}