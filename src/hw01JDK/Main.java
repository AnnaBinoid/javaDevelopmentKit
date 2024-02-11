package hw01JDK;

import hw01JDK.client.ClientGUI;
import hw01JDK.server.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}
