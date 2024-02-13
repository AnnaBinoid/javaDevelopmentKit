package hw02JDK.server;

import hw02JDK.client.Client;
import hw02JDK.client.ClientGUI;

import java.util.ArrayList;
import java.util.List;

public class Server {

    boolean work;
    private iServerView serverView;
    private List<Client> clientList;
    private Repository repo;

    public Server(iServerView serverView,
                  Repository repo){
        this.serverView = serverView;
        this.repo = repo;
        clientList = new ArrayList<>();
    }

    public void setStart() {
        if (work){
            showIt("Сервер уже был запущен");
        } else {
            work = true;
            showIt("Сервер запущен!");
        }
    }

    public void setStop() {
        if (!work){
            showIt("Сервер уже был остановлен");
        } else {
            work = false;
            while (!clientList.isEmpty()){
                disconnectUser(clientList.get(clientList.size()-1));
            }
            showIt("Сервер остановлен!");
        }
    }

    private void showIt(String text){
        serverView.showMessage(text + "\n");
    }

    public boolean connectUser(Client client){
        if (!work){
            return false;
        }
        clientList.add(client);
        return true;
    }

    public void disconnectUser(Client client){
        clientList.remove(client);
        if (client != null){
            client.disconnectFromServer();
        }
    }

    public void message (String text) {
        if (!work) {
            return;
        }
        showIt(text);
        answerAll(text);
        saveInLog(text);
    }

    private void answerAll(String text) {
        for (Client client: clientList){
            client.answerFromServer(text);
        }
    }

    private void saveInLog(String text){
        repo.saveInLog(text);
    }

    public String getLog(){
        return repo.readLog();
    }
}
