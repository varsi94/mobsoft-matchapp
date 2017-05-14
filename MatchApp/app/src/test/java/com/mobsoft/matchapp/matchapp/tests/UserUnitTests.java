package com.mobsoft.matchapp.matchapp.tests;

import com.mobsoft.matchapp.matchapp.BuildConfig;
import com.mobsoft.matchapp.matchapp.utils.RobolectricDaggerTestRunner;
import com.mobsoft.matchapp.model.StandingsItem;
import com.mobsoft.matchapp.repository.MemoryRepository;
import com.mobsoft.matchapp.repository.Repository;
import com.mobsoft.matchapp.ui.main.MainPresenter;
import com.mobsoft.matchapp.ui.main.MainScreen;
import com.mobsoft.matchapp.ui.standings.StandingsPresenter;
import com.mobsoft.matchapp.ui.standings.StandingsScreen;

import org.apache.maven.artifact.ant.shaded.cli.Commandline;
import org.apache.maven.model.ReportSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import javax.inject.Inject;

import static com.mobsoft.matchapp.matchapp.TestHelper.setTestInjector;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by varsi on 2017. 05. 14..
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class UserUnitTests {
    private MainPresenter mainPresenter;
    private final ArgumentCaptor<String> stringCaptor;

    public UserUnitTests() {
        this.stringCaptor = ArgumentCaptor.forClass(String.class);
    }


    @Before
    public void setup() {
        setTestInjector();
        mainPresenter = new MainPresenter();
    }

    @Test
    public void login() {
        MainScreen mainScreen = mock(MainScreen.class);
        mainPresenter.attachScreen(mainScreen);

        //Valid credentials
        mainPresenter.logIn("admin", "123");
        verify(mainScreen, times(1)).logInFinished(eq(true), stringCaptor.capture());
        reset(mainScreen);

        //Invalid credentials
        mainPresenter.logIn("admin", "123456");
        verify(mainScreen, times(1)).logInFinished(eq(false), stringCaptor.capture());
        reset(mainScreen);

        //Anonim credentials
        mainPresenter.logIn("", "");
        verify(mainScreen, times(1)).logInFinished(eq(true), stringCaptor.capture());
    }

    @Test
    public void signup() {
        MainScreen mainScreen = mock(MainScreen.class);
        mainPresenter.attachScreen(mainScreen);

        //Already has this user.
        mainPresenter.signUp("admin", "abcdef");
        verify(mainScreen, times(1)).signUpFinished(eq(false), stringCaptor.capture());
        reset(mainScreen);

        //New user
        mainPresenter.signUp("new user", "abcdef");
        verify(mainScreen, times(1)).logInFinished(eq(true), stringCaptor.capture());
        assert MemoryRepository.teams.size() == 5;
        assert MemoryRepository.teams.get(4).getName().equals("new user");
        assert MemoryRepository.teams.get(4).getPassword().equals("abcdef");
        reset(mainScreen);

        //Fields are required
        mainPresenter.signUp("", "");
        verify(mainScreen, times(1)).signUpFinished(eq(false), stringCaptor.capture());
    }

    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }
}
