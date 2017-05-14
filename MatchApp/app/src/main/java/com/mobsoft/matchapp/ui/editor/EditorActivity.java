package com.mobsoft.matchapp.ui.editor;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.interactor.TeamInteractor;
import com.mobsoft.matchapp.matchapp.R;
import com.mobsoft.matchapp.model.Match;
import com.mobsoft.matchapp.model.Team;
import com.mobsoft.matchapp.utils.DateHelper;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import static com.mobsoft.matchapp.utils.DateHelper.getDate;
import static com.mobsoft.matchapp.utils.DateHelper.getTime;
import static com.mobsoft.matchapp.utils.DateHelper.parseDate;

public class EditorActivity extends AppCompatActivity implements EditorScreen, View.OnClickListener {
    @Inject
    EditorPresenter editorPresenter;

    private Spinner homeTeamSpinner;
    private Spinner awayTeamSpinner;
    private EditText homeScore;
    private EditText awayScore;
    private EditText homeHalfTimeScore;
    private EditText awayHalfTimeScore;
    private EditText kickOffDate;
    private EditText kickOffTime;
    private EditText venue;
    private EditText highlights;
    private ArrayAdapter<Team> adapter;
    private Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        homeTeamSpinner = (Spinner) findViewById(R.id.homeTeamSpinner);
        awayTeamSpinner = (Spinner) findViewById(R.id.awayTeamSpinner);
        homeScore = (EditText)findViewById(R.id.homeTeamScore);
        awayScore = (EditText) findViewById(R.id.awayTeamScore);
        homeHalfTimeScore = (EditText) findViewById(R.id.homeHalfTimeScore);
        awayHalfTimeScore = (EditText)findViewById(R.id.awayHalfTimeScore);
        kickOffDate = (EditText) findViewById(R.id.kickoffDate);
        kickOffTime = (EditText) findViewById(R.id.kickoffTime);
        venue = (EditText) findViewById(R.id.venue);
        highlights = (EditText) findViewById(R.id.highlights);
        saveBtn = (Button)findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(this);
        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStop() {
        editorPresenter.detachScreen();
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        editorPresenter.attachScreen(this);
        editorPresenter.loadTeams();
    }

    @Override
    public void teamsLoaded(List<Team> teams) {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, teams);
        homeTeamSpinner.setAdapter(adapter);
        awayTeamSpinner.setAdapter(adapter);

        Match m = (Match) getIntent().getSerializableExtra("match");
        boolean isNew = false;
        if (m == null) {
            m = new Match();
            isNew = true;
        }
        Long matchId = (Long)getIntent().getSerializableExtra("matchId");
        m.setId(matchId);
        editorPresenter.setCurrentMatch(m, isNew);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void matchSaved() {
        finish();
    }

    @Override
    public void matchLoaded(Match match) {
        if (match.getHomeTeam() != null) {
            int pos = adapter.getPosition(match.getHomeTeam());
            homeTeamSpinner.setSelection(pos);
        }

        if (match.getAwayTeam() != null) {
            int pos = adapter.getPosition(match.getAwayTeam());
            awayTeamSpinner.setSelection(pos);
        }
        homeScore.setText(match.getHomeTeamScore() + "");
        awayScore.setText(match.getAwayTeamScore() + "");
        homeHalfTimeScore.setText(match.getHomeTeamHalfTimeScore() + "");
        awayHalfTimeScore.setText(match.getAwayTeamHalfTimeScore() + "");
        if (match.getMatchDate() != null) {
            kickOffDate.setText(getDate(match.getMatchDate()));
            kickOffTime.setText(getTime(match.getMatchDate()));
        }
        venue.setText(match.getVenue());
        highlights.setText(match.getHighlights());
    }

    @Override
    public void onClick(View v) {
        Match m = new Match();
        m.setId(editorPresenter.getCurrentMatch().getId());
        m.setHomeTeam((Team)homeTeamSpinner.getSelectedItem());
        m.setAwayTeam((Team)awayTeamSpinner.getSelectedItem());
        m.setHomeTeamScore(Integer.parseInt(homeScore.getText().toString()));
        m.setAwayTeamScore(Integer.parseInt(awayScore.getText().toString()));
        m.setHomeTeamHalfTimeScore(Integer.parseInt(homeHalfTimeScore.getText().toString()));
        m.setAwayTeamHalfTimeScore(Integer.parseInt(awayHalfTimeScore.getText().toString()));
        m.setVenue(venue.getText().toString());
        m.setHighlights(highlights.getText().toString());
        try{
            m.setMatchDate(parseDate(kickOffDate.getText().toString(), kickOffTime.getText().toString()));
            editorPresenter.saveMatchDetails(m);
        } catch (DateHelper.DateParseException e) {
            Toast.makeText(this, "Invalid kickoff date format!", Toast.LENGTH_LONG).show();
        }
    }
}
