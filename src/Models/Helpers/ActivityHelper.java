package Models.Helpers;

import Models.Activity;

import java.time.format.DateTimeFormatter;

public class ActivityHelper {
    public static String getSummary(Activity activity){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM" +
                "/dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return "Activity{" +
                "name='" + activity.getName() +"'"+
                "description='" + activity.getDescription() + '\'' +
                "Date='" + dateFormat.format(activity.getStartTime()) + '\'' +
                "From:'" + timeFormatter.format(activity.getStartTime()) + '\'' +
                "Until:'" + timeFormatter.format(
                activity.getStartTime().plusMinutes(activity.getDurationInMinutes())) + '\'';
    }

    public static boolean doesActivityHappenBefore(Activity act1, Activity act2){
        return act1.getStartTime().isBefore(act2.getStartTime());
    }

    public static boolean doesActivityHappenAfter(Activity act1, Activity act2){
        return !doesActivityHappenBefore(act1, act2);
    }

}
