import java.util.*;
import java.io.*;
public class task2
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter text or provide a file path:");
		String input=scanner.nextLine();
		String text="";
		try
		{
			File file=new File(input);
			Scanner fileScanner=new Scanner(file);

			while(fileScanner.hasNextLine())
			{
				text+=fileScanner.nextLine()+ " ";
		    }
			fileScanner.close();
		}
		catch(FileNotFoundException e)
		{
			text = input;
		}

		String[] words= text.split("[\\s\\p{Punct}]+");
		int wordCount=0;

		for(String word: words)
		{
			if(!word.isEmpty())
			{
				wordCount++;
			}
		}
		System.out.println("Total words of string:" + wordCount);
	}
}