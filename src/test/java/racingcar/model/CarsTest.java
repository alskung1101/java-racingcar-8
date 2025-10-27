package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private static class FixedNumberGenerator implements RandomGenerator {
        private final Queue<Integer> numbers;

        public FixedNumberGenerator(Integer... numbers) {
            this.numbers = new LinkedList<>(Arrays.asList(numbers));
        }

        @Override
        public int nextInt() {
            return numbers.poll();
        }
    }

    @Test
    @DisplayName("이름 목록으로 Cars 객체가 정상 생성되고 Car 목록을 가진다")
    void 이름_목록으로_Cars_객체가_생성된다() {
        List<String> names = Arrays.asList("pobi", "woni", "jun");
        Cars cars = new Cars(names, new FixedNumberGenerator(1, 1, 1));

        List<Car> carList = cars.getCars();

        assertThat(carList).hasSize(3);
        assertThat(carList).extracting("name")
                .containsExactly("pobi", "woni", "jun");
        assertThat(carList).extracting("position")
                .containsOnly(0);
    }

    @Test
    @DisplayName("라운드 실행 시 고정된 난수(Mocking)에 따라 자동차가 이동한다")
    void 라운드_실행_시_자동차들이_규칙에_따라_이동한다() {
        RandomGenerator fixedRandom = new FixedNumberGenerator(4, 3, 5);
        List<String> names = Arrays.asList("pobi", "woni", "jun");
        Cars cars = new Cars(names, fixedRandom);

        cars.executeRound();

        List<Car> carList = cars.getCars();
        assertThat(carList.get(0).getPosition()).isEqualTo(1);
        assertThat(carList.get(1).getPosition()).isEqualTo(0);
        assertThat(carList.get(2).getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("최대 위치를 가진 자동차들을 우승자로 선정한다")
    void 우승자_선정() {

        RandomGenerator fixedRandom = new FixedNumberGenerator(
                4, 4, 4,
                4, 4, 4,
                4, 4, 4
        );
        List<String> names = Arrays.asList("pobi", "woni", "jun");
        Cars cars = new Cars(names, fixedRandom);

        cars.executeRound();
        cars.executeRound();
        cars.executeRound();

        List<Car> winners = cars.getWinners();

        assertThat(cars.getMaxPosition()).isEqualTo(3);
        assertThat(winners).hasSize(3);
        assertThat(winners).extracting("name")
                .containsExactlyInAnyOrder("pobi", "woni", "jun");
    }
}