
/**
 *
 * @author RafhaelRC Classe que implementa o Cliente UDP
 */
import com.sun.org.apache.xml.internal.utils.res.LongArrayWrapper;
import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class UDPClient {
    
    public static void main(String args[]) throws Exception {

        ArrayList<String> tempoSaida = new ArrayList<String>();
        ArrayList<String> tempoRetorno = new ArrayList<String>();
        Calendar c = new GregorianCalendar();
        int cont;
        RTT rtt = new RTT();
       
       

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite quantos pacotes serão enviados."); 
        String quantidade = inFromUser.readLine();
        int numero = Integer.parseInt(quantidade);
        //Cria socket Cliente
        DatagramSocket clientSocket = new DatagramSocket();
        //Traduz HostName para Endereço IP Usando DNS
        //InetAddress IPAddress = InetAddress.getByName("201.66.204.109");
         InetAddress IPAddress = InetAddress.getByName("localhost");
       //Testezinho pra ver se ta pegando o ip certo
        System.out.println("IPADRESS: " + IPAddress.getHostAddress());
  
       for(int i = 0; i<numero;i++){
       
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        //String sentence = inFromUser.readLine();
        
        String sentence = "Teste";
        sendData = sentence.getBytes();

        // Cria datagrama com dados a enviar, dados a receber, tamanho, endereço IP e Porta
        DatagramPacket sendPacket =
                new DatagramPacket(sendData, sendData.length, IPAddress, 8080);

        // Enviando um datagrama para o servidor
        clientSocket.send(sendPacket);
         //Pega a hora em milisegundos
        c.setTimeInMillis(System.currentTimeMillis());
        
        System.out.print("hora de envio: " + c.getTimeInMillis()+ " ");
        tempoSaida.add(i, c.getTimeInMillis()+"");
        
         

        //System.out.println("Enviou horas: " + dateFormat.format(date));

        // Cria um receveiPacket e lê datagrama do servidor
        DatagramPacket receivePacket =
                new DatagramPacket(receiveData, receiveData.length);
        // lê datagrama do servidor
        clientSocket.receive(receivePacket);
        //Pega a hora em milisegundos
        c.setTimeInMillis(System.currentTimeMillis());
        System.out.print("hora de chegada: " + c.getTimeInMillis()+ " ");
        System.out.println();
        tempoRetorno.add(i, c.getTimeInMillis()+"");
       
        cont = numero-1;
        if(cont == i){
             String t = new String(receivePacket.getData());
             String  tl = String.valueOf(t);
             long T = Long.parseLong(tl);
             rtt.setTemposIniciais(tempoSaida);
             rtt.setTemposFinais(tempoRetorno);
             c.setTimeInMillis(rtt.setClock(T)); 
        }
       
     }

     
    
     System.out.println("TIME  = "+c.getTimeInMillis());
     clientSocket.close();
     
    }
}
