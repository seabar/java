package snippet;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by carlos-lee on 17-1-11.
 */
public class Car {
	int i = j;
	static int j = 1;

	public static Car create(final Supplier<Car> supplier) {
		return supplier.get();
	}

	public static void collide(final Car car) {
		System.out.println("Collided " + car.toString());
	}

	public void follow(final Car another) {
		System.out.println("Following the " + another.toString());
	}

	public void repair() {
		System.out.println("Repaired " + this.toString());
	}

	public static void main(String[] args) {
//		final Car car = Car.create(Car::new);
//		final List<Car> cars = Arrays.asList(car);
//		// 这里调用静态方法能理解
//		cars.forEach(Car::collide);
//		// 这里为什么不能引用follow
//		cars.forEach(Car::repair);
//
//		final Car police = Car.create(Car::new);
//		// 这里为什么不能引用repair方法
//		System.out.println(car);
//		System.out.println(police);
//		cars.forEach(police::follow);
		String[] array = {"a", "b", "c", "d", "e"};
        Stream<String> stream = Arrays.stream(array);
		stream.peek(x->System.out.println("11"+x)).collect(Collectors.toList());
	}
}

class foo {
	 int i =10;

	void f2(String i) {
	}

	void f3(String i) {
	}

	void f3(int i, int j) {
	}
}
class ba extends foo{
	static int j =10;
	static {
		System.out.println("ba");
	}
}

class Test {
	void f1(int i) {
	}

	void f3(int i) {
	}

	void f2(int i) {
	}

	void m() {
		foo f=new foo() {
			{
				f1(1);
			}
		};
	}
}