package com.mobsoft.matchapp.matchapp;

import com.mobsoft.matchapp.matchapp.utils.RobolectricDaggerTestRunner;
import com.mobsoft.matchapp.ui.main.MainPresenter;
import com.mobsoft.matchapp.ui.main.MainScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import static com.mobsoft.matchapp.matchapp.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by varsi on 2017. 05. 14..
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class UserUnitTests {
    private MainPresenter mainPresenter;

    @Before
    public void setup() {
        setTestInjector();
        mainPresenter = new MainPresenter();
    }

    @Test
    public void login() {
        MainScreen mainScreen = mock(MainScreen.class);
        mainPresenter.attachScreen(mainScreen);
        mainPresenter.logIn("admin", "123456");

        verify(mainScreen, times(1)).logInFinished(true, "Invalid username or password!");
    }

    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }
}
