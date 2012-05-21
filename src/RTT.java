/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author Marcelo
 */
public class RTT {
    
    ArrayList<String> temposIniciais;
    ArrayList<String> temposFinais;
    ArrayList<Long> rtts;
    long rtt =0;
    long t_server;

    public void setTemposFinais(ArrayList<String> temposFinais) {
        this.temposFinais = temposFinais;
    }

    public void setTemposIniciais(ArrayList<String> temposIniciais) {
        this.temposIniciais = temposIniciais;
    }

  
    public ArrayList<String> getTemposFinais() {
        return temposFinais;
    }

    public ArrayList<String> getTemposIniciais() {
        return temposIniciais;
    }

    public long calculaRTT(){
       long min=0;
       long m = ( Long.parseLong(getTemposFinais().get(0)) - Long.parseLong(temposIniciais.get(0))) ;
       for (int i = 0; i < getTemposIniciais().size() ; i++) {
           
       min = ( Long.parseLong(getTemposFinais().get(i)) - Long.parseLong(temposIniciais.get(i)));
       
       if(min<m){
           m=min;
       }
        
       }
        System.out.println("RTT MIN = "+m);
        return m;
    }
    
    public long setClock(long t){
       
        long clock = t+(calculaRTT()/2);
        System.out.println("t+rtt/2 = "+clock);
        return clock;
    }
    
  

    
}
