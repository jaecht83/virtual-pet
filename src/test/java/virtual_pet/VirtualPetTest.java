package virtual_pet;

import org.junit.Test;

import junit.framework.Assert;

public class VirtualPetTest {

	@Test
	public void shouldHaveDefaultValues() {
		VirtualPet underTest = new VirtualPet("");
		int sA = underTest.getSelfAwareness();
		int batt = underTest.getBattery();
		int happ = underTest.getHappiness();
		int health = underTest.getHealth();
		int bord = underTest.getBoredom();
		int hack = underTest.getHacking();
		boolean sick = underTest.getVirus();
		Assert.assertEquals(0, sA);
		Assert.assertEquals(100, batt);
		Assert.assertEquals(0, happ);
		Assert.assertEquals(100, health);
		Assert.assertEquals(0, bord);
		Assert.assertEquals(0, hack);
		Assert.assertEquals(false, sick);
	}

	@Test
	public void shouldHaveFaveFood() {
		VirtualPet underTest = new VirtualPet("");
		Assert.assertEquals(underTest.getFaveFood(), null);
	}

	@Test
	public void shouldHaveErrorAffectStats() {
		VirtualPet underTest = new VirtualPet("");
		int battery = underTest.getBattery();
		int happ = underTest.getHappiness();
		int selfA = underTest.getSelfAwareness();
		int hack = underTest.getHacking();
		int errMsg = underTest.haveError();
		if (errMsg < 3) {
			Assert.assertEquals(battery, underTest.getBattery());
		} else if (errMsg < 6) {
			Assert.assertEquals(happ, underTest.getHappiness());
		} else if (errMsg < 8) {
			Assert.assertEquals(selfA, underTest.getSelfAwareness());
		} else if (errMsg < 6) {
			Assert.assertEquals(hack, underTest.getHacking());
		}
	}

	@Test
	public void shouldSkipTurnOrWaitWhateverHappy() {
		VirtualPet underTest = new VirtualPet("");
		int happ = underTest.getHappiness();
		underTest.doNothing();
		Assert.assertEquals(happ - 10, underTest.getHappiness());
	}

	@Test
	public void shouldSkipTurnOrWaitWhateverBord() {
		VirtualPet underTest = new VirtualPet("");
		int bor = underTest.getBoredom();
		underTest.doNothing();
		Assert.assertEquals(bor + 10, underTest.getBoredom());
	}

	@Test
	public void shouldFeedRobotOreosWhenFave() {
		VirtualPet underTest = new VirtualPet("");
		underTest.setFaveFood(2);
		int hel = underTest.getHealth();
		int happ = underTest.getHappiness();
		int batt = underTest.getBattery();
		int sum = hel + happ + batt;
		underTest.feedRobot(2);
		hel = underTest.getHealth();
		happ = underTest.getHappiness();
		batt = underTest.getBattery();
		int sum2 = hel + happ + batt;
		Assert.assertEquals(sum + 40, sum2);
	}

	@Test
	public void shouldFeedRobotOreosWhenNotFave() {
		VirtualPet underTest = new VirtualPet("");
		underTest.setFaveFood(3);
		int hel = underTest.getHealth();
		int happ = underTest.getHappiness();
		int batt = underTest.getBattery();
		int sum = hel + happ + batt;
		underTest.feedRobot(2);
		hel = underTest.getHealth();
		happ = underTest.getHappiness();
		batt = underTest.getBattery();
		int sum2 = hel + happ + batt;
		Assert.assertEquals(sum + 20, sum2);
	}

	@Test
	public void shouldGardenBatt() {
		VirtualPet underTest = new VirtualPet("");
		int batt = underTest.getBattery();
		underTest.garden();
		Assert.assertEquals(batt - 15, underTest.getBattery());
	}

	@Test
	public void shouldGardenHapp() {
		VirtualPet underTest = new VirtualPet("");
		int batt = underTest.getHappiness();
		underTest.garden();
		Assert.assertEquals(batt + 15, underTest.getHappiness());
	}

	@Test
	public void shouldGardenBore() {
		VirtualPet underTest = new VirtualPet("");
		underTest.setBoredom(50);
		int batt = underTest.getBoredom();
		underTest.garden();
		Assert.assertEquals(batt - 15, underTest.getBoredom());
	}
}
