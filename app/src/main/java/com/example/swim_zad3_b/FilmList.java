package com.example.swim_zad3_b;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class FilmList extends Fragment {

    public static final String FILM_SHARED_PREFS = "FilmPrefs";
    public static final String LIST = "List";

    ArrayList<Film> arrayList;

    private ListView listView;
    private FilmListAdapter adapter;

    public FilmList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_film_list, container, false);

        loadData();
        listView = (ListView) view.findViewById(R.id.F_list);
        adapter = new FilmListAdapter(getContext(), R.layout.adapter_view_film,arrayList);
        listView.setAdapter(adapter);

        return view;
    }


    public void loadData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(FILM_SHARED_PREFS,MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(LIST,"");

        Type type = new TypeToken<ArrayList<Film>>(){}.getType();

        arrayList = gson.fromJson(json, type);

        if(arrayList == null){
            arrayList = new ArrayList<Film>();
        }
    }
}
