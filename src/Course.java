/**
 * @author dpaez2
 *
 */
public class Course {

//Properties of Single Course
	private String courseName;
	private int courseNumber;
	private String courseDescription;
	private int startingHour;
	private boolean requiredForMajor;
	private int numberOfCreditHours;
	private char[] daysTheCourseMeets;
	private String[] courseTimeDayID;

	// "courseTimeDayID" is how I was able to make the "Add Courses" part of the program detect the interference with 
	// the schedule. See relative source code on how its implemented.
	
//Link Property
	private Course next;
	
// Constructors
	//Assuming you make 1 course only
	public Course(String newCourseName, int newCourseNumber, String newCourseDescription,
			int newStartingHour, boolean newRequiredForMajor, int newNumberofCreditHours,
			char[] newDaysTheCourseMeets) {
		
		this.courseName = newCourseName.toUpperCase();
		this.courseNumber = newCourseNumber;
		this.courseDescription = newCourseDescription;
		this.startingHour = newStartingHour;
		this.requiredForMajor = newRequiredForMajor;
		this.numberOfCreditHours = newNumberofCreditHours;
		this.daysTheCourseMeets = newDaysTheCourseMeets;
		this.courseTimeDayID = combineCharArrayAndIntTogether(this.daysTheCourseMeets, this.startingHour);
		this.next = null;
	}
	
	//Assuming you want to add on to your schedule
	public Course(Course newCourse, Course n) {
		this.courseName = newCourse.getCourseName().toUpperCase();
		this.courseNumber = newCourse.getCourseNumber();
		this.courseDescription = newCourse.getCourseDescription();
		this.startingHour = newCourse.getStartingHour();
		this.requiredForMajor = newCourse.getRequiredForMajor();
		this.numberOfCreditHours = newCourse.getCreditHours();
		this.daysTheCourseMeets = newCourse.getDaysCourseMeets();
		this.courseTimeDayID = combineCharArrayAndIntTogether(newCourse.getDaysCourseMeets(), newCourse.getStartingHour());
		this.next = n;
	}
	
// Setters
	public Course insert(Course currentCourseSchedule, Course newCourse) {
		 if (currentCourseSchedule == null || newCourse.getCourseName().compareTo(currentCourseSchedule.getCourseName()) < 0)
			 return new Course(newCourse, currentCourseSchedule);
		 else {
			 currentCourseSchedule.next = insert(currentCourseSchedule.next, newCourse);
			 return currentCourseSchedule;
		 }
		} // end of method
	
	public Course remove(Course currentCourseSchedule, Course courseToBeRemoved) {
	    if (currentCourseSchedule == null) return null;
	    Course temp = currentCourseSchedule;
	    while (temp.next != null) {
	        if (equals(temp.next, courseToBeRemoved)) temp.next = temp.next.next;
	        else temp = temp.next;
	    }
	    return equals(currentCourseSchedule, courseToBeRemoved) ? currentCourseSchedule.next : currentCourseSchedule;
	} // end of method
	
// Getters
	public int getTotalCreditHours() {
		if (next == null) {
			return this.getCreditHours();
		} else {
			return this.getCreditHours() + next.getTotalCreditHours();
		}
	} // end of method
	
	public int getNumberOfCourses() {
		if (next == null) {
			return 1;
		} else {
			return 1 + next.getNumberOfCourses();
		}
	} // end of method
	
	public Course pickCourseOut(int choice, int index) {
		if (choice == index) {
			return this;
		} else {
			return next.pickCourseOut(choice, index + 1 );
		}
	} // end of method
	
	public String toString() {
		if (next == null) {
			return this.courseName + " " + this.courseNumber + "\n" + this.courseDescription + "\n" + 
		"Starting Hour: " + this.startingHour + "\n" + "Required for Major: " + 
			this.requiredForMajor + "\n" + "Number of Credit Hours: " + this.numberOfCreditHours + 
			"\n" + "Days The Course Meets: " + charArrayToString(this.daysTheCourseMeets);
		} else {
			return this.courseName + " " + this.courseNumber + "\n" + this.courseDescription + "\n" + 
			"Starting Hour: " + this.startingHour + "\n" + "Required for Major: " + 
			this.requiredForMajor + "\n" + "Number of Credit Hours: " + this.numberOfCreditHours + 
			"\n" + "Days The Course Meets: " + charArrayToString(this.daysTheCourseMeets) + "\n" + "\n" + next.toString();
		}
	} // end of method

	public Course getCourseLink() {
		return this.next;
	} // end of method
	
	public String[] getCourseTimeID() {
		return this.courseTimeDayID;
	} // end of method
	
