package com.digitalpartners.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinkExample {

    @Test
    public void verifyBrokenLink(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ganesh.jadhav\\Downloads\\chromedriver_win32 (7)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.amazon.in");
        List<WebElement> elementList = driver.findElements(By.tagName("a"));
        System.out.println("Size of url " + elementList.size());
        List<String> urlList = new ArrayList<>();
        for (WebElement e : elementList){
            String url = e.getAttribute("href");
            urlList.add(url);
//            checkBrokenLink(url);
        }

        urlList.parallelStream().forEach( e -> checkBrokenLink(e));
        driver.close();
    }

    public static void checkBrokenLink(String linkUrl){

        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode() >= 400){
                System.out.println(linkUrl + " ------ " + httpURLConnection.getResponseMessage() + " " + httpURLConnection.getResponseCode() + " " + "This links are broken");
            }else {
                System.out.println(linkUrl + " ------ " + httpURLConnection.getResponseCode() + " " + httpURLConnection.getResponseMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
