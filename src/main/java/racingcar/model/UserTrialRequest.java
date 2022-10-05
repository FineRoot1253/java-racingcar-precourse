package racingcar.model;

import static racingcar.common.Constants.*;

public class UserTrialRequest {
    private final String input;

    private UserTrialRequest(String input) {
        validateInput(input);
        this.input = input;
    }

    public static UserTrialRequest valueOf(String input) throws IllegalArgumentException {
        return new UserTrialRequest(input);
    }

    public int getTrial(){
        return Integer.parseInt(input);
    }

    private void validateInput(String input) {
        try {
            int parseInt = Integer.parseInt(input);
            if (parseInt <= 0){
                throw new IllegalArgumentException(getRangeErrorMessage());
            }
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(getInputErrorMessage());
        }

    }

    private String getInputErrorMessage() {
        return COMMON_ERROR_HEADER.concat(ERROR_TRIAL_INPUT);
    }

    private String getRangeErrorMessage(){
        return COMMON_ERROR_HEADER.concat(ERROR_TRIAL_RANGE_OVER);
    }
}
