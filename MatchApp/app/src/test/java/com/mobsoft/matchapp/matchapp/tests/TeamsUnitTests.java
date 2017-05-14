package com.mobsoft.matchapp.matchapp.tests;

import com.mobsoft.matchapp.matchapp.BuildConfig;
import com.mobsoft.matchapp.matchapp.utils.RobolectricDaggerTestRunner;
import com.mobsoft.matchapp.model.StandingsItem;
import com.mobsoft.matchapp.ui.standings.StandingsPresenter;
import com.mobsoft.matchapp.ui.standings.StandingsScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import static com.mobsoft.matchapp.matchapp.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by varsi on 2017. 05. 14..
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class TeamsUnitTests {
    @Before
    public void setup() {
        setTestInjector();
    }

    @Test
    public void getStandings() {
        StandingsPresenter presenter = new StandingsPresenter();
        StandingsScreen screen = mock(StandingsScreen.class);
        presenter.attachScreen(screen);

        ArgumentCaptor<List> listCaptor = ArgumentCaptor.forClass(List.class);
        verify(screen, times(1)).updateStandings(listCaptor.capture());
        List<StandingsItem> list = (List<StandingsItem>)listCaptor.getValue();
        for (StandingsItem t : list) {
            System.out.println(t.getName() + " " + t.getPoint() + " " + t.getPlayed());
        }
        assert list.size() == 3;
        assert list.get(0).getName().equals("team2");
        assert list.get(0).getPoint() == 3;
        assert list.get(1).getPoint() == 0;
        assert list.get(2).getPoint() == 0;
        assert list.get(0).getPlayed() == 1;
        assert list.get(1).getPlayed() <= 1;
        assert list.get(2).getPlayed() <= 1;
        presenter.detachScreen();
    }
}
