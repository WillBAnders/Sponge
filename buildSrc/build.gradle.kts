import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

plugins {
    `kotlin-dsl`

}
repositories {
    mavenCentral()
    gradlePluginPortal()
    jcenter()
    maven(url = "https://files.minecraftforge.net/maven")
}
dependencies {
    implementation("net.minecrell.licenser:net.minecrell.licenser.gradle.plugin:0.4.1")
    implementation("com.github.jengelman.gradle.plugins:shadow:5.0.0")
    implementation("org.spongepowered.plugin:org.spongepowered.plugin.gradle.plugin:0.8.1")
    implementation("net.minecraftforge.gradle:ForgeGradle:3.0.105")
}

tasks {
    val copyApi by creating(Copy::class) {
        from("../SpongeAPI/buildSrc/src/main/kotlin") {
            include("*.kt", "*.kts")
        }
        into("src/main/kotlin")
    }

    compileKotlin {
        dependsOn(copyApi)
    }
}



kotlinDslPluginOptions {
    experimentalWarning.set(false)
}
