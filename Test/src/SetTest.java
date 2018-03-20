import java.util.HashSet;
import java.util.Set;


public class SetTest {
	
	public static void main(String[] args) {
		Set<TestObject> set=new HashSet<TestObject>();
		TestObject testObject1= new TestObject(1);
		set.add(testObject1);
		set.add(new TestObject(2));
		
		System.out.println(set);
		testObject1.a=2;
		System.out.println(set);
	}

}
 class TestObject{
	 public TestObject() {};
	 public TestObject(int a ) {this.a=a;};
	public int a;
	@Override
	public boolean equals(Object object) {
		
		if (a==((TestObject)object).a) {
			return true;
		}
		return false;
		
	}
	
	public String toString() {
		return String.valueOf(a);
	}
	public int hashCode() {
		int i = a*37+a;

		System.out.println(i);
		return i;
	}
}