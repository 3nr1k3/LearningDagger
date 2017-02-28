# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /home/ecardero/Android/Sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}


-keepattributes Signature
-keepattributes *Annotation*

-dontwarn java.lang.invoke.*
-dontwarn okio.*
-dontwarn com.squareup.okhttp.**
-dontwarn com.squareup.okhttp3.**

-keep interface okhttp3.** { *; }
-keep class okhttp3.* { *; }


#Joda time
-dontwarn org.joda.convert.**
-dontwarn org.joda.time.**
-keep class org.joda.time.** { *; }
-keep interface org.joda.time.** { *; }

#Retrofit 2
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}