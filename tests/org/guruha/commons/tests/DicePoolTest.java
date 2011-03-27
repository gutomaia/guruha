package org.guruha.commons.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.BeforeClass;

import org.guruha.commons.DicePool;

/**
 * A class to test the Dice Pool features.
 *
 * @author GigaNERDs
 *
 */
public class DicePoolTest {

    private static final Integer DEFAULT_DICEPOOL_DICES = 3;
    private static final Integer DEFAULT_DICEPOOL_MODIFIERS = 0;
    private static final String DEFAULT_DICEPOOL_STRING = "3d";
    private static final Integer CUSTOM_DICEPOOL_DICES = 1;
    private static final Integer CUSTOM_DICEPOOL_MODIFIERS = 0;
    private static final String CUSTOM_DICEPOOL_STRING = "1d";
    private static final Integer DETAILED_DICEPOOL_DICES_1 = 2;
    private static final Integer DETAILED_DICEPOOL_MODIFIERS_1 = 1;
    private static final String DETAILED_DICEPOOL_STRING_1 = "2d+1";
    private static final Integer DETAILED_DICEPOOL_DICES_2 = 2;
    private static final Integer DETAILED_DICEPOOL_MODIFIERS_2 = -1;
    private static final String DETAILED_DICEPOOL_STRING_2 = "2d-1";
    private static final Integer DETAILED_DICEPOOL_DICES_3 = 0;
    private static final Integer DETAILED_DICEPOOL_MODIFIERS_3 = 1;
    private static final String DETAILED_DICEPOOL_STRING_3 = "1";
    private static final Integer DETAILED_DICEPOOL_DICES_4 = 0;
    private static final Integer DETAILED_DICEPOOL_MODIFIERS_4 = -1;
    private static final String DETAILED_DICEPOOL_STRING_4 = "-1";

    private static DicePool defaultDicePool;
    private static DicePool customDicePool;
    private static DicePool detailedDicePool1;
    private static DicePool detailedDicePool2;
    private static DicePool detailedDicePool3;
    private static DicePool detailedDicePool4;
    private static DicePool stringDefaultDicePool;
    private static DicePool stringCustomDicePool;
    private static DicePool stringDetailedDicePool1;
    private static DicePool stringDetailedDicePool2;
    private static DicePool stringDetailedDicePool3;
    private static DicePool stringDetailedDicePool4;

    @BeforeClass
    static public void createEnviroment() {
	defaultDicePool	= new DicePool();
	customDicePool	= new DicePool(CUSTOM_DICEPOOL_DICES);
	detailedDicePool1	= new DicePool(DETAILED_DICEPOOL_DICES_1, DETAILED_DICEPOOL_MODIFIERS_1);
	detailedDicePool2	= new DicePool(DETAILED_DICEPOOL_DICES_2, DETAILED_DICEPOOL_MODIFIERS_2);
	detailedDicePool3	= new DicePool(DETAILED_DICEPOOL_DICES_3, DETAILED_DICEPOOL_MODIFIERS_3);
	detailedDicePool4	= new DicePool(DETAILED_DICEPOOL_DICES_4, DETAILED_DICEPOOL_MODIFIERS_4);
	stringDefaultDicePool	= new DicePool(DEFAULT_DICEPOOL_STRING);
	stringCustomDicePool	= new DicePool(CUSTOM_DICEPOOL_STRING);
	stringDetailedDicePool1	= new DicePool(DETAILED_DICEPOOL_STRING_1);
	stringDetailedDicePool2	= new DicePool(DETAILED_DICEPOOL_STRING_2);
	stringDetailedDicePool3	= new DicePool(DETAILED_DICEPOOL_STRING_3);
	stringDetailedDicePool4	= new DicePool(DETAILED_DICEPOOL_STRING_4);
    }

    @Test
    public void testGetDices() {
	assertEquals("Fail to get the dices number from the default dice pool", DEFAULT_DICEPOOL_DICES, defaultDicePool.getDices());
	assertEquals("Fail to get the dices number from the custom dice pool", CUSTOM_DICEPOOL_DICES, customDicePool.getDices());
	assertEquals("Fail to get the dices number from the detailed dice pool 1", DETAILED_DICEPOOL_DICES_1, detailedDicePool1.getDices());
	assertEquals("Fail to get the dices number from the detailed dice pool 2", DETAILED_DICEPOOL_DICES_2, detailedDicePool2.getDices());
	assertEquals("Fail to get the dices number from the detailed dice pool 3", DETAILED_DICEPOOL_DICES_3, detailedDicePool3.getDices());
	assertEquals("Fail to get the dices number from the detailed dice pool 4", DETAILED_DICEPOOL_DICES_4, detailedDicePool4.getDices());
	assertEquals("Fail to get the dices number from the string default dice pool", DEFAULT_DICEPOOL_DICES, stringDefaultDicePool.getDices());
	assertEquals("Fail to get the dices number from the string custom dice pool", CUSTOM_DICEPOOL_DICES, stringCustomDicePool.getDices());
	assertEquals("Fail to get the dices number from the string detailed dice pool 1", DETAILED_DICEPOOL_DICES_1, stringDetailedDicePool1.getDices());
	assertEquals("Fail to get the dices number from the string detailed dice pool 2", DETAILED_DICEPOOL_DICES_2, stringDetailedDicePool2.getDices());
	assertEquals("Fail to get the dices number from the string detailed dice pool 3", DETAILED_DICEPOOL_DICES_3, stringDetailedDicePool3.getDices());
	assertEquals("Fail to get the dices number from the string detailed dice pool 4", DETAILED_DICEPOOL_DICES_4, stringDetailedDicePool4.getDices());
	assertTrue(true);
    }

