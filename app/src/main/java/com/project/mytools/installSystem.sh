#!/bin/bash

# Change these
app_package="com.project.aaron.verizontest"
dir_app_name="mysystemapp"
MAIN_ACTIVITY="MainActivity"

path_apk="./app/build/outputs/apk/app-debug.apk"
path_sysapp="/system/priv-app"
install_path="$path_sysapp/$dir_app_name/$dir_app_name.apk"

# Compile the APK
rm $path_apk
cd ..
# You can change this for production build, flavors etc
./gradlew assembleDeb#!/bin/bash

# Change these
app_package="com.project.aaron.verizontest"
dir_app_name="mysystemapp"
MAIN_ACTIVITY="MainActivity"

path_apk="./app/build/outputs/apk/app-debug.apk"
path_sysapp="/system/priv-app"
install_path="$path_sysapp/$dir_app_name/$dir_app_name.apk"

# Compile the APK
rm $path_apk
cd ..
# You can change this for production build, flavors etc
./gradlew assembleDebug

adb root 2> /dev/null
adb remount
adb push $path_apk $install_path
adb shell chmod 644 $install_path
adb shell "mount -o remount,ro /"
echo "Installed $path_apk to $install_path"

# Stop the app
adb shell "am force-stop $app_package"

# Re execute the app
adb shell "am start -n \"$app_package/$app_package.$MAIN_ACTIVITY\" -a android.intent.action.MAIN -c android.intent.category.LAUNCHER"ug

adb root 2> /dev/null
adb remount
adb push $path_apk $install_path
adb shell chmod 644 $install_path
adb shell "mount -o remount,ro /"
echo "Installed $path_apk to $install_path"

# Stop the app
adb shell "am force-stop $app_package"

# Re execute the app
adb shell "am start -n \"$app_package/$app_package.$MAIN_ACTIVITY\" -a android.intent.action.MAIN -c android.intent.category.LAUNCHER"