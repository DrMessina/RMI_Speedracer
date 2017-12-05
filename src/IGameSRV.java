import java.rmi.*;

public interface IGameSRV extends java.rmi.Remote{

	public void registerClient(IGUI clientGUI, int coreId) throws java.rmi.RemoteException;
	public void setGui(IGUI gui, int coreId) throws java.rmi.RemoteException;
	public void runGame(int coreId) throws java.rmi.RemoteException;
	public void score(int score, int coreId) throws java.rmi.RemoteException;
	public void bGameQuit(boolean isQuitting, int coreId) throws java.rmi.RemoteException;
	public void bGameFinishing(boolean isFinishing, int coreId) throws java.rmi.RemoteException;
	public void bGameInProgress(boolean isProgressing, int coreId) throws java.rmi.RemoteException;
	public void UP_P(boolean isUp, int coreId) throws java.rmi.RemoteException;
	public void DO_P(boolean isDown,int coreId) throws java.rmi.RemoteException;
	public void RI_P(boolean isRight, int coreId) throws java.rmi.RemoteException;
	public void LE_P(boolean isLeft, int coreId) throws java.rmi.RemoteException;
	public boolean getBGameInProgress(int coreId) throws java.rmi.RemoteException;
	public void newGrid(int coreId) throws java.rmi.RemoteException;
	public int getScore(int coreId) throws java.rmi.RemoteException;
	public void newCore(int key) throws java.rmi.RemoteException;
	public Core getCore(int key) throws java.rmi.RemoteException;
	public int getID() throws java.rmi.RemoteException;
	public int getFutureID() throws java.rmi.RemoteException;
	public void deleteCore(int coreId) throws java.rmi.RemoteException;
	}
