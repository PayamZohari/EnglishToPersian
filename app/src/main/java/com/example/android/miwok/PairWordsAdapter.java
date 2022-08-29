package com.example.android.miwok;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PairWordsAdapter extends ArrayAdapter<PairWords> {


    private int backgroundColor;

    private MediaPlayer mediaPlayer;

    private AudioManager audioManager;

    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;


    public PairWordsAdapter(@NonNull Context context, @NonNull List<PairWords> objects, int backgroundColor) {
        super(context, 0, objects);
        this.backgroundColor = backgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        PairWords currentPairWord = this.getItem(position);

        View listItemView = convertView;
        if (convertView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.words_layout, parent,
                    false);
        }

        LinearLayout textsRootView = (LinearLayout) listItemView.findViewById(R.id.text_root_view);
        textsRootView.setBackgroundResource(backgroundColor);

        TextView upperTextView = (TextView) listItemView.findViewById(R.id.upper_text);
        upperTextView.setText(currentPairWord.getFirstWord());

        TextView lowererTextView = (TextView) listItemView.findViewById(R.id.lower_text);
        lowererTextView.setText(currentPairWord.getSecondWord());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentPairWord.hasImage()) {
            imageView.setImageResource(currentPairWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }


        Context context = this.getContext();

        ImageButton button = (ImageButton) listItemView.findViewById(R.id.button);
        button.setBackgroundResource(backgroundColor);

        mediaPlayer = MediaPlayer.create(this.getContext(), currentPairWord.getAudioResourceId());
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        PairWordsAdapter pairWordsAdapterTemp = this;

        audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int focusChange) {
                Helper.releaseResources(pairWordsAdapterTemp);
                if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                    button.setImageResource(R.drawable.baseline_pause_white_36);
                    mediaPlayer.start();
                } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                    button.setImageResource(R.drawable.baseline_play_arrow_white_36);
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                    button.setImageResource(R.drawable.baseline_play_arrow_white_36);
                    Helper.releaseResources(pairWordsAdapterTemp);
                }
            }
        };


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.releaseResources(pairWordsAdapterTemp);
                int result = audioManager.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    button.setImageResource(R.drawable.baseline_pause_white_36);
                    mediaPlayer = MediaPlayer.create(context, currentPairWord.getAudioResourceId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            button.setImageResource(R.drawable.baseline_play_arrow_white_36);
                            Helper.releaseResources(pairWordsAdapterTemp);
                        }
                    });
                }

            }
        });


        return listItemView;

    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public AudioManager getAudioManager() {
        return audioManager;
    }

    public void setAudioManager(AudioManager audioManager) {
        this.audioManager = audioManager;
    }

    public AudioManager.OnAudioFocusChangeListener getAudioFocusChangeListener() {
        return audioFocusChangeListener;
    }

    public void setAudioFocusChangeListener(AudioManager.OnAudioFocusChangeListener audioFocusChangeListener) {
        this.audioFocusChangeListener = audioFocusChangeListener;
    }

}
