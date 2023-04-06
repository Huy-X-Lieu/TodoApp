package Models;

import Models.Helpers.InputHelper;
import Models.TodoAppExceptions.ActivityDateTimeException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DailyScheduleTest {


    @Test
    void cannotAddActivityIfItsTimeConflictWithOtherActivities() {
        String filePath = "/Volumes/D/Java/Java/Projects/ToDoApp/src/activityInput";
        ArrayList<Activity> activities = InputHelper.getActivities(filePath);
        DailySchedule dailySchedule = new DailySchedule();
        String actualErrorMessage = "";
        for (Activity activity : activities){
            try{
                dailySchedule.addActivity(activity);
            } catch (ActivityDateTimeException e) {
                actualErrorMessage = e.getMessage();
            }
        }

        String expectedErrorMessage = "Activity's time conflicts with other " +
                "activities' time.";
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    void getSumOfAllActivitiesDurationInMinutes() {
        DailySchedule dailySchedule = GetInitialData();

        int expectedResult = 260;
        int actualResult = dailySchedule.GetSumOfAllActivitiesDurationInMinutes();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void count(){
        DailySchedule dailySchedule = GetInitialData();

        int expectedResult = 3;
        int actualResult = dailySchedule.count();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void CheckIfAnActivityHappenOnTheSameDayAsdailySchedule(){
        DailySchedule dailySchedule = new DailySchedule();
        String input = "Homework|DAR122 Homework|Design a set 6 stamps with a" +
                "background scene|2023/04/06|2:10|240|||";

        Activity activity = InputHelper.createActivityFromStringInput(input);

        assertTrue(dailySchedule.doesActivityHappenOnTheSameDay(activity));
    }

    private DailySchedule GetInitialData() {
        String filePath = "/Volumes/D/Java/Java/Projects/ToDoApp/src/activityInput";
        ArrayList<Activity> activities = InputHelper.getActivities(filePath);
        DailySchedule dailySchedule = new DailySchedule();
        for (Activity activity : activities){
            try{
                dailySchedule.addActivity(activity);
            } catch (ActivityDateTimeException e) {
                //System.out.println(e.getMessage());
            }
        }

        return dailySchedule;
    }
}