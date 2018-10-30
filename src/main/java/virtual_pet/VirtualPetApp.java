package virtual_pet;

import java.util.Scanner;

public class VirtualPetApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println(
				"You find an awesome robot laying in a field.\nThat's weird, but it should go home before it's \neaten by vultures or animals.");
		System.out.println("Please name your robot:");
		String givenName = input.nextLine();
		VirtualPet robot = new VirtualPet(givenName);

		while (robot.alive) {
			robot.displayStats();

			String choice = askActivity(input, robot);

			System.out.println("\n\n\n");

			processChoice(robot, choice, input);

			// require the user to press enter (helps them see the action dialogue)
//		System.out.println("Press Enter to continue.");
			input.nextLine();

			System.out.println("\n");

			robot.tick();
		}

		input.close();
	}// end main method

	private static void processChoice(VirtualPet robot, String choice, Scanner input) {
		if (choice.equals("1")) {
			robot.doNothing();
		} else if (choice.equals("2")) {
			robot.chargeRobot();
		} else if (choice.equals("3")) {
			robot.askFood(input);
		} else if (choice.equals("4")) {
			robot.garden();
		} else if (choice.equals("5")) {
			robot.watchTv();
		} else if (choice.equals("6")) {
			robot.learnInstrument();
		} else if (choice.equals("7")) {
			robot.askWalk(input);
		} else if (choice.equalsIgnoreCase("doctor")) {
			robot.goToDoctor();
		} else if (choice.equalsIgnoreCase("engineer")) {
			robot.goToEngineer();
		} else if (choice.equalsIgnoreCase("hacking")) {
			robot.stopHacking();
		}
		// TODO add in other activities- go on walk, learn to play an instrument,
		// discuss philosophy
		else if (choice.equalsIgnoreCase("exit")) {
			System.out.println("You leave " + robot.getName());
			System.exit(0);
		} else {
			System.out.println("Bad choice. You ask your robot to mow the lawn. It fails to comply.");
		}
	}

	public static String askActivity(Scanner input, VirtualPet robot) {
		System.out.println("What would you like  to do with " + robot.getName() + "? Press a number key.");
		System.out.println("1: Do nothing");
		System.out.println("2: Charge " + robot.getName());
		System.out.println("3: Feed " + robot.getName());
		System.out.println("4: Garden together");
		System.out.println("5: Watch TV together");
		System.out.println("6: Teach " + robot.getName() + " to play an instrument.");
		System.out.println("7: Go on a nice walk");
		if (robot.getHacking() > 0) {
			System.out.println("Type HACKING in all caps to ask your robot to stop hacking the computer system.");
		}
		if (robot.getVirus() && !robot.beenToDoctor) {
			System.out.println("Type DOCTOR in all caps to take your robot to the doctor.");
		}
		if (robot.getVirus() && robot.beenToDoctor) {
			System.out.println("Type ENGINEER in all caps to take your robot to an engineer.");
		}

		System.out.println("Type EXIT to abandon " + robot.getName() + " and quit application.");
		String choice = input.nextLine();
		return choice;
	}
}
