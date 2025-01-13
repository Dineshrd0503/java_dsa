public class RailwayTimeConversions {
    public static void main(String[] args) {
        System.out.println(timeConversion("07:05:45PM")); // Output: 19:05:45
        System.out.println(timeConversion("12:00:00AM")); // Output: 00:00:00
        System.out.println(timeConversion("06:40:03AM")); // Output: 06:40:03
    }
    public static String timeConversion(String s) {
        String[] timeParts = s.split(":");
        String hours = timeParts[0];
        String minutes = timeParts[1];
        String seconds = timeParts[2].substring(0, 2);
        String ampm = timeParts[2].substring(2);

        int hour = Integer.parseInt(hours);
        if (ampm.equals("PM")) {
            if (hour != 12) {
                hour += 12;
            }
        } else {
            if (hour == 12) {
                hour = 0;
            }
        }

        String newHours = String.format("%02d", hour);
        return newHours + ":" + minutes + ":" + seconds;
    }

   
    }