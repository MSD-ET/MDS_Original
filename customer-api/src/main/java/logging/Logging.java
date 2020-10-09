package logging;

public class Logging {
	
	private static String module = "na";
	private static boolean on = true;

	public Logging(String module) {
		Logging.module = module;
	}

	public Logging() {
	}

	public void mlog(String message) {
		System.out.println(module.toUpperCase() + ": " + message);
	}

	public static void log(String message) {
		System.out.println(module.toUpperCase() + ": " + message);
	}

	public static void on() {
		Logging.on = true;
	}

	public static void off() {
		Logging.on = true;
	}


}
