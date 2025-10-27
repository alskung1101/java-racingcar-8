package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class MissionUtilsRandomGenerator implements RandomGenerator {

    @Override
    public int nextInt() {
        return Randoms.pickNumberInRange(0, 9);
    }
}