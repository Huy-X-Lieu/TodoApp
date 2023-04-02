import Models.Activity;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Activity activity = new Activity();

        String name = "Homework";
        String description = "DAR 122 Homework";
        String detail = "Design a t-shirt using Adobe Illustrator";
        String dateString = "2023/04/03";
        String timeString = "10:45";
        int duration = 90;


        int year = Integer.parseInt(dateString.split("[/-]")[0]);
        int month = Integer.parseInt(dateString.split("[/-]")[1]);
        int day = Integer.parseInt(dateString.split("[/-]")[2]);
        int hour = Integer.parseInt(timeString.split("[/:-]")[0]);
        int minute = Integer.parseInt(timeString.split("[/:-]")[1]);
        LocalDateTime date = LocalDateTime.of(year,month,day,hour,minute);

        activity = new Activity(name,description,detail,date,duration);

        System.out.println(activity);


    }
}