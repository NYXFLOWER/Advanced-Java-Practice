package Week1;
import Tools.Sheffield.EasyReader;

public class ReadFromFile {
    public static void main(String[] args) {
        EasyReader units = new EasyReader("F:\\mycode\\Advanced-Java-Practice\\WarmLab\\src\\Week1\\units.txt");

        String firstLine = units.readString();
        System.out.println(firstLine);

        int secondLine = units.readInt();
        System.out.println(secondLine);

        String thirdLine = units.readString();
        System.out.println(thirdLine);
    }

}
