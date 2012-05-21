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

    public RTT(ArrayList<String> temposIniciais, ArrayList<String> temposFinais) {
        this.temposIniciais = temposIniciais;
        this.temposFinais = temposFinais;
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
       System.out.println("RTT" + min); 
       if(min<m){
           m=min;
       }
        
       }
        
        return m;
    }
}
