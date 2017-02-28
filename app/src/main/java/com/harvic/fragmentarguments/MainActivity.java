package com.harvic.fragmentarguments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


/**
 * Fragment与Fragment之间传递参数
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment1 fragment1 = new Fragment1();
        getFragmentManager().beginTransaction().replace(R.id.main_layout, fragment1).commit();
    }

}
