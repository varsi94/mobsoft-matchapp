package com.mobsoft.matchapp.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class Team extends SugarRecord implements Serializable {
    String name;
    String password;
    boolean isAdmin;

    public Team() {
    }

    public Team(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<Match> getMatches() {
        return Match.find(Match.class, "home_Team = ? OR away_Team = ?", String.valueOf(getId()), String.valueOf(getId()));
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        return name.equals(team.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}