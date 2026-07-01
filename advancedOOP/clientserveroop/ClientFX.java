package clientserveroop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

public class ClientFX {

    private JTextArea outputArea;
    private JTextField inputField;

    // RMI remote reference
    

    public ClientFX() {
        connectToServer();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("RMI Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);

        JPanel panel = new JPanel(new BorderLayout(5,5));

        JLabel title = new JLabel("Java RMI Client");
        panel.add(title, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(outputArea);
        scroll.setPreferredSize(new Dimension(480, 220));
        panel.add(scroll, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout(5,5));
        inputField = new JTextField();
        JButton sendBtn = new JButton("Send to Server");
        JButton clearBtn = new JButton("Clear");

        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        clearBtn.addActionListener(e -> outputArea.setText(""));

        bottom.add(inputField, BorderLayout.CENTER);
        JPanel btns = new JPanel();
        btns.add(sendBtn);
        btns.add(clearBtn);
        bottom.add(btns, BorderLayout.EAST);

        panel.add(bottom, BorderLayout.SOUTH);

        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // CONNECT TO RMI SERVER
    private void connectToServer() {
        try {
            service = (RemoteService) Naming.lookup("rmi://localhost/RemoteService");
            System.out.println("Connected to RMI Server!");
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    // SEND MESSAGE TO SERVER
    private void sendMessage() {
        try {
            String msg = inputField.getText();

            if (msg == null || msg.trim().isEmpty()) {
                outputArea.append("Enter a message first!\n");
                return;
            }

            String response = service.sendMessage(msg);

            outputArea.append("You: " + msg + "\n");
            outputArea.append("Server: " + response + "\n\n");

            inputField.setText("");

        } catch (Exception e) {
            outputArea.append("Error communicating with server.\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClientFX());
    }
}
