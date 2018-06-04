import java.util.Scanner;

public class VowelThread extends Thread{
	
	Scanner sc = new Scanner(System.in);
	public void run() {
		System.out.println("Enter the word :");
		int a=0,c=0,e=0,i1=0,o=0,u=0;
		String x = sc.next();
		x = x.toLowerCase();
		for(int i =0;i<x.length();i++) {
			switch(x.charAt(i)) {
			case 'a': a++;
					break;
			case 'e': e++;
					break;
			case 'i': i1++;
					break;
			case 'o': o++;
					break;
			case 'u': u++;
					break;
			default : c++;
			}
		}
		System.out.println("Vowel Count :"+(a+e+i1+o+u)+"\na -> "+a+"\ne -> "+e+"\ni -> "+i1+"\no -> "+o+"\nu -> "+u);
		System.out.println("Consonents :"+c);}
}
