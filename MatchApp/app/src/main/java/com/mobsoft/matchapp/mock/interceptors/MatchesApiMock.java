package com.mobsoft.matchapp.mock.interceptors;

import android.net.Uri;
import android.provider.ContactsContract;

import com.mobsoft.matchapp.model.Match;
import com.mobsoft.matchapp.network.NetworkConfig;
import com.mobsoft.matchapp.repository.MemoryRepository;
import com.mobsoft.matchapp.utils.GsonHelper;

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
        MemoryRepository memoryRepository = new MemoryRepository();
        memoryRepository.open(null);
        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "matches") && request.method().equals("POST")) {
            Match m = GsonHelper.getGson().fromJson(bodyToString(request), Match.class);
            memoryRepository.addMatch(m);
            responseCode = 200;
        } else if (path.matches("^" + (NetworkConfig.ENDPOINT_PREFIX + "matches").replace("/", "\\/") + "([0-9]+)") && request.method().equals("PUT")) {
            //TODO: update match
            responseString = "";
            responseCode = 200;
        //TODO: get matches for team
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
