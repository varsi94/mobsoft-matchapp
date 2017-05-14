package com.mobsoft.matchapp.ui.details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.gson.annotations.SerializedName;
import com.mobsoft.matchapp.DaggerMobSoftApplicationComponent;
import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.matchapp.R;
import com.mobsoft.matchapp.model.Match;
import com.mobsoft.matchapp.ui.editor.EditorActivity;

import java.io.Serializable;

import javax.inject.Inject;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen, MenuItem.OnMenuItemClickListener {
    @Inject
    DetailsPresenter presenter;

    private MenuItem editMatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStop() {
        presenter.detachScreen();
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);
        Match m = (Match) getIntent().getSerializableExtra("match");
        Long matchId = (Long) getIntent().getSerializableExtra("matchId");
        m.setId(matchId);
        presenter.setMatch(m);
    }

    @Override
    public void detailsLoaded(String details) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.match_details_menu, menu);
        editMatch = menu.findItem(R.id.editMatch);
        editMatch.setOnMenuItemClickListener(this);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Intent i = new Intent(this, EditorActivity.class);
        i.putExtra("match", presenter.getMatch());
        i.putExtra("matchId", (Serializable)presenter.getMatch().getId());
        startActivity(i);
        return false;
    }
}
