/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as_tp3;

import java.time.LocalDate;

/**
 *
 * @author Stéphane
 */
public interface DataStore {
    public void mostra_temperatura();
    public void mostra_humidade();

    public void mostra_presao_atm();
    public void mostra_audio();

    public void mostra_luminusidade() ;
    public void mostra_media(LocalDate data, int sensor);

    public void mostra_max_minimo(LocalDate data, int sensor) ;
    public void mostra_ultimos_dias(int sensor, int dias) ;
}