package sdp;

public class Shapes {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(1, 1);
		Triangle t11 = new Triangle(1, 1);
		Triangle t12 = new Triangle(1, 1);
		Triangle t13 = new Triangle(1, 1);
		Triangle t14 = new Triangle(1, 1);

		Shape[] s1 = { r1, t11, t12, t13, t14 };
		CompositeShape cs1 = new CompositeShape(s1);

		System.out.println("cs1.area = " + cs1.area());
	}
}

abstract class Shape {
	public abstract float area();

	public abstract float circumference();
}

class Rectangle extends Shape {
	private float length;
	private float breadth;

	public Rectangle(float length, float breadth) {
		this.length = length;
		this.breadth = breadth;
	}

	public float area() {
		return this.length * this.breadth;
	}

	public float circumference() {
		return 2 * (this.length + this.breadth);
	}
}

class Triangle extends Shape {
	private float base;
	private float height;

	public Triangle(float base, float height) {
		this.base = base;
		this.height = height;
	}

	public float area() {
		return 0.5f * this.base * this.height;
	}

	public float circumference() {
		return 2 * this.base; // wrong implementation; but that's OK!
	}
}

class CompositeShape extends Shape {
	private Shape[] shapes;

	public CompositeShape(Shape[] shapes) {
		this.shapes = shapes;
	}

	public float area() {
		float sum = 0;
		for (Shape shape : this.shapes) {
			sum += shape.area();
		}
		return sum;
	}

	public float circumference() {
		return -1;
	}
}
