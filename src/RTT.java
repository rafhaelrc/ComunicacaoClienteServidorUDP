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
        for (int i = 0; i < getTemposIniciais().size() ; i++) {
        long min = Long.parseLong(getTemposFinais().get(i)) - Long.parseLong(temposIniciais.get(i));  
        if(min<rtt){
           rtt = min;
         }  
            
        }
    
    return rtt;
    }
}
