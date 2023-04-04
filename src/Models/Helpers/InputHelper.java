package Models.Helpers;

import Models.Activity;
import Models.ActivityDay;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Stream;

public class InputHelper {
    public static ArrayList<Activity> getActivities (String filePath){
        ArrayList<Activity> activities = new ArrayList<>();
        try(FileReader inputFile = new FileReader(filePath);
            Scanner scanner = new Scanner(inputFile)){
            while (scanner.hasNext()){
                String activityString = getWholeInputString(scanner);
                Activity activity =
                        createActivityFromStringInput(activityString);
                activities.add(activity);
            }
        }catch (IOException e){
            System.out.println();
        }
        return activities;
    }

    private static Activity createActivityFromStringInput(String activityString) {
        String[] activityElements =
                activityString
                        .replace("|||", "")
                        .split("\\|");

        String name = activityElements[0];
        String description = activityElements[1];
        String detail = activityElements[2];
        String dateString = activityElements[3];
        String timeString = activityElements[4];
        int duration = Integer.parseInt(activityElements[5]);

        LocalDateTime date = getLocalDateTime(dateString, timeString);

        return new Activity(name,description,detail,date,duration);
    }

    private static LocalDateTime getLocalDateTime(String dateString, String timeString) {
        int year = Integer.parseInt(dateString.split("[/-]")[0]);
        int month = Integer.parseInt(dateString.split("[/-]")[1]);
        int day = Integer.parseInt(dateString.split("[/-]")[2]);
        int hour = Integer.parseInt(timeString.split("[/:-]")[0]);
        int minute = Integer.parseInt(timeString.split("[/:-]")[1]);
        LocalDateTime date = LocalDateTime.of(year,month,day,hour,minute);
        return date;
    }

    private static String getWholeInputString(Scanner scanner) {
        StringBuilder inputString = new StringBuilder(scanner.nextLine());
        while (!inputString.toString().endsWith("|||") && scanner.hasNext()){
            inputString.append(scanner.nextLine());
        }
        return inputString.toString();
    }
}
