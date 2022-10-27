package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MealTestData {

    public static final int NOT_FOUND = 100;

    public static final Meal meal1 = new Meal(100003,LocalDateTime.of(2022, Month.OCTOBER, 24, 7, 20, 0), "Завтрак", 500);
    public static final Meal meal2 = new Meal(100004,LocalDateTime.of(2022, Month.OCTOBER, 24, 13, 0, 0), "Обед", 1000);
    public static final Meal meal3 = new Meal(100005,LocalDateTime.of(2022, Month.OCTOBER, 24, 20, 0, 0), "Ужин", 500);
    public static final Meal meal4 = new Meal(100006,LocalDateTime.of(2022, Month.OCTOBER, 25, 0, 0, 0), "Еда на граничное значение", 100);
    public static final Meal meal5 = new Meal(100007,LocalDateTime.of(2022, Month.OCTOBER, 25, 9, 30, 0), "Завтрак", 1000);
    public static final Meal meal6 = new Meal(100008,LocalDateTime.of(2022, Month.OCTOBER, 25, 15, 0, 0), "Обед", 500);
    public static final Meal meal7 = new Meal(100009,LocalDateTime.of(2022, Month.OCTOBER, 25, 20, 0, 0), "Ужин", 410);

    public static Meal getNewMeal() {
        return new Meal(null, LocalDateTime.of(2021, Month.JANUARY, 01, 00, 1, 00), "Новогодняя еда", 1000);
    }

    public static Meal getUpdatedMeal() {
        Meal updated = meal2;
        updated.setDateTime(LocalDateTime.of(2022, Month.OCTOBER, 20, 20, 20, 0));
        updated.setDescription("UpdatedDescription");
        updated.setCalories(330);
        return updated;
    }

    public static void assertMatchForMeal(Meal actual, Meal expected) {
        System.out.println(actual);
        System.out.println(expected);
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    public static void assertMatchForMeal(Iterable<Meal> actual, Meal... expected) {
        assertMatchForMeal(actual, Arrays.asList(expected));
    }

    public static void assertMatchForMeal(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingRecursiveFieldByFieldElementComparator().isEqualTo(expected);
    }


}
