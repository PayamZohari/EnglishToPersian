package com.example.android.miwok;

import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;

public class Helper {

    public static void releaseResources(PairWordsAdapter pairWordsAdapter){
        if(pairWordsAdapter.getMediaPlayer()!=null){
            pairWordsAdapter.getMediaPlayer().release();
            pairWordsAdapter.setMediaPlayer(null);
            pairWordsAdapter.getAudioManager().abandonAudioFocus(pairWordsAdapter.getAudioFocusChangeListener());
        }

    }


}
