package com.mobsoft.matchapp.matchapp;

import com.mobsoft.matchapp.MobSoftApplication;
import com.mobsoft.matchapp.MobSoftApplicationComponent;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

/**
 * Created by varsi on 2017. 05. 14..
 */

public class TestHelper {
    public static void setTestInjector() {
        ShadowLog.stream = System.out;
        MobSoftApplication application = (MobSoftApplication) RuntimeEnvironment.application;
        TestComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.setInjector(injector);
    }
}
