import java.util.*;
public class LastProg {
	static boolean isPalindrome(int N)
	{
		int temp = N;
		int reverse = 0;

		while(temp > 0)								
		{
			reverse = (reverse*10) + (temp % 10);
			temp /= 10;
		}

		return reverse == N;
	}

	static boolean isAmstrong(int N)
	{
		int temp = N;
		int sum = 0;
		while(temp > 0)
		{
			int rem = temp % 10;
			sum += (rem * rem * rem);
			temp /= 10;
		}
		return sum == N;
	}
	static boolean isPerfect(int N)
	{
		int sum = 1;
		for(int i=2;i * i <= N;i++)
		{
			if(N % i == 0)
				sum += (i + (N / i));
		}
		return sum == N;
	}
	public static void main(String[] args) {

		Scanner s1 = new Scanner(System.in);
		while(true)
		{
			System.out.println(
					"Enter a option \n"
							+"1).Palindrome \n"
							+"2).Amstrong   \n"
							+"3).Perfect    \n"
							+"0).Exit       "	
					);

			int input = s1.nextInt();			
			if(input == 0)
			{
				System.out.println("Program exiting");
				return;
			}
			else
			{
				System.out.println("Enter a number");
				int N = s1.nextInt();
				switch(input)
				{
				case 1:
					if(isPalindrome(N))
						System.out.println("The number is a palindrome");
					else
						System.out.println("The number is not a palindrome");
					break;
				case 2:
					if(isAmstrong(N))
						System.out.println("The number is a amstrong number");
					else
						System.out.println("The number is not a amstrong number");
					break;
				case 3:
					if(isPerfect(N))
						System.out.println("The number is perfect");
					else
						System.out.println("The number is not perfect");
					break;
				default:
					System.out.println("Invalid input");
				}
			}
		}
	}
}
