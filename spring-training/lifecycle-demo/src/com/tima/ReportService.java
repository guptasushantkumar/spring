package com.tima;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ReportService {

	private String filename;

	private PrintWriter writer;

	public String getFilename() {
		return filename;
	}

	@PostConstruct
	public void doInit() {
		System.out.println("inside custom init method");

		try {
			writer = new PrintWriter(filename);
			System.out.println("Inside create writer");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void setFilename(String filename) {
		this.filename = filename;
		System.out.println("Inside set filename");
	}

	public void generateReport() {
		System.out.println("Inside generateReport");
		writer.print("Generating report in a file");
	}

	@PreDestroy
	public void doDestroy() {
		System.out.println("Inside doDestroy");
		writer.close();
	}
}
