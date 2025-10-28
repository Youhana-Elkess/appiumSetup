# appiumSetup

Java + TestNG + Appium example.

## Prerequisites
- Java 11+ with JAVA_HOME
- Android SDK with ANDROID_HOME and platform-tools on PATH
- Appium Server running (2.x) and drivers installed (uiautomator2)
- Maven 3.8+

## Run
1. Start Appium server
2. Connect device/emulator
3. mvn -Dtest=appiumSetup test

## Notes
- Device UDID and capabilities are set in tests; adapt for your environment.