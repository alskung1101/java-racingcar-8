package racingcar.model;

// 자동차 객체
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
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