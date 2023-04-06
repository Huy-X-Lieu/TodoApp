package Models;

import Models.Helpers.InputHelper;
import Models.TodoAppExceptions.ActivitiesTimeConflictException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDayTest {


    @Test
    void cannotAddActivityIfItsTimeConflictWithOtherActivities() {
        String filePath = "/Volumes/D/Java/Java/Projects/ToDoApp/src/activityInput";
        ArrayList<Activity> activities = InputHelper.getActivities(filePath);
        ActivityDay activityDay = new ActivityDay();
        String actualErrorMessage = "";
        for (Activity activity : activities){
            try{
                activityDay.addActivity(activity);
            } catch (ActivitiesTimeConflictException e) {
                actualErrorMessage = e.getMessage();
            }
        }

        String expectedErrorMessage = "Activity's time conflicts with other " +
                "activities' time.";
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    void getSumOfAllActivitiesDurationInMinutes() {
        ActivityDay activityDay = GetInitialData();

        int expectedResult = 260;
        int actualResult = activityDay.GetSumOfAllActivitiesDurationInMinutes();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void count(){
        ActivityDay activityDay = GetInitialData();

        int expectedResult = 3;
        int actualResult = activityDay.count();

        assertEquals(expectedResult, actualResult);
    }

    private ActivityDay GetInitialData() {
        String filePath = "/Volumes/D/Java/Java/Projects/ToDoApp/src/activityInput";
        ArrayList<Activity> activities = InputHelper.getActivities(filePath);
        ActivityDay activityDay = new ActivityDay();
        for (Activity activity : activities){
            try{
                activityDay.addActivity(activity);
            } catch (ActivitiesTimeConflictException e) {
                //System.out.println(e.getMessage());
            }
        }

        return activityDay;
    }
}