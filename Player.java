package Ass_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	private ArrayList<Song> LikedSongs;
	private SongQueue queue;
	private int size;

	public Player() {
		LikedSongs = new ArrayList<>();
		queue = new SongQueue();
		size = 0;
	}

	public void addSong(Song s) {
		boolean found = false;
		for (int i = 0; i < LikedSongs.size(); i++) {
			if (LikedSongs.get(i).getArtist().equals(s.getArtist())
					&& LikedSongs.get(i).getName().equals(s.getName())) {
				found = true;
				break;
			}
		}
		if (found == false) {
			LikedSongs.add(s);
			System.out.println("Song successfully liked.");
		} else {
			System.out.println("Song already liked.");
		}
	}
	public void playSong() {
		if(queue.isEmpty()) 
			System.out.println("Queue is empty.");
		else {
			Song s = queue.dequeue();
			s.incrementNbOfPlays();
			size = size - s.getDuration();
			System.out.println(s);
		}
			
	}
	
	public void queueSong() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter name of the song:");
		String name = scan.nextLine();
		System.out.print("Enter name of the artist:");
		String artist = scan.nextLine();
		boolean found = false;
		Song s = null;
		for (int i = 0; i < LikedSongs.size(); i++) {
			if (LikedSongs.get(i).getArtist().equals(artist)
					&& LikedSongs.get(i).getName().equals(name)) {
				found = true;
				s = LikedSongs.get(i);
				break;
			}
		}
		if(found==true) {
			if(size+s.getDuration()>2000)
				System.out.println("Cannot add song to the queue.");
			else {
				size = size + s.getDuration();
				queue.enqueue(s);
				System.out.println("Song has been added to the queue.");
			}
		}else {
			System.out.println("No such song in your list of liked songs.");
		}
	}
	public void resetQueue() {
		while(!queue.isEmpty())
			queue.dequeue();
		size = 0;
	}
	public void displayQueue() {
		SongQueue q = new SongQueue();
		while(!queue.isEmpty()) {
			Song s = queue.dequeue();
			q.enqueue(s);
			System.out.println(s);
		}
		while(!q.isEmpty()) {
			Song s = q.dequeue();
			queue.enqueue(s);
		}
		
			
	}

	public static void main(String args[]) {
		boolean found = false;
		Player p = new Player();
		Scanner scanChoice = new Scanner(System.in);
		while (found==false) {
			System.out.println("1. Add a Liked Song");
			System.out.println("2. Play Song");
			System.out.println("3. Queue Song");
			System.out.println("4. Reset Song Queue");
			System.out.println("5. Display Queued Songs");
			System.out.println("6. Exit");
			System.out.println("------------------------------------------");
			System.out.print("Enter your choice: ");
			int choice = scanChoice.nextInt();
			switch (choice) {
			case 1:
				Scanner scan = new Scanner(System.in);
				System.out.print("Enter name of the song:");
				String name = scan.nextLine();
				System.out.print("Enter name of the artist:");
				String artist = scan.nextLine();
				System.out.print("Enter the duration in seconds of the song:");
				int duration = scan.nextInt();
				p.addSong(new Song(name, artist, duration));
				break;
			case 2:
				p.playSong();
				
				break;
			case 3:
				p.queueSong();
				break;
			case 4:
				p.resetQueue();
				System.out.println("Queue successfully reseted.");
				break;
			case 5:
				p.displayQueue();
				break;
			case 6:
				p.resetQueue();
				found = true;
				System.out.println("Exiting the program...");
				break;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 6.");
				break;
			}

		}
	}
	
}