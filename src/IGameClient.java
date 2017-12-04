import java.rmi.*;

public interface IGameClient extends java.rmi.Remote{
	public void runGame() throws java.rmi.RemoteException;
	public void score(int score) throws java.rmi.RemoteException;
	public void bGameQuitTrue() throws java.rmi.RemoteException;
	public void bGameQuitFalse() throws java.rmi.RemoteException;
	public void newGrid() throws java.rmi.RemoteException;
	public void setGUI(GUI gGUI) throws java.rmi.RemoteException;
	public void bGameFinishing(Boolean isFinishing) throws java.rmi.RemoteException;
	public void bGameInProgress(Boolean isRunning) throws java.rmi.RemoteException;
	public void bGameQuit(Boolean isQuitting) throws java.rmi.RemoteException;
	public void LE_P(Boolean leftPressed) throws java.rmi.RemoteException;
	public void RI_P(Boolean rightPressed) throws java.rmi.RemoteException;
	public void UP_P(Boolean upPressed) throws java.rmi.RemoteException;
	public void DO_P(Boolean downPressed) throws java.rmi.RemoteException;
	public Boolean getbGameInProgress() throws java.rmi.RemoteException;
}
