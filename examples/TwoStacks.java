package examples;

import java.util.Comparator;
import java.util.Stack;

public class TwoStacks<E extends Comparable<E>> {
	
	Stack<E> regularStack = new Stack<E>();
	Stack<E> minStack = new Stack<E>();
	
	public TwoStacks(){
	}
	
	public void addElement(E item)
	{
		regularStack.push(item);
		if(minStack.isEmpty() || minStack.peek().compareTo(item)>0)
		{
			minStack.push(item);
		}
	}
	
	public E removeLastElement()
	{
		E removedItem = regularStack.pop();
		if(!minStack.isEmpty() || minStack.peek().compareTo(removedItem)==0)
		{
			minStack.pop();
		}
		return removedItem;
	}
	
	public E getMin()
	{
		return minStack.peek();
	}
	
	public E getLastElement()
	{
		return regularStack.peek();
	}

	public static void main(String[] args)
	{
		TwoStacks<MyItem> customStack = new TwoStacks<MyItem>();
		customStack.addElement(new MyItem("Shahid",10));
		customStack.addElement(new MyItem("Shahid",20));
		customStack.addElement(new MyItem("Shahid",2));
		System.out.println(customStack.getMin().id);
		System.out.println(customStack.getLastElement().id);
		System.out.println(customStack.removeLastElement().id);
	}
}

class MyItem implements Comparable<MyItem>
{
	int id;
	String name;
	
	MyItem(String name, int id)
	{
		this.id=id;
		this.name=name;
	}
	
	@Override
	public int compareTo(MyItem o) {
		if(o == null) throw new NullPointerException("Second Object is null");
		if(this.id < o.id) return -1;
		else if(this.id > o.id) return 1;
		return 0;
	}
}