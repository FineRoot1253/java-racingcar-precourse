package racingcar.model;

public class UserCarRacingRequest {
    private final String input;

    private UserCarRacingRequest(String input){
        this.input = input;
    }

    public static UserCarRacingRequest valueOf(String input){
        return new UserCarRacingRequest(input);
    }

    public String[] getCarNameArray(){
        return input.split(",");
    }
}
