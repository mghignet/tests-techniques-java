package io.github.gabbloquet.tddtraining.TicTacToe;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Nested
    class TakeField {

        @Test
        void should_not_take_field_if_wrong_x_coordinates() throws GamePlayException {
            var board = new Board();
            assertThrows(GamePlayException.class, () -> board.takeField("X", 3, 0));
            assertThrows(GamePlayException.class, () -> board.takeField("X", -1, 0));
        }

        @Test
        void should_not_take_field_if_wrong_y_coordinates() throws GamePlayException {
            var board = new Board();
            assertThrows(GamePlayException.class, () -> board.takeField("X", 0, 3));
            assertThrows(GamePlayException.class, () -> board.takeField("X", 0, -1));
        }

        @Test
        void should_take_field_if_right_coordinates() throws GamePlayException {
            var board = new Board();
            board.takeField("X", 2, 2);
            assertEquals("_,_,_\n_,_,_\n_,_,X", board.toString());
        }

    }

    @Nested
    class HasFullUniformRow {

        @Test
        void should_not_have_full_row_on_empty_board() {
            var board = new Board();
            assertEquals(false, board.hasFullUniformRow());
        }

        @Test
        void should_not_have_full_uniform_row_if_not_uniform() throws GamePlayException {
            var board = new Board();
            board.takeField("X", 0, 0);
            board.takeField("X", 0, 1);
            board.takeField("O", 0, 2);
            assertEquals(false, board.hasFullUniformRow());
        }

        @Test
        void should_have_full_uniform_row() throws GamePlayException {
            var board = new Board();
            board.takeField("X", 0, 0);
            board.takeField("X", 0, 1);
            board.takeField("X", 0, 2);
            assertEquals(true, board.hasFullUniformRow());

            board = new Board();
            board.takeField("X", 1, 0);
            board.takeField("X", 1, 1);
            board.takeField("X", 1, 2);
            assertEquals(true, board.hasFullUniformRow());

            board = new Board();
            board.takeField("X", 2, 0);
            board.takeField("X", 2, 1);
            board.takeField("X", 2, 2);
            assertEquals(true, board.hasFullUniformRow());
        }

    }

    @Nested
    class HasFullUniformColumn {

        @Test
        void should_not_have_full_column_on_empty_board() {
            var board = new Board();
            assertEquals(false, board.hasFullUniformColumn());
        }

        @Test
        void should_not_have_full_uniform_column_if_not_uniform() throws GamePlayException {
            var board = new Board();
            board.takeField("X", 0, 0);
            board.takeField("X", 1, 0);
            board.takeField("O", 2, 0);
            assertEquals(false, board.hasFullUniformColumn());
        }

        @Test
        void should_have_full_uniform_column() throws GamePlayException {
            var board = new Board();
            board.takeField("X", 0, 0);
            board.takeField("X", 1, 0);
            board.takeField("X", 2, 0);
            assertEquals(true, board.hasFullUniformColumn());

            board = new Board();
            board.takeField("X", 0, 1);
            board.takeField("X", 1, 1);
            board.takeField("X", 2, 1);
            assertEquals(true, board.hasFullUniformColumn());

            board = new Board();
            board.takeField("X", 0, 2);
            board.takeField("X", 1, 2);
            board.takeField("X", 2, 2);
            assertEquals(true, board.hasFullUniformColumn());
        }

    }

    @Nested
    class HasFullUniformDiagonal {

        @Test
        void should_not_have_full_column_if_middle_field_is_not_taken() {
            var board = new Board();
            assertEquals(false, board.hasFullUniformDiagonal());
        }

        @Test
        void should_not_have_full_uniform_column_if_not_uniform() throws GamePlayException {
            var board = new Board();
            board.takeField("X", 0, 0);
            board.takeField("X", 1, 1);
            board.takeField("O", 2, 2);
            assertEquals(false, board.hasFullUniformDiagonal());
        }

        @Test
        void should_have_full_uniform_diagonal() throws GamePlayException {
            var board = new Board();
            board.takeField("X", 0, 0);
            board.takeField("X", 1, 1);
            board.takeField("X", 2, 2);
            assertEquals(true, board.hasFullUniformDiagonal());

            board = new Board();
            board.takeField("X", 0, 2);
            board.takeField("X", 1, 1);
            board.takeField("X", 2, 0);
            assertEquals(true, board.hasFullUniformDiagonal());
        }

    }

    @Nested
    class IsFull {

        @Test
        void should_not_be_full_if_empty() {
            var board = new Board();
            assertEquals(false, board.isFull());
        }

        @Test
        void should_not_be_full() throws GamePlayException {
            var board = new Board();
            board.takeField("X", 0, 0);
            assertEquals(false, board.isFull());
        }

        @Test
        void should_be_full() throws GamePlayException {
            var board = new Board();
            board.takeField("X", 0, 0);
            board.takeField("O", 1, 0);
            board.takeField("X", 2, 0);
            board.takeField("O", 0, 1);
            board.takeField("X", 1, 1);
            board.takeField("O", 2, 1);
            board.takeField("X", 0, 2);
            board.takeField("X", 1, 2);
            board.takeField("O", 2, 2);
            assertEquals(true, board.isFull());
        }

    }

    @Nested
    class ToString {

        @Test
        void should_display_board_state() throws GamePlayException {
            Board board = new Board();
            board.takeField("X", 0, 0);
            board.takeField("X", 0, 1);
            board.takeField("O", 2, 1);
            assertEquals("X,X,_\n_,_,_\n_,O,_", board.toString());
        }
    }
}
