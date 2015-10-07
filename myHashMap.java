public class MyHashMap<K, V> {
	private int size;
	private Object[] table;
	
	public MyHashMap () {
		size = 64;
		table = new Object[64];
	}
	
	class Entry {
		K key;
		V value;
		public Entry (K key, V value){
			this.key = key;
			this.value = value;
		}
		public K getKey(){
			return key;
		}
		public V getValue(){
			return value;
		}
		public void setKey(K key){
			this.key = key;
		}
		public void setValue(V value){
			this.value = value;
		}
	}
	
	public void put(K key, V value){
		if(key != null){
			int hash = key.hashCode() % size;
			hash = hash < 0 ? -hash : hash;
			if(table[hash] == null){
				Entry entry = new Entry(key, value);
				LinkedList<Entry> list = new LinkedList<Entry>();
				list.add(entry);
				table[hash] = list;
			}
			else{
				LinkedList<Entry> list = (LinkedList<Entry>) table[hash];
				int i = 0;
				while(i < list.size()){
					if(list.get(i).getKey().equals(key)){
						list.get(i).setValue(value);
						break;
					}
					i++;
				}
				if(i == list.size()){
					list.add(new Entry(key, value));
				}
			}
		}
	}
	
	public V get(K key){
		if(key != null){
			int hash = key.hashCode() % size;
			hash = hash < 0 ? -hash : hash;
			if(table[hash] == null){
				return null;
			}
			else{
				LinkedList<Entry> list = (LinkedList<Entry>) table[hash];
				for(int i = 0 ; i < list.size() ; i++){
					if(list.get(i).getKey().equals(key)){
						return list.get(i).getValue();
					}
				}
				return null;
			}
		}
		return null;
	}
}