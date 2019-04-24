package com.example.swim_zad3_b;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
public class BookList extends Fragment {

    public static final String BOOK_SHARED_PREFS = "BookPrefs";
    public static final String LIST = "List";
    public static final String ListCheck = "ListCheck";

    ArrayList<Book> arrayList;

    private ListView listView;
    private BookListAdapter adapter;


    public BookList() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book_list, container, false);

        loadData();
        listView = (ListView) view.findViewById(R.id.B_list);
        adapter = new BookListAdapter(getContext(), R.layout.adapter_view_book,arrayList);
        listView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


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

}
