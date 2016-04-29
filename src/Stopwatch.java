import java.util.concurrent.TimeUnit;

public class Stopwatch {

	public int currentTime = 0;
	public boolean stopped = false;
	public boolean paused = false;
	public boolean start = false;
	private Thread regulator = new Thread() {

		public void run() {
			while (!stopped) {
				if (Thread.interrupted()) {
					return;
				}

				while (paused) {
					try {
						synchronized (this) {
							wait();
						}
					} catch (InterruptedException e) {
					}
				}
				System.out.println(currentTime++);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		}

	};

	public void start() {
		if (!start) {
			start = true;
			regulator.start();
		}
	}

	public void stop() {
		stopped = true;
	}

	public void pause() throws InterruptedException {
		paused = true;
	}

	public void resume() {
		paused = false;
		synchronized (regulator) {
			regulator.notifyAll();
		}
	}

}
