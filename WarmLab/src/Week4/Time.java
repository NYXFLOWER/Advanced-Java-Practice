package Week4;

public abstract class Time {
    public abstract int getMinutes();

    public int getSeconds() {
        return getMinutes() * 60;
    }
}

class Days extends Time {
    private int days;

    public Days(int days) {
        this.days = days;
    }

    @Override
    public int getMinutes() {
        return days * 24 * 60;
    }
}

class HoursMinutes extends Time {
    private int hours;
    private int minutes;

    @Override
    public int getMinutes() {
        return hours * 60 + minutes;
    }
}

interface iTime {
    int time = 233;
    int getMinutes();
    int getSeconds();
}

class iDays implements iTime {
    private final int days;

    public iDays(int days) {
        this.days = days;
    }

    @Override
    public int getSeconds() {
        return getMinutes() * 60;
    }

    @Override
    public int getMinutes() {
        return days * 24 * 60;
    }
}

class iHoursMinutes implements iTime {
    private final int hours;
    private final int minutes;

    public iHoursMinutes(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public int getSeconds() {
        return getMinutes() * 60;
    }

    @Override
    public int getMinutes() {
        return hours * 60 + minutes;
    }
}

class TestTime {
    public static void main(String[] args) {
        Time time = new Days(12);
        System.out.println(time.getMinutes());
        System.out.println(time.getSeconds());

        // create new interface can override the methods
        // while we can't create an object of an abstract class
        iTime iTime = new iTime() {
            @Override
            public int getMinutes() {
                return 0;
            }

            @Override
            public int getSeconds() {
                return 0;
            }
        };
        System.out.println(iTime.getMinutes());
        System.out.println("time in interface " + iTime.getSeconds());
    }
}
