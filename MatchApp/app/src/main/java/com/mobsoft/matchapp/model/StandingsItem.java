package com.mobsoft.matchapp.model;

import java.io.Serializable;

/**
 * Created by varsi on 2017. 04. 14..
 */

public class StandingsItem extends Team implements Serializable {
    private int point;
    private int played;
    private Long id;

    public StandingsItem(Team t, int point, int played) {
        super(t.getName(), t.getPassword(), t.isAdmin());
        this.point = point;
        this.played = played;
        this.setId(t.getId());
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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
