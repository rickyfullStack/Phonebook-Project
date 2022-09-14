package phoneBook;

import java.util.Scanner;

public class MainMenu {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		String menuChoice = "";
		Directory d1 = new Directory();
		do {
			System.out.println("********************************************************* \n"
					+ "Phonebook Project");
			System.out.println("1. Add a new entry : \n"
					+ "2. Search the phonebook by name, location, or telephone number \n"
					+ "3. Search an entry by phone number \n"
					+ ""
					+ "4. Delete an entry by phone number \n"
					+ "5. Update an entry by phone number \n"
					+ "6. Display all entries \n"
					+ "7. Exit \n"
					+ "*********************************************************");		
			System.out.println("Make a selection using the corresponding number:");
			menuChoice = input.nextLine();
			if (menuChoice.equals("7")) {
				System.out.println("GoodBye!");
				break;
			} else {
				switch (menuChoice) {
				case "1":
					System.out.println("What is your full name, address, and"
							+ " phone number? (e.g. John Doe, 114 Market St, St Louis," + " MO, 63403, 6366435698:");
					String userEntry = input.nextLine();
					String[] userEntryArray = userEntry.split(",");
					ContactData entry = new ContactData(userEntryArray[0], userEntryArray[1], userEntryArray[2],
							userEntryArray[3], userEntryArray[4], userEntryArray[5]);
					d1.addEntries(entry);
					break;
					
				case "2":
					System.out.println("Enter full name, last name, first name, city, or state abbreviation: ");
					String searchTerm = input.nextLine();
					d1.searchByName(searchTerm);
					break;
					
				case "3":
					System.out.println("Enter phoneNumber (i.e. 6366435698:)");
					String searchNumber = input.nextLine();
					
					searchTerm = "(" + searchNumber.charAt(0) + searchNumber.charAt(1) + searchNumber.charAt(2) + ")-"
							+ searchNumber.charAt(3) + searchNumber.charAt(4) + searchNumber.charAt(5) + "-"
							+ searchNumber.charAt(6) + searchNumber.charAt(7) + searchNumber.charAt(8)
							+ searchNumber.charAt(9);
					
					d1.searchEntryByPhoneNumber(searchTerm);
					break;
					
				case "4":
					System.out.println("Enter phoneNumber (i.e. 6366435698):");
					String searchNumber2 = input.nextLine();
					searchTerm = "(" + searchNumber2.charAt(0) + searchNumber2.charAt(1) + searchNumber2.charAt(2)
							+ ")-" + searchNumber2.charAt(3) + searchNumber2.charAt(4) + searchNumber2.charAt(5) + "-"
							+ searchNumber2.charAt(6) + searchNumber2.charAt(7) + searchNumber2.charAt(8)
							+ searchNumber2.charAt(9);
					d1.deleteEntryByPhoneNumber(searchTerm);
					break;
					
				case "5":
					System.out.println("Enter phone number of the entry to be updated (no spaces or punctuation):");
					String searchNumber3 = input.nextLine();
							searchTerm = "(" + searchNumber3.charAt(0) + searchNumber3.charAt(1) + searchNumber3.charAt(2)
							+ ")-" + searchNumber3.charAt(3) + searchNumber3.charAt(4) + searchNumber3.charAt(5) + "-"
							+ searchNumber3.charAt(6) + searchNumber3.charAt(7) + searchNumber3.charAt(8)
							+ searchNumber3.charAt(9);		
					d1.updateEntryByPhoneNumber(searchTerm);
					break;
					
				case "6":
					d1.displayAll();
					break;
			
				default:
					System.out.println("Invalid entry");
					break;
				}
			}
		} while (menuChoice != "7");
	}
}