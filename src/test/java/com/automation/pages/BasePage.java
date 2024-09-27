package com.automation.pages;

import com.automation.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.InputSource;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.InvalidMidiDataException;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

public class BasePage {

    AppiumDriver driver;
    WebDriverWait wait;

    BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isPresent(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnElementIfPresent(WebElement element) {
        if (isPresent(element)) {
            element.click();
        }

    }
    public void scrollAndSwipe(int startX,int startY,int endX,int endY){
        PointerInput finger1=new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        Sequence sequence=new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX,startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofSeconds(2)))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(1),PointerInput.Origin.viewport(),startX,startY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    public void zooming(int startX,int startY){
        PointerInput finger1=new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        PointerInput finger2=new PointerInput(PointerInput.Kind.TOUCH,"finger2");
        Sequence sequence=new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX,startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(2)))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(1),PointerInput.Origin.viewport(),startX+300,startY+300))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                ;
        Sequence sequence2=new Sequence(finger2,1)
                .addAction(finger2.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX,startY))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger2,Duration.ofSeconds(2)))
                .addAction(finger2.createPointerMove(Duration.ofSeconds(1),PointerInput.Origin.viewport(),startX-300,startY-300))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));



        driver.perform(Arrays.asList(sequence,sequence2));
    }


}


