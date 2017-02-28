package com.harvic.fragmentarguments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Fragment2 extends Fragment implements View.OnClickListener{

    public interface ICustomDialogEventListener {
        void customDialogEvent(int selectID);
    }

    private ICustomDialogEventListener mCustomDialogEventListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment2, container, false);

        if (getArguments() != null) {
            String mParam1 = getArguments().getString("param");
            TextView tv =  (TextView)view.findViewById(R.id.textview);
            tv.setText(mParam1);
        }

        view.findViewById(R.id.img1).setOnClickListener(this);
        view.findViewById(R.id.img2).setOnClickListener(this);
        view.findViewById(R.id.img3).setOnClickListener(this);
        view.findViewById(R.id.img4).setOnClickListener(this);

        return view;
    }

    public static Fragment2 newInstance(String text) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString("param", text);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 回调结果值
     */
    public void setResultListener(ICustomDialogEventListener listener){
        mCustomDialogEventListener = listener;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.img1:{
                mCustomDialogEventListener.customDialogEvent(R.drawable.animal1);
            }
                break;
            case R.id.img2:{
                mCustomDialogEventListener.customDialogEvent(R.drawable.animal2);
            }
                break;
            case R.id.img3:{
                mCustomDialogEventListener.customDialogEvent(R.drawable.animal3);
            }
                break;
            case R.id.img4:{
                mCustomDialogEventListener.customDialogEvent(R.drawable.animal4);
            }
                break;
        }

        //退出当前fragment
        getFragmentManager().popBackStack();
    }
}
