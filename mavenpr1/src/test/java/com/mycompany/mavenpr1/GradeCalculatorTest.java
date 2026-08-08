/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mavenpr1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DELL
 */
public class GradeCalculatorTest {
    
    public GradeCalculatorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of GradeCalulatorScore method, of class GradeCalculator.
     */
    @Test
    public void testGradeCalulatorScore() {
        System.out.println("GradeCalulatorScore");
        Student st = null;
        double expResult = 0.0;
        double result = GradeCalculator.GradeCalulatorScore(st);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of xeploai method, of class GradeCalculator.
     */
    @Test
    public void testXeploai() {
        System.out.println("xeploai");
        double xl = 0.0;
        String expResult = "";
        String result = GradeCalculator.xeploai(xl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validate method, of class GradeCalculator.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        double xl = 0.0;
        String filedName = "";
        GradeCalculator.validate(xl, filedName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
