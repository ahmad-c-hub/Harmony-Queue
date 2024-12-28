package Ass_3;

public class Song {
	private String name;
	private String artist;
	private int nbOfPlays;
	private int duration;
	public Song(String n, String a, int d) {
		name = n;
		artist = a;
		duration = d;
		nbOfPlays = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getNbOfPlays() {
		return nbOfPlays;
	}
	public void incrementNbOfPlays() {
		nbOfPlays++;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String toString() {
		return "Song [name=" + name + ", artist=" + artist + ", nbOfPlays=" + nbOfPlays + ", duration=" + duration
				+ "s]";
	}
	
	
}
