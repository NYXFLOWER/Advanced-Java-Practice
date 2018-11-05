/**
 * CorrectReader
 * Provides a simple interface for text stream input. The 'correct' means that the program will ask for a new input
 * again and again until the user input correctly.
 * @author Hao Xu
 * First version 11/03/2018
 */

import sheffield.EasyReader;
import java.io.InputStream;

public class CorrectReader extends EasyReader {
    /**
     * Create a new CorrectReader that reads from System.in
     */
    public CorrectReader(InputStream in) {
        super();
    }

    @Override
    public double readDouble() {
        Double re = 0.0;
        try {
            re = (new Double(readString())).doubleValue();
        } catch (Exception e) {
            System.out.println("invalid double number");
            System.out.println("Enter again!");
            re = readDouble();
        }
        return re;
    }

    @Override
    public float readFloat() {
        float re = 0;
        try {
            re = (new Float(readString())).floatValue();
        } catch (Exception e) {
            System.out.println("invalid floating point number");
            System.out.println("Enter again!");
            re = readFloat();
        }
        return re;
    }

//    @Override
//    public int readInt() {
//        int re = 0;
//        try {
//            re = (new Integer(readString())).intValue();
//        } catch (Exception e) {
//            System.out.println("invalid integer number");
//            System.out.println("Enter again!");
//            re = readInt();
//        }
//        return re;
//    }

    public static void main(String[] args) {
        EasyReader cr = new CorrectReader(System.in);
        System.out.println(cr.readDouble());
    }
}
