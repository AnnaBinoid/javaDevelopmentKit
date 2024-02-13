package hw02JDK.server;

public interface iRepository {
    void saveInLog(String s);
    String readLog();
}
