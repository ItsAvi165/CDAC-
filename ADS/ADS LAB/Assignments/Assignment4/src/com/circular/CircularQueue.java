package com.circular;

public class CircularQueue {
	private int[] queue;
	private int front;
	private int rear;

	public CircularQueue(int size) {
		queue = new int[size];
		front = -1;
		rear = -1;
	}

	public boolean isEmpty() {
		return front == -1;
	}

	public boolean isFull() {
//        if((rear + 1) % queue.length == front) return true;
		if ((front == 0 && rear == queue.length - 1) || (front == rear + 1))
			return true;
		// else if(front == rear+1) return true;
		else
			return false;
	}

	public void enqueue(int data) {
		if (isFull()) {
			System.out.println("Queue is full");
			// return;
		} else {
			if (front == -1)
				front = 0;
			rear = (rear + 1) % queue.length;
			queue[rear] = data;
			System.out.println("Data added!");
		}
	}

	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		} else {
			int data = queue[front];
			if (front == rear) {
				front = rear = -1;
			} else {
				front = (front + 1) % queue.length;
			}
			return data;
		}
	}

	public void show() {
		System.out.println("Elements of queue are:");
		int i;
		for (i = front; i < rear; i = (i + 1) % queue.length) {
			System.out.println(queue[i] + " ");
		}
		//System.out.println(queue[i] + " ");
	}

	public int size() {
		return (rear - front) % queue.length;
	}
}
