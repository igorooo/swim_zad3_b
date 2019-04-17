package com.example.swim_zad3_b;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

/** RADIO BUTTON FRAGMENT */


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment1_1 extends Fragment implements RadioGroup.OnCheckedChangeListener {


    Fragment ParentFragment;
    OnOptionSelectedListener Listener1;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            ParentFragment = getParentFragment();
            Toast.makeText(getActivity(),(CharSequence)Integer.toString(ParentFragment.getId()),Toast.LENGTH_SHORT).show();
            Listener1 = (OnOptionSelectedListener) ParentFragment;
        }
        catch (ClassCastException e){
            throw new ClassCastException(ParentFragment.toString() + "musi implementowac OnWyborOpcjiListener");
        }
    }

    public fragment1_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1_1, container, false);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.RB1:
                Listener1.OnOptionSelected(1);
                break;
            case R.id.RB2:
                Listener1.OnOptionSelected(2);
                break;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((RadioGroup) getActivity().findViewById(R.id.RG1)).setOnCheckedChangeListener(this);
    }
}
