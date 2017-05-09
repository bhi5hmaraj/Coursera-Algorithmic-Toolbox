import java.util.Scanner;
public class SumOfOddAndEven {
public static void main(String[] args) {
	Scanner s1 = new Scanner(System.in);
	System.out.println("Enter a range ");
	int left = s1.nextInt();
	int right = s1.nextInt();
	if(right < left || left <=0 || right <= 0)  //Checking weather left and right are correct limits
	{
		System.out.println("Invalid range");
		return;
	}
	long evenSum = 0;
	long oddSum = 0;
	for(int i=left;i<=right;i++)
		if(i % 2 == 0)
			evenSum += i;
		else
			oddSum += i;
	
	System.out.println("Sum of even numbers " + evenSum);
	System.out.println("Sum of odd  numbers " + oddSum);
}
}
