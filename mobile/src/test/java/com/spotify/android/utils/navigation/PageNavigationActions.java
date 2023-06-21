package com.spotify.android.utils.navigation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class PageNavigationActions {

    private final AndroidDriver driver;
    private final WebDriverWait wait;
    private final AndroidDeviceGestures androidDeviceGestures;

    public PageNavigationActions(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.androidDeviceGestures = new AndroidDeviceGestures(driver);
    }

    public void scrollToElementWithInnerText(String scrollableElementResourceId, String scrollTargetResourceId, String scrollTargetText) {
        driver.findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiScrollable(new UiSelector().resourceId(\"%s\"))" +
                                ".scrollIntoView(new UiSelector().resourceId(\"%s\").text(\"%s\"))",
                        scrollableElementResourceId, scrollTargetResourceId, scrollTargetText)));
    }

//    public WebElement scrollToElementWithInnerTextTemp(String scrollTargetResourceId, String scrollTargetText) {
//        String uiSelector = "new UiSelector().resourceId(\"" + scrollTargetResourceId + "\").text(\"" + scrollTargetText + "\")";
//        String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" + uiSelector + ")";
//
//        return driver.findElement(AppiumBy.androidUIAutomator(uiScrollable));
//    }

//    public WebElement scrollToElementWithInnerTextTemp(String scrollableElementResourceId, String scrollTargetResourceId, String scrollTargetText) {
//        String xpath = String.format("//*[@resource-id='%s' and @text='%s']", scrollTargetResourceId, scrollTargetText);
//
//        return wait.until(driver -> {
//            driver.findElement(AppiumBy.androidUIAutomator(
//                    "new UiScrollable(new UiSelector().resourceId(\"" + scrollableElementResourceId + "\")).scrollForward()"
//            ));
//            return driver.findElement(By.xpath(xpath));
//        });
//    }

//    public void swipeToElementWithInnerTextTemp(String scrollTargetResourceId, String scrollTargetText) {
////        String xpath = String.format("//*[@resource-id='%s' and @text='%s']", scrollTargetResourceId, scrollTargetText);
//
//        FluentWait<WebDriver> customWait = wait.withTimeout(Duration.ofMillis(9000));
//
//         customWait.until(driver -> {
//
//            Map<String, Object> scrollObject = new HashMap<>();
//            scrollObject.put("direction", "up");
//            scrollObject.put("percent", 1);
//            scrollObject.put("left", 460);
//            scrollObject.put("top", 1150);
//            scrollObject.put("width", 300);
//            scrollObject.put("height", 650);
//            scrollObject.put("speed", 3500);
//
//            WebElement element = null;
//            boolean canScrollMore = true;
//
//            while (canScrollMore && element == null) {
//                try {
//                    element = driver.findElement(AppiumBy.androidUIAutomator(
//                            "new UiSelector().resourceId(\"" + scrollTargetResourceId + "\").text(\"" + scrollTargetText + "\")"
//                    ));
////                    ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", scrollObject);
////                    element = driver.findElement(By.xpath(xpath));
//
//                } catch (NoSuchElementException e) {
//                    ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", scrollObject);
//                    canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", scrollObject);
//                }
//            }
//            return element;
//        });
//    }

