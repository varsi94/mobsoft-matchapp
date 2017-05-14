package com.mobsoft.matchapp.matchapp.tests;

import com.mobsoft.matchapp.matchapp.BuildConfig;
import com.mobsoft.matchapp.matchapp.utils.RobolectricDaggerTestRunner;
import com.mobsoft.matchapp.model.Match;
import com.mobsoft.matchapp.model.Team;
import com.mobsoft.matchapp.repository.MemoryRepository;
import com.mobsoft.matchapp.ui.editor.EditorPresenter;
import com.mobsoft.matchapp.ui.editor.EditorScreen;
import com.mobsoft.matchapp.ui.matchlist.MatchListPresenter;
import com.mobsoft.matchapp.ui.matchlist.MatchListScreen;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;
import java.util.Random;

import static com.mobsoft.matchapp.matchapp.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by varsi on 2017. 05. 14..
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MatchUnitTests {
    @Before
    public void setup(){
        setTestInjector();
    }

    @Test
    public void addMatch() {
        EditorPresenter presenter = new EditorPresenter();
        EditorScreen screen = mock(EditorScreen.class);
        presenter.attachScreen(screen);
        Match m = new Match();
        m.setHomeTeamScore(5);
        m.setAwayTeamScore(0);
        presenter.setCurrentMatch(m, true);
        presenter.saveMatchDetails(m);

        verify(screen, times(1)).matchSaved();
        assert MemoryRepository.matches.size() == 2;
        assert MemoryRepository.matches.get(1).getHomeTeamScore() == 5;
        assert MemoryRepository.matches.get(1).getAwayTeamScore() == 0;
        presenter.detachScreen();
    }

    @Test
    public void getMatchesForTeam() {
        MatchListPresenter presenter = new MatchListPresenter();
        MatchListScreen screen = mock(MatchListScreen.class);
        presenter.attachScreen(screen);

        Team team3 = MemoryRepository.teams.get(3);
        presenter.loadMatchesForTeam(team3);

        ArgumentCaptor<List> listCaptor = ArgumentCaptor.forClass(List.class);
        verify(screen, times(1)).matchesLoaded(listCaptor.capture());
        assert listCaptor.getValue().size() == 0;
        reset(screen);

        Team team1 = MemoryRepository.teams.get(0);
        presenter.loadMatchesForTeam(team1);
        verify(screen, times(1)).matchesLoaded(listCaptor.capture());
        assert listCaptor.getValue().size() == 1;

        presenter.detachScreen();
    }

    @Test
    public void updateMatch() {
        EditorPresenter presenter = new EditorPresenter();
        EditorScreen screen = mock(EditorScreen.class);
        presenter.attachScreen(screen);
        Match m = MemoryRepository.matches.get(0);
        m.setId(1994L);
        m.setHomeTeamScore(5);
        m.setAwayTeamScore(0);
        Random r = new Random();
        String newHighlights = r.nextInt() + "szöveg";
        m.setHighlights(newHighlights);
        presenter.setCurrentMatch(m, false);
        presenter.saveMatchDetails(m);

        verify(screen, times(1)).matchSaved();
        assert MemoryRepository.matches.size() == 1;
        assert MemoryRepository.matches.get(0).getHomeTeamScore() == 5;
        assert MemoryRepository.matches.get(0).getAwayTeamScore() == 0;
        assert MemoryRepository.matches.get(0).getHighlights().equals(newHighlights);
        presenter.detachScreen();
    }
}
