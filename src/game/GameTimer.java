package game;

public class GameTimer implements Runnable {

    private int seconds;
    private boolean running;
    private Thread timerThread;

    public GameTimer() {
        seconds = 0;
        running = false;
    }

    public void start() {

        if (running) {
            return;
        }

        running = true;

        timerThread = new Thread(this);
        timerThread.start();
    }

    public void stop() {
        running = false;
    }

    public void reset() {
        stop();
        seconds = 0;
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public void run() {

        while (running) {

            try {
                Thread.sleep(1000);
                seconds++;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}