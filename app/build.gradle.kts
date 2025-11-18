plugins {
    alias(libs.plugins.android.application)



}

android {
    namespace = "com.example.peacefull_dessert_mob_dev"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.peacefull_dessert_mob_dev"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.viewpager2)
    implementation(libs.cardview)
    implementation(libs.gson)
    implementation(libs.recyclerview)
    implementation(libs.gridlayout)
    implementation(libs.material.v150)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

}