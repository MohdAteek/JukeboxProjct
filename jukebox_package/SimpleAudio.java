package jukebox_package;
//Java program to play an Audio
//file using Clip Object
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.mysql.cj.protocol.Resultset;


public class SimpleAudio {
    Scanner sc = new Scanner(System.in);
    // to store current position
    Long currentFrame;
    Clip clip;

    // current status of clip
    String status;

    AudioInputStream audioInputStream;
    // constructor to initialize streams and clip
    public SimpleAudio(String filePath) throws UnsupportedAudioFileException,
            IOException, LineUnavailableException, SQLException, ClassNotFoundException {
        // create AudioInputStream object
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    // Method to play the audio
    public void play()
    {
        //start the clip
        clip.start();

        status = "play";
    }

    // Method to pause the audio
    public void pause()
    {
        if (status.equals("paused"))
        {
            System.out.println("audio paused");
            return;
        }
        this.currentFrame =
                this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    // Method to resume the audio
    public void resumeAudio(String filePath) throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
    	 if (status.equals("play")) 
         {
             System.out.println("Audio is already "+
             "being played");
             return;
         }
         clip.close();
         resetAudioStream(filePath);
         clip.setMicrosecondPosition(currentFrame);
         this.play();
    }

    // Method to restart the audio
    public void restart(String filePath) throws IOException, LineUnavailableException,
            UnsupportedAudioFileException
    {
        clip.stop();
        clip.close();
        resetAudioStream(filePath);
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        this.play();
    }

    // Method to stop the audio
    public void stop() {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    // Method to jump over a specific part
    public void jump(long c,String filePath) throws UnsupportedAudioFileException, IOException,
            LineUnavailableException
    {
        if (c > 0 && c < clip.getMicrosecondLength())
        {
            clip.stop();
            clip.close();
            resetAudioStream(filePath);
            currentFrame = c;
            clip.setMicrosecondPosition(c);
            this.play();
        }
    }

    // Method to reset audio stream
    public void resetAudioStream(String filePath) throws UnsupportedAudioFileException, IOException,
            LineUnavailableException
    {
        audioInputStream = AudioSystem.getAudioInputStream(
                new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    // Work as the user enters his choice

    public void userChoice(int c,String filePath)
            throws IOException, LineUnavailableException, UnsupportedAudioFileException, ClassNotFoundException, SQLException
    {
        switch (c) {
            case 1 -> pause();
            case 2 -> resumeAudio(filePath);
            case 3 -> restart(filePath);
            case 4 -> stop();
            case 5 -> clip.setMicrosecondPosition(clip.getMicrosecondPosition()+10000000);
            case 6->clip.setMicrosecondPosition(clip.getMicrosecondPosition()-10000000);
            case 7->
            {
            	Driver d=new Driver();
            	d.mainMethod();
            }
        }
    }

    public void playerOptionsDisplay()
    {
    	System.out.println("\n| ------------------------Audio Player----------------------- |");
       System.out.println ("  | ----------------------------------------------------------- |");
    	System.out.println("""
                \t\t\t1️ to pause 
                \t\t\t2️ Resume   
                \t\t\t3️ Restart 
                \t\t\t4️ Stop     
                \t\t\t5️ Forward  -->>10 SEC -->>
                \t\t\t6? Backword <<--10 SEC <<--
                \t\t\t7? For Main Menu""");
    }

    int choose() {
        System.out.println("Select: ");
        return sc.nextInt();
    }
}