plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    //id("maven-publish")
    `maven-publish`
}

android {
    namespace = "com.onixen.playervawebar"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        version = "0.2.2"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.onixen"
            artifactId = "player-wave-bar"
            version = "0.2.1"
            description = "Default description."

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}