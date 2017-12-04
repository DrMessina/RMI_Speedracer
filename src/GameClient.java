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
		try{
			server = (IGameSRV) java.rmi.Naming.lookup(address);
        
			//give the server a remote reference to myself with which it can call me back
			server.registerClient((IGUI) java.rmi.server.RemoteObject.toStub(this));
        }catch(Exception e){
        	System.out.println("failed init Client! " + e);
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
	
}
