package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.MissionUtilsRandomGenerator;
import racingcar.model.RandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Cars cars;
    private int tryCount;

    public void run() {
        initializeGame();
        startGame();
        endGame();
    }

    private void initializeGame() {
        this.cars = createCars();
        this.tryCount = inputView.inputTryCount();
    }

    private Cars createCars() {
        RandomGenerator generator = new MissionUtilsRandomGenerator();
        return new Cars(inputView.inputCarNames(), generator);
    }

    private void startGame() {
        outputView.printExecutionStart();
        for (int i = 0; i < tryCount; i++) {
            runOneRound();
        }
    }

    private void runOneRound() {
        cars.executeRound();
        outputView.printRoundResult(cars.getCars());
    }

    private void endGame() {
        outputView.printWinners(cars.getWinners());
    }
}