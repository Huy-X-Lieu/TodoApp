package Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Activity{
    private String name;
    private String description;
    private String detail;
    private LocalDateTime startTime;
    private int durationInMinutes;

    private LocalDateTime endTime;
    public Activity(){}

    public Activity(String name, String description, String detail, LocalDateTime startTime, int durationInMinutes) {
        this.name = name;
        this.description = description;
        this.detail = detail;
        this.startTime = startTime;
        this.durationInMinutes = durationInMinutes;
        this.endTime = startTime.plusMinutes(durationInMinutes);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        return "Activity{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", detail='" + detail + '\'' +
                ", start time='" + dtf.format(startTime) + '\'' +
                ", end time=" + dtf.format(startTime.plusMinutes(durationInMinutes)) +
                "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Activity activity)) return false;

        if (getDurationInMinutes() != activity.getDurationInMinutes())
            return false;
        if (!getName().equals(activity.getName())) return false;
        if (getDescription() != null ? !getDescription().equals(activity.getDescription()) : activity.getDescription() != null)
            return false;
        if (getDetail() != null ? !getDetail().equals(activity.getDetail()) : activity.getDetail() != null)
            return false;
        return getStartTime().equals(activity.getStartTime());
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), name, description, startTime, durationInMinutes);
    }

    public int compareByStartTime(Activity other){
        if(this.startTime == other.getStartTime())
            return 0;
        if(this.startTime.isBefore(other.getStartTime()))
            return -1;
        return 1;
    }
}
