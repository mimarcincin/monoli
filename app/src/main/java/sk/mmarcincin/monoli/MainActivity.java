package sk.mmarcincin.monoli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import sk.mmarcincin.monoli.adapters.NovenasAdapter;
import sk.mmarcincin.monoli.fragments.MainMenuFragment;
import sk.mmarcincin.monoli.fragments.NovenasListFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigationView;
    NovenasAdapter novenasAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setSelectedItemId(R.id.home_ni);

        MainMenuFragment mainMenuFragment = new MainMenuFragment();
        NovenasListFragment novenasFragment = new NovenasListFragment();
        //novenasAdapter = new NovenasAdapter(new String[]{"novena1", "novena2", "novena3"});

        navigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.home_ni:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, mainMenuFragment).commit();
                    return true;

                case R.id.modlitby_ni:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, mainMenuFragment).commit();
                    return true;

                case R.id.noveny_ni:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, novenasFragment).commit();
                    return true;

                case R.id.litanie_ni:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, mainMenuFragment).commit();
                    return true;
            }

            return false;


        });
    }


}