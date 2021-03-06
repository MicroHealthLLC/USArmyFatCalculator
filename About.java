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

import java.net.MalformedURLException;
import java.net.URL;

import butterknife.ButterKnife;


/**
 * Created by ubuntuadmin on 3/24/17.
 * Edited by Anu Uprety 5/23/19
 */

public class About  extends AppCompatActivity {

/// AU- Field variables declared private to this class but can be acessed within any methods below

    private RecyclerView recyclerView;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Button twitterview;
    private Button websitetxt;
    private Button privacypolicy;
    private Button termsofUse;
     private TextView Lincenceagreement;
     private TextView rateview;

    URL websiteurl;
     // AU- Website URL is  declared as a field so it can be accessed below in the methods, url mal functions are also caught with
    /// the catch phrase.
    {
        try {
            websiteurl = new URL("https://www.microhealthllc.com/how-to-calculate-body-mass-index-bmi/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        twitterview = (Button) findViewById(R.id.followus);
        websitetxt =(Button) findViewById(R.id.webaddress);
        privacypolicy =(Button) findViewById(R.id.privacyp);
        termsofUse = (Button) findViewById(R.id.termsofuse);

        //AU: sets the movement, so the twitter link is lined with the instance
        twitterview.setMovementMethod(LinkMovementMethod.getInstance());

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

           twitterview.setClickable(true);
           //websitetxt =(TextView) findViewById(R.id.websiteurl);
         websitetxt.setClickable(true);

         //websitetxt.setText(Html.fromHtml(website));

          //twitterview.setText(Html.fromHtml(twiteracc));
         Linkify.addLinks(twitterview,Linkify.ALL);
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

   /* AU- this method is never accesssed or used
        private void setupToolbar() {
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
    }*/


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