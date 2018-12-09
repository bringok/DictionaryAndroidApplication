package com.rsr.bapon.dictionary;

public class DictionaryObject{

    String word, meaning;

    public DictionaryObject(String word, String meaning){

        this.word = word;
        this.meaning = meaning;

    }

    public  String getWord()
    {
        return word;
    }

    public  String getMeaning()
    {
        return meaning;
    }
}
