package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.Constants;

class RacingCarListTest {

    private static final List<Car> carList = new ArrayList<>();

    @BeforeAll
    static void init() {
        carList.add(Car.valueOf("Avent", 0));
        carList.add(Car.valueOf("Tusca", 0));
        carList.add(Car.valueOf("Boxst", 0));
    }

    @ParameterizedTest
    @CsvSource({"Avent,Avent : -", "Tusca,Tusca : -", "Boxst, Boxst : -"})
    @DisplayName("fromCarListTest:[success]")
    void fromCarListTest(String input, String expected) {
        //given
        List<Car> insideCarList = new ArrayList<>();
        insideCarList.add(Car.valueOf(input, 1));

        //when
        RacingCarList racingCarList = RacingCarList.fromCarList(insideCarList);

        //then
        assertThat(racingCarList.getCarStatus(0)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Lamborghini Aventador", "Hyundai Tuscani", "Porsche Boxster"})
    @DisplayName("fromCarListTest (차 이름 예외):[failure]")
    void fromCarListExceptionTest_NameSizeOver(String input) {
        //given
        List<Car> carList = new ArrayList<>();
        carList.add(Car.valueOf(input, 1));

        //when & then
        assertThatThrownBy(() -> RacingCarList.fromCarList(carList)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        Constants.COMMON_ERROR_HEADER);
    }

    @Test
    @DisplayName("fromCarListTest (중복 차량 예외):[failure]")
    void fromCarListExceptionTest_CarDuplicate() {
        //given
        carList.add(Car.valueOf("Avent", 0));

        //when & then
        assertThatThrownBy(() -> RacingCarList.fromCarList(carList)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        Constants.COMMON_ERROR_HEADER);
    }

}