plugins {
	id("org.springframework.boot") version "3.3.6" apply false
	id("io.spring.dependency-management") version "1.1.6"
	id("java")
}

allprojects {
	group = "com.example"
	version = "0.0.1-SNAPSHOT"
	repositories { mavenCentral() }
}

extra["springCloudVersion"] = "2023.0.5"

subprojects {
	apply(plugin = "java")
	apply(plugin = "io.spring.dependency-management")

	extensions.configure<JavaPluginExtension> {
		toolchain { languageVersion.set(JavaLanguageVersion.of(17)) }
	}

	dependencyManagement {
		imports {
			mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
		}
	}

	tasks.withType<Test> { useJUnitPlatform() }
}
