package com.epam.rdtraining.autoparkingapplicationtest;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import com.epam.rdtraining.consoleservices.MainCommandLineArgs;
import com.epam.rdtraining.consoleservices.PerformOpeartions;

/**
 * @author Srujan_Aditya
 *
 */
public class MainCommandLineArgsTest extends MainCommandLineArgs {
    /**
     * Test by reseting the files and accepting the slot input from console.
     */
    @Test
    //TODO Test by reseting the files and accepting the slot input from args.
    public void testResetFilesAndStore() {
        String[] args = {"admin", "epam123", "1", "5"};
        PerformOpeartions.reset();
        StringBuilder input = new StringBuilder();
        input.append("aeds\n1\n");
        input.append("TS2E123\n");
        input.append("1\n");
        input.append("TS2E11231\n");
        input.append("3\n");
        input.append("2\n");
        input.append("TS2E123432\n");
        input.append("aeds\n2\n");
        input.append("TS2E123\n");
        input.append("3\n4\n4\n");
        input.append("1\nTS2E123\n");
        input.append("1\nTS2ER123\n");
        input.append("2\nTS2E123\n");
        input.append("3\n5\n5\n");
        ByteArrayInputStream inputStream
            = new ByteArrayInputStream(input.toString().getBytes());
        System.setIn(inputStream);
        MainCommandLineArgs.main(args);
        assertTrue(true);
    }
    /**
     * Test by reading the files.
     */
    @Test
    //TODO Test by reading the files.
    public void testReadFiles() {
        String[] args = {"admin", "epam123", "0"};
        PerformOpeartions.reset();
        StringBuilder input = new StringBuilder();
        input.append("aeds\n1\n");
        input.append("TS2E123\n");
        input.append("1\n");
        input.append("TS2E11231\n");
        input.append("3\n");
        input.append("2\n");
        input.append("TS2E123432\n");
        input.append("aeds\n2\n");
        input.append("TS2E123\n");
        input.append("3\n4\n4\n");
        input.append("1\nTS2E123\n");
        input.append("1\nTS2ER123\n");
        input.append("2\nTS2E123\n");
        input.append("3\n5\n5\n");
        ByteArrayInputStream inputStream
            = new ByteArrayInputStream(input.toString().getBytes());
        System.setIn(inputStream);
        MainCommandLineArgs.main(args);
        assertTrue(true);
    }

}
