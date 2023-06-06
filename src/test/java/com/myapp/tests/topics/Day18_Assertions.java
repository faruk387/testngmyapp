package com.myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day18_Assertions {
    @Test(groups = "regression1")
    public void hardAssertion(){
        /*
        Hard assertion will stop if the assertion fails.
         */
        System.out.println("Starting the test case");
        Assert.assertTrue(true);//PASS SO CONTINUE
        System.out.println("Line 15 codes");
        Assert.assertEquals(2,3);//Fails so stop and get out of test method
        System.out.println("Line 17 codes");
    }
    @Test
    public void softAssertions(){
        /*
        Test case will continue to execute even if a test assertion fails
        We must use SoftAsser object to do soft assertion
        assertall must be used to do actual assertion. it makes the test case as failed if assertion fails

         */
        System.out.println("Starting the test case");
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(true);//Pass so continue
        System.out.println("Line 28 codes");
        softAssert.assertEquals(3,4);// Fails but continue without problem until end of the method
        System.out.println("Line 30 codes");
        softAssert.assertAll("Test Case Completed");//asserAll must be used at the end to mark the test case as fail


    }
    @Test(groups = "regression1")

     public void JavaAssertion(){
        /*
        java assert is like hard assertion.This is not used a lot. we should use testng assertion in a test ng framework
         */
        System.out.println("Starting the test case");
       if(3<=4) throw new AssertionError("Message");
        assert 3>4;// if statement true the continue. if the statement false the throw java.lang.AssertionErro
        assert "apple".contains("a");
        assert "Apple".toLowerCase().equals("apple");
        assert 8==10;
        System.out.println("line 45");
    }
}
