import java.rmi.*;

public interface IGameClient extends java.rmi.Remote{
	public void runGame() throws java.rmi.RemoteException;
	public void score(int score) throws java.rmi.RemoteException;
	public void bGameQuitTrue() throws java.rmi.RemoteException;
	public void bGameQuitFalse() throws java.rmi.RemoteException;
	public void newGrid() throws java.rmi.RemoteException;
	public void setGUI(GUI gGUI) throws java.rmi.RemoteException;
}
