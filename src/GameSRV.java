import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.SortedMap;
import java.util.TreeMap;

public class GameSRV extends java.rmi.server.UnicastRemoteObject implements IGameSRV{

	private static final long serialVersionUID = -1501804357866249049L;
	private Core core;
	private SortedMap<Integer, Core> CoreList;

	
	protected GameSRV() throws RemoteException, MalformedURLException {
		super();
		startRegistry(1099);
		java.rmi.Naming.rebind("//192.168.1.37/speedracer", this);
		System.out.println("server started");
		CoreList = new TreeMap<Integer, Core>();
		//core = newCore(0);
	
	}
	
	@Override
	public synchronized void registerClient(IGUI gGUI, int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			newCore(coreId);
			System.out.println(coreId);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			System.out.println("Erreur création core ");
			e1.printStackTrace();
		}
		getCore(coreId).setGUI(gGUI);
		
	}
	@Override
	public void runGame(int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		getCore(coreId).runGame();
		System.out.println("runGame");
		System.out.println(coreId);
	}
	
	@Override
	public void setGui(IGUI gui, int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		getCore(coreId).setGUI(gui);
		System.out.println("setGui");
		System.out.println(coreId);

	}
	@Override
	public void score(int score, int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		getCore(coreId).score = score;
		System.out.println("set score");
		System.out.println(coreId);
	}
	@Override
	public void newGrid(int coreId) throws RemoteException {
		getCore(coreId).newGrid();
		
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
	@Override
	public void bGameQuit(boolean isQuitting, int coreId) throws RemoteException {
		getCore(coreId).bGameQuit = isQuitting;
	}
	@Override
	public void bGameFinishing(boolean isFinishing, int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		getCore(coreId).bGameFinishing = isFinishing;
	}
	@Override
	public void bGameInProgress(boolean isProgressing, int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		getCore(coreId).bGameInProgress = isProgressing;
	}
	@Override
	public void UP_P(boolean isUp, int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		getCore(coreId).UP_P = isUp;
	}
	@Override
	public void DO_P(boolean isDown, int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		getCore(coreId).DO_P = isDown;
	}
	@Override
	public void RI_P(boolean isRight, int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		getCore(coreId).RI_P = isRight;
	}
	@Override
	public void LE_P(boolean isLeft, int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		getCore(coreId).LE_P = isLeft;
	}
	@Override
	public boolean getBGameInProgress(int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		return getCore(coreId).bGameInProgress;
	}
	@Override
	public int getScore(int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		return getCore(coreId).getScore();
	}
	@Override
	public Core getCore(int key) throws RemoteException {
		// TODO Auto-generated method stub
		return CoreList.get(key);
	}
	
	public int getFutureID() throws RemoteException {
		// TODO Auto-generated method stub
		try {
			int i = CoreList.lastKey();
			System.out.println("last kay");
			System.out.println(i+1);
			return i+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Return 0 future key");
			//e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int getID() throws RemoteException {
		// TODO Auto-generated method stub
		try {
			int i = CoreList.lastKey();
			System.out.println("getID");
			System.out.println(i);
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Return 0 key");
			//e.printStackTrace();
			return 0;
		}
	}
	@Override
	public void newCore(int key) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(key);
		Core c = new Core();
		CoreList.put(key, c);
	}


	
}
