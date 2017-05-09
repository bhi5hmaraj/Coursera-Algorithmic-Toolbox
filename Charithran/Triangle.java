import java.util.Scanner;
public class Triangle {
public static void main(String[] args) {
	Scanner s1 = new Scanner(System.in);
	System.out.println("Enter the 3 sides of the triangle");
	int a = s1.nextInt();
	int b = s1.nextInt();
	int c = s1.nextInt();
	if((a+b)>=c && (b+c)>=a && (c+a)>= b)
	{
		if(a == b && b == c)
			System.out.print("Equilateral ");
		else if(a==b || a==c || b==c)
			System.out.print("Isoceles ");
		else 
			System.out.print("Scalene ");
		
		System.out.println("Triangle");
	}
	else
		System.out.println("Trinagle cannot be created");
}
}
