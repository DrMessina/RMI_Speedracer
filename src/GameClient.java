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
	public void bGameQuitTrue() throws RemoteException {
		// TODO Auto-generated method stub
		server.bGameQuitTrue();
	}

	@Override
	public void bGameQuitFalse() throws RemoteException {
		// TODO Auto-generated method stub
		server.bGameQuitFalse();
	}

	@Override
	public void newGrid() throws RemoteException {
		// TODO Auto-generated method stub
		server.newGrid();
	}
	public void setGUI(GUI gGUI) throws RemoteException {
		this.myGUI = gGUI;
	}
}
