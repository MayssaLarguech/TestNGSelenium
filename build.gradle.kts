plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    // WebDriverManager dependency
    implementation ("io.github.bonigarcia:webdrivermanager:5.6.3")

    // JUnit 4 dependency (for backwards compatibility)


    // Selenium Java dependency
    implementation ("org.seleniumhq.selenium:selenium-java:4.13.0")
    // https://mvnrepository.com/artifact/org.testng/testng
    testImplementation("org.testng:testng:7.10.2")

    // https://mvnrepository.com/artifact/com.github.javafaker/javafaker
    implementation("com.github.javafaker:javafaker:1.0.2")

    // https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple
    implementation("com.googlecode.json-simple:json-simple:1.1.1")


}

tasks.test {
    useTestNG()
}