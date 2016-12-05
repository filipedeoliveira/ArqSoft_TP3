import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.time.LocalDate;

public class ViewClient {
		public static void main (String[] args) {
			DataStore view;
			try {
	  		    System.setSecurityManager(new RMISecurityManager());
				view = (DataStore)Naming.lookup("rmi://localhost/ABC");
				int i = view.mostra_temperatura();
				System.out.println("Tempertura Actual: " + i);
				int j = view.mostra_humidade();
				System.out.println("Humidade Actual: " + j);
				int k = view.mostra_presao_atm();
				System.out.println("pressao atmosférica actual: " + k);
				
				}catch (Exception e) {
					System.out.println("Client exception: " + e);
					}
			}
	}