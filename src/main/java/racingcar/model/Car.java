package racingcar.model;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty() || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    public void tryMove(int randomNumber) {
        if (MoveRule.isMovable(randomNumber)) {
            move();
        }
    }

    private void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}