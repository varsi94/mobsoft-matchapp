package com.mobsoft.matchapp.ui.matchlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.matchapp.R;
import com.mobsoft.matchapp.model.Match;
import com.mobsoft.matchapp.model.StandingsItem;
import com.mobsoft.matchapp.ui.details.DetailsActivity;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

public class MatchListActivity extends AppCompatActivity implements MatchListScreen, AdapterView.OnItemClickListener {
    @Inject
    MatchListPresenter presenter;

    private ListView listView;
    private MatchListAdapter adapter;
    private Tracker tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_list);

        MobSoftApplication.injector.inject(this);
        listView = (ListView) findViewById(R.id.matchListView);

        MobSoftApplication app = (MobSoftApplication)getApplication();
        tracker = app.getDefaultTracker();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);
        StandingsItem item = (StandingsItem) this.getIntent().getSerializableExtra("team");
        presenter.loadMatchesForTeam(item);
        tracker.setScreenName("Image~MatchListActivity");
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachScreen();
    }

    @Override
    public void matchesLoaded(List<Match> matches) {
        adapter = new MatchListAdapter(this, matches);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void matchLoadFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, DetailsActivity.class);
        Match match = adapter.getMatch(position);
        i.putExtra("match", match);
        i.putExtra("matchId", (Serializable)match.getId());
        startActivity(i);
    }
}
