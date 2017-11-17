// Used for designing room object.

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Room
{
	View view;
	protected int roomId;
	protected String roomDesc;
	protected int items; 
//	protected int puzzles;
//	protected int enemies; 
	public static ArrayList<Room> rooms = new ArrayList<Room>();
	protected boolean locked;
	protected int[] exitIDs;
	protected char[] directions;
	protected String[] doorDescriptions;
	
	public Room(String loadedString)
	{
		// loaded from file
		//int roomId, String roomDescription, int exitRoomId, char direction, String doorDescription
		locked = false;
		try {	
			String[] splitString = loadedString.split("-_");
			roomId = Integer.parseInt(splitString[0]);
			roomDesc = splitString[1];
			//exits
			String[] tempString1 = splitString[2].split("><");
			String[] tempString2 = splitString[3].split("><");
			int i = Array.getLength(tempString1);
			exitIDs = new int[i];
			directions = new char[i];
			while(i>0) {
				i--;
				exitIDs[i] = Integer.parseInt(tempString1[i]);
				directions[i] = tempString2[i].charAt(0);;
			}
			doorDescriptions = splitString[4].split("><");
		}catch(Exception E)
		{
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include RoomsA in the text message");
		}
	}

	public int getRoomId()
	{
		return roomId;
	}

	public String getRoomDesc()
	{
		return roomDesc;
	}
	
	public int[] getExits() {
		return exitIDs;}
	public int getExit(int i) {
		return exitIDs[i];}
	
	public String[] getExitDescriptions() {
		return doorDescriptions;}
	public String getExitDescription(int i) {
		return doorDescriptions[i];}
	
	public char[] getDirections() {
		return directions;}
	public char getDirection(int i){
		try{return directions[i];}
		catch(Exception E) {return ' ';}}
	
	public boolean isLocked(){
		return locked;
	}

	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}
	
	public void setView(View v) {
		view = v;
	}
	
	public void examineRoom() {}

	public void showPaths(){
		int i = directions.length;
		while(i>0) {
			i--;
			System.out.println(directions[i]+
					" "+doorDescriptions[i]);
		}
	}

	@Override
	public String toString(){
		return getRoomDesc();}
}
