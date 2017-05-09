import java.util.Scanner;
public class TwinPrime {

	static boolean isPrime(int N)  //Used to check weather a number is prime or not (Same functions used in the previous question)
	{
		if(N <= 1)return false;

		for(int i=2;i * i <= N;i++)          // This loops till i <= sqrt(N)
			if(N % i == 0 )
				return false;

		return true;
	}
	
	public static void main(String[] args) {
		
		/*
		 * A twin prime is a prime number that is either 2 less or 2 more than another prime number
		 * eg. (3, 5), (5, 7), (11, 13), (17, 19)
		 */
		
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter a range ");
		int left = s1.nextInt();
		int right = s1.nextInt();
		if(right < left || left <=0 || right <= 0)  //Checking weather left and right are correct limits
		{
			System.out.println("Invalid range");
			return;
		}
		
		for(int i=left ; i<=right;i++)
		{
			if(isPrime(i) && (isPrime(i -2) || isPrime(i + 2)))   // The number should be prime AND (either (NUM - 2) OR (NUM + 2) should be prime
				System.out.print(i + " ");
		}
		
	}
}
