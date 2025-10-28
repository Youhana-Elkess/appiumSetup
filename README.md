# appiumSetup

Java + TestNG + Appium example.

## Prerequisites
- Java 11+ with JAVA_HOME
- Android SDK with ANDROID_HOME and platform-tools on PATH
- Appium Server running (2.x) and drivers installed (uiautomator2)

## Build/Run (portable using Maven Wrapper)
1. Start Appium server
2. Connect device/emulator
3. Compile tests (no device required):
   - Windows: `.\u005cmvnw.cmd -q -DskipTests=true test-compile`
   - macOS/Linux: `./mvnw -q -DskipTests=true test-compile`
4. Run a specific test class:
   - Windows: `.\u005cmvnw.cmd -Dtest=appiumSetup test`
   - macOS/Linux: `./mvnw -Dtest=appiumSetup test`

### Configure device and app under test
Pass overrides via system properties (recommended):

Windows example:
```
.\u005cmvnw.cmd -Dudid=YOUR_DEVICE_UDID -DappPackage=com.bluev.users.dev -DappActivity=com.bluev.users.MainActivity -Dtest=appiumSetup test
```

macOS/Linux example:
```
./mvnw -Dudid=YOUR_DEVICE_UDID -DappPackage=com.bluev.users.dev -DappActivity=com.bluev.users.MainActivity -Dtest=appiumSetup test
```

## Notes
- Device UDID and capabilities are set in tests; adapt for your environment.