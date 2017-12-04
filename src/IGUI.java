import java.rmi.*;
import java.util.Vector;

public interface IGUI extends java.rmi.Remote{
	   public void update(Vector<Rectangle> vDisplayRoad, Vector<Rectangle> vDisplayObstacles, Vector<Rectangle> vDisplayCars, Car myCar, int pos, int nbParticipants, boolean bGameOver, String sPosition) throws java.rmi.RemoteException;
	   public void enableButton() throws java.rmi.RemoteException;
}
