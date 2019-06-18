package com.projects.iamlegend.hollyquranappv1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment frag = null;
            switch(menuItem.getItemId())
            {
                case R.id.navegation_quran:
                {
                    frag = new HollyBookMainActiity();
                    break;
                }
                case R.id.navigation_hadeeth:
                {
                    frag = new ahadeth_activity();
                    break;
                }
                case R.id.navigation_tasbeh:
                {
                    frag =  new sebha_activity();
                    break;
                }
            }
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainfragment_container,frag)
                    .commit();
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.mainNavigationView);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navegation_quran);
    }

    public void HollyBookLaunchBtn(View view) {
        Intent hollyIntetn = new Intent(MainActivity.this,HollyBookMainActiity.class);
        startActivity(hollyIntetn);
    }

    public void sebhaLaunchBtn(View view) {
        Intent sebhaIntetn = new Intent(MainActivity.this,sebha_activity.class);
        startActivity(sebhaIntetn);
    }

    public void sunnahLaunchBtn(View view) {
        Intent hadethintent = new Intent(MainActivity.this,ahadeth_activity.class);
        startActivity(hadethintent);
    }
}
