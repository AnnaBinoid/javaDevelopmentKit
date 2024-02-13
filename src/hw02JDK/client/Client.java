package hw02JDK.client;

import hw02JDK.server.Server;
import sem02JDK.client.ClientView;

import javax.swing.text.View;

public class Client {
    // класс клиента зависит от абстракции iClientView

    private boolean connected;
    private String name;
    private iClientView clientView;
    private Server server;


    //в Client придет не абстрактный интерфейс,а конкретный класс, реализующий этот интерфейс
    public Client(iClientView clientView, Server server) {
        this.clientView = clientView;
        this.server = server;
    }

    public boolean connectToServer(String name) {
        this.name = name;
        if (server.connectUser(this)) {
            showOnWindow("Вы успешно подключились!\n");
            connected = true;
            String log = server.getLog();
            if (log != null) {
                showOnWindow(log);
            }
            return true;
        } else {
            showOnWindow ("Подключение не удалось.\n");
            return false;
        }
    }

    public void answerFromServer(String text) {
        showOnWindow(text);
    }

    public void message(String text) {
        if (connected) {
            if (!text.isEmpty()) {
                server.message(name + ": " + text);
            }
        } else {
            showOnWindow("Нет подключения к серверу.");
        }
    }

    public void disconnectFromServer() {
        if (connected) {
            connected = false;
            clientView.disconnectFromServer();
            server.disconnectUser(this);
            showOnWindow("Вы были отключены от сервера! \n");
        }
    }

    private void showOnWindow(String text) {
        clientView.showMessage(text + "\n");
    }


}
