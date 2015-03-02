package list;

import java.util.ArrayList;

class Node{
	int data;
	Node next;
	public Node(int d){
		this.data = d;
		next = null;
	}
	
	public void setNext(Node n){
		this.next = n;
	}
	
	public String toString(){
		return ""+data;
	}
}

class LinkedList{
	Node head;
	
	LinkedList(){
		head = null;
	}
	
	public void append(Node a){
		if(a == null)
			return;
		if(head == null){
			head = a;
			head.next = null;
		}else{
			Node headCopy = head;
			while(headCopy.next!=null){
				headCopy = headCopy.next;
			}
			
			
		}
	}
}

public class FindLoopEntrance {
	
	public static Node findLoopEntranceNode(Node a){
		if(a == null || a.next == null){
			return null;
		}
		
		Node curr = a.next;
		int index = 1;
		while(curr != null){
			Node headCopy = a;
			int innerIndex = index;
			while(innerIndex > 0){
				if(headCopy == curr){
					return headCopy;
				}
				innerIndex--;
				headCopy = headCopy.next;
			}
			index++;
			curr = curr.next;
		}
		return null;
	}
	
	public static void main(String[] args){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n3);
		
		Node f1 = findLoopEntranceNode(n1);
		System.out.println(f1);
	}
}
