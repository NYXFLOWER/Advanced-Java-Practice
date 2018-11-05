import java.util.*;

public class WalkingPlan {
    // instance fields - instance and static
    private static int days = 14;
    private int[] target = new int[days];
    private String name;
    private int age;

    // constructor
    public WalkingPlan() {
        generateTarget();
    }

    // methods - instance and static
    private void generateTarget() {
        // generate random walking target between 100 and 2500
        int targetLow = 100;
        int targetHigh = 2500;
        for(int i = 0; i < days; i++) {
            target[i] = generateTargetDaily(targetLow, targetHigh);
        }

        // avoid two hard days in row
        boolean hardLastDay = false;    // if last day is a hard day
        for(int i = 0; i < days; i++) {
            if (target[i] > 1500) {
                if (hardLastDay) {
                    target[i] = 1000;
                    hardLastDay = false;
                } else {
                    hardLastDay = true;
                }
            }
        }
    }

    // to print out the result
    public void toPrint() {
        String ifHard = "NO";
        String head = "|--------------------------------------------------------------|";
        String middle = "|--------------------|--------------------|--------------------|";
        String format1 = "| %-18s | %-18s | %-18s |%n";
        String format2 = "| %-18d | %-18d | %18.4s | %n";
        String format3 = "| %-102s | %n";
        System.out.println(head);
        System.out.printf(format3, "YOUR 14 DATS WALKING PLAN");
        System.out.println(this.name + " ("+ this.age + " )");
        System.out.println(head);
        System.out.println(middle);
        System.out.printf(format1, "Day", "Walk Target (m)", "If Hard");
        for (int i = 0; i < days; i++) {
            if (target[i] > 1500) {
                ifHard = "YES";
            } else {
                ifHard = "NO";
            }
            System.out.println(middle);
            System.out.printf(format2, i, target[i], ifHard);
        }
        System.out.println(head);

        // print the average and sum of walking target plan
        printAverageSum();
    }

    // caculate and display the sum and average
    private void printAverageSum() {
        int sum = 0;
        for(int j = 0; j < days; j++) {
            sum += target[j];
        }
        System.out.println("Total number of meters walked: " + sum + " m");
        System.out.println("Average number of meters walked per day: " + Math.round(sum/days) + " m");
    }

    /**
     * @param lowerBoundary : the Lower boundary of random integer
     * @param higherBoundary: the Higher boundary of random integer
     * @return re: a random integer between lower and higher random integer
     */
    private static int generateTargetDaily(int lowerBoundary, int higherBoundary) {
        Random random = new Random();
        int re = random.nextInt(higherBoundary /10);
        if (re < lowerBoundary) {generateTargetDaily(lowerBoundary, higherBoundary);};
        return re*10;
    }

    // accessors - get() and seter()

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
