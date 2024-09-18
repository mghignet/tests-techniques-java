package io.github.gabbloquet.tddtraining.TicTacToe;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FieldTest {

    @Nested
    class IsTaken {

        @Test
        void should_not_be_taken() {
            var field = new Field();
            assertEquals(false, field.isTaken());
        }

        @Test
        void should_be_taken() throws GamePlayException {
            var field = new Field();
            field.take("X");
            assertEquals(true, field.isTaken());
        }

    }

    @Nested
    class Take {

        @Test
        void should_not_take_if_letter_is_wrong() throws GamePlayException {
            var field = new Field();
            assertThrows(GamePlayException.class, () -> field.take("F"));
        }

        @Test
        void should_not_take_if_already_taken() throws GamePlayException {
            var field = new Field();
            field.take("X");
            assertThrows(GamePlayException.class, () -> field.take("X"));
        }

        @Test
        void should_take_if_letter_is_X() throws GamePlayException {
            var field = new Field();
            field.take("X");
            assertEquals("X", field.toString());
        }

        @Test
        void should_take_if_letter_is_O() throws GamePlayException {
            var field = new Field();
            field.take("O");
            assertEquals("O", field.toString());
        }

    }

}
