package racingcar.model;

import java.util.Objects;
import racingcar.common.Constants;

/**
 * Value Object of Main Domain
 */
public class Car {
    private final String name;

    private int progress = 0;

    private Car(String name, int progress) {
        this.name = name;
        this.progress = progress;
    }

    /**
     * Car creation method
     * @param name name of car
     * @param progress progress of car
     * @return new Car
     */
    public static Car valueOf(String name, int progress) {
        return new Car(name, progress);
    }

    /**
     * Returns the name of the car.
     *
     * @return name of car
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a string representing the progress of the car as "PROGRESS PARTICLE".
     *
     * @return a string representing the progress of the car as "PROGRESS PARTICLE"
     */
    private String getProgressString() {
        String result = "";
        for (int i = 0; i < progress; i++) {
            result = result.concat(Constants.PROGRESS_PARTICLE);
        }
        return result;
    }

    /**
     * Increases the Car's Progress.
     */
    public void increaseProgress() {
        progress++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name.concat(" : ").concat(getProgressString());
    }
}
