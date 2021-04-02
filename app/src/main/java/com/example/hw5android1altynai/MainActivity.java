package com.example.hw5android1altynai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.SurfaceControl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements iFragment{

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    SecondFragment secondFragment;
    ThirdFragment thirdFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        createThirdFragment();
    }

    private void createThirdFragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout, thirdFragment);
        fragmentTransaction.commit();
    }

    private void init(){
        thirdFragment= new ThirdFragment();
        secondFragment = new SecondFragment();
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public void hideMethod() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(secondFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void showMethod() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.show(secondFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void editText(String text) {
        secondFragment = (SecondFragment) fragmentManager.findFragmentById(R.id.second_fragment);
        assert secondFragment != null;
        secondFragment.addList(text, this);
    }


}