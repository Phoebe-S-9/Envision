
/**
 * class to add time
 */

public class Time {
	private static int hoursPassed; // instance var

	public Time() { // constructor
		hoursPassed = 0;
	}

	// methods
	public void addHour() {
		hoursPassed++;
	}

	public int getHoursPassed() {
		return hoursPassed;
	}
}

/// ---------- notes
/*
 * (del later)
 * 
 * cd C:\Users\Phoebe\Desktop\ru hacks javac AppName.java java AppName
 * 
 */
