package educative.coderust.SrutiTest;

public class ThreadsafeSingleton {
    private static  ThreadsafeSingleton ts ;
    //private static final Object obj=new Object();
    private ThreadsafeSingleton(){

    }

    public static ThreadsafeSingleton getInstance(){

        if (ts==null){
        synchronized (ThreadsafeSingleton.class){
            if(ts==null){
                ts=new ThreadsafeSingleton();
            }
        }

        }
        return ts;
    }
}
