package main;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import java.io.File;
import java.rmi.server.ExportException;

class MidPlayer implements Runnable {

    Thread runner;

    String name = "res/mid/back.mid";

    Sequencer sound;

    Sequence soundname;

    File file;

    Boolean playing = false;

    public void toggle()  {
        if (!playing){
            play();
        }else{
            stop();
        }
        try{
            if (!sound.isRunning()){
                play();
            }
        }catch(Exception e){

        }
        playing = !playing;
    }

    void play() {

        if (runner == null) {

            runner = new Thread(this);

            runner.start();

        }

    }

    void stop() {

        if (runner != null)

            sound.close();

        runner = null;

    }

    public void run() {

        try {

            sound = MidiSystem.getSequencer();

            file = new File(name);

            soundname = MidiSystem.getSequence(file);

            sound.open();

            sound.setSequence(soundname);

            sound.start();

            while (sound.isRunning()) {

                try {

                    Thread.sleep(1000);

                } catch (Exception e) {

                    System.out.println("some problems happended in this program");

                }

            }

            sound.close();

        } catch (Exception e) {

            System.out.println("can't play the music" + e.getMessage());

        }

    }

}
