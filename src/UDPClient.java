
/**
 *
 * @author RafhaelRC Classe que implementa o Cliente UDP
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

        //Cria Stream de Enrada
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        //Cria socket Cliente
        DatagramSocket clientSocket = new DatagramSocket();

        //Traduz HostName para Endereço IP Usando DNS
        InetAddress IPAddress = InetAddress.getByName("localhost");

        //Testezinho pra ver se ta pegando o ip certo
        System.out.println("IPADRESS: " + IPAddress.getHostAddress());


        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();


        /*
         * DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss,SSS"); Date
         * date = new Date();
         */
        Calendar c = new GregorianCalendar();

        //Pega a hora em milisegundos
        c.setTimeInMillis(System.currentTimeMillis());
        System.out.println("Pegando o tempo em MiliSegundos: " + c.getTimeInMillis());

        // Cria datagrama com dados a enviar, dados a receber, tamanho, endereço IP e Porta
        DatagramPacket sendPacket =
                new DatagramPacket(sendData, sendData.length, IPAddress, 9876);

        // Enviando um datagrama para o servidor
        clientSocket.send(sendPacket);

        //System.out.println("Enviou horas: " + dateFormat.format(date));

        // Cria um receveiPacket e lê datagrama do servidor
        DatagramPacket receivePacket =
                new DatagramPacket(receiveData, receiveData.length);
        // lê datagrama do servidor
        clientSocket.receive(receivePacket);

        //System.out.println("Recebeu horas: " + dateFormat.format(date));


        String modifiedSentence =
                new String(receivePacket.getData());
        System.out.println("FROM SERVER:" + modifiedSentence);
        clientSocket.close();
    }
}
