package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ColorsActivity extends AppCompatActivity {


    private ListView colorsList;

    private ArrayList<PairWords> colors;

    private PairWordsAdapter colorsContainer;


    private void initialize() {
        colors = new ArrayList<>();
        colors.add(new PairWords("red", "قرمز", R.drawable.color_red,R.raw.color_red));
        colors.add(new PairWords("green", "سبز", R.drawable.color_green,R.raw.color_green));
        colors.add(new PairWords("brown", "قهوه ای", R.drawable.color_brown,R.raw.color_brown));
        colors.add(new PairWords("gray", "طوسی", R.drawable.color_gray,R.raw.color_gray));
        colors.add(new PairWords("black", "سیاه", R.drawable.color_black,R.raw.color_black));
        colors.add(new PairWords("white", "سفید", R.drawable.color_white,R.raw.color_white));
        colors.add(new PairWords("yellow", "زرد", R.drawable.color_mustard_yellow,R.raw.color_dusty_yellow));

        colorsList = (ListView) findViewById(R.id.words_list);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordslist);

        initialize();

        colorsContainer = new PairWordsAdapter(this, colors,
                R.color.category_colors);

        colorsList.setAdapter(colorsContainer);

    }

    @Override
    protected void onStop() {
        super.onStop();
        Helper.releaseResources(this.colorsContainer);
    }
}