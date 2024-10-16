import java.util.ArrayList;
import java.util.Arrays;

public class BowlingGame {

    private Frame[] frames = new Frame[10];  // 총 10개의 프레임
    private int currentFrame = 0;
    private int score;

    public BowlingGame() {
        for (int i = 0; i < frames.length; i++) {
            frames[i] = new Frame();  // 각 프레임을 초기화
        }
    }

    public void checkInvalidPins(int pins){
        if (pins < 0 || pins > 10) {
            throw new IllegalArgumentException("Invalid pin");
        }

        if (!frames[currentFrame].isComplete() && !frames[currentFrame].isStrike()) {
            int sumOfCurrentFrame = frames[currentFrame].getScoreForRound(0) + pins;
            if (sumOfCurrentFrame < 0 || sumOfCurrentFrame > 10) {
                throw new IllegalStateException("Invalid pins");
            }
        }
    }

    public void roll(int pins) {
        checkInvalidPins(pins);
        score += pins;

        if (strike > 0){
            score += pins * (strike -1);
            strike--;
        } else if (spare) {
            score += pins;
        }


        // strike
        if (pins == 10) {
            strike[frame*2 + round]++;
            strike[frame*2 + round+1]++;
            frame++;
            round = FIRST_ROUND;
            rolls.add(pins);
            return;
        }
        // spare
        if (rolls.size() % 2 != 0 && rolls.get(rolls.size() - 1) + pins == 10){
            spare = true;
        }
//        frame += (round+1) / 2;
//        round = round == FIRST_ROUND ? SECOND_ROUND : FIRST_ROUND;
        rolls.add(pins);
    }

    public int score() {
        return score;
    }
}
