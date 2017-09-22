package com.example.asus.applearnenglish.activity.navigation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.asus.applearnenglish.R;
import com.example.asus.applearnenglish.fragment.HomeFragment;

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final float END_SCALE = 1f;
    private DrawerLayout drLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    private TextView labelView;
    private View contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        init();
        event();
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }

    private void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drLayout.addDrawerListener(toggle);
        drLayout.setScrimColor(Color.TRANSPARENT);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        labelView = (TextView) findViewById(R.id.label);
        contentView = findViewById(R.id.content);
        setFragmentHome(new HomeFragment());
    }

    private void event() {
        toolbar.setNavigationIcon(new DrawerArrowDrawable(this));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     if (drLayout.isDrawerOpen(navigationView)) {
                                                         drLayout.closeDrawer(navigationView);
                                                     } else {
                                                         drLayout.openDrawer(navigationView);
                                                     }
                                                 }
                                             }
        );
        drLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
                                       @Override
                                       public void onDrawerSlide(View drawerView, float slideOffset) {
                                           labelView.setVisibility(slideOffset > 0 ? View.VISIBLE : View.GONE);

                                           // Scale the View based on current slide offset
                                           final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                                           final float offsetScale = 1 - diffScaledOffset;
                                           contentView.setScaleX(offsetScale);
                                           contentView.setScaleY(offsetScale);

                                           // Translate the View, accounting for the scaled width
                                           final float xOffset = drawerView.getWidth() * slideOffset;
                                           final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                                           final float xTranslation = xOffset - xOffsetDiff;
                                           contentView.setTranslationX(xTranslation);
                                       }

                                       @Override
                                       public void onDrawerClosed(View drawerView) {
                                           labelView.setVisibility(View.GONE);
                                       }
                                   }
        );

    }

    @Override
    public void onBackPressed() {
        if (drLayout.isDrawerOpen(GravityCompat.START)) {
            drLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void setFragmentHome(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        drLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
