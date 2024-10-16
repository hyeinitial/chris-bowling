public class Frame {
    private int currentRound = 0;
    private boolean isStrike = false;
    private Integer[] rounds = new Integer[2];  // 각 프레임은 두 번의 라운드(roll)를 가짐// 현재 진행 중인 라운드 인덱스 (0 또는 1)
    private Integer[] bonus = new Integer[2];

    public void addRoll(int pins) throws Exception {
        if (pins == 10) {
            bonus[0]++;
            isStrike = true;
        }
        if (currentRound < 2) {
            rounds[currentRound] = pins;
            currentRound++;
        } else {
            throw new Exception("프레임에 더 이상 점수를 추가할 수 없습니다.");
        }
    }

    public Integer getScoreForRound(int roundNumber){
        if (isStrike) {
            return 10;
        }
//        if (roundNumber < 1 || roundNumber > 2) {
//            throw new Exception("유효하지 않은 라운드 번호입니다. 1 또는 2이어야 합니다.");
//        }
        return rounds[roundNumber - 1];
    }

    public boolean isComplete() {
        return rounds[0] != null && rounds[1] != null;  // 두 라운드가 모두 완료되었는지 확인
    }

    public boolean isStrike() {
        return isStrike;
    }

//    public void setRound(int pin) {
//        if (pin == 10) {
//            frame++;
//            round = STRIKE_ROUND;
//        }
//        frame += (round+1) / 2;
//        round = round == FIRST_ROUND ? SECOND_ROUND : FIRST_ROUND;
//    }
}
