package com.digitalpartners.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BookDirectAndSavePage;
import pages.HomePage;
import testbase.TestBase;

public class LoginTest extends TestBase {

    BookDirectAndSavePage bookDirectAndSavePage;
    HomePage homePage;

    LoginTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage(getDriver());
        bookDirectAndSavePage = new BookDirectAndSavePage(getDriver());
    }

    @Test
    public void verifyBookCalender() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        homePage.clickOnReservation();
        bookDirectAndSavePage.selectCheckInDate("1");
        bookDirectAndSavePage.selectCheckOutData("2");
        bookDirectAndSavePage.selectRoomAdultChild(2,2);
        bookDirectAndSavePage.searchHotels();
        System.out.println("Hello Evening Batch Student");
        System.out.println("Hello");
		System.out.println("Evening Batch Student");
		System.out.println("Evening Batch Student");
		System.out.println("Afternoon Batch Student");
	    System.out.println("Afternoon Batch Student");
        softAssert.assertAll();
    }


    @AfterMethod
    public void tearDown() {
        getDriver().quit();
		System.out.println("Hello");
		System.out.println("Good Afternoon");
    }
}
