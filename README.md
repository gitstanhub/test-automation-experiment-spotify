## Test automation project for Spotify app

<p align="center">
<br>
  <img src="media/logo/Spotify_Logo_RGB_Green.png" alt="spotify-logo" width="400">
</p>

## Table of Contents
- [Overview](#overview)
- [Installation and Setup](#installation-and-setup)
- [Usage](#usage)
- [Disclaimer](#disclaimer)
- [License](#license)

## Overview
Whether you're looking for a **built-from-scratch** test automation project example, curious to see how **patterns** like Page Object Model, Singleton, Factory Method and Dependency Injection can be applied within the same scope or just wonder if **Spring Framework** might be helpful in managing test utilities - this repository could be a great thing to explore and play around! 

For this project I've used the latest public version of **Spotify app** to cover it with a few automation tests on **API**, **Mobile (Android)** and **Web** layers.

### Technology stack:

<p align="center">
<a href="https://appium.io/"><img src="media/icons/appium.png" alt="appium-logo" width="55"></a><a href="https://www.docker.com/"><img src="media/icons/docker.png" alt="docker-logo" width="55"></a><a href="https://github.com/allure-framework"><img src="media/icons/allure.png" alt="allure-logo" width="55"></a><a href="https://gradle.org/"><img src="media/icons/gradle.png" alt="gradle-logo" width="55"></a><a href="https://rest-assured.io/"><img src="media/icons/restassured.png" alt="restassured-logo" width="55"></a><a href="https://www.java.com/en/"><img src="media/icons/java.png" alt="java-logo" width="55"></a><a href="https://junit.org/junit5/"><img src="media/icons/junit5.png" alt="junit5-logo" width="55"></a><a href="https://aerokube.com/moon/"><img src="media/icons/selenoid.png" alt="selenoid-logo" width="55"></a><a href="https://spring.io/projects/spring-framework"><img src="media/icons/spring.png" alt="spring-logo" width="55"></a><a href="https://playwright.dev/java/"><img src="media/icons/playwright.png" alt="jenkins-logo" width="55"></a><a href="https://www.jenkins.io/"><img src="media/icons/jenkins.png" alt="jenkins-logo" width="55"></a>
</p>

### Showcase:

[//]: # (<details>)

[//]: # (  <summary>Click to see a test run example from the <b>Mobile</b> module</summary>)
<p align="center">
<br>
<img src="media/gifs/mobile_test_run.gif" alt="mobile-test-run" width="400">
<br>
<i>Automated Mobile test run</i>
</p>

[//]: # (</details>)
<br>
<details>
  <summary>Click to see a test run example from the <b>Web</b> module</summary>
<p align="center">
<br>
<img src="media/gifs/web_test_run.gif" alt="web-test-run">
<br>
<i>Web test run</i>
</p>
</details>
<br>
<details>
  <summary>Click to see a test run example from the <b>API</b> module</summary>
<p align="center">
<br>
<img src="media/gifs/api_test_run.gif" alt="api-test-run">
<br>
<i>API test run</i>
</p>
</details>
<br>

### Reporting Results, Remote Run and Continuous Integration:
* For each module you can generate Allure reports:
<p align="center">
<img src="media/screenshots/allure_screenshot.png" alt="allure-screenshot">
</p>

* Web module tests can be launched remotely on a Moon instance:
<p align="center">
<img src="media/screenshots/selenoid_screenshot.png" alt="selenoid-screenshot">
</p>

* All modules contain parametrised tests well suited for CI flow that you can maintain with Jenkins. Give it a try with a separate Freestlye Project per each module:
<p align="center">
<img src="media/screenshots/jenkins_screenshot.png" alt="jenkins-screenshot">
</p>

## Installation and Setup
* Clone the repo to a local directory: <br>
```git clone https://github.com/gitstanhub/test-automation-experiment-spotify.git```


* Install <a href="https://appium.io/docs/en/2.1/quickstart/install/">Appium</a> and <a href="https://appium.io/docs/en/2.1/quickstart/uiauto2-driver/">UiAutomator2 Driver</a> before running mobile tests as well as other essentials for the mentioned stack


* A <a href="https://www.spotify.com/us/signup">Spotify account</a> signed up for <a href="https://developer.spotify.com/">developers program</a> is required to generate access token for API tests and provide user credentials for Web and Mobile tests


* After creating a Spotify user, make sure to add the Artists, Albums and Tracks mentioned in the test data properties in each module to your Library


* For practicing with remote test runs and CI stuff you can roll out new Jenkins and Moon instances locally using <a href="https://www.docker.com/products/docker-desktop/">Docker</a>

## Usage
* Run API tests with parameters:<br>

```gradle clean :api:test -Dcountry=de```

* Run Mobile tests with parameters:<br>

```gradle clean :mobile:test -Dcountry=de -Denvironment=local -DplatformName=android -DdeviceName=pixel_4_emulated```

* Run Web tests with parameters:<br>

```gradle clean :web:test -Dcountry=uk -Denvironment=remote -Dbrowser=chromium```

* You can also run tests without specifying any parameters. In that case the default parameters will be used:<br>

```gradle clean :api:test```<br>

```gradle clean :mobile:test```<br>

```gradle clean :web:test```


## Disclaimer

This project is for educational purposes and serves as a demonstration of test automation techniques. It is not affiliated with, endorsed by, or connected to Spotify. All Spotify logos, names, trademarks, and other proprietary materials are owned by Spotify or its affiliates.

## License

This project is open-source and is licensed under the MIT License. See [LICENSE](./LICENSE) for more information.
