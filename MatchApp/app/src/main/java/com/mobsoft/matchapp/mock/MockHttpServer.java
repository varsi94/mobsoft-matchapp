package com.mobsoft.matchapp.mock;

import com.mobsoft.matchapp.mock.interceptors.MockInterceptor;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

public class MockHttpServer {
    public static Response call(Request request) {
        MockInterceptor mockInterceptor = new MockInterceptor();
        return mockInterceptor.process(request);
    }
}
