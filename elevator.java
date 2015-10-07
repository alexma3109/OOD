public class TaskCenter{
	private static TaskCenter taskCenter = null;
	private Queue<Request> queueNormal;//// maybe another queue for the higher level request ////
	private Queue<Request> queueImportant;
	private List<Elevator> elevators;  //// choose next available elevator to run the request //// 
	
	private TaskCenter(){
		//// construct the taskCenter, initialize the queue and the elevators ////
	}
	
	public synchronized static TaskCenter getTaskCenter(){//// singleton, lazy mode ////
		if(taskCenter == null){
			taskCenter = new TaskCenter(); 
		}
		return taskCenter;
	}
	
	public boolean setRequest(Request req, int level){
		//// if level 0, put into normal queue ////
	}
	
	public boolean findRequest(Request req){
		//// iterate the queues to find whether the req is in the queues ////
	}
	public boolean upgradeRequest(Request req){
		//// find the req in normal and remove, and put it into important queue ////
	}
	public boolean dispatchTask(){
		//// if important queue is empty, go to deal with the normal queue ////
		//// find the next available elevator to take the task ////
		//// if no elevator is available, find the elevator whose target is closer ////
		//// task queue jumper : req only has target ////
	}
////	public boolean assignTaskTo(Elevator elevator){
////				
////	}
}

public class Elevator {
	private Request request;
	private boolean goUp;
	private int currentPos;
	private int targetPos;
	private boolean locked;
	
	public Elevator(){
		//// construct ////
	}
	public boolean setRequest(Request, req){
		if(!locked && request != null){
			return false;
		}
		request = req;
		targetPos = req.target;
		goUp = targetPos - currentPos > 0 ? true : false;
  	}
	
	public Request getRequest(){
		return request;
	}
	/////////////////////////
}