package racingcar.model;

// 전진 규칙을 담당하는 클래스
public class MoveRule {
    private static final int FORWARD_CONDITION = 4;


    public static boolean isMovable(int randomNumber) {

        return randomNumber >= FORWARD_CONDITION;
    }
}