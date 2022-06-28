package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//img[@class='W100 cross-pop-r']")
    WebElement closePopUp;

    @FindBy(xpath = "//a[@class='reservation-button']")
    WebElement reservationBtn;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnReservation() throws InterruptedException {
        Thread.sleep(5000);
        closePopUp.click();
        reservationBtn.click();
    }
}
