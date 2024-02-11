package hw01JDK.server;

import hw01JDK.client.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import static java.awt.BorderLayout.SOUTH;

public class ServerWindow extends JFrame {
    private static final int WEIGHT = 300;
    private static final int HEIGHT = 300;
    private boolean serverIsWorking;
    private static final String LOG_LIST =
            "C:\\Users\\User\\IdeaProjects\\javaDevelopmentKit\\src\\hw01JDK\\logList.txt";
    private ArrayList<ClientGUI> activeUsers;

    JButton btnStart, btnStop;

    JTextArea textArea;

    public ServerWindow(){
        serverIsWorking = false;
        activeUsers = new ArrayList<>();
        getServerWindow();
        setStartLogic();
        setStopLogic();

    }

    public void messageFromUtoServ(String message) {
        if(!serverIsWorking) {
            return;
        }
        makeSLog(message);
        sendAll(message);
        appendLog(message);
    }

    private void appendLog(String text) {
        textArea.append(text);
    }

    public boolean addUserToChat(ClientGUI clientGUI) {
        if(serverIsWorking)
        {
            activeUsers.add(clientGUI);
            serverIsWorking = true;

        }
        else {
            serverIsWorking = false;
        }
        return serverIsWorking;

    }

    public void disconnectUserFromChat(ClientGUI clientGUI){
        for (int i = 0; i < activeUsers.size() - 1; i++){
            activeUsers.get(i).disconnectUserFromServer();
            activeUsers.remove(i);
        }
    }
    // проверить

    public void makeSLog(String logMessage) {
        try (FileWriter writer = new FileWriter(LOG_LIST, true)) {
            writer.write(logMessage + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // проверить

    public static String getLog() {
        StringBuilder logForReturn = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_LIST))) {
            String line;
            while ((line = reader.readLine()) != null) {
                logForReturn.append(line).append("\n");
            }
            return logForReturn.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private void sendAll(String message) {
        for (ClientGUI u: activeUsers) {
            u.answerFromServ(message);
        }
    }

    private void setStartLogic(){
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (serverIsWorking == false) {
                    serverIsWorking = true;
                    textArea.setText("Server is working.\n");
                    makeSLog("Server is working.\n");
                    ;
                }
                else textArea.setText("Server is steel working.\n");
            }
        });

    }

    private void setStopLogic() {
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (serverIsWorking) {
                    serverIsWorking = false;
                    textArea.setText("Server stopped.\n");
                    makeSLog("Server is out of work.\n");
                }
                else {textArea.setText("Server is still stop.\n");}
                disconnectUserFromChat(activeUsers.get(activeUsers.size() - 1));
            }
        });
    }

    private JPanel getServerWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WEIGHT, HEIGHT);
        setLocationRelativeTo(null);

        setTitle("Chat server");
        //user can't change window sides
        setResizable(false);

        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        textArea  = new JTextArea("Подключение сервера", 10, 1);
        textArea.setEditable(false);

        JPanel mainPan = new JPanel(new GridLayout(1, 2));

        mainPan.add(btnStart);
        mainPan.add(btnStop);

        add(mainPan, SOUTH);
        add(textArea);

        setVisible(true);

        return mainPan;
    }
}
