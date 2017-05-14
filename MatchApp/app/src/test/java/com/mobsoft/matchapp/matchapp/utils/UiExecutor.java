package com.mobsoft.matchapp.matchapp.utils;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

/**
 * Created by varsi on 2017. 05. 14..
 */

public class UiExecutor implements Executor {
    private Handler handler;

    public UiExecutor() {
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(@NonNull Runnable command) {
        handler.post(command);
    }
}
