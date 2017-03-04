//Singleton Class//
public class Singleton{
	private static SingletonHolder{
		private static final Singleton INSTANCE = new Singleton();
	}
	private Singleton(){...}
	public static final Singleton getInstance(){
		return SingletonHolder.INSTANCE;
	}
}
///static nested, recommended. ///////////////////
//////////////////////////////////////
public class Singleton {
	private static Singleton instance = null;
	private Singleton (){...}
	public Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
}
///lazy mode, instantiated when using. Not thread safe.///
////////////////////////////////////////
public class Singleton {
	private static final Singleton instance = new Singleton();
	private Singleton(){...}
	public Singleton getInstance(){
		return instance;
	}
}
///hungry mode, instantiated when loading, thread safe.///
//////////////////////////////////////////// 
public class Singleton{
	private static Singleton instance = null;
	private Singleton (){...}
	public synchronized static Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
}
///synchronized but not efficient. ///////////////////
//////////////////////////////////////
public class Singleton{
	private volatile static Singleton instance = null;
	private Singleton(){...}
	public static Singleton getInstance(){
		if(instance == null){
			synchronized (Singleton.class){
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
///double checked locking pattern, synchronized. ///////////////////
//////////////////////////////////////