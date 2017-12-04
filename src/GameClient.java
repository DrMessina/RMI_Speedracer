import java.lang.reflect.InvocationTargetException;
import java.rmi.*;
import java.util.Vector;

public class GameClient extends java.rmi.server.UnicastRemoteObject implements IGUI, IGameClient{

	private static final long serialVersionUID = -8257530013687833578L;
	private GUI myGUI;
	private IGameSRV server;
	
	protected GameClient(String address) throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		connectToServer(address);
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
		 //give the server a remote reference to myself with which it can call me back
			try {
				server.registerClient((IGUI) java.rmi.server.RemoteObject.toStub(this));
			} catch (NoSuchObjectException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
	
	public void runGame () throws RemoteException {
		server.runGame();
	}

	@Override
	public void score(int score) throws RemoteException {
		// TODO Auto-generated method stub
		server.score(score);
	}

	@Override
	public void newGrid() throws RemoteException {
		// TODO Auto-generated method stub
		server.newGrid();
	}
	public void setGUI(GUI gGUI) throws RemoteException {
		this.myGUI = gGUI;
	}

	@Override
	public void bGameFinishing(Boolean isFinishing) throws RemoteException {
		// TODO Auto-generated method stub
		server.bGameFinishing(isFinishing);
		
	}

	@Override
	public void bGameInProgress(Boolean isRunning) throws RemoteException {
		// TODO Auto-generated method stub
		server.bGameInProgress(isRunning);
	}

	@Override
	public void bGameQuit(Boolean isQuitting) throws RemoteException {
		// TODO Auto-generated method stub
		server.bGameQuit(isQuitting);
	}

	@Override
	public void LE_P(Boolean leftPressed) throws RemoteException {
		// TODO Auto-generated method stub
		server.LE_P(leftPressed);
	}

	@Override
	public void RI_P(Boolean rightPressed) throws RemoteException {
		// TODO Auto-generated method stub
		server.RI_P(rightPressed);
	}

	@Override
	public void UP_P(Boolean upPressed) throws RemoteException {
		// TODO Auto-generated method stub
		server.UP_P(upPressed);
	}

	@Override
	public void DO_P(Boolean downPressed) throws RemoteException {
		// TODO Auto-generated method stub
		server.DO_P(downPressed);
	}

	@Override
	public Boolean getBGameInProgress() throws RemoteException {
		// TODO Auto-generated method stub
		return server.getBGameInProgress();
	}
	
	
}
