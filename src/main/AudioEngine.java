package main;

import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AudioEngine extends Application
{
	private static MediaPlayer mediaPlayer; //this will get garbage collected if instantiated in the start method...
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{	
		String path = AudioEngine.class.getResource("/audio/02-opening-part-2-.mp3").toString(); //use getResource for referencing items INSIDE
		// a jar file.. NOTE: cannot run through the IDE this way! Needs to be compiled.
		Media audio = new Media(path);
		mediaPlayer = new MediaPlayer(audio);
		mediaPlayer.setOnEndOfMedia(new Runnable() 
		{
			public void run()
			{
				mediaPlayer.seek(Duration.ZERO);
			}
		});
		mediaPlayer.setAutoPlay(true); 
		//The following code is for debugging purpose only
		/*
		String filePath = "audio/02-opening-part-2-.mp3";
		Media soundFile = new Media(new File(filePath).toURI().toString());
		mediaPlayer = new MediaPlayer(soundFile);
		mediaPlayer.play();
		*/
	}

}
