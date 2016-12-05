import java.time.LocalDate;
import java.util.Vector;

public class XDK {
    public void controlador() {
        // Create a hash map
        Vector<Integer> xdk1_reading_1= new Vector<>();
        xdk1_reading_1.add(23);
        xdk1_reading_1.add(2);
        xdk1_reading_1.add(3);
        xdk1_reading_1.add(54);
        xdk1_reading_1.add(32);

        Vector<Integer> xdk1_reading_2= new Vector<>();
        xdk1_reading_2.add(22);
        xdk1_reading_2.add(24);
        xdk1_reading_2.add(3);
        xdk1_reading_2.add(4);
        xdk1_reading_2.add(5);

        WeatherStation iot = new WeatherStation();
        // simular a recepção de valores
        iot.update(1, xdk1_reading_1);
        iot.update(1, xdk1_reading_2);
    }
   /* public static void ver(){ 

       // Views
        View view = new View();
        view.mostra_temperatura();
        view.mostra_max_minimo(LocalDate.now(), 0);
        view.mostra_max_minimo(LocalDate.now(), 1);
        view.mostra_max_minimo(LocalDate.now(), 2);
        view.mostra_max_minimo(LocalDate.now(), 3);
        view.mostra_max_minimo(LocalDate.now(), 4);
        view.mostra_presao_atm();
        view.mostra_humidade();
        view.mostra_media(LocalDate.now(),0);
        view.mostra_ultimos_dias(0,2);
    }*/
}
