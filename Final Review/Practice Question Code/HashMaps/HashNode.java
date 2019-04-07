
//这里的HashNode就跟平时linked list 里面的Node 定义一样，只是有了key:value pair
public class HashNode<K,V> {
	K key;
	V value;
	HashNode<K, V>next;
	public HashNode()
	{
		this.key=key;
		this.value=value;
		this.next = null;
	}
	

}
