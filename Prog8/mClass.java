
public class mClass {
	public static void main(String[] args) {
		Thread t1,t2;
		t1 = new NumberThread();
		t2 = new VowelThread();
		t1.start();
		try {
			t1.join();
		}
		catch(Exception e) {
			System.out.println("Error :"+e);
		}
		t2.start();
	}

}
