package com.example.android.miwok;

public class PairWords {

    private String firstWord;

    private String secondWord;

    private int imageResourceId = NO_IMAGE;

    private int audioResourceId;

    private static final int NO_IMAGE = -1;

    public PairWords(String firstWord, String secondWord, int audioResourceId) {
        this.firstWord = firstWord;
        this.secondWord = secondWord;
        this.audioResourceId = audioResourceId;
    }

    public PairWords(String firstWord, String secondWord, int imageResourceId, int audioResourceId) {
        this.firstWord = firstWord;
        this.secondWord = secondWord;
        this.imageResourceId = imageResourceId;
        this.audioResourceId = audioResourceId;
    }

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public boolean hasImage(){
        return imageResourceId!=NO_IMAGE;
    }

    public int getAudioResourceId() {
        return audioResourceId;
    }

    public void setAudioResourceId(int audioResourceId) {
        this.audioResourceId = audioResourceId;
    }
}
