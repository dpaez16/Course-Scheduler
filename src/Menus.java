/**
 * @author dpaez2
 *
 */
public class Menus extends Driver {
	
	
	//Displaying Methods
	
	public static void DisplayMainMenu() {
			ClearConsole();
			System.out.println("Welcome to the Course Scheduler! Select an option below:");
			System.out.println("1) Add a Course");
			System.out.println("2) Remove a Course");
			System.out.println("3) Display Courses Alphabetically");
			System.out.println("4) Display Courses in Major");
			System.out.println("5) Display Schedule for a Day");
			System.out.println("6) Display Total Number of Credit Hours");
			System.out.println("7) Quit");
			System.out.println("Select an option from above:");
			System.out.println("(Type in a number from 1 to 7, inclusive.)");
	} // end of method
	
	// Course Name
	public static void DisplayMenu1Part1() {
		ClearConsole();
		System.out.println("Course Name:");
} // end of method
	
	// Course Number
	public static void DisplayMenu1Part2() {
		ClearConsole();
		System.out.println("Course Number:");
} // end of method
	
	// Course Description
	public static void DisplayMenu1Part3() {
		ClearConsole();
		System.out.println("Course Description:");
} // end of method
	
	// Starting Hour
	public static void DisplayMenu1Part4() {
		ClearConsole();
		System.out.println("Starting Hour:");
		System.out.println("(Please Insert a Number from 0 to 23 inclusive.)");
} // end of method
	
	// Required For Major?
	public static void DisplayMenu1Part5() {
		ClearConsole();
		System.out.println("Required for Major?");
		System.out.println("(Type in 'Yes' or 'No')");
} // end of method
	
	// Number of Credit Hours
	public static void DisplayMenu1Part6() {
		ClearConsole();
		System.out.println("Number of Credit Hours:");
} // end of method
	
	// Days The Course Meets
	public static void DisplayMenu1Part7() {
		ClearConsole();
		System.out.println("Days the Course Meets:");
		System.out.println("(Please input a string which consists of the days your class meets.)");
		System.out.println("(Ex. MTWRF, MWF, TR, etc.)");
} // end of method
	
	public static void DisplayMenu2PickCourse(String myCurrentSchedule, int numberOfCourses) {
		ClearConsole();
		System.out.println(myCurrentSchedule);
		System.out.println("\n");
		System.out.println("Pick the class that you want to remove:");
		System.out.println("(Type in a number from 1 to " + (numberOfCourses) + " inclusive.)");
	} // end of method
	
	//Display Schedule
	public static void DisplayMenu3(String mySchedule) {
		ClearConsole();
		System.out.println(mySchedule + "\n");
		System.out.println("Type in '1' when you're done.");
	} // end of method
	
	//Display Major-Related Courses
	public static void DisplayMenu4(String mySchedulePortion) {
		ClearConsole();
		System.out.println(mySchedulePortion + "\n");
		System.out.println("Type in '1' when you're done.");
	} // end of method
	
	//Pick Day of Choice
	public static void DisplayMenu5() {
		ClearConsole();
		System.out.println("Pick your day of choice:");
		System.out.println("1) Monday");
		System.out.println("2) Tuesday");
		System.out.println("3) Wednesday");
		System.out.println("4) Thursday");
		System.out.println("5) Friday");
		System.out.println("(Type in a number from 1 to 5 inclusive.)");
	} // end of method

	// Display Schedule for Day of Choice
	public static void DisplayMenu5ScheduleForPickedDay(String myScheduleForDay) {
		ClearConsole();
		System.out.println(myScheduleForDay + "\n");
		System.out.println("Type in '1' when you're done.");
	} // end of method
	
	// Display Total Credit Hours
	public static void DisplayMenu6(int totalNumberOfCreditHours) {
		ClearConsole();
		System.out.println("Total Credit Hours: " + totalNumberOfCreditHours);
		System.out.println("Type in '1' when you're done.");
	} // end of method
	
	public static void DisplayEmptySchedule() {
		ClearConsole();
		System.out.println("Your Schedule is empty!");
	} // end of method
	
	public static void DisplayScheduleInterference() {
		ClearConsole();
		System.out.println("The course you are trying to add interferes with your schedule! Sorry!");
	} // end of method
	
	// Quit?
	public static void DisplayMenu7() {
		ClearConsole();
		System.out.println("Are you sure you want to quit? - all your data will be lost.");
		System.out.println("1) Yes");
		System.out.println("2) No");
	} // end of method
	
	//Helper Methods
	public static void ClearConsole() {
		for (int i = 0; i < 20; i++)
			System.out.println("\n");
	} // end of method
	
} // end of class
