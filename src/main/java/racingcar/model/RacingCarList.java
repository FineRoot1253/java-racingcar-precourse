package racingcar.model;

import static racingcar.common.Constants.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * First Class Collection
 */
public class RacingCarList {
    private final List<Car> carList;

    private RacingCarList(List<Car> carList) {
        validateCarName(carList);
        validateDuplicate(carList);
        this.carList = carList;
    }

    /**
     * RacingCarList Creation method
     *
     * @param carList list of car
     * @return new RacingCarList
     */
    public static RacingCarList fromCarList(List<Car> carList) throws IllegalArgumentException {
        return new RacingCarList(carList);
    }

    /**
     * Returns the status of a specific Car in the list.
     *
     * @param index index of car list
     * @return the status of a specific Car in the list.
     */
    public String getCarStatus(int index) {
        return carList.get(index).toString();
    }

    /**
     * the name of car verification logic used in the creation process.
     *
     * @param carList list of car
     */
    private void validateCarName(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            String carName = car.getName();
            if (carName.length() > 5) {
                throw new IllegalArgumentException(getCarNameExMessage(carName));
            }
        }
    }

    /**
     * the car duplicate verification logic used in the creation process.
     *
     * @param carList list of car
     */
    private void validateDuplicate(List<Car> carList) {
        Set<Car> carSet = new HashSet<>();
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            String carName = car.getName();
            if (!carSet.add(car)) {
                throw new IllegalArgumentException(getCarDupExMessage(carName));
            }
        }
    }

    /**
     * Returns a message used when an exception occurs as a result of car name verification.
     *
     * @param carName name of car
     * @return exception message
     */
    private String getCarNameExMessage(String carName) {
        return COMMON_ERROR_HEADER.concat(carName).concat(ERROR_CAR_NAME_SIZE_OVER);
    }

    /**
     * Returns a message used when an exception occurs as a result of car duplicate validation.
     *
     * @param carName name of car
     * @return exception message
     */
    private String getCarDupExMessage(String carName) {
        return COMMON_ERROR_HEADER.concat(carName).concat(ERROR_CAR_DUPLICATE);
    }

}
