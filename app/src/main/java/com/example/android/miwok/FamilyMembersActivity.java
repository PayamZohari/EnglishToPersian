package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class FamilyMembersActivity extends AppCompatActivity {

    private ListView familyMembersList;

    private ArrayList<PairWords> familyMembers;

    private PairWordsAdapter familyMembersContainer;


    private void initialize() {
        familyMembers = new ArrayList<>();
        familyMembers.add(new PairWords("father", "پدر",R.drawable.family_father,R.raw.family_father));
        familyMembers.add(new PairWords("mother", "مادر",R.drawable.family_mother,R.raw.family_mother));
        familyMembers.add(new PairWords("son", "پسر",R.drawable.family_son,R.raw.family_son));
        familyMembers.add(new PairWords("daughter", "دختر",R.drawable.family_daughter,R.raw.family_daughter));
        familyMembers.add(new PairWords("brother","برادر",R.drawable.family_older_brother,R.raw.family_older_brother));
        familyMembers.add(new PairWords("sister","خواهر",R.drawable.family_older_sister,R.raw.family_older_sister));
        familyMembers.add(new PairWords("grandfather", "پدربزرگ",R.drawable.family_grandfather,R.raw.family_grandfather));
        familyMembers.add(new PairWords("grandmother", "مادربزرگ",R.drawable.family_grandmother,R.raw.family_grandmother));
        familyMembers.add(new PairWords("grandchild", "نوه",R.drawable.family_younger_brother,R.raw.family_younger_brother));

        familyMembersList = (ListView) findViewById(R.id.words_list);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordslist);

        initialize();

        familyMembersContainer = new PairWordsAdapter(this, familyMembers,
                R.color.category_family);

        familyMembersList.setAdapter(familyMembersContainer);

    }

    @Override
    protected void onStop() {
        super.onStop();
        Helper.releaseResources(this.familyMembersContainer);
    }


}