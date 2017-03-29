package com.mobsoft.matchapp.ui.standings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.matchapp.R;

import java.util.List;

import javax.inject.Inject;

public class StandingsActivity extends AppCompatActivity implements StandingsScreen {

    @Inject
    StandingsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachScreen();
    }

    @Override
    public void updateStadings(List<String> standings) {

    }
}
