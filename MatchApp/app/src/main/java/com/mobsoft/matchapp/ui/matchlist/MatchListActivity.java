package com.mobsoft.matchapp.ui.matchlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.matchapp.R;
import com.mobsoft.matchapp.model.Match;
import com.mobsoft.matchapp.model.StandingsItem;

import java.util.List;

import javax.inject.Inject;

public class MatchListActivity extends AppCompatActivity implements MatchListScreen {
    @Inject
    MatchListPresenter presenter;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_list);

        MobSoftApplication.injector.inject(this);
        listView = (ListView) findViewById(R.id.matchListView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);
        StandingsItem item = (StandingsItem) this.getIntent().getSerializableExtra("team");
        presenter.loadMatchesForTeam(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachScreen();
    }

    @Override
    public void matchesLoaded(List<Match> matches) {
        listView.setAdapter(new MatchListAdapter(this, matches));
    }

    @Override
    public void matchLoadFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
