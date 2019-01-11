package com.example.rockb.onlyui2;

import android.app.SearchManager;
import android.content.Context;
//import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.AutoCompleteTextView;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListView;
import android.widget.SearchView;

import java.util.ArrayList;


public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener{
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
    private SearchManager searchManager;
    private android.widget.SearchView searchView;
    private MyRecipeListAdapter listAdapter;
    private ExpandableListView myList;
    private ArrayList<RecipeTitleRow> recipeTitleList = new ArrayList<RecipeTitleRow>();
    private ArrayList<RecipeTitleRow> showTheseRecipeTitleList = new ArrayList<RecipeTitleRow>();
    private MenuItem searchItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //AutoCompleteTextView searchResults = findViewById(R.id.searchTextView);
        //To fill AutoComplete in search field Use this adapter
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, RECIPIES);
        //Fills search field with suggested results from RECIPES
        //searchResults.setAdapter(adapter);

        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        recipeTitleList = new ArrayList<RecipeTitleRow>();
        showTheseRecipeTitleList = new ArrayList<RecipeTitleRow>();

        displayList();
        expandAll();
        defineButtons();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        searchItem = menu.findItem(R.id.action_search);
        searchView = (android.widget.SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setSearchableInfo
                (searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);
        searchView.requestFocus();

        return true;
    }

    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            myList.expandGroup(i);
        }
    }

    private void displayList() {
        loadData();

        myList = findViewById(R.id.expandableListView_search);
        listAdapter = new MyRecipeListAdapter(SearchActivity.this, recipeTitleList);

        myList.setAdapter(listAdapter);
    }

    private void loadData() {
        ArrayList<RecipeRow> recipeRows = new ArrayList<RecipeRow>();
        RecipeTitleRow recipeTitleRow = null;

        recipeRows.add(new RecipeRow(R.mipmap.recipe3, R.mipmap.add_to_fav
                ,"Apply Pie"));
        recipeRows.add(new RecipeRow(R.mipmap.recipe3, R.mipmap.add_to_fav
                ,"Ham Burgers"));
        recipeTitleRow = new RecipeTitleRow("American Food", recipeRows);
        recipeTitleList.add(recipeTitleRow);

        recipeRows = new ArrayList<RecipeRow>();
        recipeRows.add(new RecipeRow(R.mipmap.recipe3, R.mipmap.add_to_fav
                ,"Pizza"));
        recipeRows.add(new RecipeRow(R.mipmap.recipe3, R.mipmap.add_to_fav
                ,"Fetuccini Alfrado"));
        recipeTitleRow = new RecipeTitleRow("Italian Food", recipeRows);
        recipeTitleList.add(recipeTitleRow);
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

    @Override
    public boolean onClose() {
        listAdapter.filterData("");
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        listAdapter.filterData(query);
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        listAdapter.filterData(newText);
        expandAll();
        return false;
    }
}
