package com.example.maxmoons.usarmy_fatcalculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.maxmoons.usarmy_fatcalculator.About.About;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public double waistInches = 36.0;
    public double hipInches = 36.0;
    public double neckInches = 18.0;
    public int heightInches = 60;
    public boolean gender = false;
    public boolean infotab = false;
    DecimalFormat df = new DecimalFormat("#.#");
    @Override
    // AU: Thee same on create method from the App CompatActivity has been overwritten
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar WaistBar = (SeekBar) findViewById(R.id.WaistBar);
        final SeekBar HipBar = (SeekBar) findViewById(R.id.HipBar);
        final SeekBar NeckBar = (SeekBar) findViewById(R.id.NeckBar);
        final SeekBar HeightBar = (SeekBar) findViewById(R.id.HeightBar);
        final TextView WaistNumber = (TextView) findViewById(R.id.WaistNumber);
        final TextView HipNumber = (TextView) findViewById(R.id.HipNumber);
        final TextView NeckNumber = (TextView) findViewById(R.id.NeckNumber);
        final TextView HeightNumber = (TextView) findViewById(R.id.HeightNumber);
        final TextView BodyFatPercent = (TextView) findViewById(R.id.BodyFatPercent);
        final CheckBox Female = (CheckBox) findViewById(R.id.Female);


        if(getSupportActionBar()!=null){

            getSupportActionBar().setDisplayHomeAsUpEnabled(false);

            getSupportActionBar().setHomeButtonEnabled(true);

            getSupportActionBar().setTitle("       US Army Fat Calculator");



        }
        WaistBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar MHeightInches, int progress, boolean fromUser) {
                waistInches = progress/2;
                WaistNumber.setText(progress+"");
                CalculateFat();
            }

            public void onStartTrackingTouch(SeekBar MHeightInches) {
            }

            public void onStopTrackingTouch(SeekBar MHeightInches) {
            }
        });

        HipBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar MHeightInches, int progress, boolean fromUser) {
                hipInches = progress/2;
                HipNumber.setText(progress+"");
                CalculateFat();
            }

            public void onStartTrackingTouch(SeekBar MHeightInches) {
            }

            public void onStopTrackingTouch(SeekBar MHeightInches) {
            }
        });

        NeckBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar MHeightInches, int progress, boolean fromUser) {
                neckInches = progress/2;
                NeckNumber.setText(progress+"");
                CalculateFat();
            }

            public void onStartTrackingTouch(SeekBar MHeightInches) {
            }

            public void onStopTrackingTouch(SeekBar MHeightInches) {
            }
        });

        HeightBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar MHeightInches, int progress, boolean fromUser) {
                heightInches = progress;
                HeightNumber.setText(progress+"");
                CalculateFat();
            }

            public void onStartTrackingTouch(SeekBar MHeightInches) {
            }

            public void onStopTrackingTouch(SeekBar MHeightInches) {
            }
        });

        Female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                gender = b;

                CalculateFat();
            }
        });
    }
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_main, menu);

        return true;

    }


    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                startActivity(new Intent(MainActivity.this, About.class));
                break;
            case R.id.terms:
                Uri uri = Uri.parse("https://microhealthllc.com/about/terms-of-use/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);

    }
    // AU: same method has been simplified for use, set text for doubles can cause randomization errors.
    private void CalculateFat() {
        final TextView BodyFatPercent = (TextView) findViewById(R.id.BodyFatPercent);
       double  number = (86.010 * Math.log10(waistInches-neckInches)) - (70.041 * Math.log10(heightInches)) + 36.76;
       double number2 = (163.205 * Math.log10(waistInches + hipInches - neckInches)) - (97.684 * Math.log10(heightInches)) - 78.387;
        if(!gender)
            if(((86.010 * Math.log10(waistInches-neckInches)) - (70.041 * Math.log10(heightInches)) + 36.76)>=0)
                //BodyFatPercent.setText( df.format( (86.010 * Math.log10(waistInches-neckInches)) - (70.041 * Math.log10(heightInches)) + 36.76;+"%"));
                //AU: This simplifies code and reduces errors.
                BodyFatPercent.setText( df.format(number+"%"));
            else
                BodyFatPercent.setText("0%");
        else
            if(((163.205 * Math.log10(waistInches + hipInches - neckInches)) - (97.684 * Math.log10(heightInches)) - 78.387)>=0)
                //BodyFatPercent.setText( df.format((163.205 * Math.log10(waistInches + hipInches - neckInches)) - (97.684 * Math.log10(heightInches)) - 78.387) + "%");
                // AU: This simplifies code and reduces errors
                BodyFatPercent.setText( df.format(number2+"%"));
            else
                BodyFatPercent.setText("0%");
    }
