package Week5;/*
 * Circle.java
 *
 * Copyright (c) University of Sheffield 2014
 */


import java.util.Objects;

public class Circle {

    // constructor
    public Circle( double r ) {
	radius = r;
    }

    // class method
    public static double radToDeg( double angleRad ) {	
	return angleRad * 180.0 / PI;
    }


    // instance methods
    public double area() {
	// returns area of the circle
	    return PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            System.out.println("Point to the same memory location");
            return true;
        }
        if (!(o instanceof Circle)) return false;

        Circle circle = (Circle) o;
        return Double.compare(circle.radius, this.radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    public double circumference() {
	// returns circumference of the circle
	    return 2.0 * PI * radius;
    }
		
    // class field
    public static final double PI = 3.1415927;
		
    // instance field
    private double radius;

}

class TestCircle {
    // The static variables are often used for constants, which is common to all the instances.
    // The static function are used to do some utility task, and can be called without any object declaration.
    public static void main(String[] args) {
        // Test static variable and function
//        System.out.println(Circle.PI);
//        System.out.println(Circle.radToDeg(3.141));

// -----------------------------------Part 5-------------------------------------//
        Circle myCircle = new Circle(12.2);
        System.out.println(myCircle.toString());
        System.out.println(myCircle.getClass());
        System.out.println(myCircle.hashCode());

        Circle myCircle2 = new Circle(155.4);
        System.out.println(myCircle2.hashCode());

        Circle myCircle3 = myCircle2;
        System.out.println(myCircle3.hashCode());
    }
}
