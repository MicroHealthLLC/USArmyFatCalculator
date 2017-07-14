package com.example.maxmoons.usarmy_fatcalculator.About;

/**
 * Created by dan on 4/23/17.
 */


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maxmoons.usarmy_fatcalculator.R;

import butterknife.ButterKnife;


/**
 * Created by ubuntuadmin on 3/24/17.
 */

public class About  extends AppCompatActivity {



    private RecyclerView recyclerView;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    Button twitterview;
    Button websitetxt;
    Button privacypolicy;
    Button termsofUse;
    TextView Lincenceagreement;
    TextView rateview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        twitterview = (Button) findViewById(R.id.followus);
        websitetxt =(Button) findViewById(R.id.webaddress);
        privacypolicy =(Button) findViewById(R.id.privacyp);
        termsofUse = (Button) findViewById(R.id.termsofuse);
        // twitterview.setMovementMethod(LinkMovementMethod.getInstance());

        twitterview.setText("@microhealthtalk");
        twitterview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURl("https://twitter.com/MicroHealthTalk");
            }
        });
        websitetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURl("https://www.microhealthllc.com/");
            }
        });
        termsofUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURl("https://www.microhealthllc.com/about/terms-of-use/");

            }
        });
        privacypolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gotoURl("https://www.microhealthllc.com/about/privacy-policy/");

            }
        });


        //   twitterview.setClickable(true);
        //    websitetxt =(TextView) findViewById(R.id.websiteurl);
        //   websitetxt.setClickable(true);
        //   websitetxt.setText(Html.fromHtml(website));

        //   twitterview.setText(Html.fromHtml(twiteracc));
        // Linkify.addLinks(twitterview,Linkify.ALL);
        ButterKnife.bind(this);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle("About");

        }





    }

    private void gotoURl(String url){

        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);

    }

    private void setupToolbar() {
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
    }


    @Override

    public void onBackPressed() {



            super.onBackPressed();

        }










    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
//        mDrawerToggle.syncState();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }





}