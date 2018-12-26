
import java.text.ParseException;
import java.util.ArrayList;

// ========================================================================================= //
// ==========================     Handling Stock Market Data      ========================== //
// ========================================================================================= //

class HandleData {
    // ********************************************************************** //
    // ** Instant Field
    // ********************************************************************** //
    private ArrayList<MyDate> data = new ArrayList<>();
    private ArrayList<Double> open = new ArrayList<>();
    private ArrayList<Double> high = new ArrayList<>();
    private ArrayList<Double> low = new ArrayList<>();
    private ArrayList<Double> close = new ArrayList<>();
    private ArrayList<Integer> volume = new ArrayList<>();


    // ********************************************************************** //
    // ** Constructor
    // ********************************************************************** //
    HandleData(String data) throws ParseException {
        this.writeToArray(data);
    }


    // ********************************************************************** //
    // ** Method for initial instant field
    // ********************************************************************** //
    private void writeToArray(String data) throws ParseException {
        String[] sp = data.split("[, ]+");
        int length = sp.length;
        for (int i = 0; i < length; i+=6) {
            this.data.add(0, new MyDate(sp[i]));
            this.open.add(0, Double.valueOf(sp[i+1]));
            this.high.add(0, Double.valueOf(sp[i+2]));
            this.low.add(0, Double.valueOf(sp[i+3]));
            this.close.add(0, Double.valueOf(sp[i+4]));
            this.volume.add(0, Integer.parseInt(sp[i+5]));
        }
    }


    // ********************************************************************** //
    // ** Method for initial instant field
    // ********************************************************************** //
    ArrayList<MyDate> getData() {
        return data;
    }

    ArrayList<Double> getOpen() {
        return open;
    }

    ArrayList<Double> getHigh() {
        return high;
    }

    ArrayList<Double> getLow() {
        return low;
    }

    ArrayList<Double> getClose() {
        return close;
    }

    ArrayList<Integer> getVolume() {
        return volume;
    }
}