	public String getMajorCourses() {
		if (next == null && !this.getRequiredForMajor()) {
			return "";
		} 
		if (next == null && this.getRequiredForMajor()) {
			return this.courseName + " " + this.courseNumber + "\n" + this.courseDescription + "\n" + 
		"Starting Hour: " + this.startingHour + "\n" + "Required for Major: " + 
			this.requiredForMajor + "\n" + "Number of Credit Hours: " + this.numberOfCreditHours + 
			"\n" + "Days The Course Meets: " + charArrayToString(this.daysTheCourseMeets);
		} if (next != null && this.getRequiredForMajor()) {
			return this.courseName + " " + this.courseNumber + "\n" + this.courseDescription + "\n" + 
			"Starting Hour: " + this.startingHour + "\n" + "Required for Major: " + 
			this.requiredForMajor + "\n" + "Number of Credit Hours: " + this.numberOfCreditHours + 
			"\n" + "Days The Course Meets: " + charArrayToString(this.daysTheCourseMeets) + "\n" + "\n" + next.getMajorCourses();
		} else {
			return next.getMajorCourses();
		}
	} // end of method
	
	public String getScheduleForDay(char pickedDay) {
		if (next == null && !checkArrayForValue(this.getDaysCourseMeets(), pickedDay)) {
			return "";
		} 
		if (next == null && checkArrayForValue(this.getDaysCourseMeets(), pickedDay)) {
			return this.courseName + " " + this.courseNumber + "\n" + this.courseDescription + "\n" + 
		"Starting Hour: " + this.startingHour + "\n" + "Required for Major: " + 
			this.requiredForMajor + "\n" + "Number of Credit Hours: " + this.numberOfCreditHours + 
			"\n" + "Days The Course Meets: " + charArrayToString(this.daysTheCourseMeets);
		} if (next != null && checkArrayForValue(this.getDaysCourseMeets(), pickedDay)) {
			return this.courseName + " " + this.courseNumber + "\n" + this.courseDescription + "\n" + 
			"Starting Hour: " + this.startingHour + "\n" + "Required for Major: " + 
			this.requiredForMajor + "\n" + "Number of Credit Hours: " + this.numberOfCreditHours + 
			"\n" + "Days The Course Meets: " + charArrayToString(this.daysTheCourseMeets) + "\n" + "\n" + next.getScheduleForDay(pickedDay);
		} else {
			return next.getScheduleForDay(pickedDay);
		}
	} // end of method
	
	public String getCourseName() {
		return this.courseName;
	} // end of method

	public int getCourseNumber() {
		return this.courseNumber;
	} // end of method
	
	public String getCourseDescription() {
		return this.courseDescription;
	} // end of method

	public int getStartingHour() {
		return this.startingHour;
	} // end of method

	public boolean getRequiredForMajor() {
		return this.requiredForMajor;
	} // end of method
	
	public char[] getDaysCourseMeets() {
		return this.daysTheCourseMeets;
	} // end of method
	
	public int getCreditHours() {
		return this.numberOfCreditHours;
	} // end of method
	
	// Helper Methods
	
	public static boolean equals(Course a, Course b) {
		if (a.getCourseName().toUpperCase().equals(b.getCourseName().toUpperCase()) && 
			a.getCourseNumber() == b.getCourseNumber() &&
			a.getCourseDescription().toUpperCase().equals(b.getCourseDescription().toUpperCase()) &&
			a.getStartingHour() == b.getStartingHour() && a.requiredForMajor == b.requiredForMajor && 
			a.getCreditHours() == b.getCreditHours() && a.getDaysCourseMeets() == b.getDaysCourseMeets()) {
			return true;
		} else {
			return false;
		}
	} // end of method

	public static String charArrayToString(char[] arr, String acc, int index) {
		if (index == arr.length - 1) {
			return acc + arr[index];
		} else {
			return arr[index] + ", " + charArrayToString(arr, acc, index + 1);
		}
	} // end of method
	
	public static String[] combineCharArrayAndIntTogether(char[] arr, int x) {
		String[] temp = new String[arr.length];
		for (int i = 0; i < temp.length; i++) {
			String tempString = "" + arr[i] + x;
			temp[i] = tempString;
		} // end of for loop
		return temp;
	} // end of method
	
	public boolean InterferenceWithSchedule(String[] newCourseTimeID, boolean match) {
		if (next == null) {
			for (int i = 0; i < this.getCourseTimeID().length; i++) {
				for (int j = 0; j < newCourseTimeID.length; j++) {
					if (this.getCourseTimeID()[i].equals(newCourseTimeID[j])) {
						match = true;
					}
				} // end of j loop
			} // end of i loop
			return match;
		} else {
			for (int i = 0; i < this.getCourseTimeID().length; i++) {
				for (int j = 0; j < newCourseTimeID.length; j++) {
					if (this.getCourseTimeID()[i].equals(newCourseTimeID[j])) {
						match = true;
					}
				} // end of j loop
			} // end of i loop
			return next.InterferenceWithSchedule(newCourseTimeID, match);
		}
	} // end of method

	public static boolean checkArrayForValue(char[] arr, char key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) return true;
		} // end of for loop
		return false;
	} // end of method
	
	//Wrapper Method to above charArrayToString method
	public static String charArrayToString(char[] arr) {
		return charArrayToString(arr, "", 0);
	} // end of method
	
} // end of class
