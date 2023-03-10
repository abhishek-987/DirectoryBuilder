package com.example.DirectoryBuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class DirectoryBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DirectoryBuilderApplication.class, args);

		String projectDir = "/home/abhishek/Downloads/helo"; // linux
		String projectDir1 = "C:\\path\\to\\project\\directory"; // windows
		ProcessBuilder processBuilder1 = new ProcessBuilder("cmd.exe", "/c", "mvn", "clean", "install", "-DskipTests"); //windows
		ProcessBuilder processBuilder = new ProcessBuilder("mvn", "clean", "install", "-DskipTests"); //linux
		processBuilder.directory(new File(projectDir));

		try {
			Process process = processBuilder.start();
			int exitCode = process.waitFor();
			if (exitCode == 0) {
				System.out.println("Build succeeded");
			} else {
				System.out.println("Build failed with exit code " + exitCode);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
