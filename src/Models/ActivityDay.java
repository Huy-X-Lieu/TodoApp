package Models;

import Models.Helpers.ActivityHelper;
import Models.TodoAppExceptions.ActivitiesTimeConflictException;

import java.util.ArrayList;

public class ActivityDay {
    ArrayList<Activity> activities = new ArrayList<>();

    public ActivityDay(){}

    public void addActivity(Activity activity) throws ActivitiesTimeConflictException {
        // if the activity list is empty
        // add activity and return
        if (activities.size() == 0) {
            activities.add(activity);
            return;
        }

        // If activity has already existed in the activity list
        // Return without doing anything
        if (this.contains(activity)) {
            return;
        }

        if (doesActivityCauseTimeConflict(activity)) {
            throw new ActivitiesTimeConflictException();
        }

        // if new activity start after the last activity in the list
        // add the new activity to the end of the list and return
        if (ActivityHelper.doesActivityHappenAfter(activity,
                activities.get(activities.size() - 1))) {
            activities.add(activity);
            return;
        }

        // find the right spot for the new activity according to its start time
        for(int i = 0; i < activities.size() - 1; i++){
            if(ActivityHelper.doesActivityHappenBefore(activity,
                    activities.get(i))){
                activities.add(i, activity);
                break;
            }
        }
    }

    public void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public boolean contains(Activity activity){
        return activities.contains(activity);
    }

    public int count(){
        return activities.size();
    }

    public int GetSumOfAllActivitiesDurationInMinutes() {
        return activities.stream().mapToInt(Activity::getDurationInMinutes).sum();
    }

    public void printToDoListOfTheDay() {
        for (Activity activity : activities) {
            System.out.println(activity);
        }
    }

    private boolean doesActivityCauseTimeConflict(Activity activity) {
        for (Activity existingActivity : activities) {
            if (this.contains(activity)) {
                break;
            }
            if (ActivityHelper.isThereAnyTimeConflict(existingActivity, activity)) {
                return true;
            }
        }

        return false;
    }
}
