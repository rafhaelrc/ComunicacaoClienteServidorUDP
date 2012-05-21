
/**
 * @author RafhaelRC
 */
import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class TCPServer {

    public static void main(String args[]) throws Exception {

        //Cria um datagrama socket na parta 8080
        DatagramSocket serverSocket = new DatagramSocket(8080);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        Calendar c = new GregorianCalendar();
       
        while (true) {

            //Cria espaço para datagramas recebidos
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            //Recebe datagrama
            serverSocket.receive(receivePacket);

            String sentence = new String(receivePacket.getData());
            System.out.println("Sentença: " + sentence);
            
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
             c.setTimeInMillis(System.currentTimeMillis());
       
            String capitalizedSentence = c.getTimeInMillis()+"";
            sendData = capitalizedSentence.getBytes();
            
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress,port);
            serverSocket.send(sendPacket);

        }
    }
}