//    public WebElement swipeToElementWithInnerText(String scrollTargetResourceId, String scrollTargetText) {
//        FluentWait<WebDriver> customWait = wait.withTimeout(Duration.ofMillis(9000));
//
//        return customWait.until(driver -> {
//
//            Map<String, Object> scrollObject = new HashMap<>();
//            scrollObject.put("direction", "up");
//            scrollObject.put("percent", 1);
//            scrollObject.put("left", 460);
//            scrollObject.put("top", 1150);
//            scrollObject.put("width", 300);
//            scrollObject.put("height", 650);
//            scrollObject.put("speed", 3500);
//
//            WebElement element = null;
//            boolean canScrollMore = true;
//
//            while (canScrollMore) {
//                try {
//                    element = driver.findElement(AppiumBy.androidUIAutomator(
//                            "new UiSelector().resourceId(\"" + scrollTargetResourceId + "\").text(\"" + scrollTargetText + "\")"
//                    ));
//
//                    if (element != null) {
//                        break;
//                    }
//                } catch (NoSuchElementException e) {
//                    System.out.println("Desired element seems to be out of page focus. Trying to swipe down...");
//                }
//
//                try {
//                    ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", scrollObject);
//                    element = driver.findElement(AppiumBy.androidUIAutomator(
//                            "new UiSelector().resourceId(\"" + scrollTargetResourceId + "\").text(\"" + scrollTargetText + "\")"
//                    ));
//
//                    if (element != null) {
//                        break;
//                    }
//                } catch (NoSuchElementException e2) {
//                    canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", scrollObject);
//                }
//            }
//            return element;
//        });
//    }

//    public WebElement getToElementWithInnerText(String scrollTargetResourceId, String scrollTargetText) {
//        FluentWait<WebDriver> customWait = wait.withTimeout(Duration.ofMillis(10000));
//
//        WebElement element = null;
//
//        try {
//            element = driver.findElement(AppiumBy.androidUIAutomator(
//                    "new UiSelector().resourceId(\"" + scrollTargetResourceId + "\").text(\"" + scrollTargetText + "\")"
//            ));
//
//            if (element != null) {
//                return element;
//            }
//        } catch (NoSuchElementException e) {
//            boolean canScrollMore = true;
//
//            while (canScrollMore) {
//                androidDeviceGestures.scrollDown();
//                try {
//                    element = driver.findElement(AppiumBy.androidUIAutomator(
//                            "new UiSelector().resourceId(\"" + scrollTargetResourceId + "\").text(\"" + scrollTargetText + "\")"
//                    ));
//
//                    if (element != null) {
//                        return element;
//                    }
//                } catch (NoSuchElementException e2) {
//                    System.out.println("Couldn't find the  desired element from the second attempt. Trying to scroll futher...");
//                    canScrollMore = androidDeviceGestures.scrollDown();
//                }
//            }
//        }
//        throw new NoSuchElementException("Couldn't find the desired element after scrolling attempts");
//    }

//    public WebElement getToElementWithInnerText(String scrollTargetResourceId, String scrollTargetText) {
//        String xpath = String.format("//*[@resource-id='%s' and @text='%s']", scrollTargetResourceId, scrollTargetText);
//
//        WebElement element;
//
//        try {
//            element = driver.findElement(By.xpath(xpath));
//
//            if (element != null) {
//                return element;
//            }
//        } catch (Exception e) {
//            System.out.println("Couldn't find the desired element from the first attempt. Trying to scroll futher...");
//            boolean canScrollMore = false;
//
//            while (!canScrollMore) {
//                canScrollMore = androidDeviceGestures.scrollDown();
//                System.out.println("Scroll returns: " + canScrollMore);
//                try {
//                    element = driver.findElement(By.xpath(xpath));
//
//                    if (element != null) {
//                        return element;
//                    }
//                } catch (Exception e2) {
//                    System.out.println("Couldn't find the  desired element from another attempt. Trying to scroll further...");
//                }
//            }
//        }
//        throw new NoSuchElementException("Couldn't find the desired element after scrolling attempts");
//    }

