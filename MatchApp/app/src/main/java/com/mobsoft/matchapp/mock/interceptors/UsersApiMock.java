package com.mobsoft.matchapp.mock.interceptors;

import android.net.Uri;

import com.mobsoft.matchapp.network.NetworkConfig;
import com.mobsoft.matchapp.network.model.Team;
import com.mobsoft.matchapp.repository.MemoryRepository;
import com.mobsoft.matchapp.utils.GsonHelper;
import com.mobsoft.matchapp.utils.Mapper;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static com.mobsoft.matchapp.mock.interceptors.MockHelper.bodyToString;
import static com.mobsoft.matchapp.mock.interceptors.MockHelper.makeResponse;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

public class UsersApiMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString = "";
        int responseCode;
        Headers headers = request.headers();

        MemoryRepository memoryRepository = new MemoryRepository();
        memoryRepository.open(null);
        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "login") && request.method().equals("POST")) {
            responseString = "1";
            responseCode = 200;
        }else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "signup") && request.method().equals("POST")) {
            String requestStr = bodyToString(request);
            Team team = GsonHelper.getGson().fromJson(requestStr, Team.class);
            responseString = "";
            try{
                memoryRepository.addTeam(Mapper.mapTeam(team));
                responseCode = 200;
            } catch (RuntimeException e) {
                responseCode = 400;
            }
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
