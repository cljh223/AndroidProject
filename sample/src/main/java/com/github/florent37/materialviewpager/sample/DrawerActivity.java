/*
package com.github.florent37.materialviewpager.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

*/
/**
 * Created by florentchampigny on 27/05/2016.
 *//*

public class DrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mDrawerToggle;
    public String where = "purchase";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!BuildConfig.DEBUG) {
            Fabric.with(this, new Crashlytics());
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, 0, 0);
        mDrawer.setDrawerListener(mDrawerToggle);
        setNavigationViewListener();

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayUseLogoEnabled(false);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item) ||
                super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        ImageView imageView = (ImageView) findViewById(R.id.logo_header);
        switch (item.getItemId()) {

            case R.id.purchaseMenu: {
                //do somthing
                Toast.makeText(this, "재준사아아앙!!!!!", Toast.LENGTH_SHORT).show();
                where = "purchase";
                break;
            }
            case R.id.productionMenu: {
                //do somthing
                Toast.makeText(this, "죠쵸!!!!!", Toast.LENGTH_SHORT).show();
                where = "production";
                break;
            }
            case R.id.logisticsMenu: {
                //do somthing
                Toast.makeText(this, "은지쏘오오옹!", Toast.LENGTH_SHORT).show();
                where = "logistics";
                break;
            }
            case R.id.salesMenu: {
                //do somthing
                Toast.makeText(this, "준석상!!!!", Toast.LENGTH_SHORT).show();
                where = "sales";
                break;
            }

        }

        switch (where) {
            case "purchase":
                imageView.setImageResource(R.drawable.purchaselogo);
                break;
            case "production":
                imageView.setImageResource(R.drawable.productionlogo);
                break;
            case "logistics":
                imageView.setImageResource(R.drawable.logisticslogo);
                break;
            case "sales":
                imageView.setImageResource(R.drawable.saleslogo);
                break;
        }
        //close navigation drawer
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public String getWhere(){
        return where;
    }

}
*/
