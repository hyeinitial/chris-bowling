import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {
    @Test
    public void gutterGame() {
        BowlingGame game = new BowlingGame();

        for (int i=0; i<20; i++){
            game.roll(0);
        }

        int score = game.score();
        assertEquals(score, 0);
    }

    @Test
    public void whenPlaysOnePinThenPointsOne() {
        BowlingGame game = new BowlingGame();
        game.roll(1);
        game.roll(0);

        for(int i=1; i<10; i++){
            game.roll(0);
            game.roll(0);
        }
        int score = game.score();
        assertEquals(score, 1);
    }

    @Test
    public void whenPlaysTenMorePinThenError() {
        BowlingGame game = new BowlingGame();
        assertThrows(IllegalArgumentException.class, () -> game.roll(11));
    }

    @Test
    public void whenPlaysOneLessPinThenError() {
        BowlingGame game = new BowlingGame();
        assertThrows(IllegalArgumentException.class, () -> game.roll(-1));
    }

    @Test
    public void whenPlaysSpareThenGetsBonus() {
        BowlingGame game = new BowlingGame();
        game.roll(7);
        game.roll(3);
        game.roll(1);
        game.roll(0);
        for(int i=3; i<10; i++){
            game.roll(0);
            game.roll(0);
        }
        int score = game.score();
        assertEquals(12, score);
    }

    @Test
    public void whenPlaysStrikeThenGetsBonus() {
        BowlingGame game = new BowlingGame();
        game.roll(10);
        game.roll(1);
        game.roll(1);
        for(int i=3; i<10; i++){
            game.roll(0);
            game.roll(0);
        }
        int score = game.score();
        assertEquals(14, score);
    }

    @Test
    public void whenPlaysTenMorePinWithinOneFrameThenError() {
        BowlingGame game = new BowlingGame();
        game.roll(4);
        assertThrows(IllegalStateException.class, () -> game.roll(7));
    }

    @Test
    public void perfectGame() {
        BowlingGame game = new BowlingGame();

        for(int i=0; i<9; i++){
            game.roll(10);
        }
        game.roll(10);
        game.roll(10);
        game.roll(10);
        int score = game.score();
        assertEquals(300, score);
    }
}