package com.mobsoft.matchapp.ui.standings;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.matchapp.R;
import com.mobsoft.matchapp.model.StandingsItem;
import com.mobsoft.matchapp.model.Team;
import com.mobsoft.matchapp.ui.editor.EditorActivity;
import com.mobsoft.matchapp.ui.matchlist.MatchListActivity;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

public class StandingsActivity extends AppCompatActivity implements StandingsScreen, AdapterView.OnItemClickListener, MenuItem.OnMenuItemClickListener {

    @Inject
    StandingsPresenter presenter;

    private ListView listView;
    private MenuItem addMatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings);

        MobSoftApplication.injector.inject(this);
        listView = (ListView) findViewById(R.id.standings);
        listView.setOnItemClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        presenter.detachScreen();
        super.onStop();
    }

    @Override
    public void updateStandings(List<StandingsItem> standings) {
        if (standings == null) {
            Toast.makeText(this, "Error loading standings!", Toast.LENGTH_LONG).show();
        } else {
            listView.setAdapter(new StandingsAdapter(this, standings));
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        StandingsItem item = (StandingsItem) listView.getAdapter().getItem(position);
        Intent i = new Intent(this, MatchListActivity.class);
        i.putExtra("team", item);
        this.startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.standings_menu, menu);
        addMatch = menu.findItem(R.id.addMatch);
        addMatch.setOnMenuItemClickListener(this);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Intent i = new Intent(this, EditorActivity.class);
        i.putExtra("match", (Serializable)null);
        this.startActivity(i);
        return false;
    }
}