import java.rmi.*;

public interface IGameClient extends java.rmi.Remote{
	public void runGame(int coreId) throws java.rmi.RemoteException;
	public void score(int score, int coreId) throws java.rmi.RemoteException;
	public int getScore(int coreId) throws java.rmi.RemoteException;
	public void newGrid(int coreId) throws java.rmi.RemoteException;
	public void setGUI(GUI gGUI, int coreId) throws java.rmi.RemoteException;
	public void bGameFinishing(Boolean isFinishing, int coreId) throws java.rmi.RemoteException;
	public void bGameInProgress(Boolean isRunning, int coreId) throws java.rmi.RemoteException;
	public void bGameQuit(Boolean isQuitting, int coreId) throws java.rmi.RemoteException;
	public void LE_P(Boolean leftPressed, int coreId) throws java.rmi.RemoteException;
	public void RI_P(Boolean rightPressed, int coreId) throws java.rmi.RemoteException;
	public void UP_P(Boolean upPressed, int coreId) throws java.rmi.RemoteException;
	public void DO_P(Boolean downPressed, int coreId) throws java.rmi.RemoteException;
	public Boolean getBGameInProgress(int coreId) throws java.rmi.RemoteException;
	public Core newCore(int key) throws java.rmi.RemoteException;
	public Core getCore(int key) throws java.rmi.RemoteException;
	public int getID() throws java.rmi.RemoteException;
	public int getFutureID() throws java.rmi.RemoteException;
	}
