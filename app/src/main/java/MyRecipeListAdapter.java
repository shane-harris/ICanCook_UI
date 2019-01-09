import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rockb.onlyui2.R;


import java.util.ArrayList;

public class MyRecipeListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<RecipeTitleRow> recipeTitleList;
    private ArrayList<RecipeTitleRow> originalList;

    public MyRecipeListAdapter(Context context, ArrayList<RecipeTitleRow> originalList) {
        this.context = context;
        this.recipeTitleList = new ArrayList<>();
        this.recipeTitleList.addAll(originalList);
        this.originalList = new ArrayList<>();
        this.originalList.addAll(originalList);
    }

    @Override
    public int getGroupCount() {
        return recipeTitleList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return recipeTitleList.get(groupPosition).getResultList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return recipeTitleList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return recipeTitleList.get(groupPosition).getResultList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        RecipeTitleRow recipeTitleRow = (RecipeTitleRow) getGroup(groupPosition);

        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.recipe_title_row, null);
        }

        TextView header = convertView.findViewById(R.id.recipe_title);
        /*.getTitle may need to be .getName*/
        header.setText(recipeTitleRow.getTitle().trim());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        RecipeRow recipeRow = (RecipeRow) getChild(groupPosition, childPosition);
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.recipe_row, null);
        }

        ImageView recipeIcon = convertView.findViewById(R.id.recipe_icon);
        recipeIcon.setImageResource(R.mipmap.recipe3);

        ImageView favoriteIcon = convertView.findViewById(R.id.add_to_fav_icon);
        favoriteIcon.setImageResource(R.mipmap.add_to_fav);
        favoriteIcon.setOnClickListener(buttonClickListener);

        final TextView recipeText = (TextView) convertView.findViewById(R.id.recipe_text);
        recipeText.setText(recipeRow.getText().trim());

        final View finalConvertView = convertView;
        recipeText.setOnClickListener(buttonClickListener);
        /*recipeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "You Clicked on a Recipe", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void filterData(String query){
        query = query.toLowerCase();
        recipeTitleList.clear();

        if(query.isEmpty()){
            recipeTitleList.addAll(originalList);
        }
        else{
            for(RecipeTitleRow recipeTitleRow : originalList ){
                ArrayList<RecipeRow> recipeList = recipeTitleRow.getResultList();
                ArrayList<RecipeRow> newList = new ArrayList<RecipeRow>();

                for (RecipeRow recipeRow: recipeList){
                    if(recipeRow.getText().toLowerCase().contains(query)){
                        newList.add(recipeRow);
                    }
                }
                if(newList.size()>0){
                    RecipeTitleRow newRecipeTitleRow = new RecipeTitleRow(recipeTitleRow.getTitle(), newList);
                    recipeTitleList.add(newRecipeTitleRow);
                }
            }
        }

        notifyDataSetChanged();
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.recipe_text: {
                    Snackbar.make(v, "You Clicked on a Recipe", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    break;
                }
                case R.id.add_to_fav_icon: {
                    Snackbar.make(v, "Recipe added to Favorites", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    break;
                }
                default:
            }
        }
    };
}
