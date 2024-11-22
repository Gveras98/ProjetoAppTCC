// Arquivo build.gradle (nível de módulo)
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.projetovital"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.projetovital"
        minSdk = 27
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Configuração para permissões de tempo de execução
        vectorDrawables.useSupportLibrary = true
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

    buildFeatures {
        viewBinding = true
    }

    // Configurações para lidar com permissões de notificações e compatibilidade
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.work:work-runtime-ktx:2.10.0")


    // Activity e Fragment
    implementation(libs.androidx.activity)
    implementation("androidx.activity:activity-ktx:1.9.3")
    implementation("androidx.fragment:fragment-ktx:1.8.5")

    // ConstraintLayout e Material
    implementation(libs.androidx.constraintlayout)
    implementation("com.google.android.material:material:1.12.0")

    // Notificações e permissões
    implementation("androidx.core:core-ktx:1.15.0")

    // WorkManager (para notificações agendadas)
    implementation("androidx.work:work-runtime-ktx:2.10.0")

    // Biometria
    implementation("androidx.biometric:biometric:1.1.0")

    // ViewModel e LiveData
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.7")

    // Room Database
    implementation("androidx.room:room-ktx:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    androidTestImplementation("androidx.room:room-testing:2.6.1")
    implementation("androidx.room:room-runtime:2.6.1")

    // Google ML Kit
    implementation("com.google.android.gms:play-services-mlkit-document-scanner:16.0.0-beta1")

    // Testes
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}


