import java.rmi.*;

public interface IGameSRV extends java.rmi.Remote{

	public void registerClient(IGUI clientGUI) throws java.rmi.RemoteException;
	public void setGui(IGUI gui) throws java.rmi.RemoteException;
	public void runGame() throws java.rmi.RemoteException;
	public void score(int score) throws java.rmi.RemoteException;
	public void bGameQuit(boolean isQuitting) throws java.rmi.RemoteException;
	public void bGameFinishing(boolean isFinishing) throws java.rmi.RemoteException;
	public void bGameInProgress(boolean isProgressing) throws java.rmi.RemoteException;
	public void UP_P(boolean isUp) throws java.rmi.RemoteException;
	public void DO_P(boolean isDown) throws java.rmi.RemoteException;
	public void RI_P(boolean isRight) throws java.rmi.RemoteException;
	public void LE_P(boolean isLeft) throws java.rmi.RemoteException;
	public boolean getBGameInProgress() throws java.rmi.RemoteException;
	public void newGrid() throws java.rmi.RemoteException;
	public int getScore() throws java.rmi.RemoteException;
	public Core newCore() throws java.rmi.RemoteException;
	public Core getCore(int key) throws java.rmi.RemoteException;
	public int getID() throws java.rmi.RemoteException;
}
