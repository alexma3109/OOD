////call center ////
////singleton class ////
public class callHandler {
	private static callHandler instance = null;
	
	private static final LEVEL = 3;
	private static final NUM_RESPONDER = 10;
	private static final NUM_MANAGER = 5;
	private static final NUM_DIRECTOR = 2;
	
	private Queue<Call> waitQueue = new LinkedList<Call>();
	private List<List<Employee>> employeeArray = new ArrayList<List<Employee>>();
	
	public Employee dispatchCall(Call call){
		if(employeeArray.get(0).size() < NUM_RESPONDER){
			Employee emp = new Responder();
			call.setRank(0);
			call.setEmployee(emp, employeeArray.get(0).size());
			employeeArray.get(0).add(emp);
			return emp;
		}
		else if(employeeArray,get(1).size() < NUM_MANAGER){
			Employee emp = new Manager();
			call.setRank(1);
			call.setEmployee(emp, employeeArray.get(0).size());
			employeeArray.get(1).add(emp);
			return emp;
		}
		else if(employeeArray.get(2).size() < NUM_DIRECTOR){
			Employee emp = new Director();
			call.setRank(2);
			call.setEmployee(emp, employeeArray.get(0).size());
			employeeArray.get(2).add(emp);
			return emp;
		}
		else{
			waitQueue.add(call);
			return null;
		}
	}

	public Queue<Call> getWaitingList(){
		if(waitQueue.size() != 0){
			return waitQueue;
		}
		return null;
	}
	
	private callHandler{
		for(int i = 0 ; i < LEVEL ; i++){
			employeeArray.add(new ArrayList<Employee>());
		}
		
	////constructor/////	
	}
	public static getInstance(){
		if(instance == null){
			instance = new callHandler();
		}
		return instance;
	}
}

public class Call {
	private int rank = 0;
	private int position = -1; ////the position in the array of the employee who is dealing with this call, -1 as not dispatched yet////
	private Employee emp;
	
	public Call(){
	////constructor////
	}
	
	public void setEmployee(Employee emp, int pos){
		this.emp = emp;
		position = pos;
	}
	public void setRank(int r){
		rank = r;
	}
	public int getEmployee(){
		return emp;
	}
	public int getRank(){
		return rank;
	}
	////other methods////
}

public abstract class Employee {
	protected int rank;
	private Call currentCall = null;
	
	public Employee();
	public void setRank(int r){
		rank = r;
	}
	public void setCall(Call call){
		currentCall = call;
	}
}

public class Responder extends Employee {
	public Responder(){
		rank = 0;
	}
}
public class Manager extends Employee {
	public Manager(){
		rank = 1;
	}
}
public class Director extends Employee {
	public Director(){
		rank = 2;
	}
}