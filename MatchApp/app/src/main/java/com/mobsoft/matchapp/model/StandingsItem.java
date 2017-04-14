package com.mobsoft.matchapp.model;

import java.io.Serializable;

/**
 * Created by varsi on 2017. 04. 14..
 */

public class StandingsItem extends Team implements Serializable {
    private int point;
    private int played;

    public StandingsItem(Long id, String name, String password, int point, int played) {
        super(id, name, password);
        this.point = point;
        this.played = played;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }
}
