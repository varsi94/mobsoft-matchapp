package com.mobsoft.matchapp.utils;

import com.mobsoft.matchapp.model.Team;
import com.mobsoft.matchapp.network.model.StandingsItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

public class Mapper {
    public static Team mapTeam(com.mobsoft.matchapp.network.model.Team team){
        Team t = new Team();
        t.setName(team.getName());
        t.setPassword(team.getPassword());
        t.setAdmin(team.getIsAdmin());
        return t;
    }

    private static StandingsItem mapStandingsItem(com.mobsoft.matchapp.model.StandingsItem item) {
        StandingsItem result = new StandingsItem();
        result.setName(item.getName());
        result.setPlayed(BigDecimal.valueOf(item.getPlayed()));
        result.setPoints(BigDecimal.valueOf(item.getPoint()));
        return result;
    }

    public static List<StandingsItem> mapStandings(List<com.mobsoft.matchapp.model.StandingsItem> standings) {
        List<StandingsItem> items = new ArrayList<>();
        for (com.mobsoft.matchapp.model.StandingsItem si : standings) {
            items.add(mapStandingsItem(si));
        }
        return items;
    }
}
