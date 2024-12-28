package Ass_3;

public class SongQueue {
	private SongStack st1;
	private SongStack st2;
	public SongQueue() {
		st1 = new SongStack();
		st2 = new SongStack();
	}
	public void enqueue(Song s) {
		if(st1.isEmpty())
			st1.push(s);
		else {
			while(!st1.isEmpty())
				st2.push(st1.pop());
			st1.push(s);
			while(!st2.isEmpty())
				st1.push(st2.pop());
		}
	}
	public Song dequeue() {
		if(st1.isEmpty())
			return null;
		else {
			return st1.pop();
		}
	}
	public Song peek() {
		if(st1.isEmpty())
			return null;
		else {
			return st1.peek();
		}
	}
	public boolean isEmpty() {
		return st1.isEmpty();
	}
	
}
