package io.github.gabbloquet.tddtraining.TicTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Board {

    private Field[][] board = new Field[3][3];

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = new Field();
            }
        }
    }

    public void takeField(String letter, int xCoordinate, int yCoordinate) throws GamePlayException {
        if (xCoordinate < 0 || xCoordinate > 2) throw new GamePlayException();
        if (yCoordinate < 0 || yCoordinate > 2) throw new GamePlayException();
        board[xCoordinate][yCoordinate].take(letter);
    }

    public String toString() {
        var rows = new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            rows.add(Arrays.stream(board[i]).map(Field::toString).collect(Collectors.joining(",")));
        }
        return String.join("\n", rows);
    }

    public boolean hasFullUniformRow() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].isTaken()
                    && board[i][0].equals(board[i][1])
                    && board[i][0].equals(board[i][2])) {
                return true;
            }
        }
        return false;
    }

    public boolean hasFullUniformColumn() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i].isTaken()
                    && board[0][i].equals(board[1][i])
                    && board[0][i].equals(board[2][i])) {
                return true;
            }
        }
        return false;
    }

    public boolean hasFullUniformDiagonal() {
        var middleField = board[1][1];
        if(!middleField.isTaken()) return false;

        if(board[0][0].equals(middleField) && board[2][2].equals(middleField)) return true;
        if(board[0][2].equals(middleField) && board[2][0].equals(middleField)) return true;
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(!board[i][j].isTaken()) return false;
            }
        }
        return true;
    }
}
