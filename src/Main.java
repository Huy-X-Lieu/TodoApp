import Models.Activity;
import Models.ActivityDay;
import Models.Helpers.InputHelper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "/Volumes/D/Java/Java/Project/src/activityInput";
        ArrayList<Activity> activities = InputHelper.getActivities(filePath);
        ActivityDay activityDay = new ActivityDay();
        for (Activity activity : activities){
            activityDay.addActivity(activity);
        }

        activityDay.printToDoListOfTheDay();
    }
}