package com.mobsoft.matchapp.ui.standings;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mobsoft.matchapp.matchapp.R;
import com.mobsoft.matchapp.model.StandingsItem;
import com.mobsoft.matchapp.model.Team;

import java.util.List;

/**
 * Created by varsi on 2017. 04. 14..
 */

public class StandingsAdapter extends BaseAdapter {
    private Context context;
    private List<StandingsItem> teams;

    public StandingsAdapter(Context context, List<StandingsItem> teams) {
        this.teams = teams;
        this.context = context;
    }

    @Override
    public int getCount() {
        return teams.size();
    }

    @Override
    public Object getItem(int position) {
        return teams.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private static class ViewHolder {
        public TextView teamTV;
        public TextView detailsTV;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.standings_item, null);
            viewHolder = new ViewHolder();
            viewHolder.teamTV = (TextView) convertView.findViewById(R.id.teamNameTextView);
            viewHolder.detailsTV = (TextView) convertView.findViewById(R.id.detailsTextView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        StandingsItem item = this.teams.get(position);
        viewHolder.teamTV.setText("#" + (position + 1) + " " + item.getName());
        viewHolder.detailsTV.setText("Played: " + item.getPlayed() + " - Points:" + item.getPoint());
        return convertView;
    }
}
