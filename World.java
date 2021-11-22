import ansi_terminal.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class World{
  private int roomNum=1;
  private Room room1;
  private Room room2;
  private Room room3;
  private ArrayList<Room> rooms;
  Scanner in;
  //Room r = new Room();
//  private ArrayList<String> rooms = new ArrayList<String>();
//  rooms.add(Room1);
//  rooms.add(Room2);
//  rooms.add(Room3);
  //keeps track of room change?
  //once the player goes to the next room - increment level
//  for(String filename: rooms){
//    World(String filename) throws Exception{
//      Scanner s = new Scanner(new FileReader(filename));
    //...
//    }
//  }  
  public World(){
	rooms = new ArrayList<Room>();
      	Scanner in = new Scanner(System.in);
		try{
		   FileInputStream file = new FileInputStream("Room1.txt");
		   //File f = new File("Room1.txt");
		   in = new Scanner(file);
		   Room room1 = new Room(in);
		   rooms.add(room1);
		}catch (FileNotFoundException e){
			System.out.print("Something went wrong :(");
			System.exit(-1);
		}
		try{
		   FileInputStream file = new FileInputStream("Room2.txt");
	//	   File f = new File("Room2.txt");
		   in = new Scanner(file);
		   Room room2 = new Room(in);
		   rooms.add(room2);

		}catch (FileNotFoundException e){
			System.out.print("Something went wrong :(");
			System.exit(-1);
		}
		try{
		  // File f = new File("Room3.txt");
		   FileInputStream file = new FileInputStream("Room3.txt");
		   in = new Scanner(file);
		   Room room3 = new Room(in);
		   rooms.add(room3);

		}catch (FileNotFoundException e){
			System.out.print("Something went wrong :,(");
			System.exit(-1);
		}
  }

  public Room getRoom1(){
      return rooms.get(0);
  }

  public Room getNextRoom(){
      return rooms.get(1);
  }

  public Room getLastRoom(){
      return rooms.get(2);
  }

  public int getRoomNum(){
      return roomNum;
  }
   


}
