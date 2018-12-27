package jfl.com.landmark;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import jfl.com.landmark.fragments.Fragment1;
import jfl.com.landmark.fragments.Fragment2;
import jfl.com.landmark.fragments.FragmentList3;
import jfl.com.landmark.fragments.FragmentList4;
import jfl.com.landmark.fragments.FragmentList5;
import jfl.com.landmark.fragments.FragmentTY;

public class MainActivity extends AppCompatActivity implements Fragment1.OnFragmentInteractionListener, View.OnClickListener
        , Fragment2.OnFragmentInteractionListener
        , FragmentList3.OnFragmentInteractionListener
        , FragmentList4.OnFragmentInteractionListener
        , FragmentList5.OnFragmentInteractionListener
        , FragmentTY.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment1();
    }


    private void fillFragments(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.ll_fragments, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    private void popFragments() {
            FragmentManager manager = getSupportFragmentManager();
            if (manager.getBackStackEntryCount() > 0) {
                FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
                manager.popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    private void loadFragment1() {
        Fragment1 fragment1 = new Fragment1();
        fillFragments(fragment1);
    }

    @Override
    public void loadFragment2() {
        Fragment2 fragment2 = new Fragment2();
        fillFragments(fragment2);
    }


    @Override
    public void loadFragment3() {
        FragmentList3 fragmentList3 = new FragmentList3();
        fillFragments(fragmentList3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                // loadNextFragment();
                break;

        }
    }

    @Override
    public void loadFragment4() {
        FragmentList4 fragmentList4 = new FragmentList4();
        fillFragments(fragmentList4);
    }

    @Override
    public void loadFragment5() {
        FragmentList5 fragmentList5 = new FragmentList5();
        fillFragments(fragmentList5);
    }

    @Override
    public void loadTYFragment() {
        popFragments();
        FragmentTY fragmentTY = new FragmentTY();
        fillFragments(fragmentTY);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(getSupportFragmentManager().getBackStackEntryCount() ==0 || getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount()) instanceof FragmentTY){
            loadFragment1();
        }
    }
}
