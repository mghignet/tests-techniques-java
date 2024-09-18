package io.github.gabbloquet.tddtraining.TicTacToe;

public class Game {
    private Board board;

    public enum GameState {STARTED, STOPPED}
    public GameState state;

    public Game() {
        board = new Board();
        this.state = GameState.STARTED;
    }

    public void play(String letter, int xCoordinate, int yCoordinate) throws GamePlayException {
        board.takeField(letter, xCoordinate, yCoordinate);
        if (board.hasFullUniformRow()) {
            this.stop();
            return;
        }
        if (board.hasFullUniformColumn()) {
            this.stop();
            return;
        }
        if (board.hasFullUniformDiagonal()) {
            this.stop();
            return;
        }
        if (board.isFull()) {
            this.stop();
        }
    }

    public void stop() {
        this.state = GameState.STOPPED;
    }

    public GameState getState() {
        return state;
    }
}
