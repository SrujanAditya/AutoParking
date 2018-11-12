package com.epam.rdtraining.validatorstest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.epam.rdtraining.validators.ValidateRegistrationNumber;

/**
 * This class contains test cases to validate the vehicle registration number
 * method.
 * @author Srujan_Aditya
 *
 */
public class ValidateRegistrationNumberTest {
    /**
     * To InjectMock for this class.
     */
    @InjectMocks
    private ValidateRegistrationNumber instance
                = new ValidateRegistrationNumber();

    /**
     * Before annotation.
     */
    @Before
    public void setUp() {
        org.mockito.MockitoAnnotations.initMocks(this);
        //instance = Mockito.mock(ValidateRegistrationNumber.class);
    }
    /**
     * Test : Vehicle Number with no state character.
     */
    // TODO Vehicle Number with no state character
    @Test
    public void testNoStateChar() {
        assertFalse("InValid Vehicle Number", instance.validate("3e123"));
    }
    /**
     * Test : Vehicle Number with only one state character.
     */
    // TODO Vehicle Number with only one state character
    @Test
    public void testOneStateChar() {
        assertFalse("InValid Vehicle Number", instance.validate("T3e123"));
    }
    /**
     * Test : Vehicle Number with two state characters.
     */
    // TODO Vehicle Number with two state characters
    @Test
    public void testTwoStateChar() {
        assertTrue("Valid Vehicle Number", instance.validate("TS3e123"));
    }
    /**
     * Test : Vehicle Number with more than two state characters.
     */
    // TODO Vehicle Number with more than two state character
    @Test
    public void testMoreThanTwoStateChar() {
        assertFalse("InValid Vehicle Number", instance.validate("TSR3e123"));
    }
    /**
     * Test : Vehicle Number with no digit in second place.
     */
    // TODO Vehicle Number with no digit in second place
    @Test
    public void testNoDigitInSecond() {
        assertFalse("InValid Vehicle Number", instance.validate("TSe123"));
    }
    /**
     * Test : Vehicle Number with one digit in second place.
     */
    // TODO Vehicle Number with one digit in second place
    @Test
    public void testOneDigitInSecond() {
        assertTrue("Valid Vehicle Number", instance.validate("TS2e123"));
    }
    /**
     * Test : Vehicle Number with two digit in second place.
     */
    // TODO Vehicle Number with two digit in second place
    @Test
    public void testTwoDigitInSecond() {
        assertTrue("Valid Vehicle Number", instance.validate("TS23e123"));
    }
    /**
     * Test : Vehicle Number with more than two digit in second place.
     */
    // TODO Vehicle Number with more than two digit in second place
    @Test
    public void testMoreThanTwoDigitInSecond() {
        assertFalse("InValid Vehicle Number", instance.validate("TS243e123"));
    }
    /**
     * Test : Vehicle Number with no character in third place.
     */
    // TODO Vehicle Number with no character in third place
    @Test
    public void testNoCharInThird() {
        assertFalse("InValid Vehicle Number", instance.validate("TS24123"));
    }
    /**
     * Test : Vehicle Number with one character in third place.
     */
    // TODO Vehicle Number with one character in third place
    @Test
    public void testOneCharInThird() {
        assertTrue("Valid Vehicle Number", instance.validate("TS24e123"));
    }
    /**
     * Test : Vehicle Number with two character in third place.
     */
    // TODO Vehicle Number with two character in third place
    @Test
    public void testTwoCharInThird() {
        assertTrue("Valid Vehicle Number", instance.validate("TS24eW123"));
    }
    /**
     * Test : Vehicle Number with more than two character in third place.
     */
    // TODO Vehicle Number with more then 3 character in third place
    @Test
    public void testMoreThanTwoCharInThird() {
        assertFalse("InValid Vehicle Number", instance.validate("TS24eWf123"));
    }
    /**
     * Test : Vehicle Number with no digit in last place.
     */
    // TODO Vehicle Number with no digit in last place
    @Test
    public void testNoDigitInLast() {
        assertFalse("InValid Vehicle Number", instance.validate("TS24eW"));
    }
    /**
     * Test : Vehicle Number with one digit in last place.
     */
    // TODO Vehicle Number with one digit in last place
    @Test
    public void testOneDigitInLast() {
        assertTrue("Valid Vehicle Number", instance.validate("TS24eW1"));
    }
    /**
     * Test : Vehicle Number with two digit in last place.
     */
    // TODO Vehicle Number with two digit in last place
    @Test
    public void testTwoDigitInLast() {
        assertTrue("Valid Vehicle Number", instance.validate("TS24eW12"));
    }
    /**
     * Test : Vehicle Number with three digit in last place.
     */
    // TODO Vehicle Number with three digit in last place
    @Test
    public void testThreeDigitInLast() {
        assertTrue("Valid Vehicle Number", instance.validate("TS24eW123"));
    }
    /**
     * Test : Vehicle Number with four digit in last place.
     */
    // TODO Vehicle Number with four digit in last place
    @Test
    public void testFourDigitInLast() {
        assertTrue("Valid Vehicle Number", instance.validate("TS24eW1234"));
    }
    /**
     * Test : Vehicle Number with more than four digit in last place.
     */
    // TODO Vehicle Number with more than four digit in second place
    @Test
    public void testMoreThanFourDigitInLast() {
        assertFalse("InValid Vehicle Number", instance.validate("TS24eW12345"));
    }
    /**
     * Test : Vehicle Number with correct sequence without spaces.
     */
    // TODO Vehicle Number with correct sequence without spaces
    @Test
    public void testWithoutSpaces() {
        assertTrue("Valid Vehicle Number", instance.validate("TS24eW1234"));
    }
    /**
     * Test : Vehicle Number with correct format
     * with more spaces between each part.
     */
   // TODO Vehicle Number with correct format with more spaces between each part
    @Test
    public void testMoreSpaces() {
        assertFalse("InValid Vehicle Number",
                instance.validate("TS  24 eW   1234"));
    }
    /**
     * Test : Vehicle Number with correct format
     *  with one space between each part.
     */
    // TODO Vehicle Number with correct format with one space between each part
    @Test
    public void testOneSpaces() {
        assertTrue("Valid Vehicle Number",
                instance.validate("TS 24 eW 1234"));
    }
}
