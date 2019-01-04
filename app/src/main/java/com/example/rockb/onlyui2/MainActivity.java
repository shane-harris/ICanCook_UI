package com.example.rockb.onlyui2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //configureSignInButton();
        configureButtons();

        /*Button createButton = findViewById(R.id.create_button);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton searchButton = findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Search Button Clicked", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton pantryButton = findViewById(R.id.pantry_button);
        pantryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pantry Button Clicked", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton cameraButton = findViewById(R.id.camerabutton);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Camera Button Clicked", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    private void configureButtons() {
        findViewById(R.id.create_button).setOnClickListener(buttonClickListener);
        findViewById(R.id.sign_in_button).setOnClickListener(buttonClickListener);
        findViewById(R.id.search_button).setOnClickListener(buttonClickListener);
        findViewById(R.id.pantry_button).setOnClickListener(buttonClickListener);
        findViewById(R.id.camerabutton).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.create_button: {
                    Snackbar.make(v, "Create Button Clicked", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();;
                    break;
                }
                case R.id.sign_in_button: {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    break;
                }
                case R.id.search_button:{
                    Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                    startActivity(intent);
                    break;
                }
                case R.id.pantry_button:{
                    Snackbar.make(v, "Pantry Button Clicked", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    break;
                }
                case R.id.camerabutton:{
                    Snackbar.make(v, "Camera Button Clicked", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    break;
                }
                default:
            }
        }
    };


    /*private void configureSignInButton() {
        Button signInButton = findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }*/

}
