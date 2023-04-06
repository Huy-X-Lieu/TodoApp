package Models.TodoAppExceptions;

public class UnexpectedActivityDateException extends ActivityDateTimeException{
    public UnexpectedActivityDateException(){
        super("Activity's Day must be the same as DailySchedule entity's day");
    }
}
