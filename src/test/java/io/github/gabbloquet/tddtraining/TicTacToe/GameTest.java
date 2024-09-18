package io.github.gabbloquet.tddtraining.TicTacToe;

import org.junit.jupiter.api.Test;

import static io.github.gabbloquet.tddtraining.TicTacToe.Game.GameState.STARTED;
import static io.github.gabbloquet.tddtraining.TicTacToe.Game.GameState.STOPPED;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @Test
    public void should_start_the_game() throws GamePlayException {
        Game game = new Game();
        assertEquals(STARTED, game.getState());
    }

    @Test
    public void should_end_with_full_X_row() throws GamePlayException {
        var game = new Game();
        game.play("X", 0, 0);
        game.play("O", 1, 0);
        game.play("X", 0, 1);
        game.play("O", 1, 1);
        assertEquals(STARTED, game.getState());
        game.play("X", 0, 2);
        assertEquals(STOPPED, game.getState());
    }

    @Test
    public void should_end_with_full_X_column() throws GamePlayException {
        var game = new Game();
        game.play("X", 0, 0);
        game.play("O", 0, 1);
        game.play("X", 1, 0);
        game.play("O", 1, 1);
        assertEquals(STARTED, game.getState());
        game.play("X", 2, 0);
        assertEquals(STOPPED, game.getState());
    }

    @Test
    public void should_end_with_full_diagonal() throws GamePlayException {
        var game = new Game();
        game.play("X", 1, 1);
        game.play("O", 0, 1);
        game.play("X", 0, 0);
        game.play("O", 0, 2);
        assertEquals(STARTED, game.getState());
        game.play("X", 2, 2);
        assertEquals(STOPPED, game.getState());
    }

    @Test
    public void should_end_with_full_board() throws GamePlayException {
        var game = new Game();
        game.play("X", 0, 0);
        game.play("O", 1, 0);
        game.play("X", 2, 0);
        game.play("O", 0, 1);
        game.play("X", 1, 1);
        game.play("O", 2, 1);
        game.play("O", 0, 2);
        game.play("X", 1, 2);
        assertEquals(STARTED, game.getState());
        game.play("X", 2, 2);
        assertEquals(STOPPED, game.getState());
    }
}
