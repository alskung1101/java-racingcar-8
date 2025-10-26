package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("이름 목록으로 Cars 객체가 정상 생성되고 Car 목록을 가진다")
    void 이름_목록으로_Cars_객체가_생성된다() {
        List<String> names = Arrays.asList("pobi", "woni", "jun");
        Cars cars = new Cars(names);

        List<Car> carList = cars.getCars();

        assertThat(carList).hasSize(3);
        assertThat(carList).extracting("name")
                .containsExactly("pobi", "woni", "jun");
        assertThat(carList).extracting("position")
                .containsOnly(0);
    }
}