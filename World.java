import ansi_terminal.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//This class holds the rooms, assigns them to text files, and switches between them
/**
* World class holds the room,assigs them to text files, and switches between them
*/
public class World{
  private int roomNum=1;
  private Room room1;
  private Room room2;
  private Room room3;
  private ArrayList<Room> rooms;
  Scanner in; 

  /**
  * Constructor used to load Rooms to an ArrayList
  */
  public World(){
	rooms = new ArrayList<Room>();
      	Scanner in = new Scanner(System.in);
		try{
		   FileInputStream file = new FileInputStream("Room1.txt");
		   in = new Scanner(file);
		   Room room1 = new Room(in, 1);
		   rooms.add(room1);
		   room1.setRoomNumber(1);
		}catch (FileNotFoundException e){
			System.out.print("Something went wrong :(");
			System.exit(-1);
		}
		try{
		   FileInputStream file = new FileInputStream("Room2.txt");
		   in = new Scanner(file);
		   Room room2 = new Room(in, 2);
		   rooms.add(room2);
		   room2.setRoomNumber(2);
		}catch (FileNotFoundException e){
			System.out.print("Something went wrong :(");
			System.exit(-1);
		}
		try{
		   FileInputStream file = new FileInputStream("Room3.txt");
		   in = new Scanner(file);
		   Room room3 = new Room(in, 3);
		   rooms.add(room3);
		   room3.setRoomNumber(3);
		}catch (FileNotFoundException e){
			System.out.print("Something went wrong :,(");
			System.exit(-1);
		}
  }

  /**
  * Returns room 1
  */
  public Room getRoom1(){
      return rooms.get(0);
  }
  
  /**
  * Returns room 2
  */
  public Room getRoom2(){
      return rooms.get(1);
  }

  /**
  * Returns room 3
  */
  public Room getRoom3(){
      return rooms.get(2);
  }

  /**
  * Returns room number
  */
  public int getRoomNum(){
      return roomNum;
  }
   


}
