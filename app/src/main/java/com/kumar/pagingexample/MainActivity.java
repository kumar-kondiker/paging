package com.kumar.pagingexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    RecyclerView recyclerView;
    LinearLayoutManager manager;
    RecyclerView.Adapter adapter;
    ProgressBar progressBar;
    boolean isscrolling;
    int crrentitems,scrolleditems,totalitems;
    ArrayList<String> citynames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        citynames=new ArrayList<>();
        citynames.add("1");
        citynames.add("2");
        citynames.add("3");
        citynames.add("4");
        citynames.add("5");
        citynames.add("6");
        citynames.add("7");
        citynames.add("8");
        citynames.add("9");
        citynames.add("10");
        citynames.add("11");
        citynames.add("12");
        citynames.add("13");
        citynames.add("14");
        citynames.add("15");
        recyclerView=findViewById(R.id.recyclerview_cities);
        progressBar=findViewById(R.id.preogressbar);
        manager= new LinearLayoutManager(this);
        adapter=new Adapter(this,citynames);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState== AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                {
                    isscrolling=true;
                }

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                crrentitems=manager.getChildCount();
                Log.i(TAG, "crrentitems : "+crrentitems);
                totalitems=manager.getItemCount();
                Log.i(TAG, "totalitems : "+totalitems);
                scrolleditems=manager.findFirstVisibleItemPosition();
                Log.i(TAG, "scrolleditems : "+scrolleditems);

                if(isscrolling && (crrentitems+scrolleditems==totalitems))
                {
                    isscrolling=false;
                    fetchdata();
                }
            }
        });


    }

    private void fetchdata() {
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    citynames.add(Math.floor(Math.random()*100)+"");
                }
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);

            }
        }, 5000);
    }
}
