package com.example.rockb.onlyui2;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class HomeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        defineButtons();
    }

    private void defineButtons() {
        findViewById(R.id.mainActivityButton).setOnClickListener(buttonClickListener);
        findViewById(R.id.favoriteButton).setOnClickListener(buttonClickListener);
        findViewById(R.id.recipeButton).setOnClickListener(buttonClickListener);
        findViewById(R.id.search_button).setOnClickListener(buttonClickListener);
        findViewById(R.id.pantry_button).setOnClickListener(buttonClickListener);
        findViewById(R.id.camerabutton).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.mainActivityButton: {
                    finish();
                    break;
                }
                case R.id.favoriteButton: {
                    Snackbar.make(v, "Favorites Button Clicked", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    break;
                }
                case R.id.recipeButton: {
                    Snackbar.make(v, "Recipe Button Clicked", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    break;
                }
                case R.id.search_button:{
                    Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
                    startActivity(intent);
                    break;
                }
                case R.id.pantry_button:{
                    Snackbar.make(v, "Pantry Button Clicked", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
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


}
