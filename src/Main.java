import Models.Activity;
import Models.ActivityDay;
import Models.Helpers.InputHelper;
import Models.TodoAppExceptions.ActivitiesTimeConflictException;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "/Volumes/D/Java/Java/Projects/ToDoApp/src/activityInput";
        ArrayList<Activity> activities = InputHelper.getActivities(filePath);
        ActivityDay activityDay = new ActivityDay();
        for (Activity activity : activities){
            try{
                activityDay.addActivity(activity);
            } catch (ActivitiesTimeConflictException e) {
                System.out.println("Could not add activity: " + activity);
                System.out.println("Error: " + e.getMessage());
            }
        }

        activityDay.printToDoListOfTheDay();
    }
}