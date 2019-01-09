package com.example.rockb.onlyui2;

import java.util.ArrayList;

public class RecipeTitleRow {
    private String title;
    private ArrayList<RecipeRow> resultList;

    public RecipeTitleRow(String title, ArrayList<RecipeRow> resultList) {
        this.title = title;
        this.resultList = resultList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<RecipeRow> getResultList() {
        return resultList;
    }

    public void setResultList(ArrayList<RecipeRow> resultList) {
        this.resultList = resultList;
    }
}
