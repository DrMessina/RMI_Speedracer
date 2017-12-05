import java.lang.reflect.InvocationTargetException;
import java.rmi.*;
import java.util.Vector;

public class GameClient extends java.rmi.server.UnicastRemoteObject implements IGUI, IGameClient{

	private static final long serialVersionUID = 8257530013687833578L;
	private GUI myGUI;
	private IGameSRV server;
	int coreID;
	Core myCore;
	
	protected GameClient(String address) throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		connectToServer(address);
		coreID = getFutureID();
		System.out.println("connected to server");
		System.out.println(coreID);
		
		//give the server a remote reference to myself with which it can call me back
		try {
			System.out.println("register to server");
			System.out.println(coreID);
			server.registerClient((IGUI) java.rmi.server.RemoteObject.toStub(this), coreID);
		} catch (NoSuchObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* GUI will call this method when the client needs to locate the server */
	   
	   public void connectToServer(String address)
	      {
	      //look up the server and store a reference to the returned object in a class variable
		   try{
				server = (IGameSRV) java.rmi.Naming.lookup(address);
	        }catch(Exception e){
	        	System.out.println("failed init Client! " + e + address);
	        }
	      }
	
	  /* Methods the server will call on the client */
	@Override
	public void update(Vector<Rectangle> vDisplayRoad, Vector<Rectangle> vDisplayObstacles,
			Vector<Rectangle> vDisplayCars, Car myCar, int pos, int nbParticipants, boolean bGameOver, String sPosition)
			throws RemoteException {
		// TODO Auto-generated method stub
		//Ask the GUI to perform its update
        try {
			javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
			    @Override public void run() {
			        myGUI.update(vDisplayRoad, vDisplayObstacles, vDisplayCars, myCar, pos, nbParticipants, bGameOver, sPosition);
			    }
			});
		} catch (InvocationTargetException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void enableButton() throws RemoteException {
		// TODO Auto-generated method stub
		myGUI.jButton1.setEnabled(true);
	}

	/*method call by GUI*/
	
	public void runGame (int coreId) throws RemoteException {
		server.runGame(coreId);
	}

	@Override
	public void score(int score, int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		server.score(score, coreId);
	}

	@Override
	public void newGrid(int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		server.newGrid(coreId);
	}
	public void setGUI(GUI gGUI, int coreId) throws RemoteException {
		this.myGUI = gGUI;
	}

	@Override
	public void bGameFinishing(Boolean isFinishing, int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		server.bGameFinishing(isFinishing, coreId);
		
	}

	@Override
	public void bGameInProgress(Boolean isRunning, int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		server.bGameInProgress(isRunning, coreId);
	}

	@Override
	public void bGameQuit(Boolean isQuitting, int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		server.bGameQuit(isQuitting, coreId);
	}

	@Override
	public void LE_P(Boolean leftPressed, int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		server.LE_P(leftPressed, coreId);
	}

	@Override
	public void RI_P(Boolean rightPressed, int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		server.RI_P(rightPressed, coreId);
	}

	@Override
	public void UP_P(Boolean upPressed, int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		server.UP_P(upPressed, coreId);
		System.out.println("accélérer");
		System.out.println(coreID);
	}

	@Override
	public void DO_P(Boolean downPressed, int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		server.DO_P(downPressed, coreId);
	}

	@Override
	public Boolean getBGameInProgress(int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		return server.getBGameInProgress(coreId);
	}

	@Override
	public int getScore(int coreId) throws RemoteException {
		// TODO Auto-generated method stub
		return server.getScore(coreId);
	}

	@Override
	public int getID() throws RemoteException {
		// TODO Auto-generated method stub
		return server.getID();
	}

	@Override
	public Core getCore(int key) throws RemoteException {
		// TODO Auto-generated method stub
		return server.getCore(key);
	}

	@Override
	public void newCore(int key) throws RemoteException {
		// TODO Auto-generated method stub
		server.newCore(key);
	}

	@Override
	public int getFutureID() throws RemoteException {
		// TODO Auto-generated method stub
		return server.getFutureID();
	}
	
	
}
