package Tools.Flower;

import java.lang.reflect.Field;
import Week5.Circle;

public class ObjectF {

    public static String toString(Object o) {
        StringBuilder sb = new StringBuilder();
        sb.append(o.getClass().getTypeName())
                .append(" { object name=").append(o.getName())
                .append(", instance fields = { ");

        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            sb.append(", ").append(field.getName()).append("=").append(field);
        }

        return sb.append(" }").toString();
    }
}

class TestObjectF {
    Circle circle = new Circle(335);

    public static void main(String[] args) {
        System.out.println(ObjectF.toString(circle));
    }
}
