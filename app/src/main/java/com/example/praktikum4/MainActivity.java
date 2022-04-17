package com.example.praktikum4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.praktikum4.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText phoneNumber;
    private EditText websiteUri;
    private EditText locationUri;
    private EditText textShare;

    Button buttonWebsite;
    Button buttonLocation;
    Button buttonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumber = findViewById(R.id.txt1);
        websiteUri = findViewById(R.id.txt2);
        locationUri = findViewById(R.id.txt3);
        textShare = findViewById(R.id.txt4);

        buttonWebsite = findViewById(R.id.button2);
        buttonWebsite.setOnClickListener(this);

        buttonWebsite = findViewById(R.id.button3);
        buttonWebsite.setOnClickListener(this);

        buttonWebsite = findViewById(R.id.button4);
        buttonWebsite.setOnClickListener(this);
    }
    public void openDialPhone (View view) {
        Intent dialPhone = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:" + phoneNumber.getText().toString()));
        if (phoneNumber.length() == 0)
        {
            phoneNumber.setError("Silahkan isi terlebih dahulu!");
        } else {
            startActivity(dialPhone);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button2:
                Intent openWebsite = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(websiteUri.getText().toString()));
                if (websiteUri.length() == 0)
                {
                    websiteUri.setError("Silahkan isi terlebih dahulu!");
                } else {
                    startActivity(openWebsite);
                }
                break;
            case R.id.button3:
                Intent openLocation = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=" +
                                locationUri.getText().toString()));
                if (locationUri.length() == 0)
                {
                    locationUri.setError("Silahkan isi terlebih dahulu!");
                } else {
                    startActivity(openLocation);
                }
                break;
            case R.id.button4:
                if (textShare.length() == 0)
                {
                    textShare.setError("Silahkan isi terlebih dahulu!");
                } else {
                    ShareCompat.IntentBuilder
                            .from(this)
                            .setType("text/plan")
                            .setChooserTitle("Share this text with : ")
                            .setText(textShare.getText().toString())
                            .startChooser();
                }
                break;
        }
    }

}