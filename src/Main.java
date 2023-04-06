import Models.Activity;
import Models.DailySchedule;
import Models.Helpers.InputHelper;
import Models.TodoAppExceptions.ActivityDateTimeException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String filePath = "/Volumes/D/Java/Java/Projects/ToDoApp/src/activityInput";
        ArrayList<Activity> activities = InputHelper.getActivities(filePath);
        DailySchedule dailySchedule = new DailySchedule();
        for (Activity activity : activities){
            try{
                dailySchedule.addActivity(activity);
            } catch (ActivityDateTimeException e) {
                System.out.println("Could not add activity: " + activity);
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println();
        System.out.println("Schedule:");
        dailySchedule.printToDoListOfTheDay();
    }
}