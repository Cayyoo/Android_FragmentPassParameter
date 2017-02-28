package com.harvic.fragmentarguments;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class Fragment1 extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        Button btn = (Button)view.findViewById(R.id.load_fragment1_btn);

        btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Fragment2 fragment2 = Fragment2.newInstance("从Fragment1传来的参数");

        fragment2.setResultListener(new Fragment2.ICustomDialogEventListener() {
            @Override
            public void customDialogEvent(int selectID) {
                ImageView imageView = (ImageView)getView().findViewById(R.id.img_result);
                imageView.setImageResource(selectID);
            }
        });

        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.add(R.id.main_layout, fragment2);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
