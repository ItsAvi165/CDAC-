package com.core;



public class LinkList {
	public static class Node{
		private int data;
		private Node next;
		public Node() {
			
			data = 0;
			next = null;
		}
		public Node(int data) {
			
			data = data;
			next = null;
		}
			
	}
	
	private Node head;

	public LinkList() {
		
		head = null;
	}
	
	private boolean isEmpty() {
		return head==null;
				
	}
	public void display() {
		if(isEmpty()) {
			throw new RuntimeException("list is empty..");
		}
		else {
			Node trav=head;
			while(trav!=null) {
				System.out.print(trav.data+" -> ");
				trav=trav.next;
			}
		}
		
	}
	public void addAtFirst(int data) {
		Node newNode=new Node(data);
        	newNode.next=head;
			head=newNode;
			
		
	}
	
	public void addAtLast(int data) {
		Node newNode=new Node(data);
		if(isEmpty()) {
			head=newNode;
		}
		else {
			Node trav=head;
			while(trav.next!=null) {
				trav=trav.next;
				newNode.next=trav.next;
				trav.next=newNode;
			}
		}
		
	}
	public void addAtPos(int data,int pos) {
		Node newNode=new Node(data);
		
		if(head==null||pos<=1)
		{
			addAtFirst(data);
		}
		else {
		 Node trav=head;
		 for(int i=0;i<pos-1;i++) {
			 trav=trav.next;
			 newNode.next=trav.next;
			 trav.next=newNode;
			 
		 }
		}
	}
	public void addSorted(int data) {
		Node newNode=new Node(data);
		if(head==null||head.data>data) {
			newNode.next=head;
			head=newNode;
			}
		else {
			Node trav=head;
			while(trav.next!=null&&trav.next.data<data) {
				trav=trav.next;
				
			}
			newNode.next=trav.next;
			trav.next=newNode;
			
		}
		
	}
	
	public void delAtFirst() {
		if(isEmpty())
			throw new RuntimeException("List is empty");
		else {
			head=head.next;
			
		}
	}
	public void delAtLast() {
		if(isEmpty())
			throw new RuntimeException("List is empty");
		if(head.next==null) {
			head=null;
		}
		else {
			Node trav=head;
			Node temp=null;
			while(trav.next!=null) {
				temp=trav;
				trav=trav.next;
				}
			temp.next=null;
		}
	}
	public void delAtPos(int pos) {
		if(head==null||pos<1)
			throw new RuntimeException("list is empty or invalid position");
		if(pos==1) {
			delAtFirst();
		}
		else {
			Node trav=head;
			Node temp=null;
			for(int i=0;i<pos;i++) {
				if(trav==null)
					throw new RuntimeException("invalid posiiton");
				temp=trav;
				trav=trav.next;
				
			}
			temp.next=trav.next;
		}
	}
public void delAll() {
	head=null;
}
public void reverse() {
	//consider current list as old and new list as empty
	Node oldHead=head;
	head=null;
	while(oldHead!=null) {
	//delete first(temp)from old list
	Node temp=oldHead;
	oldHead=oldHead.next;
	//add first to new list
	temp.next=head;
	head=temp;}
	
}
public void removeOccurence(int data) {
	if(head!=null&&head.data==data) {
		head=head.next;
	}
	else {
		Node trav=head;
		while(trav!= null&&trav.next!=null ) {
			if(trav.next.data==data) {
				trav.next=trav.next.next;
			}
			else {
				trav=trav.next;
			}
		}
		
	}}
public void search(int data) {
	int i=1;
	boolean flag=false;
	if(isEmpty())
		throw new RuntimeException("list is empty");
	
	else {
		Node trav=head;
		
		while(trav!=null) {
			if(trav.data==data) {
				flag=true;
				break;
			}
			i++;
			trav=trav.next;	
		}
	}
	if(flag) {
		System.out.println("element is present in the list at the position"+i);}
	else {
		System.out.println("element is not found");
	}
}
@Override
public String toString() {
	
	String result="";
	Node trav=head;
	while(trav!=null) {
		result+=trav.data+",";
		trav=trav.next;
		
	}
return result;
}

public boolean isSorted() {
	int x=-1;
	Node trav=head;
	while(trav!=null) {
		if(trav.data<x)
			return false;
		x=trav.data;
		trav=trav.next;
	}
	return true;
}

}
