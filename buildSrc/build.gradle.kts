

repositories {
    mavenCentral()
    gradlePluginPortal()
    jcenter()
}

dependencies {
    implementation(group= "org.jetbrains.kotlin", name= "kotlin-script-runtime", version= "1.3.21")
    implementation(gradleKotlinDsl())
}