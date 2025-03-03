plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
    alias(libs.plugins.daggerHilt)
}
android {
    namespace = "com.mufeez.epasero"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.mufeez.epasero"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // ExoPlayer for video playback
    //implementation("androidx.media3:media3-exoplayer:1.2.0")
    //implementation ("androidx.media3:media3-ui:1.2.0")
    //implementation ("me.relex:circleindicator:2.1.6")


   // implementation ("com.google.dagger:hilt-android:2.50")
   // kapt ("com.google.dagger:hilt-compiler:2.50")

    //implementation ("androidx.activity:activity-ktx:1.7.0")
//    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0")
//    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
//    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
//    implementation("androidx.datastore:datastore-preferences:1.0.0")
//    implementation("androidx.work:work-runtime-ktx:2.9.0")

    implementation(libs.androidx.activity)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.datastore)
    implementation(libs.androidx.workmanager)

    //implementation(libs.lifecycle.ktx)
    //implementation(libs.activity.ktx)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(libs.media3.exoplayer)
    implementation(libs.media3.ui)
    implementation(libs.circleindicator)



    // AndroidX Core Libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.room.ktx)


    // DataStore (Optional for storing user preferences)

    implementation(libs.coroutines.android)
    implementation(libs.coroutines.core)
    implementation(libs.androidx.recyclerview)
    implementation(libs.glide)
    kapt(libs.glide.compiler)

    // Unit Testing
    testImplementation(libs.junit)

    // UI & Instrumentation Testing
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
