pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
rootProject.name = "MathCalculator"
include(":app")
include(":core:ui")
include(":core:utils")
include(":features:settings:impl")
include(":features:settings:api")
include(":module-injector")
include(":features:calculator:impl")
include(":features:calculator:api")
include(":features:history:impl")
include(":features:history:api")
