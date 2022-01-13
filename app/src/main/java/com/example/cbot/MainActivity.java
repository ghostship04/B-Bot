package com.example.cbot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import android.view.MenuItem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    private Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();

        click = findViewById(R.id.btnToggleDark);

        navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case  R.id.nav_home:

                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_Aboutus:
                        Intent intent1 = new Intent(MainActivity.this , Aboutus.class);

                        startActivity(intent1);
                        break;
                    case R.id.nav_Settings:
                        Intent intent2 = new Intent(MainActivity.this , SettingsPage.class);

                        startActivity(intent2);
                        break;
                    case R.id.nav_Login:
                        Intent intent3 = new Intent(Intent.ACTION_VIEW);
                        intent3.setData(Uri.parse("https://webcampus.bmsce.in/"));
                        startActivity(intent3);
                        break;

                    case R.id.nav_info:
                        Intent intent4 = new Intent(MainActivity.this , LoginPage.class);

                        startActivity(intent4);
                        break;

                }
                return false;
            }
        });

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainBot.class));
            }
        });



    }

    public void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));
        actionBarDrawerToggle.syncState();

    }
}