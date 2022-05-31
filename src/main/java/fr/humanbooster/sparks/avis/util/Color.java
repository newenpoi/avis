package fr.humanbooster.sparks.avis.util;

public class Color {
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_VERT = "\u001B[32m";
	private static final String ANSI_ROUGE = "\u001B[31m";
	
	public Color() {
	}
	
	public static final String red(String text) {
		return ANSI_ROUGE + text + ANSI_RESET;
	}
	
	public static final String green(String text) {
		return ANSI_VERT + text + ANSI_RESET;
	}
}
