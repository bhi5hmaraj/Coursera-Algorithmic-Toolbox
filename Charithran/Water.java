import java.util.Scanner;
public class Water {

	public static void main(String[] args) {
		
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter ammout of water wasted");
		int wasted = s1.nextInt();
		
		double rate = 0;
		if(wasted <= 45)
			rate  = 0.0;
		else if(wasted > 45 && wasted <= 75 )
			rate = 475.0;
		else if(wasted > 75 && wasted <= 125)
			rate = 750.0;
		else if(wasted > 125 && wasted <= 200)
			rate = 1225.0;
		else if(wasted > 200 && wasted <= 350)
			rate = 1650.0;
		else 
			rate = 2000.0;
		
		System.out.println("Ammount wasted = "+ wasted + " Fine = Rs"+rate);
	}
	
}
