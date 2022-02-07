import java.io.*;
import java.math.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class TimeTravel {

    public static void main(String[] args) {
        TimeTravel app = new TimeTravel();
    }

    public TimeTravel() {
        File filename = new File("TimeTravel/TimeData.txt");

        try {
            BufferedReader input = new BufferedReader(new FileReader(filename));
            String text;
            int count = 0;

            while ((text = input.readLine()) != null) {
                count++;
                System.out.println("Trip " + count + ":");

                String[] arr = text.split("\\s+");
                int minutes = Integer.parseInt(arr[2]);
                int hours = Integer.parseInt(arr[1]);
                int days = Integer.parseInt(arr[0]);

                Date date = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");

                String[] departure1 = simpleDateFormat.format(cal.getTime()).split("-");
                if (departure1[0].indexOf("0") == 0)
                    departure1[0] = departure1[0].substring(1);
                if (departure1[1].indexOf("0") == 0)
                    departure1[1] = departure1[1].substring(1);
                String formattedDate1 = departure1[0] + "/" + departure1[1] + "/" + departure1[2];
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm a");
                String[] departure2 = simpleDateFormat2.format(cal.getTime()).split(":");
                if (departure2[0].indexOf("0") == 0)
                    departure2[0] = departure2[0].substring(1);
                String formattedTime1 = departure2[0] + ":" + departure2[1];
                System.out.println("\tDeparture Date and Time: " + formattedTime1 + " on " + formattedDate1);

                cal.add(Calendar.MINUTE, minutes);
                cal.add(Calendar.HOUR, hours);
                cal.add(Calendar.DATE, days);

                String[] arrival1 = simpleDateFormat.format(cal.getTime()).split("-");
                if (arrival1[0].indexOf("0") == 0)
                    arrival1[0] = arrival1[0].substring(1);
                if (arrival1[1].indexOf("0") == 0)
                    arrival1[1] = arrival1[1].substring(1);
                String formattedDate = arrival1[0] + "/" + arrival1[1] + "/" + arrival1[2];

                String[] arrival2 = simpleDateFormat2.format(cal.getTime()).split(":");
                if (arrival2[0].indexOf("0") == 0)
                    arrival2[0] = arrival2[0].substring(1);
                String formattedTime = arrival2[0] + ":" + arrival2[1];
                System.out.println("\tArrival Date and Time: " + formattedTime + " on " + formattedDate);

            }

        } catch (IOException e) {
            System.out.println("File Does Not Exist");
        }

    }

}