package GrandCircus.co.lab16;

import java.util.List;
import java.util.Scanner;
public class CountryApp {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		String cont = "y";
		
		System.out.println("Welcome! Please enter you name: ");
		String userName = scnr.next();
	
		do {
		
			System.out.println(userName + ", please choose from the following: ");
			System.out.println("Enter '1' to list the countries. \nEnter '2' to add a country. \nEnter '3' to quit.");
					
			int userChoice = Validator.getInt(scnr, "\nEnter a number: ", 1, 3); //input with a validator (Have to remember to add the validation at the end
			System.out.println(); 
			
			if (userChoice == 1) {
				List<Country> countries = CountriesFileUtil.readFile(); // Lists all Countries
				for (Country country : countries) {
					System.out.println(country.getName());
				}
			}	
			else if (userChoice == 2) {
				System.out.println("What country would you like to add? "); // adding countries to the list
				String userCountry = scnr.nextLine();
				Country country = new Country(userCountry);
				CountriesFileUtil.appendLine(country);
			}
			else {
				break;
			}
			
		System.out.println("\n" + userName + ", would you like to choose again?"); // continue validaation
		cont = scnr.next();											
			
		}while (cont.trim().toLowerCase().startsWith("y"));
		
		System.out.println("Thanks for messing around with countries!");
		
		//if no file exsists this will catch it and create a new one
		CountriesFileUtil.createDirectory(System.getProperty("user.home") + "/Desktop/CountriesFolder");
		CountriesFileUtil.createBlankFile(System.getProperty("user.home") + "/Desktop/CountriesFolder/countries.txt");
		
		scnr.close();
	}

}
