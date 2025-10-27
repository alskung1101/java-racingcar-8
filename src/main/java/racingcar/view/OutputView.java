package racingcar.view;

import racingcar.model.Car;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printExecutionStart() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println();
    }

    private void printCarPosition(Car car) {
        String positionMarker = convertPositionToMarker(car.getPosition());
        System.out.println(car.getName() + " : " + positionMarker);
    }

    private String convertPositionToMarker(int position) {
        return "-".repeat(position);
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}