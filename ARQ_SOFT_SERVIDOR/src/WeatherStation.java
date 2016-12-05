import java.time.LocalDate;
import java.util.*;

/**
 * Created by "amateur programmer”
 */
public class WeatherStation implements WeatherObserver {

    static HashMap<LocalDate, Vector<Integer>> temperatura;
    static HashMap<LocalDate, Vector<Integer>> humidade;
    static HashMap<LocalDate, Vector<Integer>> pressao_atm;
    static HashMap<LocalDate, Vector<Integer>> audio;
    static HashMap<LocalDate, Vector<Integer>> luminosidade;

    public WeatherStation() {

    }

    /**
     * A estção meteriologica recebe updates dos sensores e armazena os valores
     * na estrutura de dados respectiva.
     *
     * @param id identificador do sensor XDK
     * @param values parametros lidos pelo sensor posição 0 : temperatura
     * posição 1 : humidade posição 2 : pressão atmosféria posição 3 : audio
     * posição 4 : luminosidade
     *
     */
    @Override
    public void update(int id, Vector<Integer> values) {
        this.humidade = new HashMap<LocalDate, Vector<Integer>>();
        this.temperatura = new HashMap<LocalDate, Vector<Integer>>();
        this.audio = new HashMap<LocalDate, Vector<Integer>>();
        this.luminosidade = new HashMap<LocalDate, Vector<Integer>>();
        this.pressao_atm = new HashMap<LocalDate, Vector<Integer>>();

        switch (id) {
            case 1: // XDK exterior

                if (temperatura.get(LocalDate.now()) != null) {
                    Vector<Integer> val_temp = temperatura.get(LocalDate.now());
                    Iterator<Integer> iterator = values.iterator();
                    val_temp.add(values.elementAt(0));
                } else {
                    Vector<Integer> new_vector = new Vector<Integer>();
                    new_vector.add(values.elementAt(0));
                    temperatura.put(LocalDate.now(), new_vector);
                }
                if (humidade.get(LocalDate.now()) != null) {
                    Vector<Integer> val_temp = humidade.get(LocalDate.now());
                    Iterator<Integer> iterator = values.iterator();
                    val_temp.add(values.elementAt(1));
                } else {
                    Vector<Integer> new_vector = new Vector<Integer>();
                    new_vector.add(values.elementAt(1));
                    humidade.put(LocalDate.now(), new_vector);
                }

                if (pressao_atm.get(LocalDate.now()) != null) {
                    Vector<Integer> val_temp = pressao_atm.get(LocalDate.now());
                    Iterator<Integer> iterator = values.iterator();
                    val_temp.add(values.elementAt(2));
                } else {
                    Vector<Integer> new_vector = new Vector<Integer>();
                    new_vector.add(values.elementAt(2));
                    pressao_atm.put(LocalDate.now(), new_vector);
                }

                if (audio.get(LocalDate.now()) != null) {
                    Vector<Integer> val_temp = audio.get(LocalDate.now());
                    Iterator<Integer> iterator = values.iterator();
                    val_temp.add(values.elementAt(3));
                } else {
                    Vector<Integer> new_vector = new Vector<Integer>();
                    new_vector.add(values.elementAt(3));
                    audio.put(LocalDate.now(), new_vector);
                }
                if (luminosidade.get(LocalDate.now()) != null) {
                    Vector<Integer> val_temp = luminosidade.get(LocalDate.now());
                    Iterator<Integer> iterator = values.iterator();
                    val_temp.add(values.elementAt(4));
                } else {
                    Vector<Integer> new_vector = new Vector<Integer>();
                    new_vector.add(values.elementAt(4));
                    luminosidade.put(LocalDate.now(), new_vector);
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
