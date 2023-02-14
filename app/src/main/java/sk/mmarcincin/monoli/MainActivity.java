package sk.mmarcincin.monoli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import sk.mmarcincin.monoli.adapters.NovenasAdapter;
import sk.mmarcincin.monoli.fragments.LitaniesListFragment;
import sk.mmarcincin.monoli.fragments.LitanyFragment;
import sk.mmarcincin.monoli.fragments.MainMenuFragment;
import sk.mmarcincin.monoli.fragments.NovenaFragment;
import sk.mmarcincin.monoli.fragments.NovenasListFragment;
import sk.mmarcincin.monoli.fragments.PrayerFragment;
import sk.mmarcincin.monoli.fragments.PrayersListFragment;
import sk.mmarcincin.monoli.models.Litany;
import sk.mmarcincin.monoli.models.Novena;
import sk.mmarcincin.monoli.models.Prayer;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigationView;
    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setSelectedItemId(R.id.home_ni);

        MainMenuFragment mainMenuFragment = new MainMenuFragment();
        NovenasListFragment novenasFragment = new NovenasListFragment();
        PrayersListFragment prayersListFragment = new PrayersListFragment();
        LitaniesListFragment litaniesListFragment = new LitaniesListFragment();
        //novenasAdapter = new NovenasAdapter(new String[]{"novena1", "novena2", "novena3"});

        myToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(myToolbar);

        navigationView.setOnItemSelectedListener(item -> {
        // Upratat na krajsi a nerepetitivny kod
            switch (item.getItemId()) {
                case R.id.home_ni:
                    getSupportFragmentManager().popBackStack("homeFrag", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, mainMenuFragment).commit();
                    return true;

                case R.id.modlitby_ni:
                    getSupportFragmentManager().popBackStack("homeFrag", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, prayersListFragment).addToBackStack("homeFrag").commit();
                    return true;

                case R.id.noveny_ni:
                    getSupportFragmentManager().popBackStack("homeFrag", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, novenasFragment).addToBackStack("homeFrag").commit();
                    return true;

                case R.id.litanie_ni:
                    getSupportFragmentManager().popBackStack("homeFrag", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, litaniesListFragment).addToBackStack("homeFrag").commit();
                    return true;
            }
            return false;
        });
    }

    public void openFragment(Prayer prayer){
        PrayerFragment prayerFragment = new PrayerFragment(prayer);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, prayerFragment).addToBackStack(null).commit();
    }
    public void openFragment(Novena novena) {
        NovenaFragment novenaFragment = new NovenaFragment(novena);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, novenaFragment).addToBackStack(null).commit();
    }
    public void openFragment(Litany litany) {
        LitanyFragment litanyFragment = new LitanyFragment(litany);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, litanyFragment).addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Fragment f = getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        if (f instanceof MainMenuFragment){
            navigationView.setSelectedItemId(R.id.home_ni);
        }
    }


}