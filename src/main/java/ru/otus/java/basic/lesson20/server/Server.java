package ru.otus.java.basic.lesson20.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8080);
        System.out.println("SERVER START!");
        while (true) {
            Socket client = socket.accept();
            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            System.out.println("client.getPort() = " + client.getPort());
            String userInput = inputStream.readUTF();
            System.out.println("получили от пользователя : " + userInput);
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Клиент с портом :" + client.getPort() + " отключился!");
                client.close();
                continue;
            }
            String result = transformStringToUpperCase(userInput);
            outputStream.writeUTF(result);
            outputStream.flush();
            System.out.println("result после трансформации клиенту = " + result);
        }
    }

    private static String transformStringToUpperCase(String userInput) {
        System.out.println("Выполняем трансформацию!");
        return userInput.toUpperCase();
    }
}
