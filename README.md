# Appium Setup
Pre-requisites: Softwares to install

1.	Download java jdk from below link (Choose appropriate installer according to OS you are using ) 
     http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
2.	Set up java in path variable and set up a new variable called JAVA_HOME.
      Windows -> https://stackoverflow.com/questions/1672281/environment-variables-for-java-installation
      Mac -> https://www.baeldung.com/java-home-on-windows-7-8-10-mac-os-x-linux
3. Download Android studio and install it from here (https://developer.android.com/studio/).
4. Create ANDROID_HOME environment variable and point it to path where sdk is installed (C:\Users\<username>\AppData\Local\Android\Sdk)
5. Add following path to "Path" environment variable:
    For Windows:
      C:\Users\<username>\AppData\Local\Android\Sdk\tools\bin or ANDROID_HOME\tools\bin
      C:\Users\<username>\AppData\Local\Android\Sdk\tools,  or ANDROID_HOME\tools\
      C:\Users\<username>\AppData\Local\Android\Sdk\platform-tools or ANDROID_HOME\platform-tools
   For Mac,
      Create ANDROID_HOME environment variable (https://stackoverflow.com/questions/28296237/set-android-home-environment-variable-in-mac).
6. Now launch Android Studio and install additional android SDK tools as shown in the below link:
    http://www.automationtestinghub.com/install-additional-android-sdk-tools/
7. Download and install appium desktop client from the below link:
    Windows -> https://github.com/appium/appium-desktop/releases/download/v1.6.2/appium-desktop-setup-1.6.2.exe  
    IOS -> https://github.com/appium/appium-desktop/releases/download/v1.6.2/Appium-1.6.2.dmg
8. After installation of Appium launch appium and click on Start Server button and see that server started without any issue.
9. Download Appium and Selenium Java client library as shown here : http://www.automationtestinghub.com/appium-jars-download/
10. Install Eclipse – Create a Project in Eclipse - configure Appium libraries, configure testng library, configure selenium library http://www.automationtestinghub.com/appium-project-in-eclipse/
11. In android studio create an emulator and see that you can launch emulator without any issues


# Running first test case
1.	Add testng library
2.	Create a first testng test
3.	You can refer to this for creating first test case : https://nishantverma.gitbooks.io/appium-for-android/writing_first_android_test/ 
