plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "es.iessaladillo.pedrojoya.helloworld"
    compileSdk = 37

    defaultConfig {
        applicationId = "es.iessaladillo.pedrojoya.helloworld"
        minSdk = 27
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}
