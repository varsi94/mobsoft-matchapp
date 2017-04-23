package com.mobsoft.matchapp.ui.matchlist;

import com.mobsoft.matchapp.model.Match;

import java.util.List;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public interface MatchListScreen {
    void matchesLoaded(List<Match> matches);

    void matchLoadFailed(String message);
}
