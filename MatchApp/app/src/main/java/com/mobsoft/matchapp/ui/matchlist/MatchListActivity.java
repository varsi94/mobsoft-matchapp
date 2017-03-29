package com.mobsoft.matchapp.ui.matchlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.matchapp.R;

import java.util.List;

import javax.inject.Inject;

public class MatchListActivity extends AppCompatActivity implements MatchListScreen {
    @Inject
    MatchListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_list);

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
    public void matchesLoaded(List<String> matches) {

    }
}
