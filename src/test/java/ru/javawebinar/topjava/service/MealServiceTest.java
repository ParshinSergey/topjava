package ru.javawebinar.topjava.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {

    static {
        // Only for postgres driver logging
        // It uses java.util.logging and logged via jul-to-slf4j bridge
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private MealService service;

    @Test
    public void get() {
        Meal meal = service.get(meal1.getId(),USER_ID);
        assertMatchForMeal(meal, meal1);
    }

    @Test
    public void delete() {
        service.delete(MealTestData.meal3.getId(), ADMIN_ID);
        assertThrows(NotFoundException.class, () -> service.get(MealTestData.meal3.getId(), ADMIN_ID));
    }

    @Test
    public void getBetweenInclusive() {
        List<Meal> all = service.getBetweenInclusive(LocalDate.of(2022, Month.OCTOBER, 25), LocalDate.of(2022, Month.OCTOBER, 26), USER_ID);
        all.sort(Comparator.comparing(Meal::getDateTime));
        assertMatchForMeal(all, meal5, meal6);
    }

    @Test
    public void getAll() {
        List<Meal> all = service.getAll(USER_ID);
        assertMatchForMeal(all, meal1, meal5, meal6);
    }

    @Test
    public void update() {
        Meal updated = getUpdatedMeal();
        service.update(updated, ADMIN_ID);
        assertMatchForMeal(service.get(updated.getId(), ADMIN_ID), getUpdatedMeal());
    }

    @Test
    public void create() {
        Meal createdMeal = service.create(getNewMeal(), GUEST_ID);
        Meal newMeal = getNewMeal();
        newMeal.setId(createdMeal.getId());
        assertMatchForMeal(service.get(createdMeal.getId(), GUEST_ID), newMeal);
    }
}