package examples;

import java.util.Stack;


public class ConstantTimeCustomStack<E extends Comparable<E>>{

	/**
	 * @param args
	 */
	Stack<E> regularStack = new Stack<E>();
	Stack<E> minStack = new Stack<E>();
	public ConstantTimeCustomStack(){
	}
	
	public void AddElement(E item) throws Exception
	{
		regularStack.push(item);
		if(minStack.isEmpty() || minStack.peek().compareTo(item) > 0){
			minStack.push(item);
		}
	}
	
	public E GetMin(){
		return minStack.peek();
	}
	
	public E RemoveLastElement(){
		E removedElement = regularStack.pop();
		if(!minStack.isEmpty() && removedElement.compareTo(GetMin())==0)
		{
			minStack.pop();
		}
		return removedElement;
	}

	public E GetLastElement()throws Exception{
		return regularStack.peek();
	}	
	
	public static void main(String[] args) throws Exception {
		ConstantTimeCustomStack<MyItem> minStack = new ConstantTimeCustomStack<MyItem>();
		minStack.AddElement(new MyItem("Shahid",20));
		minStack.AddElement(new MyItem("Khalid",10));
		minStack.AddElement(new MyItem("Aslam",34));
		minStack.AddElement(new MyItem("raheel",2));
		minStack.AddElement(new MyItem("Bashir",44));
		minStack.AddElement(new MyItem("Insan",1));
		minStack.AddElement(new MyItem("rashid",100));
		System.out.println("Expected 1, Actual "+ minStack.GetMin().id);
		System.out.println(minStack.RemoveLastElement().id);
		System.out.println(minStack.RemoveLastElement().id);
		System.out.println("Expected 2, Actual "+ minStack.GetMin().id);
		System.out.println(minStack.GetLastElement().id);
		System.out.println(minStack.GetLastElement().id);
		System.out.println(minStack.RemoveLastElement().id);
		System.out.println(minStack.RemoveLastElement().id);
		System.out.println("Expected 10, Actual "+ minStack.GetMin().id);
	}

}

class Item implements Comparable<MyItem> {

	String name;
	int id;
	public Item(String name, int id){
		this.name = name;
		this.id = id;
	}
	@Override
	public int compareTo(MyItem o) {
		if(o == null) throw new NullPointerException("Second Object is null");
		if(this.id < o.id) return -1;
		else if(this.id > o.id) return 1;
		return 0;
	}

}