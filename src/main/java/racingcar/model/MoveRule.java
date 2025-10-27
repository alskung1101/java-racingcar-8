package racingcar.model;

public class MoveRule {
    private static final int FORWARD_CONDITION = 4;

    public static boolean isMovable(int randomNumber) {

        return randomNumber >= FORWARD_CONDITION;
    }
}