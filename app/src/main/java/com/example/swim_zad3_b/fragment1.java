package com.example.swim_zad3_b;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment1 extends Fragment implements OnOptionSelectedListener {

    Fragment FRAG_book,FRAG_film,FRAG_RG;
    FragmentTransaction transaction,transaction1;
    FragmentManager fragmentManager;



    @Override
    public void OnOptionSelected(int Option) {

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();


        switch (Option){
            case 1:
                Toast.makeText(getActivity(),"YYYY",Toast.LENGTH_SHORT).show();
                transaction.detach(FRAG_book);
                transaction.detach(FRAG_film);
                transaction.attach(FRAG_film);
                transaction.commit();

                return;
            case 2:
                transaction.detach(FRAG_book);
                transaction.detach(FRAG_film);
                transaction.attach(FRAG_book);
                transaction.commit();

                return;
        }


    }

    public fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FRAG_book = new book();
        FRAG_film = new film();
        FRAG_RG = new fragment1_1();


        fragmentManager = getChildFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.FrameL_RG,FRAG_RG);

        transaction.add(R.id.FrameL1, FRAG_film);
        transaction.detach(FRAG_film);
        transaction.add(R.id.FrameL1, FRAG_book);


        transaction.commit();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }


}
