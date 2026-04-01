abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    public void displayInfo() {
        System.out.printf("%s | Color: %s | Area: %.2f | Perimeter: %.2f%n",
                getClass().getSimpleName(), color, getArea(), getPerimeter());
    }
}

class Circle extends Shape {
    private double radius;
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private double width, height;
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }
    public double getArea() {
        return width * height;
    }
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

class Triangle extends Shape {
    private double a, b, c;
    public Triangle(String color, double a, double b, double c) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getPerimeter() {
        return a + b + c;
    }
    public double getArea() {
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle("Red", 5),
                new Rectangle("Blue", 4, 6),
                new Triangle("Green", 3, 4, 5),
                new Circle("Yellow", 2),
                new Rectangle("Black", 10, 2),
                new Triangle("White", 6, 8, 10)
        };

        double totalArea = 0;
        for (Shape s : shapes) {
            s.displayInfo();
            totalArea += s.getArea();
        }

        System.out.println("\nTotal combined area: " + String.format("%.2f", totalArea));
        System.out.print("Shape with largest area: ");
        findLargest(shapes).displayInfo();
    }

    public static Shape findLargest(Shape[] shapes) {
        Shape largest = shapes[0];
        for (Shape s : shapes) {
            if (s.getArea() > largest.getArea()) {
                largest = s;
            }
        }
        return largest;
    }
}