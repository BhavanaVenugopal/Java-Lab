import java.util.Scanner;
import java.util.HashMap;

public class NumberThread extends Thread{
	HashMap<Integer,String> n = new HashMap<Integer,String>();
	Scanner sc = new Scanner(System.in);
	NumberThread(){
		createNumberMap();
	}
	public void createNumberMap() {
		n.put(1, "one");
		n.put(2, "two");
		n.put(3, "three");
		n.put(4, "four");
		n.put(5, "five");
		n.put(6, "six");
		n.put(7, "seven");
		n.put(8, "eight");
		n.put(9, "nine");
		n.put(0, "zero");	
	}
	public void run() {
		System.out.println("Enter a number not less than four digits");
		String x = sc.next();
		if(x.length()>3) {
		for(int i=0;i<x.length();i++) {
			System.out.println(x.charAt(i)+" -> "+n.get(Integer.parseInt(x.charAt(i)+"")));
		}
	}
		else {
			System.out.println("Wrong Input");
		}
	}
}
