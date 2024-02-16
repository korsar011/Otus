package ru.otus.loadbalancer;

import lombok.Data;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
@Data
public class Node implements Runnable{
   private int ID;
   private int port;
    public Node(int ID, int port) {
        this.ID=ID;
        this.port=port;
    }

    @Override
    public void run() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new PrintWriter(socket.getOutputStream(), true));

                // Чтение сообщения от клиента
                String clientMessage = reader.readLine();
                System.out.println("Received message from LoadBalancer: " + clientMessage);

                // Отправка ответа клиенту
                writer.write( clientMessage + ". Hello from the other side. From node: " + ID + " \n\n");
                writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
