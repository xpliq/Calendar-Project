import java.util.*;
import java.util.Scanner;

/*
 * Calendar Code
 * 
 * Algorithm:
 * 1. Ask user for year and month
 * 2. Using math for ge calculations, determine the day of the week in which the month starts in that year
 * 3. Print out month based on user input
 * 4. Print year based on user input
 * 5. Determine the amount of days from given month
 * 		5a. Make logic for leap year calculations
 * 6. Get amount of days in given month
 * 7. Using the day of which the first week starts, we build off of that for the rest of the month
 * 8. Using spacing for each day possibility to print the first day in the appropriate space
 * 9. Making a for loop to loop until finish printing the calendar days
 */

public class Calendar 
{
	static Scanner k = new Scanner(System.in);
	public static void main(String[] args)
	{
		//User inputs desired date
		System.out.println("Enter the Year: ");
		int year = k.nextInt();
		
		System.out.println("Enter the Month: ");
		int month = k.nextInt();
		
		int day = 1;
			
		//lookup the day of the week
		int dayOfTheWeek = (dayOfWeek(month, day, year));
		
		String yearC = monthName(month);
			
		System.out.println(yearC + " " + year);
			
		//Making an Array of all DaysOfTheWeek for printing of calendar
		String[] days = {"S", "M", "T", "W", "Th", "F", "S"};
		for(int i=0; i<days.length; i++)
		{
			System.out.print("  " + days[i]);
		}
		
		int daysInMonth = getMonthDays(month, year);
		
		String spacing = "";
		
		if(dayOfTheWeek == 6) //sat
		{
			spacing += "                 ";
		} 
		else if(dayOfTheWeek == 5) //fri
		{
			spacing += "              ";
		} 
		else if(dayOfTheWeek == 4) //thu
		{
			spacing += "           ";
		} 
		else if(dayOfTheWeek == 3) //wed
		{
			spacing += "        ";
		} 
		else if(dayOfTheWeek == 2) //tue
		{
			spacing += "     ";
		} 
		else if(dayOfTheWeek == 1) //mon
		{
			spacing += "  ";
		}
		else if(dayOfTheWeek == 0) //sun
		{
			spacing += "";
		}
		
		
		for(int i = 1; i <= daysInMonth; i ++) 
		{
			if(i <= 9) 
			{
				spacing += " ";
			}
			spacing += " " + i;

			
			if((i+dayOfTheWeek) == 7) 
			{
				spacing += "\n";
			} 
			else if((i+dayOfTheWeek) == 14) 
			{
				spacing += "\n";
			} 
			else if((i+dayOfTheWeek) == 21) 
			{
				spacing += "\n";
			} 
			else if((i+dayOfTheWeek) == 28) 
			{
				spacing += "\n";
			}
			else if((i+dayOfTheWeek) == 35) 
			{
				spacing += "\n";
			}
		}
		
		System.out.println("\n " + spacing);
		
	}


/*
* This method will return the day of the week [0-6] based on the Gregorian
* Calendar for any given the month, day, and year.
* @param month - given as an int, 0 for Jan, 1 for Feb., etc.
* @param day - any given day represented as an int between 0-31
* @param year - any given year represented as an int such as 2016
* @return 0 for Sunday, 1 for Monday, 2 for Tuesday, etc.
*/
	public static int dayOfWeek(int month, int day, int year) 
	{
		int y = year - (14 - month) / 12;
		
		int x = y + y/4 - y/100 + y/400;
		
		int m = month + 12 * ((14 - month) / 12) - 2;
		
		int d = (day + x + (31*m)/12) % 7;
		
		return d; //returns day of week
	}
	
/*
 * This method will run through a switch to determine the month to display
 * @param the inputed month number from the user
 * @return the corresponding month name with the number
 */
	public static String monthName(int monthNum)
	{
		String nameM = "";
		
			switch(monthNum)
			{
			case(1):
				nameM = "January";
				break;
			case(2):
				nameM = "February";
				break;
			case(3):
				nameM = "March";
				break;
			case(4):
				nameM = "April";
				break;
			case(5):
				nameM = "May";
				break;
			case(6):
				nameM = "June";
				break;
			case(7):
				nameM = "July";
				break;
			case(8):
				nameM = "August";
				break;
			case(9):
				nameM = "September";
				break;
			case(10):
				nameM = "October";
				break;
			case(11):
				nameM = "November";
				break;
			case(12):
				nameM = "December";
				break;
			default:
				break;
		}
		return nameM;
	}
	
	/*
	 * This method will determine the days needed to be printed from input month
	 * @param month input
	 * @param year input
	 * @return number of days for given month, including leap year logic
	 */
	public static int getMonthDays(int months, int yearz)
	{
		int numDays = 0;
		switch (months) 
        {
            case(1):
            	numDays = 31;
                break;
            case(2):
            	if(((yearz % 4 == 0) && (yearz % 100 != 0)) || (yearz % 400 == 0))
            	{
            		numDays = 29;
    			} 
            	else 
    			{
    				numDays = 28;
    			}
                break;
            case(3):
            	numDays = 31;
                break;
            case(4):
            	numDays = 30;
                break;
            case(5):
            	numDays = 31;
                break;
            case(6):
            	numDays = 30;
                break;
            case(7):
            	numDays = 31;
                break;
            case(8):
            	numDays = 31;
                break;
            case(9):
            	numDays = 30;
                break;
            case(10):
            	numDays = 31;
                break;
            case(11):
            	numDays = 30;
                break;
            case(12):
            	numDays = 31;
                break;
        }
		return numDays;
	}
}//end