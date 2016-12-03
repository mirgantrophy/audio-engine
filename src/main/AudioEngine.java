package main;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.mirgantrophy.audioengine.handler.AudioWatchDog;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import window.GUI;

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
		 try 
		 { 
			 UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
		 } 
		 catch(Exception e)
		 { 
		    	e.printStackTrace();
		 }
		JFrame mainFrame = new JFrame("Pokemon AWD Test - mirGantrophy");
		GUI w = new GUI();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().add(w, null);
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
		
		awd.play();
		
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
