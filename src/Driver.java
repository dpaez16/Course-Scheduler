/**
 * @author dpaez2
 *
 */
public class Driver {
	
	// Main Method
	public static void main(String[] args) {
		Driver myApp = new Driver();
		myApp.Run();
	} // end of main method
	
	//Properties
	private Course myCourseSchedule;
	private int currentMenu = 0;
	
	
	//Constructor
	public Driver() {
		this.myCourseSchedule = null;
	}
	
	//Methods
	public void Run() {
	this.menuCheck();
	
	} // end of method

	public void menuCheck() {
		if (this.getCurrentMenu() == 0) {
			Menus.DisplayMainMenu();
			this.inputMainMenuOption();
		}
		if (this.getCurrentMenu() == 1) {
			Menus.DisplayMenu1Part1();
			this.inputMenuOption1();
		}
		if (this.getCurrentMenu() == 2) {
			if (this.myCourseSchedule == null) {
				Menus.DisplayEmptySchedule();
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.setMenu(0);
				this.menuCheck();
			}
			if (this.myCourseSchedule.getNumberOfCourses() == 1) {
				this.myCourseSchedule = null;
			} else {
			int choice = 0;
			boolean ChoiceIsOk = false;
			while(!ChoiceIsOk){
				Menus.DisplayMenu2PickCourse(this.myCourseSchedule.toString(), this.myCourseSchedule.getNumberOfCourses());
				choice = this.inputMenuOption2();
				if (choice >= 1 && choice <= this.myCourseSchedule.getNumberOfCourses()) {
					ChoiceIsOk = true;
				}
			} // end of while loop
			if (choice == 1) {
				this.myCourseSchedule = this.myCourseSchedule.getCourseLink();
				this.setMenu(0);
				this.menuCheck();
			} else {
				Course courseToBeRemoved = this.myCourseSchedule.pickCourseOut(choice, 1);
				this.myCourseSchedule.remove(this.myCourseSchedule, courseToBeRemoved);
				this.setMenu(0);
				this.menuCheck();
			}
		}
	}
		if (this.getCurrentMenu() == 3) {
			if (this.myCourseSchedule == null) {
				Menus.DisplayEmptySchedule();
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.setMenu(0);
				this.menuCheck();
			} else {
				Menus.DisplayMenu3(this.myCourseSchedule.toString());
				this.inputMenuOptionInput1();
			}
		}
		if (this.getCurrentMenu() == 4) {
			if (this.myCourseSchedule == null) {
				Menus.DisplayEmptySchedule();
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.setMenu(0);
				this.menuCheck();
			} else {
				String temp = this.myCourseSchedule.getMajorCourses();
				if (temp.equals("")) { // if schedule is empty
					temp = "You have no major related courses.";
				}
				Menus.DisplayMenu4(temp);
				this.inputMenuOptionInput1();
			}
		}
		if (this.getCurrentMenu() == 5) {
			if (this.myCourseSchedule == null) {
				Menus.DisplayEmptySchedule();
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.setMenu(0);
				this.menuCheck();
			} else {
				Menus.DisplayMenu5();
				int choice = this.inputMenuOption5();
				char pickedDay = ConvertChoiceToDay(choice);
				String day = "";
				
				if (pickedDay == 'M') day = "Monday";
				if (pickedDay == 'T') day = "Tuesday";
				if (pickedDay == 'W') day = "Wednesday";
				if (pickedDay == 'R') day = "Thursday";
				if (pickedDay == 'F') day = "Friday";
				
				String temp = this.myCourseSchedule.getScheduleForDay(pickedDay);
				if (temp.equals("")) { // if schedule is empty
					temp = "You have no classes for " + day + ".";
				}
				Menus.DisplayMenu5ScheduleForPickedDay(temp);
				this.inputMenuOptionInput1();
			}
		}
		if (this.getCurrentMenu() == 6) {
			if (this.myCourseSchedule == null) {
				Menus.DisplayEmptySchedule();
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.setMenu(0);
				this.menuCheck();
			} else {
			Menus.DisplayMenu6(this.myCourseSchedule.getTotalCreditHours());
			this.inputMenuOptionInput1();
			}
		}
		if (this.getCurrentMenu() == 7) {
			Menus.DisplayMenu7();
			this.inputQuitMenuOption();
		}
	} // end of method
	
	//Getter
	public int getCurrentMenu() {
		return this.currentMenu;
	} // end of method

	//Setter
	public void setMenu(int newMenu) {
		this.currentMenu = newMenu;
		this.menuCheck();
	} // end of method
	
