package com.mobsoft.matchapp.mock.interceptors;

import android.net.Uri;
import android.util.Log;

import com.mobsoft.matchapp.network.NetworkConfig;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.mobsoft.matchapp.mock.interceptors.MockHelper.makeResponse;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

public class MockInterceptor implements Interceptor {
    public MockInterceptor() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return process(chain.request());
    }

    private Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        Log.i("NETWORK", "URL call: " + uri.toString());
        Headers headers = request.headers();


        if (uri.getPath().startsWith(NetworkConfig.SERVICE_ENDPOINT + "login") || uri.getPath().startsWith(NetworkConfig.SERVICE_ENDPOINT + "signup")) {
            return UsersApiMock.process(request);
        }

        if (uri.getPath().startsWith(NetworkConfig.SERVICE_ENDPOINT + "matches") || uri.getPath().startsWith(NetworkConfig.SERVICE_ENDPOINT + "teams")) {
            return MatchesApiMock.process(request);
        }

        if (uri.getPath().startsWith(NetworkConfig.SERVICE_ENDPOINT + "standings")) {
            return TeamsApiMock.process(request);
        }

        return makeResponse(request, headers, 404, "Unknown");
    }
}
