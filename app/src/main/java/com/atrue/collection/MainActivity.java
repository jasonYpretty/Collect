package com.atrue.collection;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.app.Fragment;
import android.app.FragmentTransaction;

import layout.DashFragment;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private void setDefaultFragment(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager().beginTransaction();
        currentFragment = new CurrentFragment();
        transaction.replace(R.id.content,currentFragment);
        transaction.commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        Fragment fragment;

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        //    FragmentTransaction ft = getFragmentManager().beginTransaction();
      //      ft.replace(R.id.content, fragment);
    //        ft.addToBackStack(null);
  //          ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//            ft.commit();

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    break;
                    //return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    break;
                //return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_settings);
                    //fragment = new DashFragment();
                  break;
                    //return true;
            }

            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
