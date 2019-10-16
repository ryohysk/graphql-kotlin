import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.1.7.RELEASE"
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
	kotlin("jvm") version "1.3.50"
	kotlin("plugin.spring") version "1.3.50"
	kotlin("kapt") version "1.3.50"
	id("org.flywaydb.flyway") version "5.2.4"
}

group = "com.ryohysk"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val developmentOnly: Configuration by configurations.creating
configurations {
	runtimeClasspath {
		extendsFrom(developmentOnly)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	compile("mysql:mysql-connector-java")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:5.10.0")
	runtimeOnly("com.graphql-java-kickstart:altair-spring-boot-starter:5.10.0")
	kapt("org.seasar.doma:doma:latest.release")
	implementation("org.seasar.doma:doma:latest.release")
	implementation("org.seasar.doma.boot:doma-spring-boot-starter:latest.release")
}

val compileKotlin: KotlinCompile by tasks

kapt {
	arguments {
		arg("doma.resources.dir", compileKotlin.destinationDir)
	}
}

tasks.register("copyDomaResources", Sync::class) {
	from(sourceSets.main.get().resources.srcDirs)
	into(compileKotlin.destinationDir)
	include("doma.compile.config")
	include("META-INF/**/*.sql")
	include("META-INF/**/*.script")
}

tasks.withType<KotlinCompile> {
	dependsOn(tasks.getByName("copyDomaResources"))
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
