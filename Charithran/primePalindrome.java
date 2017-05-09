import java.util.Scanner;
public class primePalindrome {

	static boolean isPrime(int N)  //Used to check weather a number is prime or not
	{
		if(N == 1)return false;

		for(int i=2;i * i <= N;i++)          // This loops till i <= sqrt(N)
			if(N % i == 0 )
				return false;

		return true;
	}

	static boolean isPalindrome(int N)
	{
		int temp = N;
		int reverse = 0;
		/*
		 * Consider this example 173 , 173 = (1*100) + (7*10) + (3*1)
		 * 
		 * As you can see you can extract the last digit of a number 
		 * by dividing the number by 10 and the remainder gives
		 * you the last digit 
		 * 
		 * For getting the reverse of the number you need to repeatedly take the last digit 
		 * and multiply it with 10 and add it to the new reversed number, simultaneously you divide the original number to get the next digit
		 * In this case,
		 *  Let temp = 173
		 * 	step 1 : reverse = (0 * 10) + (173%10) ==> reverse = 3
		 *  step 2 : reverse = (3 * 10) + (17%10)  ==> reverse = 37
		 *  step 3 : reverse = (37 * 10) + (1%10)  ==> reverse = 371
		 *  
		 *  Now temp becomes zero and the algorithm stops.
		 * 
		 */

		while(temp > 0)								
		{
			reverse = (reverse*10) + (temp % 10);
			temp /= 10;
		}

		return reverse == N;
	}
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);        //Used Scanner to get input
		System.out.println("Enter a range");
		int left = s1.nextInt();
		int right = s1.nextInt();
		if(right < left || left <=0 || right <= 0)  //Checking weather left and right are correct limits
		{
			System.out.println("Invalid range");
			return;
		}

		for(int i=left;i<=right;i++)
			if(isPrime(i) && isPalindrome(i))      //The number should be prime and also palindrome
				System.out.print(i + " ");

	}

}
