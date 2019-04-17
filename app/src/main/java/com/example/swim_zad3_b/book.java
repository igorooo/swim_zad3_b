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
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class book extends Fragment {


    public static final String BOOK_SHARED_PREFS = "BookPrefs";
    public static final String LIST = "List";


    RadioGroup radioGroup;
    RadioButton drama,fantasy,horror;
    Button add,reset;
    EditText title,author;

    ArrayList<Book> arrayList;


    public book() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        radioGroup = (RadioGroup) getView().findViewById(R.id.B_radioGroup);
        drama = (RadioButton)getView().findViewById(R.id.B_RB1);
        fantasy = (RadioButton)getView().findViewById(R.id.B_RB2);
        horror = (RadioButton)getView().findViewById(R.id.B_RB3);
        add = (Button)getView().findViewById(R.id.B_Add);
        reset = (Button)getView().findViewById(R.id.B_Reset);
        title = (EditText)getView().findViewById(R.id.B_title);
        author = (EditText)getView().findViewById(R.id.B_author);

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

        String str = title.getText() + "  ~" + author.getText() ;
        RadioButton RB = (RadioButton) getView().findViewById(radioGroup.getCheckedRadioButtonId());

        String type = "";


        if(RB == drama){
            type = "Drama";
        }
        if(RB == fantasy){
            type = "Fantasy";
        }
        if(RB == horror){
            type = "Horror";
        }

        Book book= new Book(title.getText()+"",author.getText()+"",type+"");

        loadData();

        arrayList.add(book);

        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(BOOK_SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        editor.putString(LIST,json);
        editor.apply();


    }

    public void loadData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(BOOK_SHARED_PREFS,MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(LIST,"");

        Type type = new TypeToken<ArrayList<Book>>(){}.getType();

        arrayList = gson.fromJson(json, type);

        if(arrayList == null){
            arrayList = new ArrayList<Book>();
        }
    }

    public void Reset(){
        title.setText("Title");
        author.setText("Author");
        radioGroup.clearCheck();
    }



}
