object Version {
    const val core = "1.7.0"

    // Network
    const val retrofit = "2.9.0"
    const val okHttp = "4.10.0"
    const val gsonConverter = "2.9.0"

    // Dagger Hilt
    const val hilt = "2.44"
    const val hiltCompiler = "2.44"

    // Jetpack Compose
    const val navigation = "2.5.3"


    const val coil = "2.4.0"

}

object Deps {
    const val core = "androidx.core:core-ktx:${Version.core}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.core}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Version.okHttp}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Version.gsonConverter}"
}

object DaggerHilt {
    const val hilt = "com.google.dagger:hilt-android:${Version.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Version.hiltCompiler}"
}

object JetpackCompose {
    const val navigation = "androidx.navigation:navigation-compose:${Version.navigation}"
}

object CoilImageLibrary {
    const val coil = "io.coil-kt:coil-compose:${Version.coil}"
}
