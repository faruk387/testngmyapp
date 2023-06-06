package com.myapp.tests.topics;

import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day18_FirstConfigTest {
    @Test
    public void firstConfigTest(){
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty("amazon_title")));
        System.out.println(Driver.getDriver().getTitle());
        Driver.closeDriver();
    }
}
