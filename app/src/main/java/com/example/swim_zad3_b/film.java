package com.example.swim_zad3_b;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class film extends Fragment {

    public static final String FILM_SHARED_PREFS = "FilmPrefs";
    public static final String LIST = "List";


    EditText title,director;
    Button add,reset;
    Switch color,sound;
    RatingBar rating;

    ArrayList<Film> arrayList;

    public film() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        title = (EditText)getView().findViewById(R.id.F_title);
        director = (EditText)getView().findViewById(R.id.F_director);
        add = (Button) getView().findViewById(R.id.F_Add);
        reset = (Button) getView().findViewById(R.id.F_Reset);
        color = (Switch) getView().findViewById(R.id.F_switch1);
        sound = (Switch) getView().findViewById(R.id.F_switch2);
        rating = (RatingBar) getView().findViewById(R.id.F_rating);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPosition();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reset();
            }
        });
    }

    public void addPosition(){

        int rate = (int)rating.getRating();

        Boolean isColored = false, withSound = false;

        if( color.isChecked() ){
            isColored = true;
        }

        if( sound.isChecked() ){
            withSound = true;
        }


        Film film= new Film(title.getText()+"",director.getText()+"",rate,isColored,withSound);

        loadData();

        arrayList.add(film);

        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(FILM_SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        editor.putString(LIST,json);
        editor.apply();
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

    public void Reset(){
        title.setText("Title");
        director.setText("Director");
        sound.setChecked(false);
        color.setChecked(false);
        rating.setRating(0);
    }

}
