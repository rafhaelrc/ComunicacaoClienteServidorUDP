
/**
 *
 * @author RafhaelRC
 * Classe que implementa o Cliente UDP
 */
import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class UDPClient {

    public static void main(String args[]) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        System.out.println("IPADRESS: " + IPAddress.getHostAddress());
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss,SSS");
        Date date = new Date();
        Calendar c = new GregorianCalendar();  
        c.setTimeInMillis(System.currentTimeMillis());
        System.out.println("Pegando o tempo em MiliSegundos: "+ c.getTimeInMillis());
        
        
        DatagramPacket sendPacket =
                new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);
        System.out.println("Enviou horas: " + dateFormat.format(date));
        DatagramPacket receivePacket =
                new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        System.out.println("Recebeu horas: " + dateFormat.format(date));
        String modifiedSentence =
                new String(receivePacket.getData());
        System.out.println("FROM SERVER:" + modifiedSentence);
        clientSocket.close();
    }
}