	//Input Methods
	
	// Select Item in Main Menu
	public void inputMainMenuOption() {
		int choice = TextIO.getlnInt();
		if (choice >= 1 || choice <= 7) { 
			this.setMenu(choice);
		} else {
			Menus.DisplayMainMenu();
		}
	} // end of method
	
	// Select Item in Quit Menu
	public void inputQuitMenuOption() {
		int choice = TextIO.getlnInt();
		if (choice >= 1 || choice <= 2) { 
			if (choice == 1) System.exit(0);
			if (choice == 2) {
				this.setMenu(0);
			}
		} else {
			Menus.DisplayMainMenu();
		}
	} // end of method
	
	// Wait for User to Be Done with Viewing (Inputs 1, then presses enter)
	public void inputMenuOptionInput1() {
		int choice = TextIO.getlnInt();
		if (choice == 1) { 
				this.setMenu(0);
				this.menuCheck();
		} else {
				this.menuCheck();
		}
	} // end of method
	
	// User inputs data for new course to be added to schedule
	public void inputMenuOption1() {
		String courseName = TextIO.getlnString();
		Menus.DisplayMenu1Part2();
		int courseNumber = TextIO.getlnInt();
		Menus.DisplayMenu1Part3();
		String courseDescription = TextIO.getlnString();
		
		boolean startingHourIsOk = false;
		int startingHour = 0;
		while (!startingHourIsOk) {
			Menus.DisplayMenu1Part4();
			startingHour = TextIO.getlnInt();
			if (startingHour >=0 && startingHour <= 23) {
				startingHourIsOk = true;
			}
		} // end of while loop
		
		Menus.DisplayMenu1Part5();
		boolean requiredForMajor = TextIO.getlnBoolean();
		Menus.DisplayMenu1Part6();
		int numberOfCreditHours = TextIO.getlnInt();
		
		Boolean StringIsOk = false;
		String daysTheCourseMeets = "";
		
		while (!StringIsOk) {
			Menus.DisplayMenu1Part7();
			daysTheCourseMeets = TextIO.getlnString();
			String temp = daysTheCourseMeets.toUpperCase();
			StringIsOk = checkString(temp);
		} // end of while loop
		
		char[] daysTheCourseMeetsCONVERTED = daysTheCourseMeets.toUpperCase().toCharArray();
		String[] tempCourseTimeID = Course.combineCharArrayAndIntTogether(daysTheCourseMeetsCONVERTED, startingHour);
		
		Course tempCourse = new Course(courseName, courseNumber, courseDescription, startingHour, 
				requiredForMajor, numberOfCreditHours, daysTheCourseMeetsCONVERTED);
		
		if (this.myCourseSchedule == null) { //if you didn't put any courses in at all...
			this.myCourseSchedule = new Course(tempCourse, null);
			this.setMenu(0);
			this.menuCheck();
		} else { // otherwise, check for interference
			boolean interference = this.myCourseSchedule.InterferenceWithSchedule(tempCourseTimeID, false);
			if (interference) { // If interference, then exit out to menu 
				Menus.DisplayScheduleInterference();
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.setMenu(0);
				this.menuCheck();
			}
		this.myCourseSchedule = this.myCourseSchedule.insert(myCourseSchedule, tempCourse);
		this.setMenu(0);
		this.menuCheck();
		}
	} // end of method
	
	// User chooses course to be removed
	public int inputMenuOption2() {
		int choice = 0;
		boolean choiceIsOk = false;
		while (!choiceIsOk) {
			choice = TextIO.getlnInt();
			if (choice >= 1 || choice <= this.myCourseSchedule.getNumberOfCourses()) { 
				choiceIsOk = true;
			}
		} // end of while loop
			return choice;
		} // end of method
	
	// User picks day for "Display Schedule for a Day"
	public int inputMenuOption5() {
		int choice = TextIO.getlnInt();
		return choice;
	} // end of method
	
	//Helper Methods
	public static boolean checkString(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'M') continue;
			if (s.charAt(i) == 'T') continue;
			if (s.charAt(i) == 'W') continue;
			if (s.charAt(i) == 'R') continue;
			if (s.charAt(i) == 'F') continue;
			return false;
		} // end of for loop
		return true;
	} // end of method
	
	public static char ConvertChoiceToDay(int choice) {
		if (choice == 1) return 'M';
		if (choice == 2) return 'T';
		if (choice == 3) return 'W';
		if (choice == 4) return 'R';
		return 'F';
	} // end of method
	
} // end of class
