package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersActivity extends AppCompatActivity {

    private ListView numbersList;

    private ArrayList<PairWords> numbers;

    PairWordsAdapter numbersContainer;


    private void initialize() {
        numbers = new ArrayList<>();
        numbers.add(new PairWords("one", "یک", R.drawable.number_one,R.raw.number_one));
        numbers.add(new PairWords("two", "دو", R.drawable.number_two,R.raw.number_two));
        numbers.add(new PairWords("three", "سه", R.drawable.number_three,R.raw.number_three));
        numbers.add(new PairWords("four", "چهار", R.drawable.number_four,R.raw.number_four));
        numbers.add(new PairWords("five", "پنج", R.drawable.number_five,R.raw.number_five));
        numbers.add(new PairWords("six", "شش", R.drawable.number_six,R.raw.number_six));
        numbers.add(new PairWords("seven", "هفت", R.drawable.number_seven,R.raw.number_seven));
        numbers.add(new PairWords("eight", "هشت", R.drawable.number_eight,R.raw.number_eight));
        numbers.add(new PairWords("nine", "نه", R.drawable.number_nine,R.raw.number_nine));

        numbersList = (ListView) findViewById(R.id.words_list);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordslist);

        initialize();

        numbersContainer = new PairWordsAdapter(this, numbers,
                R.color.category_numbers);

        numbersList.setAdapter(numbersContainer);


    }

    @Override
    protected void onStop() {
        super.onStop();
        Helper.releaseResources(this.numbersContainer);
    }
}