package com.mobsoft.matchapp.ui.editor;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobsoft.matchapp.matchapp.R;

import java.util.List;

import javax.inject.Inject;

public class EditorActivity extends AppCompatActivity implements EditorScreen {
    @Inject
    EditorPresenter editorPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
    }

    @Override
    protected void onStop() {
        super.onStop();
        editorPresenter.detachScreen();
    }

    @Override
    protected void onStart() {
        super.onStart();
        editorPresenter.attachScreen(this);
    }

    @Override
    public void matchLoaded(String matchDetails) {

    }

    @Override
    public void loadTeams(List<String> teams) {

    }
}
