package com.flavourbasket.flavourbasket;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
     private DrawerLayout mdrawerlayout;
     private  ActionBarDrawerToggle mtoggle;
     NavigationView navigationview;
     BottomNavigationView mBottomNav;
     private VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onInitialize();
        navigationdrawer();
        sideview();

        videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video);
        videoView.start();
    }

    public void onInitialize() {
        mdrawerlayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationview = (NavigationView) findViewById(R.id.navigation);
        mBottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
    }

    public void navigationdrawer() {

        mtoggle = new ActionBarDrawerToggle(this, mdrawerlayout, R.string.open, R.string.close);
        mdrawerlayout.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.youtube_videos:

                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/flavourbasket"));
                        startActivity(i);
                        mdrawerlayout.closeDrawers();
                        break;
                }
                return true;
            }
        });
    }

    public void sideview() {


        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // handle desired action here
                // One possibility of action is to replace the contents above the nav bar
                // return true if you want the item to be displayed as the selected item
                switch (item.getItemId()) {
                    case R.id.extra_id:
                        Intent i = new Intent(MainActivity.this, Extras.class);
                        startActivity(i);
                        break;
                }
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mtoggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
