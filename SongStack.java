package Ass_3;

public class SongStack {
	private SongNode top;

	public SongStack() {
		top = null;
	}

	public void push(Song s) {
		SongNode x = new SongNode(s);
		if (top == null)
			top = x;
		else {
			x.setNext(top);
			top = x;
		}
	}

	public Song pop() {
		SongNode current = top;
		if (top == null)
			return null;
		else {
			Song s = current.getInfo();
			current = null;
			top = top.getNext();
			return s;
		}
	}

	public Song peek() {
		if (top == null)
			return null;
		else {
			return top.getInfo();
		}
	}
	public boolean isEmpty() {
		return top==null;
	}
	
}
