package singleton;

public class SingletonThreadSafe {

    private static SingletonThreadSafe ref;
    private static Object lock = new Object();

    private SingletonThreadSafe(){}

    public static SingletonThreadSafe getInstance() {

        if (ref == null) {
            synchronized (lock) {
                if (ref == null) {
                    ref = new SingletonThreadSafe();
                }
            }
        }
        return ref;
    }


}
