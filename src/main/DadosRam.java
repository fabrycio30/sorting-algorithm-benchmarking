package main;

public class DadosRam {
	public static long getMemoriaRam() {
		// Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Calculate the used memory
        long ram_bytes = runtime.totalMemory() - runtime.freeMemory();
        long MB = 1024L * 1024L;
        long ram = ram_bytes/MB;
		return ram_bytes;
	}
}
