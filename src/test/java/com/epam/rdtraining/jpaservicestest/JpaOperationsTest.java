package com.epam.rdtraining.jpaservicestest;

import org.junit.Test;

import com.epam.rdtraining.jpaservices.JpaOperations;
/**
 * jpa test.
 * @author Srujan_Aditya
 *
 */
public class JpaOperationsTest {
    /**
     * jpa operations test.
     */
    @Test
    public void test() {
        JpaOperations ins = JpaOperations.getInstance();
        ins.park(1, "TS2E123", 101, 1);
        //ins.unpark("TS2E123",102);
        /*List<String> result = ins.adminLogin("PARK", "epam123");
        System.out.println(result.get(0));*/
    }

}
