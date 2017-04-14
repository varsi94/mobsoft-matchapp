package com.mobsoft.matchapp.ui.standings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.matchapp.R;
import com.mobsoft.matchapp.model.StandingsItem;
import com.mobsoft.matchapp.model.Team;
import com.mobsoft.matchapp.ui.matchlist.MatchListActivity;

import java.util.List;

import javax.inject.Inject;

public class StandingsActivity extends AppCompatActivity implements StandingsScreen {

    @Inject
    StandingsPresenter presenter;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings);

        MobSoftApplication.injector.inject(this);

        listView = (ListView) findViewById(R.id.standings);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StandingsItem item = (StandingsItem) listView.getAdapter().getItem(position);
                Intent i = new Intent(StandingsActivity.this, MatchListActivity.class);
                i.putExtra("team", item);
                StandingsActivity.this.startActivity(i);
            }
        });
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
}
