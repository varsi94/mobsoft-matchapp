package com.mobsoft.matchapp.interactor.events;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class BaseEvent<T> {
    private int code;
    private T content;
    private Throwable throwable;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
