import java.rmi.*;

public class ViewServer {

    public static void main(String[] args) {
    	 XDK xdk = new XDK();
	     xdk.controlador();
    	 try {
			   System.setSecurityManager(new RMISecurityManager());
			   View view = new View();
			   Naming.rebind("rmi://localhost/ABC", view);

			   System.out.println("Server is ready.");
			   }catch (Exception e) {
				   System.out.println("Server failed: " + e);
				}
        
    }
}
