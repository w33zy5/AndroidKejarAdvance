package com.example.dewaagung.advancetraining;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Dewa Agung on 12/11/17.
 */

public class OneFragment extends Fragment implements View.OnClickListener {

    private static final String KEY_NAME = "KEY_NAME";
    private static final String KEY_COUNT = "KEY_COUNT";

    private String mName;
    private Button mBtnAdd;
    private TextView tvText;
    private int count;

    public static OneFragment newInstance(int count){
        OneFragment fragment = new OneFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_COUNT, count);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        count = args.getInt(KEY_COUNT);
    }



    public View onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_one, container,false);

        mBtnAdd = root.findViewById(R.id.btn_add);
        tvText = root.findViewById(R.id.tv);
        tvText.setText("Fragment" +count);
        mBtnAdd.setOnClickListener(this);
        Toast.makeText(getActivity(), mName, Toast.LENGTH_SHORT).show();

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_add:
                count++;
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, OneFragment.newInstance(count), null).commit();
                break;
            default:
        }
    }


}
