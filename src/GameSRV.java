import java.net.MalformedURLException;
import java.rmi.*;

public class GameSRV extends java.rmi.server.UnicastRemoteObject implements IGameSRV{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1501804357866249049L;
	private Core core;
	protected GameSRV() throws RemoteException, MalformedURLException {
		super();
		// TODO Auto-generated constructor stub
		java.rmi.Naming.rebind("//localhost/speedracer", this);
		System.out.println("server started");
		core = new Core();
	}
	@Override
	public void registerClient(IGUI gGUI) throws RemoteException {
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
	
}
