import java.util.*;
public class FM {
	
	static int hcf(int a , int b)        //Google search for ecuclid's hcf algorithm
	{
		int min = Math.min(a,b);
		int max = Math.max(a,b);
		if(min == 0)
			return max;
		else
			return hcf(max%min,min);
	}
	
	static int lcm(int a, int b)
	{
		return (a * b)/hcf(a,b);
	}
	
public static void main(String[] args) {
	
	Scanner s1 = new Scanner(System.in);
	System.out.println("Enter 2 numbers");
	int a = s1.nextInt();
	int b = s1.nextInt();
	System.out.println("HCF of "+ a + " and "+b + " = "+hcf(a,b));
	System.out.println("LCM of "+ a + " and "+b + " = "+lcm(a,b));
}
}
