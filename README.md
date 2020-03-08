# Java-selenium-cucumber
---

This project is an E2E automated functional testing for **Saloodo** website using Selenium and Cucumber.

## Pre-requisites:

- NodeJS
- Java 8 JDK
- Maven
- Chrome browser
- Firefox browser


## Installation:

It is required to setup **ChromeDriver** and **GeckoDriver** on your system. Follows below:

- **Chrome**: To run the tests locally with _Chrome_, install ChromeDriver from [here](http://chromedriver.chromium.org/)


- **Firefox**: To run the tests locally with _Firefox_, install GeckoDriver from [here](https://github.com/mozilla/geckodriver/releases)


## Running tests ##

- To install all dependencies - It will run all tests in **chrome** browser

```console
$ mvn clean install
```

- Run all tests using **chrome** browser

```console
$ mvn clean test
```

```console
$ mvn clean test "-Dbrowser=chrome"
```

- Run all tests using **firefox** browser

```console
$ mvn clean test "-Dbrowser=firefox" 
```

- Run a single feature

```console
$ mvn clean test -Dcucumber.options="src/test/java/com/saloodo/feature/Login.feature"
```

```console
$ mvn clean test -Dcucumber.options="src/test/java/com/saloodo/feature/DashboardShipper.feature"
```

```console
$ mvn clean test -Dcucumber.options="src/test/java/com/saloodo/feature/Registration.feature"
```

- Run using the tag **@smoke**

```console
$ mvn clean test -Dcucumber.options="--tags @smoke"
```
