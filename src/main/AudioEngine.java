package main;

import java.util.Scanner;

import com.mirgantrophy.audioengine.handler.AudioWatchDog;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AudioEngine extends Application
{
	private static AudioWatchDog awd;
	public static void main(String[] args) 
	{	
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{	
		awd = new AudioWatchDog();
		System.out.println("awd created");
	}
}

//The following code is for debugging purpose only
/*
String filePath = "audio/02-opening-part-2-.mp3";
Media soundFile = new Media(new File(filePath).toURI().toString());
mediaPlayer = new MediaPlayer(soundFile);
mediaPlayer.play();

mediaPlayer.setOnEndOfMedia(new Runnable() 
	{
		public void run()
		{
			mediaPlayer.seek(Duration.ZERO);
		}
	});
	mediaPlayer.setAutoPlay(true); 
*/
