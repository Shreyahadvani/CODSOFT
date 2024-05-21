import java.util.Scanner;
class BankAccount
{
	private double balance;

	public BankAccount(double initialBalance)
	{
		balance=initialBalance;
	} 
	public double getBalance()
	{
		return balance;
	}
	public void deposit(double amount)
	{
		balance+=amount;
		System.out.println("Deposit sucessfully.Your current balance is: " +balance);
	}
	public boolean withdraw(double amount)
	{
		if(amount>balance)
		{
			System.out.println("Insufficient funds. Withdrawal failed.");
			return false;
		}
		balance-=amount;
		System.out.println("Withdrawal sucessful. Current balance: " +balance);
		return true;
	}
}
class ATM
{
	private BankAccount account;
	public ATM(BankAccount account)
	{
		this.account=account;
	}
	public void displayOptions()
	{
		System.out.println("1. Deposit");
		System.out.println("2. Withdrawal");
		System.out.println("3. Check Balance");
		System.out.println("4. Exit");
	}
	public void handleTransaction(int option,Scanner scanner)
	{
		switch(option)
		{
		case 1:
			System.out.println("Enter amount to deposit: ");
		   double depositAmount=scanner.nextDouble();

		   if(depositAmount>0)
		   {
		   	account.deposit(depositAmount);
		   }	
		   else
		   {
		   	System.out.println("Invalid amount.Deposit failed.");
		   }
		   break;
			

		case 2:
			System.out.println("Enter amount to withdraw: ");
			double withdrawAmount=scanner.nextDouble();

			if(withdrawAmount>0)
			{
				account.withdraw(withdrawAmount);
			}
			else
			{
				System.out.println("Invalid amount. Withdrawal failed.");
			}
			break;

		case 3:
		    System.out.println("Your balance is: "+account.getBalance());
		    break;

		case 4:
		    System.out.println("Thank you for using the creative small ATM. Bye!");
		    System.exit(0);

		default:
		     System.out.println("Invalid option.please try again.");           
		}
	}
}
public class task4
{
	public static void main(String[] args) 
	{
		BankAccount bnkAcc = new BankAccount(1000);
		ATM atm = new ATM(bnkAcc);
		Scanner scanner = new Scanner(System.in);

		while(true)
		{
			System.out.println("Welcome to the ATM. Please select an option:");
			atm.displayOptions();
			int option=scanner.nextInt();
			atm.handleTransaction(option,scanner);
		}
	}
}