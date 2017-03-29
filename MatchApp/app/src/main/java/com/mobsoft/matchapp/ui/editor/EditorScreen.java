package com.mobsoft.matchapp.ui.editor;

import java.util.List;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public interface EditorScreen {
    void matchLoaded(String matchDetails);

    void loadTeams(List<String> teams);
}
