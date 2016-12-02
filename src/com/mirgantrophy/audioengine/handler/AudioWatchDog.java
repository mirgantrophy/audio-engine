/* TODO
 * the watchdog needs access to all that the music has.. so array of strings for that
 * also needs to assign a unique index to each file path.. for example 02 opening theme can be referenced by its index "02" all the way to "51"
 * I would like to avoid using "01" at index 0 and refer to it like that.
 * The watchdog needs to know where we are on the map so it knows what song to play. Each area of the map should also have a corresponding
 * index potentially.. This may need to be monitored continuously.. or just update a variable when we load into a new area
 * perhaps it can be identified by a unique string and each string should point to a song and later on a map file.
 */
package com.mirgantrophy.audioengine.handler;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class AudioWatchDog
{
	private List<MediaPlayer> players;
	private MediaView viewer;
	private String[] pathList = {"/audio/01-opening-part-1-.mp3", "/audio/02-opening-part-2-.mp3", "/audio/03-pallet-town-s-theme.mp3", "/audio/04-professor-oak.mp3", "/audio/05-oak-research-lab.mp3"};
	public AudioWatchDog()
	{
		players = new ArrayList<>();
		for(int x = 0; x < pathList.length; x++)
		{
			System.out.println("Current Index: " + x);
			System.out.println("Current Song: " + pathList[x]);
			System.out.println("Creating Player with song " + pathList[x] + " and index " + x);
			players.add(createPlayer(x));
		}
	}
	
	private MediaPlayer createPlayer(int index)
	{
		System.out.println("Current source file: " + AudioWatchDog.class.getResource(pathList[index].toString()));
		String source = AudioWatchDog.class.getResource(pathList[index]).toString();
		final Media media = new Media(source);
		final MediaPlayer player = new MediaPlayer(media);
		return player;
	}
}

/* 
 * http://stackoverflow.com/questions/12482129/play-consecutive-videos-in-javafx
 * https://gist.github.com/jewelsea/1446612
 * Here is a sample program which plays an AudioPlaylist from the hard drive.

The program works by creating a list containing a new MediaPlayer and a new Media for each file to be played. There is a single MediaView in the program and, for each MediaPlayer, onEndOfMedia the MediaView's MediaPlayer is set to the next one in the list. It's pretty much the same solution as jju's recursive answer.

Note, to change the playing Media, you don't update the Media in the MediaPlayer (there is no way to do that as there is a 1:1 correspondence between Media and MediaPlayer), instead you update the MediaPlayer in the MediaView.

The concept for Videos is pretty much the same as Audio because both Audio and Video in JavaFX are represented as Media played by a MediaPlayer and managed through a MediaView.
 */

