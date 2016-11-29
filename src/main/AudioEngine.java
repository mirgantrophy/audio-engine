package main;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AudioEngine extends Application
{
	private ArrayList musicFiles;
	private static MediaPlayer mediaPlayer; //this will get garbage collected if instantiated in the start method...
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{	
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter identifier: ");
		String response = scan.nextLine();
		switch(response)
		{
		case "01":
			//perhaps store the file paths in an array list?
			//String path = AudioEngine.class.getResource("/audio/02-opening-part-2-.mp3").toString();
			break;
		case "02":
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
			break;
		case "03":
			break;
		case "04":
			break;
		case "05":
			break;
		case "06":
			break;
		case "07":
			break;
		case "08":
			break;
		case "09":
			break;
		case "10":
			break;
		case "11":
			break;
		case "12":
			break;
		case "13":
			break;
		case "14":
			break;
		case "15":
			break;
		case "16":
			break;
		case "17":
			break;
		case "18":
			break;
		case "19":
			break;
		case "20":
			break;
		case "21":
			break;
		case "22":
			break;
		case "23":
			break;
		case "24":
			break;
		case "25":
			break;
		case "26":
			break;
		case "27":
			break;
		case "28":
			break;
		case "29":
			break;
		case "30":
			break;
		case "31":
			break;
		case "32":
			break;
		case "33":
			break;
		case "34":
			break;
		case "35":
			break;
		case "36":
			break;
		case "37":
			break;
		case "38":
			break;
		case "39":
			break;
		case "40":
			break;
		case "41":
			break;
		case "42":
			break;
		case "43":
			break;
		case "44":
			break;
		case "45":
			break;
		case "46":
			break;
		case "47":
			break;
		case "48":
			break;
		case "49":
			break;
		case "50":
			break;
		case "51":
			break;
		default:
			System.out.println("invalid identifier");
		}
		System.out.println("Program Closing...");
		scan.close();
		System.exit(0);
	}
}

//The following code is for debugging purpose only
/*
String filePath = "audio/02-opening-part-2-.mp3";
Media soundFile = new Media(new File(filePath).toURI().toString());
mediaPlayer = new MediaPlayer(soundFile);
mediaPlayer.play();
*/
