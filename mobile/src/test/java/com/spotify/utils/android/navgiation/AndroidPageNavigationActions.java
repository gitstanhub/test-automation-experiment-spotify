package com.spotify.utils.android.navgiation;

import com.spotify.utils.android.elementactions.AndroidElementActions;
import com.spotify.utils.android.navgiation.AndroidDeviceActions;
import io.appium.java_client.AppiumBy;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.spotify.driver.AppiumDriverHandler.getDriver;

@Component
@Slf4j
public class AndroidPageNavigationActions {

    @Autowired
    private AndroidDeviceActions androidDeviceActions;

    @Autowired
    private AndroidElementActions androidElementActions;

    public void scrollIntoElementByText(String scrollableElementResourceId, String targetResourceId, String targetText) {
        getDriver().findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiScrollable(new UiSelector().resourceId(\"%s\"))" +
                                ".scrollIntoView(new UiSelector().resourceId(\"%s\").text(\"%s\"))",
                        scrollableElementResourceId, targetResourceId, targetText)));
    }

    public void scrollIntoElementByDescription(String scrollableElementResourceId, String targetDescription) {
        getDriver().findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiScrollable(new UiSelector().resourceId(\"%s\"))" +
                                ".scrollIntoView(new UiSelector().description(\"%s\"))",
                        scrollableElementResourceId, targetDescription)));
    }

    public void swipeToElementByText(String targetResourceId, String targetText, int maxSwipes) {
        int attempts = 0;

        androidDeviceActions.slightlySwipeDown();

        while (attempts < maxSwipes) {
            try {
                WebElement element = getDriver().findElement(AppiumBy.androidUIAutomator(
                        String.format(
                                "new UiSelector().resourceId(\"%s\").text(\"%s\")",
                                targetResourceId, targetText)));

                if (element != null) {
                    return;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Couldn't find the desired element within the focused area. Trying to swipe further...");
                androidDeviceActions.swipeDown();
            }
            attempts++;
        }
        throw new NoSuchElementException("Couldn't find the desired element \"" + targetText + "\" after " + attempts + " swiping attempts.");
    }

    public void swipeToElementWithSiblingByText(String parentResourceId, String childSiblingText1, String childSiblingText2, int maxSwipes) {
        int attempts = 0;

        androidDeviceActions.slightlySwipeDown();

        while (attempts < maxSwipes) {
            try {
                WebElement element = getDriver().findElement(AppiumBy.androidUIAutomator(
                        String.format(
                                "new UiSelector().resourceId(\"%s\").childSelector(new UiSelector().text(\"%s\")).fromParent(new UiSelector().text(\"%s\"))",
                                parentResourceId, childSiblingText1, childSiblingText2)));

                if (element != null) {
                    return;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Couldn't find the desired element within the focused area. Trying to swipe further...");
                androidDeviceActions.swipeDown();
            }
            attempts++;
        }
        throw new NoSuchElementException("Couldn't find the desired element pair \"" + childSiblingText1 + " - " + childSiblingText2 + "\" after " + attempts + " swiping attempts.");
    }


    public void swipeToElementByText(String targetText, int maxSwipes) {
        int attempts = 0;

        androidDeviceActions.slightlySwipeDown();

        while (attempts < maxSwipes) {
            try {
                WebElement element = getDriver().findElement(AppiumBy.androidUIAutomator(
                        String.format(
                                "new UiSelector().text(\"%s\")",
                                targetText)));

                if (element != null) {
                    return;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Couldn't find the desired element within the focused area. Trying to swipe further...");
                androidDeviceActions.swipeDown();
            }
            attempts++;
        }
        throw new NoSuchElementException("Couldn't find the desired element \"" + targetText + "\" after " + attempts + " swiping attempts.");
    }

    public void swipeToElementByDescription(String targetDescriptionAttribute, int maxSwipes) {
        int attempts = 0;

        androidDeviceActions.slightlySwipeDown();

        while (attempts < maxSwipes) {
            try {
                WebElement element = getDriver().findElement(AppiumBy.androidUIAutomator(
                        String.format(
                                "new UiSelector().description(\"%s\")",
                                targetDescriptionAttribute)));

                if (element != null) {
                    return;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Couldn't find the desired element within the focused area. Trying to swipe further...");
                androidDeviceActions.swipeDown();
            }
            attempts++;
        }
        throw new NoSuchElementException("Couldn't find the desired element \"" + targetDescriptionAttribute + "\" after " + attempts + " swiping attempts.");
    }

    public void swipeToElementById(String targetId, String direction, int maxSwipes) {
        int attempts = 0;

        switch (direction) {
            case (Direction.DIRECTION_UP) -> androidDeviceActions.slightlySwipeUp();
            case (Direction.DIRECTION_DOWN) -> androidDeviceActions.slightlySwipeDown();
            case (Direction.DIRECTION_LEFT) -> androidDeviceActions.slightlySwipeLeft();
            case (Direction.DIRECTION_RIGHT) -> androidDeviceActions.slightlySwipeRight();
            default ->
                    throw new IllegalArgumentException("Wrong direction type is specified. Should be one of: up, down, left or right");
        }

        while (attempts < maxSwipes) {
            try {
                WebElement element = androidElementActions.getElementById(targetId);

                if (element != null) {
                    return;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Couldn't find the desired element within the focused area. Trying to swipe further...");

                switch (direction) {
                    case (Direction.DIRECTION_UP) -> androidDeviceActions.swipeUp();
                    case (Direction.DIRECTION_DOWN) -> androidDeviceActions.swipeDown();
                    case (Direction.DIRECTION_LEFT) -> androidDeviceActions.swipeLeft();
                    case (Direction.DIRECTION_RIGHT) -> androidDeviceActions.swipeRight();
                    default ->
                            throw new IllegalArgumentException("Wrong direction type is specified. Should be one of: up, down, left or right");
                }
            }
            attempts++;
        }
        throw new NoSuchElementException("Couldn't find the desired element after " + attempts + " swiping attempts.");
    }

    public static class Direction {
        public static final String DIRECTION_UP = "up";
        public static final String DIRECTION_DOWN = "down";
        public static final String DIRECTION_LEFT = "left";
        public static final String DIRECTION_RIGHT = "right";
    }
}
