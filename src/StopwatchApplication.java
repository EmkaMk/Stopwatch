import java.util.Scanner;

public class StopwatchApplication {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		Stopwatch stopwatch = new Stopwatch();
		while (true) {
			String s = in.next();
			if (s.equals("s")) {
				stopwatch.start();
			}
			if (s.equals("p")) {
				stopwatch.pause();
			}
			if (s.equals("r")) {
				stopwatch.resume();
			}
			if (s.equals("stop")) {
				stopwatch.stop();
				break;
			}
		}
		in.close();
	}

}
