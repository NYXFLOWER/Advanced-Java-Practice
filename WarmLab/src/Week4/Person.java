package Week4;

public class Person {
    public String name;
    public String dob; // date of birth

    public Person(String name, String dob) {
        this.name = name;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}

class Strudent extends Person{
    public String course;

    public Strudent(String name, String dob, String course) {
        super(name, dob);
        this.course = course;
    }

    @Override
    public String toString() {
        return "Strudent{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}

class Tutor extends Person{
    public String officeNumber;

    public Tutor(String name, String dob, String officeNumber) {
        super(name, dob);
        this.officeNumber = officeNumber;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", officeNumber='" + officeNumber + '\'' +
                '}';
    }
}

class Test {
    public static void main(String[] args) {
        Person person = new Person("fdfd", "jidoslfj");
        System.out.println(person.toString());

        Strudent student = new Strudent("hidhf", "ji", "jfids");
        System.out.println(student.toString());

        Tutor tutor = new Tutor("fff", "dfd", "dfd");

        Person stuPer = student;
        System.out.println(stuPer.toString());
        stuPer = tutor;
        System.out.println(stuPer.toString());
    }
}