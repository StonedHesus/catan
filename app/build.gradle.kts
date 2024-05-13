plugins {
    application
    id ("org.openjfx.javafxplugin") version "0.0.13"
}

repositories {
    mavenCentral()
}

javafx {
    version = "18.0.1"
    modules = listOf("javafx.controls", "javafx.fxml", "javafx.graphics", "javafx.swing")
}


dependencies {
    // This dependency is used by the application.
    implementation("com.google.guava:guava:31.1-jre")
}

application {
    // Define the main class for the application.
    mainClass.set("catan.main.Main")
}
