import java.rmi.*;

public interface IGameSRV extends java.rmi.Remote{

	public void registerClient(IGUI clientGUI) throws java.rmi.RemoteException;
	public void setGui(IGUI gui) throws java.rmi.RemoteException;
	public void runGame() throws java.rmi.RemoteException;
	public void score() throws java.rmi.RemoteException;
	public void bGameQuitTrue() throws java.rmi.RemoteException;
	public void bGameQuitFalse() throws java.rmi.RemoteException;
	public void bGameInProgressTrue

}
