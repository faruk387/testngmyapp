package com.myapp.tests.topics;

import com.myapp.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day18_FirstDriverTest {
    @Test
    public void firstDriverTest(){

        //Go to amazon page
        Driver.getDriver().get("https://www.amazon.com");
                       // Verify the title includes amazon
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon"));
        System.out.println(Driver.getDriver().getTitle());
        Driver.closeDriver();
    }
}