//    public WebElement getToElementWithInnerText(String scrollTargetResourceId, String scrollTargetText) {
//
//        WebElement element;
//
//        try {
//            element = driver.findElement(AppiumBy.androidUIAutomator(
//                    "new UiSelector().resourceId(\"" + scrollTargetResourceId + "\").text(\"" + scrollTargetText + "\")"
//            ));
//
//            if (element != null) {
//                return element;
//            }
//        } catch (Exception e) {
//            System.out.println("Couldn't find the desired element from the first attempt. Trying to scroll futher...");
//            boolean canScrollMore = false;
//
//            while (!canScrollMore) {
//                canScrollMore = androidDeviceGestures.scrollDown();
//                System.out.println("Scroll returns: " + canScrollMore);
//                try {
//                    element = driver.findElement(AppiumBy.androidUIAutomator(
//                            "new UiSelector().resourceId(\"" + scrollTargetResourceId + "\").text(\"" + scrollTargetText + "\")"
//                    ));
//
//                    if (element != null) {
//                        return element;
//                    }
//                } catch (Exception e2) {
//                    System.out.println("Couldn't find the  desired element from another attempt. Trying to scroll further...");
//                }
//            }
//        }
//        throw new NoSuchElementException("Couldn't find the desired element after scrolling attempts");
//    }

//    public WebElement getToElementWithInnerText(String scrollTargetResourceId, String scrollTargetText) {
//        FluentWait<WebDriver> customWait = wait.withTimeout(Duration.ofMillis(9000));
//
//        try {
//            return customWait.until(driver -> {
//                WebElement element;
//
//                try {
//                    element = driver.findElement(AppiumBy.androidUIAutomator(
//                            "new UiSelector().resourceId(\"" + scrollTargetResourceId + "\").text(\"" + scrollTargetText + "\")"
//                    ));
//
//                    if (element != null) {
//                        return element;
//                    }
//                } catch (Exception e) {
//                    System.out.println("Couldn't find the desired element within the focused area. Trying to swipe further...");
//
//                    androidDeviceGestures.swipeDown();
//                }
//
//            })
//
//        } catch (TimeoutException e) {
//            throw new NoSuchElementException("Couldn't find the desired element after few swiping attempts");
//        }
//
//    }

//    public WebElement getToElementWithInnerText(String scrollTargetResourceId, String scrollTargetText) {
//        FluentWait<WebDriver> customWait = wait
//                .withTimeout(Duration.ofMillis(9000))
//                .ignoring(NoSuchElementException.class);
//
//        try {
//            return wait.until(driver -> {
//                WebElement element;
//
//                try {
//                    element = driver.findElement(AppiumBy.androidUIAutomator(
//                            "new UiSelector().resourceId(\"" + scrollTargetResourceId + "\").text(\"" + scrollTargetText + "\")"
//                    ));
//
//                    if (element != null) {
//                        return element;
//                    }
//                } catch (NoSuchElementException e) {
//                    System.out.println("Couldn't find the desired element within the focused area. Trying to swipe further...");
//                    androidDeviceGestures.swipeDown();
//                }
//
//                return null;
//            });
//        } catch (TimeoutException ignored) {
//            throw new NoSuchElementException("Couldn't find the desired element after few swiping attempts");
//        }
//    }

    public void swipeToElementWithInnerText(String scrollTargetResourceId, String scrollTargetText, int maxSwipes) {
        int attempts = 0;
        androidDeviceGestures.slightlySwipeDown();
        while (attempts < maxSwipes) {
            try {
                WebElement element = driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiSelector().resourceId(\"" + scrollTargetResourceId + "\").text(\"" + scrollTargetText + "\")"
                ));

                if (element != null) {
                    return;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Couldn't find the desired element within the focused area. Trying to swipe further...");
                androidDeviceGestures.swipeDown();
            }
            attempts++;
        }
        throw new NoSuchElementException("Couldn't find the desired element after " + attempts + " swiping attempts.");
    }


    public void scrollToElementWithDescriptionAttribute(String scrollableElementResourceId, String scrollTargetDescription) {
        driver.findElement(AppiumBy.androidUIAutomator(
                String.format(
                        "new UiScrollable(new UiSelector().resourceId(\"%s\"))" +
                                ".scrollIntoView(new UiSelector().description(\"%s\"))",
                        scrollableElementResourceId, scrollTargetDescription)));
    }
}
