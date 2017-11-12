package com.example.dewaagung.advancetraining;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.dewaagung.advancetraining.listener.FragmentToHostListener;
import com.example.dewaagung.advancetraining.listener.HostToFragmentListener;

/**
 * Created by Dewa Agung on 12/11/17.
 */

public class FragmentTwo extends Fragment implements HostToFragmentListener{

    FragmentToHostListener listener;

    @Override
    public void onAttach(Context context) {
        listener = (FragmentToHostListener) context;
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_two, container, false);
        ((MainActivity) getActivity()).setHostToFragmentListener(this);
        Button btnPicu = view.findViewById(R.id.btn_picu);
        btnPicu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                listener.onDataReceiveFromFragment("Triggered");
            }
        });
        /*return inflater.inflate(R.layout.fragment_two, container, false);*/
        /*View root = inflater.inflate(R.layout.fragment_one, container,false);
        return super.onCreateView(inflater, container, savedInstanceState);*/
        return view;
    }

    @Override
    public void onDataReceiveIntFragment(String data) {
        Toast.makeText(getActivity(), data, Toast.LENGTH_SHORT).show();
    }
}
