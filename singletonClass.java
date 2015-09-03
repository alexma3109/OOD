Singleton Class

public class Singleton {
	private static Singleton instance = null;
	private Singleton {
		
	}
	public Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
}
///lazy mode, instantiated when using///
////////////////////////////////////////
public class Singleton {
	private static final Singleton instance = new Singleton();
	private Singleton{
		
	}
	public Singleton getInstance(){
		return instance;
	}
}
///hungry mode, instantiated when loading///
//////////////////////////////////////////// 
public class Singleton{
	private static Singleton instance = null;
	private Singleton {
		
	}
	public synchronized static Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
}
///synchronized///////////////////
//////////////////////////////////////