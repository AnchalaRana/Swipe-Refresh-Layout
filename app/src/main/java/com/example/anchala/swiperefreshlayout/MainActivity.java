package com.example.anchala.swiperefreshlayout;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout ;
    private RecyclerView recyclerView;
    //private ListView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    //Array List for Person names and images
    ArrayList personNames = new ArrayList<>(Arrays.asList("Person 1", "Person 2", "Person 3", "Person 4"));
    ArrayList personImages = new ArrayList<>(Arrays.asList(R.drawable.ic_add_a_photo_black_24dp, R.drawable.ic_account_box_black_24dp, R.drawable.ic_account_circle_black_24dp, R.drawable.ic_android_black_24dp));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        recyclerView = findViewById(R.id.recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new Custom_Adapter(this , personNames , personImages);
        recyclerView.setAdapter(mAdapter);

        //ArrayAdapter adapter = new ArrayAdapter<ArrayList>(this ,R.layout.recycler_layout ,  R.id.text ,personNames );
        //recyclerView.setAdapter(adapter);


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // cancel the Visual indication of a refresh
                swipeRefreshLayout.setRefreshing(false);
                shuffleItems();
            }
        });
    }

    public void shuffleItems() {
        // shuffle the ArrayList's items and set the adapter
        Collections.shuffle(personNames, new Random(System.currentTimeMillis()));
        Collections.shuffle(personImages, new Random(System.currentTimeMillis()));
        // call the constructor of CustomAdapter to send the reference and data to Adapter
        Custom_Adapter customAdapter = new Custom_Adapter(MainActivity.this, personNames, personImages);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView


        //ArrayAdapter adapter = new ArrayAdapter<ArrayList>( getApplicationContext(), R.layout.recycler_layout ,  R.id.text,personNames );
        //recyclerView.setAdapter(adapter);

    }

}
