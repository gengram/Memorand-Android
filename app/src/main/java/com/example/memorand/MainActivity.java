package com.example.memorand;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.memorand.Ideas.CrearIdeas;
import com.example.memorand.Ideas.Ideas;
import com.example.memorand.lienzo.Lienzo;
import com.example.memorand.notas.CrearNotas;
import com.example.memorand.notas.Notas;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigationrail.NavigationRailView;
import com.example.memorand.api.testing;

public class MainActivity extends AppCompatActivity {

    // Views

    FloatingActionButton fab;
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    NavigationRailView navigationRail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String testUserId = "5c38bb7c-026b-471b-8e24-e500cbf69833";
        testing.fetchUserData(testUserId);

        // Initializing views
        initViews();

        // Setup toolbar
        setupToolbar();

        // Set default fragment
        if (savedInstanceState == null) {
            replaceFragment(new Tareas());
        }

        NavigationRailView navigationRail = findViewById(R.id.navigation_rail);
        // Bottom navigation item selection listener
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnItemSelectedListener(this::onBottomNavigationItemSelected);

        // FAB click listener
        fab.setOnClickListener(this::showBottomDialog);


        // Toolbar buttons click listeners
        findViewById(R.id.toolbarButtonmemorand).setOnClickListener(v -> replaceFragment(new Home()));
        findViewById(R.id.toolbarButton).setOnClickListener(v -> {
            if (navigationRail.getVisibility() == View.VISIBLE) {
                navigationRail.setVisibility(View.GONE);
            } else {
                navigationRail.setVisibility(View.VISIBLE);
            }
        });

        ((NavigationView) findViewById(R.id.nav_view)).setNavigationItemSelectedListener(this::onNavigationItemSelected);

        View headerView = ((NavigationView) findViewById(R.id.nav_view)).getHeaderView(0);
        ImageButton headerButton = headerView.findViewById(R.id.im_usuario_hamburguesa);
        headerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new Perfil());
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        navigationRail.setOnItemSelectedListener(new NavigationRailView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation item selection here
                int itemId = item.getItemId();
                Fragment fragment = null;
                if (itemId == R.id.perfilrail) {
                    fragment = new Perfil();
                } else if (itemId == R.id.idearail) {
                    fragment = new Ideas();
                }else if (itemId == R.id.notarail) {
                    fragment = new Notas();
                }else if (itemId == R.id.lienzorail) {
                    fragment = new Lienzo();
                }
                if (fragment != null) {
                    replaceFragment(fragment);
                    navigationRail.setVisibility(View.GONE);
                    return true;
                }
                return false;
            }
        });
    }

    // Initializing views
    private void initViews() {
        fab = findViewById(R.id.fab);
        drawerLayout = findViewById(R.id.drawer_layout);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
    }

    // Setup toolbar
    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Drawable drawable = getResources().getDrawable(R.drawable.ic_menu);
        drawable.setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
    }

    // Bottom navigation item selection listener
    private boolean onBottomNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        int itemId = item.getItemId();
        if (itemId == R.id.tareas) {
            fragment = new Tareas();
        } else if (itemId == R.id.publicaciones) {
            fragment = new PublicacionesFragment();
        } else if (itemId == R.id.personas) {
            fragment = new PersonasFragment();
        }
        replaceFragment(fragment);
        return true;
    }

    // FAB click listener
    private void showBottomDialog(View view) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

        dialog.findViewById(R.id.layoutIdea).setOnClickListener(v -> {replaceFragment(new CrearIdeas());
            dialog.dismiss();});

        dialog.findViewById(R.id.layoutNotas).setOnClickListener(v -> {replaceFragment(new CrearNotas());
            dialog.dismiss();});

        dialog.findViewById(R.id.layoutLienzo).setOnClickListener(v -> { replaceFragment(new Lienzo());
            dialog.dismiss();});

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }


    // Navigation item selection listener
    private boolean onNavigationItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.nav_inicio) {
            replaceFragment(new Home());
        }else if (id == R.id.nav_equipos) {
            replaceFragment(new Equipos());
        }else if (id == R.id.nav_settings) {
            replaceFragment(new Configuracion());
        }else if (id == R.id.nav_logout) {
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            finish();        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    // Start main activity method
    private void startMainActivity() {
        startActivity(new Intent(MainActivity.this, MainActivity.class));
    }

    // Fragment replacement method
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }


}