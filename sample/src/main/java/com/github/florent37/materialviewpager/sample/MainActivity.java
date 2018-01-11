package com.github.florent37.materialviewpager.sample;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.github.florent37.materialviewpager.sample.fragment.FIrstRecyclerViewFragment;
import com.github.florent37.materialviewpager.sample.fragment.FourthRecyclerViewFragment;
import com.github.florent37.materialviewpager.sample.fragment.SecondRecyclerViewFragment;
import com.github.florent37.materialviewpager.sample.fragment.ThirdRecyclerViewFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.materialViewPager)
    MaterialViewPager mViewPager;

    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mDrawerToggle;

    static String WHERE = "purchase";
    static String WHERE_DETAIL = "가격 및 재고";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (!BuildConfig.DEBUG) {
            Fabric.with(this, new Crashlytics());
        }

        setContentView(R.layout.activity_main);
        setTitle("");
        ButterKnife.bind(this);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, 0, 0);
        mDrawer.setDrawerListener(mDrawerToggle);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayUseLogoEnabled(false);
            actionBar.setHomeButtonEnabled(true);
        }


        final Toolbar toolbar = mViewPager.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }


        final View logo = findViewById(R.id.logo_white);
        if (logo != null) {
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getApplicationContext(), "Yes, the title is clickable", Toast.LENGTH_SHORT).show();
                }
            });
        }



        setNavigationViewListener();
        changePage();

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
                WHERE = "purchase";
                break;
            }
            case R.id.productionMenu: {
                //do somthing
                Toast.makeText(this, "죠쵸!!!!!", Toast.LENGTH_SHORT).show();
                WHERE = "production";
                break;
            }
            case R.id.logisticsMenu: {
                //do somthing
                Toast.makeText(this, "은지쏘오오옹!", Toast.LENGTH_SHORT).show();
                WHERE = "logistics";
                break;
            }
            case R.id.salesMenu: {
                //do somthing
                Toast.makeText(this, "준석상!!!!", Toast.LENGTH_SHORT).show();
                WHERE = "sales";
                break;
            }

        }

        switch (WHERE) {
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

        changePage();
        //close navigation drawer
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void changePage() {
        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 4) {
                    case 0:
                        return FIrstRecyclerViewFragment.newInstance();
                    case 1:
                        return SecondRecyclerViewFragment.newInstance();
                    case 2:
                        return ThirdRecyclerViewFragment.newInstance();
                    default:
                        return FourthRecyclerViewFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 3;
            }



            @Override
            public CharSequence getPageTitle(int position) {

                switch (WHERE) {
                    case "purchase":
                        switch (position % 4) {
                            case 0:
                                return "가격 및 재고";
                            case 1:
                                return "Actualités";
                            case 2:
                                return "Professionnel";
                            case 3:
                                return "Divertissement";
                        }
                        break;
                    case "production":
                        switch (position % 4) {
                            case 0:
                                return "제 1공장 정보";
                            case 1:
                                return "제 2공장 정보";
                            case 2:
                                return "예측 분석";
                            case 3:
                                return "Divertissement";
                        }
                        break;
                    case "logistics":

                        switch (position % 4) {
                            case 0:
                                return "제 1물류창고";
                            case 1:
                                return "제 2물류창고";
                            case 2:
                                return "제 3물류창고";
                            case 3:
                                return "Divertissement";
                        }
                        break;
                    case "sales":
                        switch (position % 4) {
                            case 0:
                                return "매장 기본 정보";
                            case 1:
                                return "매장 거래 내역";
                            case 2:
                                return "매장 이익 달성도";
                            case 3:
                                return "Divertissement";
                        }
                        break;
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.green,
                                "http://phandroid.s3.amazonaws.com/wp-content/uploads/2014/06/android_google_moutain_google_now_1920x1080_wallpaper_Wallpaper-HD_2560x1600_www.paperhi.com_-640x400.jpg");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "http://www.hdiphonewallpapers.us/phone-wallpapers/540x960-1/540x960-mobile-wallpapers-hd-2218x5ox3.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.cyan,
                                "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());
}



}

