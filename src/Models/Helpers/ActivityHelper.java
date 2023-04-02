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
}
