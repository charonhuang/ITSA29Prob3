import java.util.*;

public class Main {
	static final int[] day_of_month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static final int[] day_of_leap_month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static final String[] weekdays = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			int year = sc.nextInt();
			int month = sc.nextInt();
			int day = sc.nextInt();
			
			if(isValidYear(year) && isValidMonth(month) && isValidDay(year, month, day))
			{
				System.out.println(weekdays[weekdayCal(daysCal(year, month, day))]);
			}
			else
			{
				System.out.println("invalid date");
			}
		}
		
		sc.close();
	}
	
	static boolean isLeapYear(int year)
	{
		if(year%400 == 0 || (year%4==0 && year%100 != 0))
		{
			return true;
		}
		else
			return false;
	}
	
	static boolean isValidYear(int year)
	{
		if(year < 2000)
			return false;
		else
			return true;
	}
	
	static boolean isValidMonth(int month)
	{
		if(month < 1 || month > 12)
			return false;
		else
			return true;
	}
	
	static boolean isValidDay(int year, int month, int day)
	{
		if(isLeapYear(year))
		{				
			if(day < 1 || day > day_of_leap_month[month-1])
				return false;
			else
				return true;
		}
		else
		{
			if(day < 1 || day > day_of_month[month-1])
				return false;
			else
				return true;
		}
	}
	
	static int weekdayCal(int day)
	{
		return ((day-1)%7);
	}

	static int daysCal(int year, int month, int day)
	{
		int sum_of_day = 0;
		for(int i = 2000; i < year; i++)
		{
			sum_of_day += 365;
			
			if(isLeapYear(i))
			{
				sum_of_day++;
			}
		}
		
		for(int i = 1; i < month; i++)
		{
			sum_of_day += day_of_month[i-1];
			if(isLeapYear(year) && i == 2)
			{
				sum_of_day++;
			}
		}
		
		sum_of_day += day;
		
		return sum_of_day;
	}
}
