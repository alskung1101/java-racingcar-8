package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("Car 객체 생성 시 이름이 할당되고 초기 위치는 0이다.")
    void createCarWithNameAndInitialPosition() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    // 전진 조건 4 이상일 때 위치가 1 증가하는지 확인
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 9})
    @DisplayName("전진 조건(4 이상)일 때 위치가 1 증가한다.")
    void moveForward(int randomNumber) {
        Car car = new Car("pobi");
        car.tryMove(randomNumber);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    // 정지 조건 3 이하일 때 위치가 변하지 않는지 확인
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3})
    @DisplayName("정지 조건(3 이하)일 때 위치가 변하지 않는다.")
    void stayStop(int randomNumber) {
        Car car = new Car("pobi");
        car.tryMove(randomNumber);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("MoveRule의 전진 조건(4)보다 작은 값으로 이동 시도 시 정지한다.")
    void stayWhenLessThanForwardCondition() {
        Car car = new Car("woni");
        car.tryMove(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}