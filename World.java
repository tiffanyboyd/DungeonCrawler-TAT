import ansi_terminal.*;

public class World{
  private int roomNum=1;
  Room r = new Room();
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
  public World(int roomNumber){
      r.loadRoom(roomNumber);
  }

//PUT THIS IN TO CHANGE
//  public changeRoom(int roomNum){
//      Room.loadRoom(roomNum);
//      roomNum++;
//  }

  public int getRoomNum(){
      return roomNum;
  }
   


}
