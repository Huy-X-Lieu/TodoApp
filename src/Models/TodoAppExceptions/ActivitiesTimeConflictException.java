package Models.TodoAppExceptions;

public class ActivitiesTimeConflictException extends ActivityDateTimeException{
    public ActivitiesTimeConflictException(){
        super("Activity's time conflicts with other activities' time.");
    }
}
