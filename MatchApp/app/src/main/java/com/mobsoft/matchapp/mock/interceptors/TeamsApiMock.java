package com.mobsoft.matchapp.mock.interceptors;

import android.net.Uri;

import com.mobsoft.matchapp.network.NetworkConfig;
import com.mobsoft.matchapp.network.model.StandingsItem;
import com.mobsoft.matchapp.repository.MemoryRepository;
import com.mobsoft.matchapp.utils.GsonHelper;
import com.mobsoft.matchapp.utils.Mapper;

import java.util.List;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static com.mobsoft.matchapp.mock.interceptors.MockHelper.makeResponse;

/**
 * Created by mobsoft on 2017. 04. 24..
 */
public class TeamsApiMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString = "";
        int responseCode;
        Headers headers = request.headers();

        MemoryRepository memoryRepository = new MemoryRepository();
        memoryRepository.open(null);
        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "standings") && request.method().equals("GET")) {
            List<StandingsItem> standings = Mapper.mapStandings(memoryRepository.getStandings());
            responseString = GsonHelper.getGson().toJson(standings);
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
