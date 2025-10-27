package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final int NAME_MAX_LENGTH = 5;

    // 자동차 이름 목록 전체에 대한 유효성 검증을 수행합니다.
    public static void validateCarNames(List<String> names) {
        validateNameLength(names);
        validateDuplication(names);
    }

    // [요구사항: 1자 이상, 5자 이하인지 검증]
    private static void validateNameLength(List<String> names) {
        for (String name : names) {
            validateSingleNameLength(name);
        }
    }

    private static void validateSingleNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
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