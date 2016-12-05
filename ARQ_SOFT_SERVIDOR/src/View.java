import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

public class View extends UnicastRemoteObject implements DataStore{
	
	public View () throws RemoteException {   }
	
    WeatherStation ws = new WeatherStation();
    /**
     * Funcionalidade: Mostrar os valores mais recentes dos sensores
     *
     * @return print da temperatura
     */
    public int mostra_temperatura() {
        int i = -100;
        if (ws.temperatura.containsKey(LocalDate.now())) {
            int size = ws.temperatura.get(LocalDate.now()).size();
            i = ws.temperatura.get(LocalDate.now()).elementAt(size - 1);
        }
        return i;
    }


    public int mostra_humidade() {
        int value = -100;
        if (ws.humidade.containsKey(LocalDate.now())) {
            int size = ws.humidade.get(LocalDate.now()).size();
            value = ws.humidade.get(LocalDate.now()).elementAt(size - 1);
        }
        
        return value;
    }


    public int mostra_presao_atm() {
        int value = -100;
        if (ws.pressao_atm.containsKey(LocalDate.now())) {
            int size = ws.pressao_atm.get(LocalDate.now()).size();
            value = ws.pressao_atm.get(LocalDate.now()).elementAt(size - 1);
        }
        
        return value;
    }


    public int mostra_audio() {
        int value = -100;
        if (ws.audio.containsKey(LocalDate.now())) {
            int size = ws.audio.get(LocalDate.now()).size();
            value = ws.audio.get(LocalDate.now()).elementAt(size - 1);
        }
        System.out.println("Audio actual: " + value);
        return value;
    }


    public int  mostra_luminusidade() {
        int value = -100;
        if (ws.luminosidade.containsKey(LocalDate.now())) {
            int size = ws.luminosidade.get(LocalDate.now()).size();
            value = ws.luminosidade.get(LocalDate.now()).elementAt(size - 1);
        }
        System.out.println("Audio actual: " + value);
        return value;
    }

    /**
     * Funcionalidade: mostra a m�dia da temperatura para um determinado dia
     *
     * @param data dia a considerar para a m�dia
     * @param sensor sensor a calcular: 0 temperatura
     */

    public float mostra_media(LocalDate data, int sensor) {

        if (sensor==0){//temperatura
                if (false != ws.temperatura.containsKey(data)) {

                    int sum = 0;
                    for (Integer val : ws.temperatura.get(data)) {
                        sum += val;
                    }

                    System.out.println("M�dia temperatura: " + sum / ws.temperatura.get(data).size());
                    float res=(sum/ ws.temperatura.get(data).size());
                    return res;
                }
        }
        else if(sensor==1){ //humidade
                if (false != ws.humidade.containsKey(data)) {

                    int sum = 0;
                    for (Integer val : ws.humidade.get(data)) {
                        sum += val;
                    }

                    System.out.println("M�dia humidade: " + sum / ws.humidade.get(data).size());
                    float res=sum / ws.humidade.get(data).size();
                    return res;
                }
        }
        float res=0;
      return res;
    }

    /**
     * Funcionalidade: Mostar os valores m�ximos e minimos de um determinado
     * sensor para um determinado dia.
     *
     * @param data dia a considerar para recolher o valor m�ximo e min�mo
     * @param sensor valor do sensor a recolher: temperatura, humidade, press�o
     * atm, audio, luminosidade
     */
    public int[] mostra_max_minimo(LocalDate data, int sensor) {

        switch (sensor) {
            case 0: // 0 temperatura
                if (false != ws.temperatura.containsKey(data)) {
                    Vector<Integer> v = ws.temperatura.get(data);
                    int max = Collections.max(v);
                    int min = Collections.min(v);
                    System.out.println("Max temperatura: " + max + " Min temperatura: " + min);
                    return new int[] {max, min};
                }
                break;
            case 1: //humidade
                if (false != ws.humidade.containsKey(data)) {
                    Vector<Integer> v = ws.humidade.get(data);
                    int max = Collections.max(v);
                    int min = Collections.min(v);
                    System.out.println("Max humidade: " + max + " Min humidade: " + min);
                    return new int[] {max, min};
                }
                break;
            case 2: //press�o atmosf�rica
                if (false != ws.pressao_atm.containsKey(data)) {
                    Vector<Integer> v = ws.pressao_atm.get(data);
                    int max = Collections.max(v);
                    int min = Collections.min(v);
                    System.out.println("Max press�o atmosf�rica: " + max + " Min press�o atmosf�rica: " + min);
                    return new int[] {max, min};
                }
                break;
            case 3: //audio
                if (false != ws.audio.containsKey(data)) {
                    Vector<Integer> v = ws.audio.get(data);
                    int max = Collections.max(v);
                    int min = Collections.min(v);
                    System.out.println("Max Audio: " + max + " Min Audio: " + min);
                    return new int[] {max, min};
                }
                break;
            case 4: //luminosidade
                if (false != ws.luminosidade.containsKey(data)) {
                    Vector<Integer> v = ws.luminosidade.get(data);
                    int max = Collections.max(v);
                    int min = Collections.min(v);
                    System.out.println("Max Luminosidade: " + max + " Min Luminosidade: " + min);
                    return new int[] {max, min};
                }
                break;}
                int[] res = null;
                res[0]=0;
            return res;
        
    }

    /**
     * Mostrar dos ultimos X dias os valores m�ximos e minumos de um sensor
     *
     * @param sensor sensor a mostrar
     * @param dias numero de dias a considerar desde a leitura mais actual.
     */
    public HashMap<LocalDate, Vector<Integer>> mostra_ultimos_dias(int sensor, int dias) {

        int dias_counter = dias - 1;
        HashMap<LocalDate, Vector<Integer>> last_values = new HashMap<LocalDate, Vector<Integer>>();
        Vector max_min_values = new Vector();
        switch (sensor) {
            case 0: //temperatura
                LocalDate today = LocalDate.now();
                while (dias_counter >= 0) {

                    if (false != ws.temperatura.containsKey(today.minusDays(dias_counter))) {
                        Vector<Integer> temp_values = ws.temperatura.get(today.minusDays(dias_counter));
                        max_min_values.add(Collections.max(temp_values));
                        max_min_values.add(Collections.min(temp_values));
                        last_values.put(today.minusDays(dias_counter), max_min_values);

                    }
                    dias_counter -= 1;
                }
                break;
        }
        System.out.println("Valores m�ximos e m�nimos: " + last_values.toString());
        return last_values;
    }
}
