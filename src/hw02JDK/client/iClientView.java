package hw02JDK.client;

public interface iClientView {
    // метод, который отображает сообщение от сервера
    void showMessage(String message);
    void disconnectFromServer();
}
