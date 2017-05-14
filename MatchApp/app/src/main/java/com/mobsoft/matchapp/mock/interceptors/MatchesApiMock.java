package com.mobsoft.matchapp.mock.interceptors;

import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;

import com.google.gson.Gson;
import com.mobsoft.matchapp.network.NetworkConfig;
import com.mobsoft.matchapp.network.model.Match;
import com.mobsoft.matchapp.repository.MemoryRepository;
import com.mobsoft.matchapp.utils.GsonHelper;
import com.mobsoft.matchapp.utils.Mapper;

import java.util.regex.Matcher;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static com.mobsoft.matchapp.mock.interceptors.MockHelper.bodyToString;
import static com.mobsoft.matchapp.mock.interceptors.MockHelper.makeResponse;

/**
 * Created by mobsoft on 2017. 04. 24..
 */
public class MatchesApiMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString = "";
        int responseCode;
        Headers headers = request.headers();

        String path = uri.getPath();
        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "matches") && request.method().equals("POST")) {
            Match m = GsonHelper.getGson().fromJson(bodyToString(request), Match.class);
            Log.i("NETWORK", "Add match: " + m.getHomeTeam().getName() + " - " + m.getAwayTeam().getName() + " (" + m.getHomeTeamScore() + ":" + m.getAwayTeamScore() + ")");
            com.mobsoft.matchapp.model.Match mappedMatch = Mapper.mapMatch(m);
            responseCode = 200;
        } else if (path.matches("^" + (NetworkConfig.ENDPOINT_PREFIX + "matches").replace("/", "\\/") + "([0-9]+)") && request.method().equals("PUT")) {
            Match m = GsonHelper.getGson().fromJson(bodyToString(request), Match.class);
            Log.i("NETWORK", "Add match: " + m.getHomeTeam().getName() + " - " + m.getAwayTeam().getName() + " (" + m.getHomeTeamScore() + ":" + m.getAwayTeamScore() + ")");
            responseString = "";
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
