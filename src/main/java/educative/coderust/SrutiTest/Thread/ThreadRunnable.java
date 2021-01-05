package educative.coderust.SrutiTest.Thread;

public class ThreadRunnable {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {System.out.println("My Runnable");});
        thread.start();
    }

}
