package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class PhrasesActivity extends AppCompatActivity {

    private ListView phrasesList;

    private ArrayList<PairWords> phrases;

    private PairWordsAdapter phrasesContainer;


    private void initialize() {
        phrases = new ArrayList<>();
        phrases.add(new PairWords("what is your name?","نام تو چیست؟",R.raw.phrase_what_is_your_name));
        phrases.add(new PairWords("how old are you?", "چند سال داری؟",R.raw.phrase_my_name_is));
        phrases.add(new PairWords("come here!", "بیا اینجا!",R.raw.phrase_come_here));
        phrases.add(new PairWords("how are you?", "حالت چطور است؟",R.raw.phrase_how_are_you_feeling));
        phrases.add(new PairWords("thank you", "از تو ممنونم",R.raw.phrase_lets_go));
        phrases.add(new PairWords("take care", "مرافب خودت باش",R.raw.phrase_im_coming));
        phrases.add(new PairWords("goodbye", "خدانگهدار",R.raw.phrase_where_are_you_going));
        phrases.add(new PairWords("nice to meet you", "از دیدنت خوشحال شدم",R.raw.phrase_im_feeling_good));

        phrasesList = (ListView) findViewById(R.id.words_list);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordslist);

        initialize();

        phrasesContainer = new PairWordsAdapter(this, phrases,
                R.color.category_phrases);

        phrasesList.setAdapter(phrasesContainer);


    }

    @Override
    protected void onStop() {
        super.onStop();
        Helper.releaseResources(this.phrasesContainer);
    }
}