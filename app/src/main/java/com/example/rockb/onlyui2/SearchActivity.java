package com.example.rockb.onlyui2;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class SearchActivity extends AppCompatActivity {
    /*This is a temp array containing recipe names
    * This will eventually be changed to a text
    * file containing all recipe titles in database*/

    private static final String[] RECIPIES = new String[]{
            "Scrambled Eggs", "Chicken Marsala", "Apple Pie",
            "Buttermilk Pancakes", "Deviled Eggs", "Eggplant Parmasan",
            "Fries", "Gornola", "Hamburger", "Italian Ice Cream",
            "Jelly Donut", "Kit Kat Cake", "Lasagna", "Mac and Cheese",
            "Noodle Soup", "Oatmeal", "Pancakes", "Quiche", "Ramen",
            "Tostada", "Udon", "Vegetable Stir Fry", "Waffles",
            "Xavier Soup", "Yogurt", "Zucchini Bread"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        AutoCompleteTextView searchResults = findViewById(R.id.searchTextView);
        //To fill AutoComplete in search field Use this adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, RECIPIES);
        //Fills search field with suggested results from RECIPES
        searchResults.setAdapter(adapter);

        defineButtons();

    }

    private void defineButtons() {
        findViewById(R.id.search_button).setOnClickListener(buttonClickListener);
        findViewById(R.id.pantry_button).setOnClickListener(buttonClickListener);
        findViewById(R.id.camerabutton).setOnClickListener(buttonClickListener);
        findViewById(R.id.mainActivityButton).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.search_button:{
                    Snackbar.make(v, "Search will return results to center fragment", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
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
                case R.id.mainActivityButton: {
                    finish();
                    break;
                }
                default:
            }
        }
    };
}
