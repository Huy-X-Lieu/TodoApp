package Models.TodoAppExceptions;

public class ActivitiesTimeConflictException extends Exception{
    public ActivitiesTimeConflictException(){
        super("Activity's time conflicts with other activities' time.");
    }
}
