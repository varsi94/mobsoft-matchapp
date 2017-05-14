package com.mobsoft.matchapp.ui.details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;

import com.google.gson.annotations.SerializedName;
import com.mobsoft.matchapp.DaggerMobSoftApplicationComponent;
import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.matchapp.R;
import com.mobsoft.matchapp.model.Match;
import com.mobsoft.matchapp.ui.editor.EditorActivity;

import org.w3c.dom.Text;

import java.io.Serializable;

import javax.inject.Inject;

import static com.mobsoft.matchapp.utils.DateHelper.formatDate;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen, MenuItem.OnMenuItemClickListener {
    @Inject
    DetailsPresenter presenter;

    private MenuItem editMatch;
    private TextView homeTeamTV;
    private TextView homeScoreTV;
    private TextView awayTeamTV;
    private TextView awayScoreTV;
    private TextView venue;
    private TextView kickoffDate;
    private TextView highlights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        homeTeamTV = (TextView) findViewById(R.id.homeTeamTV);
        homeScoreTV = (TextView) findViewById(R.id.homeScoreTV);
        awayTeamTV = (TextView)findViewById(R.id.awayTeamTV);
        awayScoreTV = (TextView) findViewById(R.id.awayScoreTV);
        venue = (TextView) findViewById(R.id.venue);
        kickoffDate = (TextView)findViewById(R.id.kickoffDate);
        highlights = (TextView) findViewById(R.id.highlights);
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

    @Override
    public void detailsLoaded(Match match) {
        homeTeamTV.setText(match.getHomeTeam().getName());
        awayTeamTV.setText(match.getAwayTeam().getName());
        homeScoreTV.setText(match.getHomeTeamScore() + " (" + match.getHomeTeamHalfTimeScore() + ")");
        awayScoreTV.setText(match.getAwayTeamScore() + " (" + match.getAwayTeamHalfTimeScore() + ")");
        venue.setText("Venue: " + match.getVenue());
        if (match.getMatchDate() != null) {
            kickoffDate.setText("Kickoff date: " + formatDate(match.getMatchDate()));
        }
        highlights.setText(match.getHighlights());
    }
}
