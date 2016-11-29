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
	private String currentPath;
	private String[] pathList = {"01-opening-part-1.mp3", "02-opening-part-2-.mp3", "03-pallet-town-s-theme.mp3"};
	public AudioWatchDog()
	{
		System.out.println("Creating new audio watchdog");
	}
	
	public void setCurrentpath(int index)
	{
		currentPath = pathList[index];
	}
	
	public String getCurrentpath()
	{
		return currentPath;
	}
}
