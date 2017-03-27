package com.mobsoft.matchapp.ui.standings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobsoft.matchapp.matchapp.R;

import java.util.List;

public class StandingsActivity extends AppCompatActivity implements StandingsScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings);
    }

    @Override
    public void updateStadings(List<String> standings) {

    }
}
