package com.mobsoft.matchapp.ui.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobsoft.matchapp.DaggerMobSoftApplicationComponent;
import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.matchapp.R;

import javax.inject.Inject;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {
    @Inject
    DetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachScreen();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void detailsLoaded(String details) {

    }
}
