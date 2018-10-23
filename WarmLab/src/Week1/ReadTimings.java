package Week1;


import Tools.Sheffield.EasyReader;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ReadTimings {
    public static void main(String[] args) {
        // EasyReader myFile = new EasyReader("F://mycode//Advanced-Java-Practice//lab//src//week1//timings.txt"); // just
        // change the pathway in your computer

//        int num = myFile.readInt();
//        double tempTime;
//        DecimalFormat df = new DecimalFormat("0.000");
//        ArrayList<Double> time = new ArrayList<>();
//        ArrayList<Double> speed = new ArrayList<>();
//        System.out.println(num);
//
//        for (int i = 0; i < num; i++) {
//            tempTime = myFile.readDouble();
//            time.add(tempTime);
//
//            speed.add(Math.PI * 0.665 / tempTime * 3.6);
//            System.out.println(df.format(speed.get(i)) + " km/h");
//        }
//
        String path = "F://mycode//Advanced-Java-Practice//lab//src//week1//timings.txt";
        Trip myTrip = new Trip(path);
        myTrip.readFile();
        ArrayList<Double> timeList = myTrip.getTimeList_();
        ArrayList<Double> speedList = myTrip.getSpeedList_();
        System.out.println("This is the speed list: ");
        for(Double speed: speedList) {
            System.out.println(speed + " km/h");
        }

        System.out.println("The total time is: " + myTrip.getTotalTime_() + " mins");
        System.out.println("The total distance is: " + myTrip.getTotalDistance_() + " km");
        System.out.println("The max speed is: " + myTrip.getMaxSpeed_() + " km/h");
    }
}
