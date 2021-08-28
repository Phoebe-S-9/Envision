
/**
 * Idea: Create an app in Java that detects symptoms, as well as provide resources to educate on opioid overdose
 * Ru hacks may 2020
 * App name: Envision
 */

/*
 * Envision: video demo
 * https://www.youtube.com/watch?v=5zeVL2MalLo&ab_channel=PhoebeS 
 */

import java.util.Scanner;

public class AppName {

	private static final String exitMessage = " (0 to exit)"; // to leave loop

	/**
	 * choose between 2 main functions. welcome: c (chatBot) or d (detectSymptoms)
	 */
	public static void main(String[] args) {
		boolean askAgain = true;

		do {
			System.out.println("\nWelcome: chatBot or detectSymptoms?" + exitMessage);
			Scanner scannerChoice = new Scanner(System.in);
			String responseChoice = scannerChoice.next();

			if (responseChoice.equalsIgnoreCase("chatBot") || responseChoice.equalsIgnoreCase("c")) {
				// System.out.println("running chatBot"); //debug
				chatBot();

			} else if (responseChoice.equalsIgnoreCase("detectSymptoms") || responseChoice.equalsIgnoreCase("d")) {
				// System.out.println("running detectSymptoms"); //debug
				detectSymptoms();

			} else if (responseChoice.equals("0")) { // exit
				askAgain = false;

			} else {
				System.out.println("invalid");
			}
		} while (askAgain == true);
	}

	/**
	 * Create a chatbot to educate on symptoms and laws regarding opioid use //use
	 * text to speech chat bot: how, help, or notif help: info, friend, 911, or
	 * helpline notif: get hours passed or add an hour
	 */
	public static void chatBot() {
		boolean askAgain = true;
		int strikes = 0;

		do {

			System.out.println("\nchatBot: Ask 'how are you' or 'help' or 'notif'." + exitMessage);
			Scanner scannerChat1 = new Scanner(System.in);
			String responseChat1 = scannerChat1.nextLine();

			if (responseChat1.equalsIgnoreCase("how are you") || responseChat1.equalsIgnoreCase("How")) {
				System.out.println("I'm fine. How are you");
				// starts a mini convo

			} else if (responseChat1.equalsIgnoreCase("help")) {
				boolean askAgain2 = true;

				do {
					System.out
							.println("\nHelp: Get information, call friend, call 911, or call helpline" + exitMessage);
					Scanner scannerChat = new Scanner(System.in);
					String responseChat = scannerChat.next();

					if (responseChat.equalsIgnoreCase("i") || responseChat.equalsIgnoreCase("information")) { // gives
																												// info
																												// about
																												// symptoms
						System.out.println(
								"things to look for: \nOpiates/Opioids: Changes in skin colour, Pinpoint pupils, Unconscious.\nStimulants: Foaming at the mouth, Heavy sweating \nHallucinogens:Trance-like state \nAlcohol:Clammy skin, Vomiting");

					} else if (responseChat.equalsIgnoreCase("f") || responseChat.equalsIgnoreCase("friend")) {
						System.out.println("calling a friend"); // calls a friend

					} else if (responseChat.equalsIgnoreCase("9") || responseChat.equalsIgnoreCase("911")) {
						System.out.println("calling 911 "); // calls 911

					} else if (responseChat.equalsIgnoreCase("h") || responseChat.equalsIgnoreCase("helpline")) {
						System.out.println("calling a helpline"); // calls a mental health or drug prevention helpline.
																	// Or can give numbers/websites to dif resources

					} else if (responseChat.equals("0")) { // exit
						askAgain2 = false;

					} else {
						System.out.println("invalid");
					}
				} while (askAgain2 == true);

			} else if (responseChat1.equalsIgnoreCase("notif") || responseChat1.equalsIgnoreCase("n")) {
				strikes = notif(strikes);

			} else if (responseChat1.equals("0")) { // exit
				// askAgain = false;
				return;

			} else {
				System.out.println("invalid");
			}
		} while (askAgain == true);
	}

	/**
	 * Set notifications if you are doing opioids alone and to ensure that you are
	 * okay
	 */
	public static int notif(int strikes) {
		final int CHECK_TIME = 3; // every few hours
		boolean askAgain = true;

		Time time = new Time();
		int hoursPassed = time.getHoursPassed();

		// change the time

		do {
			System.out.println("\nnotif: get hours passed, or add an hour" + exitMessage);
			Scanner scannerNotif = new Scanner(System.in);
			String responseNotif = scannerNotif.nextLine();

			if (responseNotif.equalsIgnoreCase("get") || responseNotif.equalsIgnoreCase("g")) {
				System.out.println("hoursPassed = " + time.getHoursPassed());
				// System.out.println("hoursPassed = " + hoursPassed + " " +
				// time.getHoursPassed()); //debug

			} else if (responseNotif.equalsIgnoreCase("add") || responseNotif.equalsIgnoreCase("a")) {
				System.out.println("adding an hour");
				time.addHour();
				hoursPassed = time.getHoursPassed();

				// System.out.println("hoursPassed = " + hoursPassed + " " +
				// time.getHoursPassed()); //debug

				if (hoursPassed == CHECK_TIME) {
					askAgain = false;
				}

			} else if (responseNotif.equals("0")) { // exit
				return strikes;

			} else {
				System.out.println("invalid"); // should ask again
			}
		} while (askAgain == true);

		// messages

		if (hoursPassed == CHECK_TIME) { // notify every find if CHECK_TIME hours
			time = new Time(); // reset
			hoursPassed = time.getHoursPassed();

			System.out.println("Are you using drugs? y/n" + exitMessage);
			Scanner scannerDrugs = new Scanner(System.in);
			String response = scannerDrugs.next(); // responseDrugs

			if (response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no")) {
				System.out.println("good");

			} else if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
				// System.out.println("adding a strike"); //debug

				strikes++;
				System.out.println("strikes = " + strikes); // debug

				// 3 strikes
				if (strikes == 1) {
					System.out.println("calling a helpline");

				} else if (strikes == 2) {
					System.out.println("calling a friend");

				} else if (strikes >= 3) {
					System.out.println("calling 911");
					// use maps api to find closest hospital
				}

			} else if (response.equals("0")) { // exit
				return strikes;

			} else {
				System.out.println("invalid");
			}
		}
		return strikes;
	}

	/**
	 * Integrating Google Vision API to determine symptoms
	 */
	public static void detectSymptoms() {
		boolean safe = true;
		System.out.println("detectSymptoms: detecting...");

		// do stuff with vision api (determines safe) //eg look at Changes in pupil size

		if (safe) {
			System.out.println("you are safe");

		} else {
			System.out.println("you are not safe");
		}

	}
}
