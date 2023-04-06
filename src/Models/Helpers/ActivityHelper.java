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

    public static boolean isThereAnyTimeConflict(Activity act1, Activity act2){
        /*
        *  If one activity's start time or end time is in the time range of
        * the other one
        * Then, there is a time conflict between two Activities
        * Return true
        *
        * If no conflict found, return false
        */
        if(act1.getStartTime().isAfter(act2.getStartTime())
                && act1.getStartTime().isBefore(act2.getEndTime())){
            return true;
        }
        if(act1.getEndTime().isAfter(act2.getStartTime())
                && act1.getEndTime().isBefore(act2.getEndTime())){
            return true;
        }
        if(act2.getStartTime().isAfter(act1.getStartTime())
                && act2.getStartTime().isBefore(act1.getEndTime())){
            return true;
        }
        if(act2.getEndTime().isAfter(act1.getStartTime())
                && act2.getEndTime().isBefore(act1.getEndTime())){
            return true;
        }
        return false;
    }

}
