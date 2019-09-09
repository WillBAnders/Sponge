plugins {
    id("org.spongepowered.gradle.sponge.impl")
    id("net.minecraftforge.gradle")
}

minecraft {
    mappings("snapshot", project.properties["mcpMappings"]!! as String)
//
//    runs {
//        server {
//            workingDirectory = project.file("../run")
//
//        }
//    }
}

dependencies {
    minecraft("net.minecraft:server:1.14.3")
}

spongeDev {
    api = project("SpongeAPI")
    common = project
}
