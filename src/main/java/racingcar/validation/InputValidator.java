package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static void validateCarNames(List<String> names) {
        validateDuplication(names);
    }

    private static void validateDuplication(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public static int validateTryCount(String countString) {
        try {
            return parseAndValidateCount(countString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private static int parseAndValidateCount(String countString) {
        int count = Integer.parseInt(countString);
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return count;
    }
}