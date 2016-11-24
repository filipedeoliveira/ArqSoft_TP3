/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as_tp3;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author Stéphane
 */
public class Model {
    /**  Data objects
     *
     * Registos do valor de temperaturas
     * Registos do valor de humidade
     * Registos do valor de pressão atmosférica
     * Registos de audio
     * Registos de luminosidade
     * */

    static HashMap<LocalDate,Vector<Integer>> temperatura;
    static HashMap<LocalDate,Vector<Integer>> humidade;
    static HashMap<LocalDate,Vector<Integer>> pressao_atm;
    static HashMap<LocalDate,Vector<Integer>> audio;
    static HashMap<LocalDate,Vector<Integer>> luminosidade;
    
    public Model(){
    
        this.humidade = new HashMap<LocalDate,Vector<Integer>>();
        this.temperatura = new HashMap<LocalDate,Vector<Integer>>();
        this.audio = new HashMap<LocalDate,Vector<Integer>>();
        this.luminosidade = new HashMap<LocalDate,Vector<Integer>>();
        this.pressao_atm = new HashMap<LocalDate,Vector<Integer>>();
    }
    
  
        
    
}
