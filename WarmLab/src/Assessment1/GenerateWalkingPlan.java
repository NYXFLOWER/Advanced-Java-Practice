import sheffield.EasyReader;

public class GenerateWalkingPlan extends EasyReader {
    public static void main(String[] args) {
        EasyReader reader = new GenerateWalkingPlan();
        WalkingPlan plan = new WalkingPlan();

        // ask for the name and age of the user
        System.out.println("$ java Generate Walking Plan for 14 Days");
        System.out.print("What is your name? ");
        plan.setName(reader.readString());
        System.out.print("Hello " + plan.getName() +  " How old are you? ");
        plan.setAge(reader.readInt());

        // print the result
        plan.toPrint();
    }

    // this allow ask for age until it is a correct type and valid age range
    @Override
    public int readInt() {
        int re = 0;
        try {
            re = (new Integer(readString())).intValue();
        } catch (Exception e) {
            System.out.println("invalid integer number");
            System.out.print("Enter again! What is your name? ");
            re = readInt();
        }
        if (re < 30 | re > 80) {     // make sure the age is ok
            System.out.println("Please input an valid age between 30 to 80");
            re = readInt();
        }
        return re;
    }
}
