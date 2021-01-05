package singleton;

public class SingletonThreadUnsafe {

    private static SingletonThreadUnsafe ref;

    private SingletonThreadUnsafe(){}

    public static SingletonThreadUnsafe getInstance() {

        if (ref == null) {
            ref =  new SingletonThreadUnsafe();
        }
        return ref;
    }


}
