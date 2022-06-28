package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookDirectAndSavePage {


    @FindBy(id = "dpd1")
    WebElement calenderDate;

    @FindBy(xpath = "(//th[@class='next'])[1]")
    WebElement calenderNext;

    @FindBy(xpath = "//div[@class='datepicker-days']//child::tbody/tr/td")
    List<WebElement> allDate;

    @FindBy(id= "room_adult_child_config")
    WebElement selectRoom;

    @FindBy(xpath= "(//button[@class='adultbtn btn btn-default count-plus'])[1]")
    WebElement addAdult;

    @FindBy(xpath= "(//button[@class='adultbtn btn btn-default count-plus'])[2]")
    WebElement addChildren;

    @FindBy(xpath= "//button[text()='Search ']")
    WebElement searchHotels;


    public BookDirectAndSavePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectCheckInDate(String selCheckInDate) {
        calenderDate.click();
        for (int i = 0; i <= 4; i++) {
            calenderNext.click();
        }
        for (WebElement date : allDate) {
            if (date.getText().equals(selCheckInDate)) {
                date.click();
                break;
            }
        }
    }

    public void selectCheckOutData(String selCheckOutDate) throws InterruptedException {
        Thread.sleep(3000);
        for (WebElement date : allDate) {
            if (date.getText().equals(selCheckOutDate)) {
                date.click();
                break;
            }
        }
    }


    public void selectRoomAdultChild(int adult, int child){
        selectRoom.click();
        selectAddAdult(adult);
        selectAddChildren(child);
    }

    public void selectAddAdult(int adult){
        for (int i=0; i<adult; i++) {
            addAdult.click();
        }
    }

    public void selectAddChildren(int child){
        for (int i=0; i<child; i++) {
            addChildren.click();
        }
    }

    public void searchHotels(){
        searchHotels.click();
    }
}
