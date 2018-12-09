package com.rsr.bapon.dictionary;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements View.OnClickListener  {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    public static ArrayList<DictionaryObject> data;

    ArrayList<String> wordCombineList;
    ArrayList<String> meanCombineList;
    LinkedHashMap<String,String> namelist;
    SearchView searchView;

    DatabaseHelper db ;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_first, container, false);

        recyclerView = (RecyclerView)v.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        searchView = (SearchView)v.findViewById(R.id.searchView);
        searchView.setQueryHint("Enter Word");
        searchView.setQueryRefinementEnabled(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<DictionaryObject>();

        fetchData();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {return  false; }

            @Override
            public boolean onQueryTextChange(String newText) {


                newText = newText.toLowerCase();

                final ArrayList<DictionaryObject> filteredList = new ArrayList<DictionaryObject>();

                for (int i = 0; i < wordCombineList.size(); i++) {

                    final String text = wordCombineList.get(i).toLowerCase();
                    if (text.contains(newText)) {

                        filteredList.add(new DictionaryObject(wordCombineList.get(i), meanCombineList.get(i)));
                    }
                }
                adapter = new CustomizedAdapter(filteredList);
                recyclerView.setAdapter(adapter);


                return true;
            }
        });

        return v;
    }

    public void fetchData()
    {
        db =new DatabaseHelper(getContext());
        try {

            db.createDataBase();
            db.openDataBase();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        namelist=new LinkedHashMap<>();
        int str;
        SQLiteDatabase sd = db.getReadableDatabase();
        Cursor cursor = sd.query("Dictionary1" ,null, null, null, null, null, null);
        str=cursor.getColumnIndex("word");
        wordCombineList =new ArrayList<String>();
        meanCombineList = new ArrayList<String>();
        while (cursor.moveToNext()){
            namelist.put(cursor.getString(str), cursor.getString(cursor.getColumnIndex("definition")));
        }
        Iterator entries = namelist.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            wordCombineList.add(String.valueOf(thisEntry.getKey()));
            meanCombineList.add("- "+String.valueOf(thisEntry.getValue()));
        }

        for (int i = 0; i < wordCombineList.size(); i++) {
            data.add(new DictionaryObject(wordCombineList.get(i), meanCombineList.get(i)));
        }
        adapter = new CustomizedAdapter(data);
        recyclerView.setAdapter(adapter);
    }



    @Override
    public void onClick(View v) {


    }


}








