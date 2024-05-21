import java.util.Random;
import java.util.Scanner;
public class task1
{
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		Random random=new Random();
		boolean replay=true;
		int score=0;

		while(replay)
		{
			int newNumber=random.nextInt(100)+1;
			int attempt=0;
			boolean guesstrue=false;

			System.out.println("welcome guys! To the number guessing game!!");
			System.out.println("You can guess a number between 1 and 100.Can you guess it?");

			while(!guesstrue && attempt<10)
			{
				System.out.println("Enter your guessing number:");
				int guessing=scanner.nextInt();
				attempt++;

				if(guessing==newNumber)
				{
					System.out.println("YESS! you guessing  the true number in"+attempt+"attempts.");
					guesstrue = true;
					score++;
				}
               else if(guessing < newNumber)
               {
               	System.out.println("Noo! It's too lower than number,try again.");
               }
               else
               {
               	System.out.println("Noo! It's too higher than number,try again.");
               }
			}
			if(!guesstrue)
			{
				System.out.println("Sorry! you can used your all attempts try again! The correct number was:"+ newNumber);
			}

			System.out.print("If you interested than you can replay? (Yes or No)");
			String playAgainResponse=scanner.next().toLowerCase();

			if(!playAgainResponse.equals("Yes"))
			{
				replay = false;
			}	
		} 
		System.out.println("Your score is:"+score);
		scanner.close();
	}
}