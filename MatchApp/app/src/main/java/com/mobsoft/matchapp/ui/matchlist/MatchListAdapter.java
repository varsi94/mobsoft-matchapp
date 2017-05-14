package com.mobsoft.matchapp.ui.matchlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mobsoft.matchapp.matchapp.R;
import com.mobsoft.matchapp.model.Match;

import java.util.List;

/**
 * Created by varsi on 2017. 04. 14..
 */

public class MatchListAdapter extends BaseAdapter {
    private Context context;
    private List<Match> matches;

    public MatchListAdapter(Context context, List<Match> matches) {
        this.context = context;
        this.matches = matches;
    }

    @Override
    public int getCount() {
        return matches.size();
    }

    @Override
    public Object getItem(int position) {
        return matches.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private static class ViewHolder {
        public TextView homeTeamNameTV;
        public TextView awayTeamNameTV;
        public TextView homeScoreTV;
        public TextView awayScoreTV;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.match_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.homeTeamNameTV = (TextView) convertView.findViewById(R.id.homeTeamTV);
            viewHolder.awayTeamNameTV = (TextView) convertView.findViewById(R.id.awayTeamTV);
            viewHolder.homeScoreTV = (TextView) convertView.findViewById(R.id.homeScoreTV);
            viewHolder.awayScoreTV = (TextView) convertView.findViewById(R.id.awayScoreTV);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Match m = matches.get(position);
        viewHolder.homeTeamNameTV.setText(m.getHomeTeam().getName());
        viewHolder.awayTeamNameTV.setText(m.getAwayTeam().getName());
        viewHolder.homeScoreTV.setText(m.getHomeTeamScore() + "");
        viewHolder.awayScoreTV.setText(m.getAwayTeamScore() + "");
        return convertView;
    }

    public Match getMatch(int position) {
        return matches.get(position);
    }
}