// AU: The URI can be set using the try catch exception

    public void Terms(View v)
    {
        try {
            URI uri = new URI("https://microhealthllc.com/about/terms-of-use/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        //startActivity(intent);
    }

    public void Infotab(View v)
    {
        infotab=!infotab;
        final SeekBar WaistBar = (SeekBar) findViewById(R.id.WaistBar);
        final SeekBar HipBar = (SeekBar) findViewById(R.id.HipBar);
        final SeekBar NeckBar = (SeekBar) findViewById(R.id.NeckBar);
        final SeekBar HeightBar = (SeekBar) findViewById(R.id.HeightBar);
        final TextView WaistNumber = (TextView) findViewById(R.id.WaistNumber);
        final TextView HipNumber = (TextView) findViewById(R.id.HipNumber);
        final TextView NeckNumber = (TextView) findViewById(R.id.NeckNumber);
        final TextView HeightNumber = (TextView) findViewById(R.id.HeightNumber);
        final TextView BodyFatPercent = (TextView) findViewById(R.id.BodyFatPercent);
        final CheckBox Female = (CheckBox) findViewById(R.id.Female);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final TextView textView2 = (TextView) findViewById(R.id.textView2);
        final TextView textView3 = (TextView) findViewById(R.id.textView3);
        final TextView textView5 = (TextView) findViewById(R.id.textView5);
        final TextView textView8 = (TextView) findViewById(R.id.textView8);
        final TextView textView10 = (TextView) findViewById(R.id.textView10);
        //final TextView textView12 = (TextView) findViewById(R.id.textView12);
        //final Button infoTab = (Button) findViewById(R.id.button2);
        if(infotab)
        {
            WaistBar.setVisibility(View.INVISIBLE);
            HipBar.setVisibility(View.INVISIBLE);
            NeckBar.setVisibility(View.INVISIBLE);
            HeightBar.setVisibility(View.INVISIBLE);
            WaistNumber.setVisibility(View.INVISIBLE);
            HipNumber.setVisibility(View.INVISIBLE);
            NeckNumber.setVisibility(View.INVISIBLE);
            HeightNumber.setVisibility(View.INVISIBLE);
            BodyFatPercent.setVisibility(View.INVISIBLE);
            Female.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.INVISIBLE);
            textView3.setVisibility(View.INVISIBLE);
            textView5.setVisibility(View.INVISIBLE);
            textView8.setVisibility(View.INVISIBLE);
            textView10.setVisibility(View.INVISIBLE);
            //textView12.setVisibility(View.VISIBLE);
            //infoTab.setText("Back");
        }
        else
        {
            WaistBar.setVisibility(View.VISIBLE);
            HipBar.setVisibility(View.VISIBLE);
            NeckBar.setVisibility(View.VISIBLE);
            HeightBar.setVisibility(View.VISIBLE);
            WaistNumber.setVisibility(View.VISIBLE);
            HipNumber.setVisibility(View.VISIBLE);
            NeckNumber.setVisibility(View.VISIBLE);
            HeightNumber.setVisibility(View.VISIBLE);
            BodyFatPercent.setVisibility(View.VISIBLE);
            Female.setVisibility(View.VISIBLE);
            textView.setVisibility(View.VISIBLE);
            textView2.setVisibility(View.VISIBLE);
            textView3.setVisibility(View.VISIBLE);
            textView5.setVisibility(View.VISIBLE);
            textView8.setVisibility(View.VISIBLE);
            textView10.setVisibility(View.VISIBLE);
            //textView12.setVisibility(View.INVISIBLE);
            //infoTab.setText("Information");
        }
    }
}
