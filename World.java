import ansi_terminal.*;

public class World{
  private int roomNum=0;
  private ArrayList<String> rooms = new ArrayList<String>();
  rooms.add(Room1);
  rooms.add(Room2);
  rooms.add(Room3);
  //keeps track of room change?
  //once the player goes to the next room - increment level
  for(String filename: rooms){
    World(String filename) throws Exception{
      Scanner s = new Scanner(new FileReader(filename));
    //...
    }
  }  

  public int getRoomNum(){
      return roomNum;
  }
   


}
