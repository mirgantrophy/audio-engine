/* TODO
 * Play through every media player and verify accuracy
 */
package com.mirgantrophy.audioengine.handler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class AudioWatchDog
{
	private List<MediaPlayer> players;
	private MediaView viewer;
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
}