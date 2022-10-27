package com.mdp.musikkita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView nav_musik;
    private ActionBar judulbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        judulbar = getSupportActionBar();
        judulbar.setTitle("Music");
        bukafrag(new musik_fragment());

        nav_musik = findViewById(R.id.nav_musik);
        nav_musik.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment FRG;
                switch(item.getItemId()){
                    case R.id.m_musik :
                        bukafrag(new musik_fragment());
                        judulbar.setTitle("Music");
                        return true;
                        case R.id.m_album:
                            bukafrag(new albumfragment());
                            judulbar.setTitle("Album");
                            return true;
                            case R.id.m_grup:
                                bukafrag(new artistfragment());
                                judulbar.setTitle("Artist");
                                return true;
                }
                return false;
            }
        });
    }
    private void bukafrag(Fragment FRG){
        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        FT.replace(R.id.f_container, FRG);
        FT.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_atas, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.m_about)
        {
            startActivity(new Intent(MainActivity.this, aboutActivity.class));
            judulbar.setTitle("About");
        }
        else if(item.getItemId() == R.id.m_help)
        {
            startActivity(new Intent(MainActivity.this,helpActivity.class));
            judulbar.setTitle(("Help"));
        }
        return super.onOptionsItemSelected(item);
    }
}