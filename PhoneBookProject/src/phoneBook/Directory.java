package phoneBook;

import java.util.Arrays;
import java.util.Scanner;

public class Directory {
	
	Scanner input = new Scanner(System.in);
	
	ContactData [] entries = new ContactData[0];
	
	public void addEntries(ContactData entry) {
		ContactData[] tempContainer = new ContactData[entries.length + 1];
		for (int i = 0; i < entries.length; i++) {
			tempContainer[i] = entries[i];
		}
		tempContainer[tempContainer.length - 1] = entry;
		entries = tempContainer;
	}
	
		public void searchByName(String searchTerm) {
			String[] orderedArray = new String[entries.length];
			for (int i = 0; i < entries.length; i++) {
				orderedArray[i] = entries[i].getName();
			}
			Arrays.sort(orderedArray);
			for (int j = 0; j < orderedArray.length; j++) {
				for (int k = 0; k < entries.length; k++) {
					if (orderedArray[j] == entries[k].getName()) {
						if (entries[k].toString().contains(searchTerm)) {
							System.out.println(entries[k]);
						} 
					} else System.out.println("*************");
				}
			}
			System.out.println("Press enter to return main menu:");
			String menuReturn = input.nextLine();
}
		public void displayAll() {
			if (entries.length != 0) {
			String[] orderedArray = new String[entries.length];
			for (int i = 0; i < entries.length; i++) {
				orderedArray[i] = entries[i].getName();
			}
			Arrays.sort(orderedArray);
			for (int j = 0; j < orderedArray.length; j++) {
				for (int k = 0; k < entries.length; k++) {
					if (orderedArray[j] == entries[k].getName()) {
						System.out.println(entries[k]);
					}
				}
			}
			}else {
				System.out.println("no further entries");
			}
			System.out.println("Press enter to return main menu:");
			String menuReturn = input.nextLine();
		}

		public void searchEntryByPhoneNumber(String searchTerm) {
			for (int i = 0; i < entries.length; i++) {
				if (entries[i].toString().contains(searchTerm)) {
					System.out.println(entries[i]);
				} else {
					System.out.println("No further entries");
				}
			}
			System.out.println("Press enter to return main menu:");
			String menuReturn = input.nextLine();
		}

		public void deleteEntryByPhoneNumber(String searchTerm) {
			ContactData[] tempArray = new ContactData[entries.length - 1];
			int x = 0;
			for (int y = 0; y < entries.length; y++) {
				if (entries[y].toString().contains(searchTerm)) {

					for (int i = 0; i < entries.length; i++) {
						if (!entries[i].toString().contains(searchTerm)) {
							tempArray[x] = entries[i];
							x++;
						}
					} 
					entries = tempArray;
				} else {
					System.out.println("No further entries");
				}
			}
		}

		public void updateEntryByPhoneNumber(String searchTerm) {
			for (int i = 0; i < entries.length; i++) {
				if (entries[i].toString().contains(searchTerm)) {
					System.out.println("***********************************\n" + "What do you want to update? \n"
							+ "1. Full name\n"
							+ "2. Street address \n"
							+ "3. City \n"
							+ "4. State \n"
							+ "5. Zip code\n"
							+ "6. Phone number\n");
					String updateNeeded = input.nextLine();

					switch (updateNeeded) {
					case "1":
						System.out.println("Enter full name:");
						String a = input.nextLine();
						entries[i].setName(a);
						break;
					case "2":
						System.out.println("Enter street address:");
						String b = input.nextLine();
						entries[i].setStreetAddress(b);
						break;
					case "3":
						System.out.println("Enter city:");
						String c = input.nextLine();
						entries[i].setCity(c);
						break;
					case "4":
						System.out.println("Enter state (i.e. MO):");
						String d = input.nextLine();
						entries[i].setState(d);
						break;
					case "5":
						System.out.println("Enter zip code:");
						String e = input.nextLine();
						entries[i].setZipCode(e);
						break;
					case "6":
						System.out.println("Enter phone number:");
						String f = input.nextLine();
						entries[i].setPhoneNum(f);
						break;
					default:
						System.out.println("Invalid input; Enter a number that correlates with a menu option");
						break;
					}
				} else {
					System.out.println("*********************");
				}
			}
			System.out.println("Press enter to return to main menu:");
			String menuReturn = input.nextLine();
		}
}