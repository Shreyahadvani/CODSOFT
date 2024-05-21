import java.util.ArrayList;
import java.util.Scanner;
class Contacts
{
	private String name;
	private String phoneNumber;
	private String emailAddress;

	public Contacts(String name,String phoneNumber,String emailAddress)
	{
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.emailAddress=emailAddress;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber=phoneNumber;
	}
	public String getEmailAddress()
	{
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress=emailAddress;
	}
	public String toString()
	{
		return "Name: " + name + ",Phone Number: " + phoneNumber + ",Email Address:" + emailAddress; 
	}
}
class AddressBook
{
	private ArrayList<Contact> contacts;

	public AddressBook()
	{
		contacts=new ArrayList<>();
	}
	public void addContact(Contact contact)
	{
		contacts.add(contact);
	}
	public void removeContact(Contact contact)
	{
		contacts.remove(contact);
	}
	public Contact searchContact(String name)
	{
		for(Contact contact : contacts)
		{
			if(contact.getName().equalsIgnoreCase(name))
			{
                return contact;
			}
		}
		return null;
	}
    public void displayAllContacts()
    {
    	for(Contact contact : contacts)
    	{
    		System.out.println(contact);
    	}
    }
}
public class task5
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		AddressBook addressBook=new AddressBook();

		addressBook.addContact(new Contact("Sima","9872156428","sima@example.com"));
		addressBook.addContact(new Contact("Usha","9821548762","usha@example.com"));
		boolean running=true;
		while(running)
		{
			System.out.println("Address Book's System");
			System.out.println("1. Add new Contact");
			System.out.println("2. Remove Contact");
			System.out.println("3. Search Contact");
			System.out.println("4. Display All Contacts");
			System.out.println("5. Exit");

			System.out.println("Enter your choice:");
			int choice=scanner.nextInt();
			scanner.nextLine();

			switch(choice)
			{
			   case 1:
			   	System.out.println("Enter name:");
			   	String name=scanner.nextLine();
			   	System.out.println("Enter phone number:");
			   	String phoneNumber=scanner.nextLine();
			   	System.out.println("Enter email address:");
			   	String emailAddress=scanner.nextLine();
			   	addressBook.addContact(new Contact(name,phoneNumber,emailAddress));
			   	break;

			  case 2:
			     System.out.println("Enter name to remove:");
			     String removeName=scanner.nextLine();
			     Contact contactToRemove=addressBook.searchContact(removeName);
			     if(contactToRemove!=null)
			     {
			     	addressBook.removeContact(contactToRemove);
			     	System.out.println("Contact removed sucessfully.");
			     } 	
			     else
			     {
			     	System.out.println("Contact not found.");
			     }
			     break;

			  case 3:
			     System.out.println("Enter name to search:");
			     String searchName=scanner.nextLine();
			     Contact foundContact=addressBook.searchContact(searchName);

			     if(foundContact!=null)
			     {
			       System.out.println("Contact found:");
			       System.out.println(foundContact);
			     }
			     else
			     {
				    System.out.println("Contact not found.");
			    }
			    break;

		       case 4:
		       	System.out.println("All contacts:");
		       	addressBook.displayAllContacts();
		       	break;

		       case 5:
		          running = false;
		          break;

		       default:
		          System.out.println("Invalid choice. Please enter a number between 1 to 5.");   
		}
	}
	scanner.close();
}
}