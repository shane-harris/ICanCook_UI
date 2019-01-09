package com.example.rockb.onlyui2;

public class RecipeRow {
    private int icon,favIcon;
    private String text;

    public RecipeRow(int icon, int favIcon, String text) {
        this.icon = icon;
        this.favIcon = favIcon;
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getFavIcon() {
        return favIcon;
    }

    public void setFavIcon(int favIcon) {
        this.favIcon = favIcon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
