public abstract class Vehicycle {
	protected int size;
	protected int type;
	protected Spot spot;
	protected String liscense;
	protected boolean isParked;
	
	public Vehicycle();
	public int getSize(){
		return size;
	}
	public Spot getSpot(){
		return spot;
	}
	public boolean setSpot(Spot spot){
		if(spot.size >= size){
			this.spot = spot;
			isParked = true;
		}
		else{
			return false;
		}
	}
	public void setLicense(String l){
		liscense = l;
	}
	public String getLicense(){
		return liscense;
	}
}

public class Motorcycle extends Vehicycle{
	public Motorcycle(){
		type = 0;
		size = 1;
	}	
}
public class Car extends Vehicycle{
	public Car(){
		type = 1;
		size = 1;
	}
}
public class Truck extends Vehicycle{
	public Truck() {
		type = 2;
		size = 2;
	}
}

public class Spot {
	private int[] pos;
	private int size;
	private Vehicycle vehicycle;
	private boolean occupied;
	private boolean created;
	
	public Spot(int[] pos){
		if(pos.length != 2){
			this.pos[0] = -1;
			this.pos[1] = -1;
			created = false;
		}
		else{
			this.pos[0] = pos[0];
			this.pos[1] = pos[1];
			created = true;
		}		
		size = 1;
	}
	public Spot(int s, int[] pos){
		if(pos.length != 2){
			this.pos[0] = -1;
			this.pos[1] = -1;
			created = false;
		}
		else{
			this.pos[0] = pos[0];
			this.pos[1] = pos[1];
			created = true;
		}
		if(s == 2){
			size = 2;
		}
		else{
			size = 1;
		}
	}
	
	public boolean setVehicycle(Vehicycle v){
		if(!occupied && size >= v.size){
			vehicycle = v;
			occupied = true;
			return true;
		}
		return false;
	}
	
	public Vehicycle getVehicycle(){
		return vehicycle;
	}
	
	public Vehicycle removeVehicycle(){
		Vehicycle temp = vehicycle;
		vehicycle = null;
		occupied = false;
		return temp;
	}
	public int getSize(){
		return size;
	}
	
	public int[] getPosition(){
		return pos;
	}
}

public class Garage{
	private Spot[][] spots;
	private boolean Full;
	
	public Garage(int row, int col, int[] sizeOfSpot){
		spots = new Spot[row][col];
		//// construct the spots ////
	}
	public boolean isFull(){
		for(int i = 0 ; i < row ; i++){
			for(int j = 0 ; j < col ; j++){
				if(!spots[i][j].occupied){
					return false;
				}
			}
		}
		return true;
	}
	public boolean isSpotAvailable(int row, int col, Vehicycle vehicycle){
		if(!spots[row][col].occupied || spots[row][col].size >= vehicycle.size){
			return true;
		}
	}
	public Spot[][] getSpots(){
		return spots;
	}
}

