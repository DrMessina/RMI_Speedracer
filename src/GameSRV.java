import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class GameSRV extends java.rmi.server.UnicastRemoteObject implements IGameSRV{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1501804357866249049L;
	private Core core;
	protected GameSRV() throws RemoteException, MalformedURLException {
		super();
		startRegistry(1099);
		java.rmi.Naming.rebind("//localhost/speedracer", this);
		System.out.println("server started");
		core = new Core();
	}
	@Override
	public synchronized void registerClient(IGUI gGUI) throws RemoteException {
		// TODO Auto-generated method stub
		core.setGUI(gGUI);
	}
	@Override
	public void runGame() throws RemoteException {
		// TODO Auto-generated method stub
		core.runGame();
	}
	
	@Override
	public void setGui(IGUI gui) throws RemoteException {
		// TODO Auto-generated method stub
		core.setGUI(gui);

	}
	@Override
	public void score(int score) throws RemoteException {
		// TODO Auto-generated method stub
		Core.score = score;
	}
	@Override
	public void bGameQuitTrue() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void bGameQuitFalse() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void newGrid() throws RemoteException {
		core.newGrid();
		
	}
	
	 public static void main(String[] args)
     {
     try
        {
        new GameSRV();
        }
        catch(Exception e)
        {
        System.out.println("Fatal: " + e);
	 e.printStackTrace();
	 System.exit(1);
        }
     }
		//This method starts a RMI registry on the local host, if
	  //it does not already exists at the specified port number.
	  private static void startRegistry(int RMIPortNum)
	    throws RemoteException{
	    try {
	      Registry registry = 
	        LocateRegistry.getRegistry(RMIPortNum);
	      registry.list( );  
	        // This call will throw an exception
	        // if the registry does not already exist
	    }
	    catch (RemoteException e) { 
	      // No valid registry at that port.
	      Registry registry = 
	        LocateRegistry.createRegistry(RMIPortNum);
	    }
	  } // end startRegistry
	
}
