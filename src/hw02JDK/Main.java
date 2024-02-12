package hw02JDK;

import hw02JDK.client.ClientGUI;
import hw02JDK.server.ServerWindow;

public class Main {
    public static void main(String[] args) {

        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}
