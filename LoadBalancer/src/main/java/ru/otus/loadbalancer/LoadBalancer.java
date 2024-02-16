package ru.otus.loadbalancer;

import lombok.Data;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
public class LoadBalancer implements Runnable {
    private int ID;
    private int port;
    private List<Node> nodeList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public LoadBalancer(int ID, int port) {
        this.ID = ID;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (int i = 0; i < nodeList.size(); i++) {
                    try {
                        Socket nodeSocket = new Socket("localhost", nodeList.get(i).getPort());
                        BufferedReader reader = new BufferedReader(new InputStreamReader(nodeSocket.getInputStream()));
                        BufferedWriter writer = new BufferedWriter(new PrintWriter(nodeSocket.getOutputStream(), true));

                        // Отправка сообщения серверу
                        String input = scanner.nextLine();
                        writer.write(input + "\n\r");
                        writer.flush();

                        // Получение ответа от сервера и вывод в консоль
                        String serverResponse = reader.readLine();
                        System.out.println("Received response from Node: " + serverResponse);

                        // Закрываем ресурсы
                        reader.close();
                        writer.close();
                        nodeSocket.close();
                    } catch (SocketTimeoutException ste) {
                        System.out.println("Node didn't respond within the timeout, removing from the list.");
                        nodeList.remove(i);
                    }
                }

                wait(1000);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            scanner.close();
        }
    }
    public void createND(int ID, int port) {
        Node node = new Node(ID, port);
        nodeList.add(node);
    }
}
