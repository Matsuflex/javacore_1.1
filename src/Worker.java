import java.util.function.Function;

public class Worker {
    public OnTaskDoneListener callback;
    public OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;
    }

    public Worker(OnTaskErrorListener errorCallback) {
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                final int error = i;
                OnTaskErrorListener<OnTaskDoneListener, String> taskError = x -> "Task " + error + " Error";
                String s = taskError.onError(callback);
                callback.onDone(s);
            } else {
                callback.onDone("Task " + i + " is done");
            }
        }
    }
}
