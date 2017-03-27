package com.mobsoft.matchapp.ui.main;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public interface MainScreen {
    void showMessage(String text);

    void signUpFinished(boolean success, String message);

    void logInFinished(boolean success, String message);
}
