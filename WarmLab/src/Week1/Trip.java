package Week1;

import Tools.Sheffield.EasyReader;

import java.util.ArrayList;

public class Trip {
    private String filePath_;
    private int num_;
    private Double maxSpeed_ = 0.0, totalDistance_= 0.0, totalTime_ = 0.0, wheelDiameter_ = 0.665;
    private ArrayList<Double> timeList_ = new ArrayList<>();
    private ArrayList<Double> speedList_ = new ArrayList<>();

    Trip(String filePath) {
        this.filePath_ = filePath;
    } // the draft wheel diameter is 0.665m

    Trip(String filePath, Double wheelDiameter) {
        this.filePath_ = filePath;
        this.wheelDiameter_ = wheelDiameter;
    }

    void readFile() {
        Double tempTime, tempSpeed;
        EasyReader myFile = null;

        try {
            myFile = new EasyReader(this.filePath_);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println("Please set correct path using: setFilePath_(), and run again.");
        }

        assert myFile == null;

        if ((num_ = myFile.readInt()) != -1) {
            totalDistance_ = num_ * Math.PI * wheelDiameter_ / 1000.0;

            for (int i = 0; i < num_; i++) {
                tempTime = myFile.readDouble();
                timeList_.add(tempTime);
                totalTime_ += tempTime;

                tempSpeed = Math.PI * wheelDiameter_ / tempTime * 3.6;
                speedList_.add(tempSpeed);
                if (maxSpeed_ < tempSpeed) maxSpeed_ = tempSpeed;
            }
        } else {
            System.out.println("fff");
        }

    }

    public void setFilePath_(String filePath_) {
        this.filePath_ = filePath_;
    }

    public void setWheelDiameter_(Double wheelDiameter_) {
        this.wheelDiameter_ = wheelDiameter_;
    }

    public int getNum_() {
        return num_;
    }

    public Double getMaxSpeed_() {
        return maxSpeed_;
    }

    public Double getTotalDistance_() {
        return totalDistance_;
    }

    public Double getTotalTime_() {
        return totalTime_ / 60;
    }

    public ArrayList<Double> getTimeList_() {
        return timeList_;
    }

    public ArrayList<Double> getSpeedList_() {
        return speedList_;
    }
}
