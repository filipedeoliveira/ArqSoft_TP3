package as_tp3;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by "amateur programmer”
 */
public class WeatherStation implements WeatherObserver {
    
    public WeatherStation(){}

    /**
     * A estção meteriologica recebe updates dos sensores e armazena os valores na estrutura de dados respectiva.
     * @param id identificador do sensor XDK
     * @param values parametros lidos pelo sensor
     *               posição 0 : temperatura
     *               posição 1 : humidade
     *               posição 2 : pressão atmosféria
     *               posição 3 : audio
     *               posição 4 : luminosidade
     *
     */
    @Override
    public void update(int id, Vector<Integer> values){
       
        Model Model = new Model();
        switch (id) {
            case 1: // XDK exterior

                if (Model.temperatura.get(LocalDate.now()) != null){
                    Vector<Integer> val_temp = Model.temperatura.get(LocalDate.now());
                    Iterator<Integer> iterator = values.iterator();
                    val_temp.add(values.elementAt(0));
                } else
                {
                    Vector<Integer> new_vector  =  new Vector<Integer>();
                    new_vector.add(values.elementAt(0));
                    Model.temperatura.put(LocalDate.now(), new_vector);
                }
                if (Model.humidade.get(LocalDate.now()) != null){
                    Vector<Integer> val_temp = Model.humidade.get(LocalDate.now());
                    Iterator<Integer> iterator = values.iterator();
                    val_temp.add(values.elementAt(1));
                } else
                {
                    Vector<Integer> new_vector  =  new Vector<Integer>();
                    new_vector.add(values.elementAt(1));
                    Model.humidade.put(LocalDate.now(), new_vector);
                }

                if (Model.pressao_atm.get(LocalDate.now()) != null){
                    Vector<Integer> val_temp = Model.pressao_atm.get(LocalDate.now());
                    Iterator<Integer> iterator = values.iterator();
                    val_temp.add(values.elementAt(2));
                } else
                {
                    Vector<Integer> new_vector  =  new Vector<Integer>();
                    new_vector.add(values.elementAt(2));
                    Model.pressao_atm.put(LocalDate.now(), new_vector);
                }

                if (Model.audio.get(LocalDate.now()) != null){
                    Vector<Integer> val_temp = Model.audio.get(LocalDate.now());
                    Iterator<Integer> iterator = values.iterator();
                    val_temp.add(values.elementAt(3));
                } else
                {
                    Vector<Integer> new_vector  =  new Vector<Integer>();
                    new_vector.add(values.elementAt(3));
                    Model.audio.put(LocalDate.now(), new_vector);
                }
                if (Model.luminosidade.get(LocalDate.now()) != null){
                    Vector<Integer> val_temp = Model.luminosidade.get(LocalDate.now());
                    Iterator<Integer> iterator = values.iterator();
                    val_temp.add(values.elementAt(4));
                } else
                {
                    Vector<Integer> new_vector  =  new Vector<Integer>();
                    new_vector.add(values.elementAt(4));
                    Model.luminosidade.put(LocalDate.now(), new_vector);
                }
                break;
            case 2: // XDK interior
                ;
                break;
            default:
                // ignore ;
                break;
        }
    }


}
