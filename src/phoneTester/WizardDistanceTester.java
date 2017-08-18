package phoneTester;

import static org.junit.Assert.*;
/*
 * 
 * 
 * 
 * 
 */

import org.junit.Test;

import phone.WizardDistance;
import phone.WizardDistance.Wizard;

public class WizardDistanceTester {

	@Test
	public void test() {
		WizardDistance wd=new WizardDistance();
		Wizard[] wizards1=new Wizard[9];
		wizards1[0]=wd.new Wizard(1);
		wizards1[1]=wd.new Wizard(2);
		wizards1[2]=wd.new Wizard(3);
		wizards1[3]=wd.new Wizard(4);
		wizards1[4]=wd.new Wizard(5);
		wizards1[5]=wd.new Wizard(6);
		wizards1[6]=wd.new Wizard(7);
		wizards1[7]=wd.new Wizard(8);
		wizards1[8]=wd.new Wizard(9);
		wizards1[0].addNeighbor(wizards1[1]);
		wizards1[0].addNeighbor(wizards1[8]);
		wizards1[1].addNeighbor(wizards1[2]);
		wizards1[2].addNeighbor(wizards1[3]);
		wizards1[5].addNeighbor(wizards1[4]);
		wizards1[3].addNeighbor(wizards1[4]);
		wizards1[6].addNeighbor(wizards1[7]);
		wizards1[7].addNeighbor(wizards1[8]);
		assertTrue(wd.calMinDistance(wizards1, 0, 8)==64);
		wizards1[4].addNeighbor(wizards1[5]);
		wizards1[5].addNeighbor(wizards1[6]);
		assertTrue(wd.calMinDistance(wizards1, 0, 8)==8);
	}

}
