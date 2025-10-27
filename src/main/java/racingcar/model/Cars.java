package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    private final RandomGenerator randomGenerator;

    public Cars(List<String> carNames, RandomGenerator randomGenerator) {
        this.cars = createCars(carNames);
        this.randomGenerator = randomGenerator;
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void executeRound() {
        cars.forEach(car -> {
            int randomNumber = randomGenerator.nextInt();
            car.tryMove(randomNumber);
        });
    }
    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}