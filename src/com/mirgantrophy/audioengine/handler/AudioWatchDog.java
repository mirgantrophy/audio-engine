/* TODO
 * Play through every media player and verify accuracy
 */
package com.mirgantrophy.audioengine.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class AudioWatchDog
{
	private List<MediaPlayer> players;
	private final MediaView viewer;
	private String[] pathList = new String[51];
	public AudioWatchDog() throws IOException
	{
		readFile();
		players = new ArrayList<>();
		for(int x = 0; x < pathList.length; x++)
		{
			players.add(createPlayer(x));
		}
		System.out.println("awd created");
		viewer = new MediaView();
	}
	
	private MediaPlayer createPlayer(int index)
	{
		String source = AudioWatchDog.class.getResource(pathList[index]).toString();
		final Media media = new Media(source);
		final MediaPlayer player = new MediaPlayer(media);
		return player;
	}
	
	private void readFile() throws IOException
	{
		InputStream is = AudioWatchDog.class.getResourceAsStream("/audio/fileList.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		int x = 0;
		while((line = br.readLine()) != null)
		{
			pathList[x] = line;
			x++;
		}
	}
	
	public void play()
	{
		viewer.setMediaPlayer(players.get(0));
		viewer.getMediaPlayer().play();
		viewer.getMediaPlayer().setOnEndOfMedia(new Runnable() 
		{
			public void run()
			{
				viewer.setMediaPlayer(players.get(1));
				viewer.getMediaPlayer().play();
			}
		});
	}
}