/* TODO
 * the watchdog needs access to all that the music has.. so array of strings for that
 * also needs to assign a unique index to each file path.. for example 02 opening theme can be referenced by its index "02" all the way to "51"
 * I would like to avoid using "01" at index 0 and refer to it like that.
 * The watchdog needs to know where we are on the map so it knows what song to play. Each area of the map should also have a corresponding
 * index potentially.. This may need to be monitored continuously.. or just update a variable when we load into a new area
 * perhaps it can be identified by a unique string and each string should point to a song and later on a map file.
 */
package com.mirgantrophy.audioengine.handler;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioWatchDog
{
	
	//why not create a list for each mediaplayer
	private MediaPlayer mediaPlayer; //plays our song
	private Media audio; //contains the song we want to play
	private String currentPath; //simply a pointer to the song we are currently referencing
	private String[] pathList = {"/audio/01-opening-part-1-.mp3", "/audio/02-opening-part-2-.mp3", "/audio/03-pallet-town-s-theme.mp3", "/audio/04-professor-oak", "/audio/05-oak-research-lab.mp3"};
	public AudioWatchDog(int index) //we make a new AWD which will play a song
	{
		System.out.println("setting path");
		currentPath = AudioWatchDog.class.getResource(pathList[index]).toString();
		System.out.println("creating media object");
		audio = new Media(currentPath);
		System.out.println("creating media Player object");
		mediaPlayer = new MediaPlayer(audio);
		System.out.println("Creating new audio watchdog");
	}
	
	public void setCurrentpath(int index)
	{
		currentPath = AudioWatchDog.class.getResource(pathList[index]).toString();
	}
	
	public String getCurrentpath()
	{
		return currentPath;
	}
	
	public void changeMedia()
	{
		audio = null;
		audio = new Media(currentPath);
	}
	
	public Media getMedia()
	{
		return audio;
	}
	
	public void play()
	{
		mediaPlayer = null;
		mediaPlayer = new MediaPlayer(audio);
		mediaPlayer.play();
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

