

import java.util.ArrayList;

public class Map<K,V> {
	
	ArrayList<HashNode<K, V>>bucket=new ArrayList<>();
	int numBuckets=10;
	int size;
	public Map()
	{
		for(int i=0;i<numBuckets;i++)
		{
			bucket.add(null);

		}
	}
	public int getSize()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size==0;
	}
	private int getBucketIndex(K key)
	{
		int hashCod=key.hashCode();
		return hashCod%numBuckets;
	}

	//计算hash code，获取hash table index，再找到key对应的value,返回值是value
	public V get(K key)
	{
		int index=getBucketIndex(key);
		HashNode<K, V> head=bucket.get(index);
		while(head!=null)
		{
			if(head.key.equals(key))
			{
				return head.value;
			}
			head=head.next;
		}
		return null;	
	}

	//删除操作
	public V remove(K key)
	{
		int index=getBucketIndex(key);
		HashNode<K, V>head=bucket.get(index);
		if(head==null)//head == null means the chain is empty
		{
			return null;
		}
		if(head.key.equals(key))
		{
			V val=head.value;
			head=head.next;
			bucket.set(index, head);
			size--;
			return val;
		}
		else
		{
			HashNode<K, V>prev=null;
			while(head!=null)
			{
				
				if(head.key.equals(key))
				{
					prev.next=head.next;
					size--;
					return head.value;
				}
				prev=head;
				head=head.next;
			}
			size--;
			return null;
		}
	}

	//增加操作
	public void add(K key,V value)
	{
		
		int index=getBucketIndex(key);
		System.out.println(index);
		HashNode<K, V>head=bucket.get(index);
		HashNode<K, V>toAdd=new HashNode<>();
		toAdd.key=key;
		toAdd.value=value;
		if(head==null)
		{
			bucket.set(index, toAdd);
			size++;
			
		}
		else
		{
			while(head!=null)
			{
				if(head.key.equals(key))
				{
					head.value=value;
					size++;
					break;
				}
				head=head.next;
			}
				if(head==null)
				{
				head=bucket.get(index);
				toAdd.next=head;
				bucket.set(index, toAdd);
				size++;
			}
		}

		//可以直接忽视这部分，这部分是考虑到数组占满的情况，double size hash table，考试一般不考虑
		if((1.0*size)/numBuckets>0.7)
		{
			//do something
			ArrayList<HashNode<K, V>>tmp=bucket;
			bucket=new ArrayList<>();
			numBuckets=2*numBuckets;
			for(int i=0;i<numBuckets;i++)
			{
				bucket.add(null);
			}
			for(HashNode<K, V> headNode:tmp)
			{
				while(headNode!=null)
				{
					add(headNode.key, headNode.value);
					headNode=headNode.next;
				}
			}
			
			
		}
		
	}


	//测试部分
	public static void main(String[] args)
	{
		Map<String,Integer>map=new Map<>();
		map.add("this",1 );
		System.out.println(map.remove("this"));
		System.out.println(map.remove("this"));
		
	}

}
