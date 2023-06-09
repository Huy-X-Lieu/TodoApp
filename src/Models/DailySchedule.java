package Models;

import Models.Helpers.ActivityHelper;
import Models.TodoAppExceptions.ActivitiesTimeConflictException;
import Models.TodoAppExceptions.UnexpectedActivityDateException;

import java.time.LocalDate;
import java.util.ArrayList;

public class DailySchedule {
    private final ArrayList<Activity> activities = new ArrayList<>();
    private final LocalDate date ;

    public DailySchedule(){
        this.date = LocalDate.now();
    }

    public DailySchedule(LocalDate date){
        this.date = date;
    }

    public void addActivity(Activity activity) throws ActivitiesTimeConflictException,
            UnexpectedActivityDateException {
        // If activity's day is different from dailySchedule's day
        // Then throw a day-conflict exception
        if(!this.doesActivityHappenOnTheSameDay(activity)){
            throw new UnexpectedActivityDateException();
        }
        
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

    public boolean doesActivityHappenOnTheSameDay(Activity activity){
        return this.date.isEqual(activity.getStartTime().toLocalDate());
    }
}
