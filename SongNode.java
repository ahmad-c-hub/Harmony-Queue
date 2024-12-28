package Ass_3;

public class SongNode {
	private Song info;
	private SongNode next;
	public SongNode(Song s) {
		info = s;
		next = null;
	}
	public Song getInfo() {
		return info;
	}
	public void setInfo(Song info) {
		this.info = info;
	}
	public SongNode getNext() {
		return next;
	}
	public void setNext(SongNode next) {
		this.next = next;
	}
	
}
