SpongeCommon.project = this
//
//plugins {
//    `java-library`
//    `maven-publish`
//    id(CommonPlugins.forgeGradle)
//}
//apply(from = "api-revision.gradle")
//
//val spongeApi = SpongeAPI.project!!
//val recommendedVersion: String by project
//// Inherit SpongeCommon version from SpongeAPI
//ext {
//    val isSnapshot = (api.version as String).contains("-SNAPSHOT")
//    val isImplRC = recommendedVersion.contains("-SNAPSHOT")
//    val trimmedApiVersion = api.version.toString().replace("-SNAPSHOT", "")
//    val apiSplitVersion = trimmedApiVersion.split("\\.")
//    // This is to determine if the split api version has at the least a minimum version.
//    val apiMinor: String = if (apiSplitVersion.size > 1) apiSplitVersion[1] else {
//        if (apiSplitVersion.size > 0) apiSplitVersion[apiSplitVersion.size - 1] else "0" }
//    val correctedMinorVersion = Math.max(Integer.parseInt(apiMinor) - 1, 0)
//    // And then here, we determine if the api version still has a patch version, to just ignore it.
//    val apiReleaseVersion = if (apiSplitVersion.size > 2) apiSplitVersion[0] + "." + apiSplitVersion[1] else trimmedApiVersion
//    val apiSuffix = if (isSnapshot) apiSplitVersion[0] + "." + correctedMinorVersion else apiReleaseVersion
//    val fixedApiVersionWithDecreasedMinor = if (apiSplitVersion.size > 2) apiSplitVersion[0] + "." + correctedMinorVersion + "." + apiSplitVersion[2]
//     else apiSplitVersion[0] + "." + correctedMinorVersion
//
//    val apiVersion = if (isSnapshot) fixedApiVersionWithDecreasedMinor else apiReleaseVersion
//}
//
//version = ImplVersions.minecraft + "-" + ext["apiSuffix"]!! + "." + recommendedVersion
//
//dependencies {
//    implementation(project(api.path)) {
//        exclude(module = "asm")
//    }
//}