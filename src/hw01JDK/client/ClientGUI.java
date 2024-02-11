package hw01JDK.client;

import hw01JDK.server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;

    private ServerWindow server;
    private boolean isConnect;

    private JButton btnLog, btnSend;
    private JTextArea chat;
    private JTextField port, ip, login, message;
    private JPasswordField password;
    private JPanel westPanel, eastPanel, nullPanel, registrationPanel, centralPanel, messagePanel, clientPanel;

    private String name, newMessage;

    public ClientGUI (ServerWindow server) {

        this.server = server;
        getClientPanel(server);
        setLogLogic();
        setSendLogic();

    }

    //answer
    public void answerFromServ(String text) {
        appendChat(text);
    }
    // соединение юзера с серверовм
    public void isConnected() {
        if (server.addUserToChat(this)) {
            appendChat("Connection success.\n");
            isConnect = true;
            setUserName();
            login.setText("guest");
            westPanel.setVisible(false);
            appendChat(server.getLog());
            appendChat(getUserName() + " joined to chat! \n");
        } else {
            isConnect = false;
            chat.append("Connection failes.\n");
        }


    }

    public void disconnectUserFromServer(){
        if (isConnect) {
            isConnect = false;
            server.disconnectUserFromChat(this);
            chat.setText("Server was stopped. Disconnect.\n");
            messagePanel.setVisible(false);

        }
    }

    private String setUserName(){
        if (login.getText().isEmpty()){
            name = "guest";
        }
        else {name = login.getText();}
        return name;
    }

    public String getUserName(){
        return name;
    }

    public void messageFromServToUser() {
        if (isConnect) {
            String text = message.getText();
            if(!text.isEmpty()){
                server.messageFromUtoServ(name + " says: " + text + "\n");
                message.setText("");
            }
        }
        else appendChat("Server is stopped.");

    }

    public void appendChat(String text) {
        chat.append(text);
    }

    private JPanel getClientPanel(ServerWindow serverWindow){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        clientPanel = new JPanel();

        setLocationRelativeTo(serverWindow);
        setSize(WIDTH, HEIGHT);

        add(getRegistrationPanel(), BorderLayout.NORTH);
        chat = new JTextArea();
        chat.setLineWrap(true);
        chat.setEditable(false);
        add(new JScrollPane(chat), BorderLayout.CENTER);
        setVisible(true);
        add(getMessagePanel(), BorderLayout.SOUTH);
        setVisible(true);
        add(clientPanel);

        setVisible(true);

        return clientPanel;
    }

    private JPanel getMessagePanel() {

        messagePanel = new JPanel(new BorderLayout());
        message = new JTextField();
        btnSend = new JButton("Send");



        messagePanel.add(message, BorderLayout.CENTER);
        messagePanel.add(btnSend, BorderLayout.EAST);

        message.setSize(new Dimension(messagePanel.getWidth()/3 * 2, messagePanel.getHeight()));


        return messagePanel;
    }

    private JPanel getRegistrationPanel() {

        btnLog = new JButton("Login");



        port = new JTextField("127.0.0");
        ip = new JTextField("8189");
        login = new JTextField();
        password = new JPasswordField("1234");

        eastPanel = new JPanel(new GridLayout(2, 1));
        centralPanel = new JPanel(new GridLayout(2, 1));
        nullPanel = new JPanel(new GridLayout(1, 1));
        westPanel = new JPanel(new GridLayout(2, 1));
        registrationPanel = new JPanel(new GridLayout(1, 3));

        eastPanel.add(port);
        eastPanel.add(login);
        centralPanel.add(ip);
        centralPanel.add(password);

        westPanel.add(nullPanel);
        westPanel.add(btnLog, BorderLayout.SOUTH);

        registrationPanel.add(eastPanel);
        registrationPanel.add(centralPanel);
        registrationPanel.add(westPanel);

        return registrationPanel;
    }

    private void setLogLogic(){
        btnLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                isConnected();

            }
        });
    }

    private void setSendLogic(){
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              messageFromServToUser();
            }
        });
    }

}
