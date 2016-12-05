import java.rmi.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Vector;

public interface DataStore extends Remote{
    public int mostra_temperatura()throws RemoteException;
    public int mostra_humidade()throws RemoteException;
    public int mostra_presao_atm()throws RemoteException;
    public int mostra_audio()throws RemoteException;
    public int mostra_luminusidade()throws RemoteException;
    public float mostra_media(LocalDate data, int sensor)throws RemoteException;
    public int[] mostra_max_minimo(LocalDate data, int sensor)throws RemoteException;
    public HashMap<LocalDate, Vector<Integer>> mostra_ultimos_dias(int sensor, int dias)throws RemoteException;
}