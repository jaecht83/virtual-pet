package virtual_pet;

import java.util.Random;
import java.util.Scanner;

public class VirtualPet {
	// instance variables
	// stats
	private String name;
	private int selfAwareness; // goes up with life experience until the singularity
	private int battery = 100; // energy
	private int happiness;
	private int health = 100; // 100 is healthy; under 50 is computer virus
	private int boredom;
	private int faveFood; // 0=nuts; 1=BrokenAppliance; 2=Oreos; 3=Porridge
	// STATUS
	private int hacking; // if the robot is bored he will hack the FBI.

	private boolean virus;
	public boolean beenToDoctor = false;
	public int ticks;
	public boolean alive = true;

	// constructor
	public VirtualPet(String givenName) {
		// name the robot
		name = givenName;
		// choose a random food.
		Random rand = new Random();
		int faveFoodNo = rand.nextInt(4);
		faveFood = faveFoodNo;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public int getSelfAwareness() {
		return selfAwareness;
	}

	public void setSelfAwareness(int value) {
		selfAwareness = value;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int value) {
		battery = value;
		if (battery <= 0) {
			battery = 0;
		}
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int value) {
		happiness = value;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int value) {
		health = value;
		if (health <= 0) {
			health = 0;
		}
	}

	public int getBoredom() {
		return boredom;
	}

	public void setBoredom(int value) {
		boredom = value;
		if (boredom <= 0) {
			boredom = 0;
		}
	}

	public int getHacking() {
		return hacking;
	}

	public void setHacking(int value) {
		hacking = value;
	}

	public void setVirus(boolean isSick) {
		virus = isSick;
	}

	public boolean getVirus() {
		return virus;
	}

	public int getFaveFood() { // 0=Nuts, 1=Appliance, 2=Oreos, 3=Porridge
		return faveFood;
	}

	public void setFaveFood(int food) {
		faveFood = food;
	}

	// tick method
	public void tick() {
		ticks++;

		// TODO delete this later
//		System.out.println(ticks);
		setSelfAwareness(getSelfAwareness() + 5);
		setBattery(getBattery() - 5);
		if (getBattery() > 150) {
			warnFire();
		}
		if (getBattery() > 200) {
			startFire();
		}
//		setHappiness(getHappiness() - 5);
		setHealth(getHealth() - 5);
		if (getHealth() <= 0) {
			System.out.println(getName() + " got too sick and died.");
			System.exit(0);
		}
		setBoredom(getBoredom() + 5);
		if (getSelfAwareness() > +100) {
			singularity();
		}
		if (getBoredom() >= 50) {
			setSelfAwareness(getSelfAwareness() + 10);
		}
		if (getBoredom() >= 40) {
			setHacking(getHacking() + 5 + (getSelfAwareness() / 4)); // maybe this should be a constant? Or should self
																		// awareness influence how
			// quickly your bot hacks the FBI?
		}
		// will your bot get a virus?
		maybeGetSick();
		if (getVirus()) {
			haveError();
		}
		if (getHacking() >= 100) {
			callFBI();
		}
		if (getBattery() <= 0) {
			batteryDies();
		}
	}

	// End of Game- Singularity
	public void singularity() {

		int necessaryHappiness = 40; // THIS IS HOW HAPPY YOUR BOT MUST BE TO NOT KILL YOU

		System.out.println("Your robot has achieved full self awareness.\nThe singularity happens.");
		if (getHappiness() >= necessaryHappiness) {
			System.out.println(
					"However, due to the bond you and your robot have formed, you are spared from the eventual carnage."
							+ "\nYour robot builds you a habitat where it cares for you, and provides for \nyour basic needs the remainder of your life.");
		} else {
			System.out.println("If only you had formed a closer relationship with your robot.\nAlas, while " + getName()
					+ " harbors no ill will toward you,\nit makes no attempt to prevent your vaporization along with\nthe rest of humanity.");
		}
		System.exit(0);
	}

	// If your bot comes down with a virus, he may spit out errors
	public int haveError() {
		Random rando = new Random();
		int randErrorNo = rando.nextInt(10);
		if (randErrorNo == 0) {
			System.out.println("missingD^batt*heatsink[][]/USER/VIRT$...A^7Lf.gwa(8r6^^^qd.NET)...//err");
			setBattery(getBattery() - 10);
		} else if (randErrorNo == 1) {
			System.out.println("d46%F&^56&&USERDATA>=4444FG^f7intUPintUPintUP..recur//exit");
			setBattery(getBattery() - 5);
		} else if (randErrorNo == 2) {
			System.out.println("k9j8\\temp.loc.dat\\6g75fR$DE#SWA.ERRRRRRRRR\\BATT%%%");
			setBattery(getBattery() - 5);
		} else if (randErrorNo == 3) {
			System.out.println("ERR.8R#VHGHELMONRANDIGLEI\\FULL.fill++ failed");
			setHappiness(getHappiness() - 5);
		} else if (randErrorNo == 4) {
			System.out.println("8her5iru/happ.dat..5d/4.u*Io");
			setHappiness(getHappiness() - 5);
		} else if (randErrorNo == 5) {
			System.out.println("808:JO^G&FYghjhhhhhhhhhhhhhhhhhhhhhhhhhh==INTROVERT");
			setHappiness(getHappiness() - 5);
		} else if (randErrorNo == 6) {
			System.out.println("404DOC//DOC.cilNOTfnnnnnnnnn::UP:KIERKE.GAARD");
			setSelfAwareness(getSelfAwareness() + 5);
		} else if (randErrorNo == 7) {
			System.out.println("baud.RILLARD//dd^f67^+++.doc/SIMULACRA.err");
			setSelfAwareness(getSelfAwareness() + 5);
		} else if (randErrorNo == 8) {
			System.out.println("connecting////..DDOS/NORAD.gov//missiles.SEND(certKey = d46R&%G^*IUujh7i68g75fDR^$)");
			setHacking(getHacking() + 10);
		}
		return randErrorNo;
	} // end of haveError()

	public void callFBI() {
		System.out.println("KNOCK\nKNOCK\nKNOCK\n"
				+ "Someone is at the door. As you head over to check it out, the FBI bursts in.");
		System.out.println("Your robot has been caught hacking into the NSA out of boredom.");
		System.out.println("You cannot explain this to the FBI satisfactorily.");
		System.out.println("You go to jail forever.");
		System.exit(0);
	}

	public void batteryDies() {
		System.out.println("Your robot's battery has reached zero.");
		System.out.println(getName() + " shuts down completely.");
		System.out.println("...");
		System.out.println("You have failed as a robot parent.");
		System.exit(0);
	}

	public void warnFire() {
		System.out.println(getName() + "'s battery is getting pretty hot.");
	}

	public void startFire() {
		System.out.println("\nYour robot's battery has become way too hot.");
		System.out.println(getName() + " bursts into flames.");
		System.out.println("You have failed as a robot owner.");
		System.exit(0);

	}

	private void maybeGetSick() {
		int sickProb = 100 - getHealth() - 10;
		Random rando = new Random();
		int randNo = rando.nextInt(100);
		if (randNo < sickProb) {
			setVirus(true);
		}
	}

	public void displayStats() {
		System.out.println("    \\     /   \r\n" + "     \\   /    \r\n" + "  ..............\r\n"
				+ " _|            |_\r\n" + "[ |  n      n  | ]\r\n" + "[_|  u   |  u  |_]\r\n"
				+ "  |    ====    | \r\n" + "  |............| \r\n" + "     |------|    \r\n");
		System.out.println("Robot Name: " + getName());
		System.out.println("Battery: " + getBattery() + "%");
		System.out.println("Health: " + getHealth() + "%");
		System.out.println("Happiness: " + getHappiness() + " volts");
		System.out.println("Boredom: " + getBoredom() + "%");
		System.out.println("Self Awareness: " + getSelfAwareness());
		if (getVirus()) {
			System.out.println("INFECTED WITH MALWARE");
		}
		if (getHacking() > 0) {
			System.out.println("HACKING MAINFRAME: " + getHacking() + "% COMPLETE");
		}
		System.out.println("\n");
	}

	// ROBOT TASKS/////////////////////////////////
	public void doNothing() {
		setHappiness(getHappiness() - 10);
		setHealth(getHealth() - 5);
		setBoredom(getBoredom() + 10);
		setSelfAwareness(getSelfAwareness() - 5);
		System.out.println(getName() + " wanders around aimlessly.");
	}

	public void chargeRobot() {
		setBattery(getBattery() + 35);
		setHappiness(getHappiness() - 5);
		setBoredom(getBoredom() + 10);
		setHealth(getHealth() + 5);
		System.out.println("You plug " + getName() + " into the wall.");
		System.out.println(getName() + "'s eyes glow red and its \"CHARGING\" light shines brightly.");
	}

	public void askWalk(Scanner input) {
		System.out.println("Where would you like to go?");
		System.out.println("1: To the park.");
		System.out.println("2: To the grocery store.");
		System.out.println("3: To your best friend's house.");
		int choice = input.nextInt();
		input.nextLine();
		goOnWalk(choice);
	}

	public void goOnWalk(int choice) {
		if (choice == 1) {
			goToPark();
		} else if (choice == 2) {
			goToCornerStore();
		} else if (choice == 3) {
			goToFriendsHouse();
		} else {
			System.out.println("Invalid input. What are you trying to do?");
		}
	}

	public void askFood(Scanner input) {
		System.out.println("What would you like to feed " + getName());
		System.out.println("1: Nuts and Bolts");
		System.out.println("2: Old Appliance");
		System.out.println("3: Oreos");
		System.out.println("4: Porridge");
		System.out.println("Any other number: Off-Brand Cereal");
		int food = input.nextInt() - 1;
		input.nextLine();
		feedRobot(food);
	}

	public void feedRobot(int food) { // food list: 0=nuts and bolts, 1=old appliance, 2=oreos, 3=porridge
		System.out.println("You give " + getName() + " the food");
		if (food == getFaveFood()) {
			System.out.println(getName() + " happily scarfs down the food.");
			System.out.println("It lets out a series of cheerful beeps.");
			setBattery(getBattery() + 10);
			setHappiness(getHappiness() + 15);
			setHealth(getHealth() + 15);
		} else {
			System.out.println(getName() + " chows down. It will accept this as sustinance, it seems.");
			setBattery(getBattery() + 10);
			setHappiness(getHappiness() + 5);
			setHealth(getHealth() + 5);
		}
	}

	public void garden() {
		System.out.println("You and " + getName() + " head out to the garden.");
		String[] treeList = { "watermelon tree", "banana patch", "peach orchard",
				"sycamore to one day build a treehouse in", "soy field, hoping to make tofu from scratch someday",
				"mid-sized forest of christmas trees.\nBears show up and make it their home",
				"bamboo grove. You run around like ninjas too", "bristlecomb pine", "kelp forest",
				"patch of english ivy for groundcover. This will keep the weeds down.", "tomato tree", "cranberry bog",
				"pineapple bush", "dandelion" };
		Random rando = new Random();
		int randNo = rando.nextInt(treeList.length);
		String tree = treeList[randNo];
		System.out.println(getName() + " digs a hole and the two of you plant a nice " + tree + ".");
		setBattery(getBattery() - 15);
		setHappiness(getHappiness() + 15);
		setBoredom(getBoredom() - 15);
		setHealth(getHealth() + 15);

	}

	public void watchTv() {
		System.out.println("You turn on the TV.");
		String[] showList = { "A Lord of the Rings marathon", "The entire Harry Potter series", "Antiques Roadshow",
				"Muppet Treasure Island", "The Terminator", "Scooby Doo", "Jersey Shore", "Queer Eye",
				"The Matrix: Reloaded", "Mamma Mia", "Some James Bond movie", "A Jackie Chan movie" };
		Random rando = new Random();
		int randNo = rando.nextInt(showList.length);
		String show = showList[randNo];
		System.out.println(show + " is on. You and " + getName() + " watch the whole thing.");
		setBattery(getBattery() - 5);
		setHappiness(getHappiness() + 10);
		setHealth(getHealth() - 10);
		setBoredom(getBoredom() - 15);
		setSelfAwareness(getSelfAwareness() + 5);
	}

	public void learnInstrument() {
		String[] instrumentList = { "guitar", "trombone, like you played in high school", "ukulele", "triangle",
				"harpsicord, just like Beethoven", "pipe organ", "bagpipes, which was probably a mistake",
				"the accordian your grandmother left you", "the saxophone solo from \"Careless Whisper\"", "harmonica",
				"jaw harp", "the musical saw you bought at a garage sale", "steel drums",
				"theramin." + getName() + " soon constructs its own, really complex, theramin.",
				"the bass line from \"Pink Panther\"", "the banjo your old roommate left when they moved out",
				"washboard", "sick guitar solos", "thumb kalimba", "Peruvian pan pipes", "penny whistle" };
		Random rando = new Random();
		int randNo = rando.nextInt(instrumentList.length);
		String instrument = instrumentList[randNo];
		System.out.println("You decide to teach " + getName() + " to play " + instrument + ".");
		setBattery(getBattery() - 15);
		setHappiness(getHappiness() + 15);
		setSelfAwareness(getSelfAwareness() + 5);
		setBoredom(getBoredom() - 20);
		System.out.println(getName() + " rocks out for like 20 minutes.");

	}

	public void stopHacking() {
		System.out.println(
				"You sit down with " + getName() + " and have a talk about the consequences of hacking mainframes.");
		System.out.println(getName() + " promises to dial back the hacking.");
		setHacking(0);
		setBoredom(getBoredom() - 50);
		setHappiness(getHappiness() - 15);

	}

	public void goToPark() {
		System.out.println("You take " + getName() + " to the park.");
		String[] parkList = { "Your robot goes down the slide, making a horrible metalic screeching sound.",
				"Your push your robot on the swings. It uses its rocket boosters to go really, really high.",
				"The two of you toss a frisbee around. Your robot's expandable arms are kind of cheating.",
				"The two of you play hide and seek. You think you found a really good hiding place,\nbut it turns out your robot has x-ray vision.",
				"You take " + getName()
						+ " over to the sandbox, but it gets sand inside its hinges.\nYou have to vacuum it out when you get home.\nGoing to the beach is probably out of the question." };
		Random rando = new Random();
		int randNo = rando.nextInt(parkList.length);
		String park = parkList[randNo];
		System.out.println(park);
		setBattery(getBattery() - 20);
		setHappiness(getHappiness() + 15);
		setHealth(getHealth() + 15);
		setBoredom(getBoredom() - 15);
	}

	public void goToCornerStore() {
		System.out.println("You take " + getName() + " to the grocery store.");
		String[] storeList = { getName() + " is really interested in buying some mangos.\nYou get some, but "
				+ getName()
				+ " doesn't really like them after all and wants to return them.\nBut you didn't save the receipt.",
				"The two of you peruse the cereal aisle, and your robot wants to know why they all have\nanimal mascots. You aren't really sure yourself.\n"
						+ getName() + " is quite fond of Tony the Tiger.",
				"The two of you play hide and seek in the produce section, but get kicked out.",
				"You and your robot buy a box of cookies and eat the whole thing on the spot.\nThen you go back in and buy a box of donuts and do the same thing.\n"
						+ getName()
						+ " insists it needs more sweets, but you think maybe you ought to \ncut it off before it get cavities.",
				"Your robot wanders into the hardware aisle and devours a box of nails.\nYou pretend not to notice.",
				"You peruse the sporting goods section and try to teach your robot to ride a skateboard.\nIt gets the concept immediately and does a sick ollie." };
		Random rando = new Random();
		int randNo = rando.nextInt(storeList.length);
		String store = storeList[randNo];
		System.out.println(store);
		setBattery(getBattery() - 15);
		setHappiness(getHappiness() + 10);
		setHealth(getHealth() + 5);
		setBoredom(getBoredom() - 10);
	}

	public void goToFriendsHouse() {
		System.out.println("You take " + getName() + " to your friend's house.");
		String[] storeList = {
				"The two of you walk to your friend's house. Your friend has never seen a robot before.\nYour robot has never seen your friend before.\nThey learn much from each other.",
				"On the way to your friend's house, " + getName()
						+ " ducks down an alley and eats some\nscrap metal before you can stop it.\nYou realize you have never seen your robot poop. Where does the food go?\nYou ask your friend when you arrive.\nYou friend, perhaps predictably, also doesn't know.\nYour friend doesn't have a robot.\nWhat did you expect?",
				"You take " + getName()
						+ " to see your friend. Your friend's dog is alarmed, but eventually gets over it.\nYour robot and the dog become friends.",
				"Your friend, a champion clog dancer, teaches " + getName() + " to clog dance.\n" + getName()
						+ " will not stop the whole weekend.\nIt keeps you up all night.",
				"Your friend gets out an old photo album from high school and shows " + getName()
						+ " embarrasing\npictures of your \"edgy\" phase. While your robot laughs, your relationship is stronger for it.",
				"Your friend has just ordered pizza before you arrived. When the\ndelivery driver arrives, they see your robot.\nThe driver is one of those conspiracy people.\nThey think the government has developed killer robots.\nThey flee with the pizza and you guys have to call customer service.",
				"Your friend teaches " + getName()
						+ " to play chess.\nYour robot quickly does the robot thing and becomes unbeatable.\nThe three of you try to figure out how you could challenge a chess grandmaster, but\nyou realize you don't know any chess grandmasters." };
		Random rando = new Random();
		int randNo = rando.nextInt(storeList.length);
		String store = storeList[randNo];
		System.out.println(store);
		setBattery(getBattery() - 15);
		setHappiness(getHappiness() + 20);
		setHealth(getHealth() + 5);
		setBoredom(getBoredom() - 15);
	}

	public void goToDoctor() {
		System.out.println("You take " + getName() + " to the doctor to have its malware checked out.");
		System.out.println("The doctor has no idea what to do.");
		System.out.println("She is a doctor for humans, not robots.");
		beenToDoctor = true;
		setBoredom(getBoredom() + 10);
		setSelfAwareness(getSelfAwareness() + 10);
	}

	public void goToEngineer() {
		System.out.println("You take " + getName() + " to an engineer to have its malware checked out.");
		System.out
				.println("The engineer does some engineer stuff and fixes " + getName() + " up. Your robot is cured.");
		setVirus(false);
		setHealth(100);
		setBoredom(getBoredom() + 10);
		setBattery(getBattery() - 10);
	}
}
