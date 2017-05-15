package com.mobsoft.matchapp.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.mobsoft.matchapp.DaggerMobSoftApplicationComponent;
import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.matchapp.R;
import com.mobsoft.matchapp.ui.standings.StandingsActivity;

import io.fabric.sdk.android.Fabric;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen {
    @Inject
    MainPresenter mainPresenter;

    private EditText teamNameTextBox;
    private EditText passwordTextBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        teamNameTextBox = (EditText) findViewById(R.id.teamNameEditText);
        passwordTextBox = (EditText) findViewById(R.id.passwordEditText);
        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void signUpFinished(boolean success, String message) {
        if (!success) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void logInFinished(boolean success, String message) {
        if (success) {
            Intent i = new Intent(this, StandingsActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }

    public void signUp(View view) {
        mainPresenter.signUp(teamNameTextBox.getText().toString(), passwordTextBox.getText().toString());
    }

    public void login(View view) {
        mainPresenter.logIn(teamNameTextBox.getText().toString(), passwordTextBox.getText().toString());
    }

    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }
}