    @Test
    public void testGetModifiers() {
	assertEquals("Fail to get the modifiers from the default dice pool", DEFAULT_DICEPOOL_MODIFIERS, defaultDicePool.getModifiers());
	assertEquals("Fail to get the modifiers from the custom dice pool", CUSTOM_DICEPOOL_MODIFIERS, customDicePool.getModifiers());
	assertEquals("Fail to get the modifiers from the detailed dice pool 1", DETAILED_DICEPOOL_MODIFIERS_1, detailedDicePool1.getModifiers());
	assertEquals("Fail to get the modifiers from the detailed dice pool 2", DETAILED_DICEPOOL_MODIFIERS_2, detailedDicePool2.getModifiers());
	assertEquals("Fail to get the modifiers from the detailed dice pool 3", DETAILED_DICEPOOL_MODIFIERS_3, detailedDicePool3.getModifiers());
	assertEquals("Fail to get the modifiers from the detailed dice pool 4", DETAILED_DICEPOOL_MODIFIERS_4, detailedDicePool4.getModifiers());
	assertEquals("Fail to get the modifiers from the string default dice pool", DEFAULT_DICEPOOL_MODIFIERS, stringDefaultDicePool.getModifiers());
	assertEquals("Fail to get the modifiers from the string custom dice pool", CUSTOM_DICEPOOL_MODIFIERS, stringCustomDicePool.getModifiers());
	assertEquals("Fail to get the modifiers from the string detailed dice pool 1", DETAILED_DICEPOOL_MODIFIERS_1, stringDetailedDicePool1.getModifiers());
	assertEquals("Fail to get the modifiers from the string detailed dice pool 2", DETAILED_DICEPOOL_MODIFIERS_2, stringDetailedDicePool2.getModifiers());
	assertEquals("Fail to get the modifiers from the string detailed dice pool 3", DETAILED_DICEPOOL_MODIFIERS_3, stringDetailedDicePool3.getModifiers());
	assertEquals("Fail to get the modifiers from the string detailed dice pool 4", DETAILED_DICEPOOL_MODIFIERS_4, stringDetailedDicePool4.getModifiers());
	assertTrue(true);
    }

    @Test
    public void testDicePoolString() {
	assertEquals("Fail to get the string from the default dice pool", DEFAULT_DICEPOOL_STRING, defaultDicePool.toString());
	assertEquals("Fail to get the string from the custom dice pool", CUSTOM_DICEPOOL_STRING, customDicePool.toString());
	assertEquals("Fail to get the string from the detailed dice pool 1", DETAILED_DICEPOOL_STRING_1, detailedDicePool1.toString());
	assertEquals("Fail to get the string from the detailed dice pool 2", DETAILED_DICEPOOL_STRING_2, detailedDicePool2.toString());
	assertEquals("Fail to get the string from the detailed dice pool 3", DETAILED_DICEPOOL_STRING_3, detailedDicePool3.toString());
	assertEquals("Fail to get the string from the detailed dice pool 4", DETAILED_DICEPOOL_STRING_4, detailedDicePool4.toString());
	assertEquals("Fail to get the string from the string default dice pool", DEFAULT_DICEPOOL_STRING, stringDefaultDicePool.toString());
	assertEquals("Fail to get the string from the string custom dice pool", CUSTOM_DICEPOOL_STRING, stringCustomDicePool.toString());
	assertEquals("Fail to get the string from the string detailed dice pool 1", DETAILED_DICEPOOL_STRING_1, stringDetailedDicePool1.toString());
	assertEquals("Fail to get the string from the string detailed dice pool 2", DETAILED_DICEPOOL_STRING_2, stringDetailedDicePool2.toString());
	assertEquals("Fail to get the string from the string detailed dice pool 3", DETAILED_DICEPOOL_STRING_3, stringDetailedDicePool3.toString());
	assertEquals("Fail to get the string from the string detailed dice pool 4", DETAILED_DICEPOOL_STRING_4, stringDetailedDicePool4.toString());
	assertTrue(true);
    }

}
