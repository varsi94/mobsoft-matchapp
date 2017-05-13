package com.mobsoft.matchapp.ui.editor;

import com.mobsoft.matchapp.model.Team;

import java.util.List;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public interface EditorScreen {
    void teamsLoaded(List<Team> teams);

    void showMessage(String msg);

    void matchSaved();
}
