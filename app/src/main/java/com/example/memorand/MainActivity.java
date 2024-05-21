package com.example.memorand;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;

import com.example.memorand.api.testing;
import com.example.memorand.home.Home;
import com.example.memorand.perfil.Perfil;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String testUserId = "5c38bb7c-026b-471b-8e24-e500cbf69833";
        testing.fetchUserData(testUserId);
        setupToolbar();
        setupDrawer();
        setupButtonListeners();
        if (savedInstanceState == null) {
            replaceFragment(new Home());
            navigationView.setCheckedItem(R.id.nav_inicio);
        }
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
    }

    private void setupDrawer() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }


    private void setupButtonListeners() {
        ImageButton memorandButton = findViewById(R.id.TBMemorand);
        memorandButton.setOnClickListener(v -> replaceFragment(new Home()));

        ImageButton usuarioButton = findViewById(R.id.TBUsuario);
        usuarioButton.setOnClickListener(v -> replaceFragment(new Perfil()));

        ImageButton headerButton = navigationView.getHeaderView(0).findViewById(R.id.im_usuario_hamburguesa);
        headerButton.setOnClickListener(v -> {
            replaceFragment(new Perfil());
            drawerLayout.closeDrawer(GravityCompat.START);
        });
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_inicio) {
            replaceFragment(new Home());
        }else if (id == R.id.nav_equipos) {
            replaceFragment(new Home());
        }else if (id == R.id.nav_settings) {
            replaceFragment(new Configuracion());
        }else if (id == R.id.nav_logout) {
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            finish();        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}