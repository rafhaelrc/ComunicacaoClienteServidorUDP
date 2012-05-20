
/**
 *
 * @author RafhaelRC
 */
import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class TCPServer {

    public static void main(String args[]) throws Exception {

        //Cria um datagrama socket na parta 8080
        DatagramSocket serverSocket = new DatagramSocket(8080);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while (true) {

            //Cria espaço para datagramas recebidos
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            //Recebe datagrama
            serverSocket.receive(receivePacket);

            String sentence = new String(receivePacket.getData());
            System.out.println("Sentença: " + sentence);
            
            //Obtem endereço IP
            InetAddress IPAddress = receivePacket.getAddress();
            //Obtem número da porta
            int port = receivePacket.getPort();
            
            // Deixa a sentença em letras maiusculas.
            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            
            //Cria datagrama para enviar para o Cliente
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress,
                    port);
            //Escreve o Datagrama no Socket
            serverSocket.send(sendPacket);

        }
    }
}
