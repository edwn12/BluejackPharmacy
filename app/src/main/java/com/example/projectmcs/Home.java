package com.example.projectmcs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Home extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    TransactionFragment transactionFragment = new TransactionFragment();
    int temp = 0;
    ImageView about, logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        about = findViewById(R.id.about);
        logout = findViewById(R.id.logout);

        bottomNavigationView = findViewById(R.id.navigation);



        Intent intent = getIntent();
        temp = intent.getIntExtra("next", 0);

        if (temp == 0){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
        }else {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, transactionFragment).commit();
        }

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.bothome:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                        return true;
                    case R.id.bottrans:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, transactionFragment).commit();
                        return true;
                }
                return false;
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Login.class));
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, AboutUs.class));
            }
        });
    }
}