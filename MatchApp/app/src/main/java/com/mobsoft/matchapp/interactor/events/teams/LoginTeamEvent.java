package com.mobsoft.matchapp.interactor.events.teams;

import com.mobsoft.matchapp.interactor.events.BaseEvent;
import com.mobsoft.matchapp.model.Team;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class LoginTeamEvent extends BaseEvent<Team> {
    private boolean isAnonim;

    public boolean isAnonim() {
        return isAnonim;
    }

    public void setAnonim(boolean anonim) {
        isAnonim = anonim;
    }
}
