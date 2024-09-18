package io.github.gabbloquet.tddtraining.TicTacToe;

import java.util.Objects;

public class Field {

    private String letter;

    public Field() {
        this.letter = "_";
    }

    public boolean isTaken() {
        return letter != "_";
    }

    public void take(String letter) throws GamePlayException {
        if(letter != "X" && letter != "O") {
            throw new GamePlayException();
        }
        if (this.isTaken()) {
            throw new GamePlayException();
        }
        this.letter = letter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return Objects.equals(letter, field.letter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letter);
    }

    public String toString(){
        return letter;
    }
}
