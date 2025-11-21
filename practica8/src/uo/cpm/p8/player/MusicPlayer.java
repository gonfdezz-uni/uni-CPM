package uo.cpm.p8.player;

import java.io.File;
import java.util.*;

import javazoom.jlgui.basicplayer.*;

public class MusicPlayer {
	
	/*
	 * PL9-> que aparezca solo el nombre de la cancion, no de todo el documento.
	 */
	public static final double VOLUME_MAX = 100;
	public static final double VOLUME_MIN = 0;

	private BasicPlayer basicPlayer = null;
	private List<File> listLibrary = null;
	private List<File> listPlay = null;
	private File currentSong; // representa la cancion que está seleccionada en el ListPlay
	private int volume = 0; // representa el volumen actual

	public MusicPlayer() {
		basicPlayer = new BasicPlayer();
		listLibrary = new ArrayList<File>();
		listPlay = new ArrayList<File>();
		currentSong = null;
		volume = 50;
	}

	public List<File> getListLibrary() {
		return listLibrary;
	}

	public List<File> getListPlay() {
		return listPlay;
	}

	public File getCurrentSong() {
		return currentSong;
	}

	public void setCurrentSong(File f) {
		this.currentSong = f;
	}

	public int getVolume() {
		return volume;
	}

	public void addListLibrary(File[] selectedFiles) {
		listLibrary.addAll(Arrays.asList(selectedFiles));
	}

	public void addListPlay(List<File> selectedValuesList) {
		//Opcion 1
		listPlay.addAll(selectedValuesList);
		//Opcion 2
//		for(int i = 0;i<selectedValuesList.size();i++) {
//			if(!listPlay.contains(selectedValuesList.get(i))) {
//				listPlay.add(selectedValuesList.get(i));
//			}
//		}
		if(currentSong == null) {
			currentSong = listPlay.get(0);
		}
	}

	public void deleteListLibrary(List<File> selectedValuesList) {
		listLibrary.removeAll(selectedValuesList);
	}
	

	public void rewind() {

	}

	public void forward() {
		int  position = listPlay.indexOf(currentSong);
		if(position != listPlay.size() -1) {
			currentSong = listPlay.get(position+1);
		}else {
			currentSong = listPlay.get(0);
		}
		play();

	}

	public int searchFilePosition() {

		return -1;
	}

	public void deleteListPlay(File selectedValue) {
		listPlay.remove(selectedValue);
	}
	
	public void clearListPlay() {
		listPlay.removeAll(listPlay);
	}
	
	public void clearListLibrary() {
		listLibrary.removeAll(listLibrary);
	}

	/**********************************************
	 * REPRODUCTOR *
	 **********************************************/

	public void play() {
		try {
			basicPlayer.open(currentSong);
			basicPlayer.play();
			setVolume(volume);
		} catch (BasicPlayerException e) {
			System.out.println("Error en play");
		}
	}

	public void stop() {
		try {
			basicPlayer.stop();
		} catch (BasicPlayerException e) {
			System.out.println("Error en stop");
		}
	}

	public void setVolume(int vol) {
		try {
			this.volume = vol;
			if (basicPlayer.getStatus() == BasicPlayer.PLAYING)
				basicPlayer.setGain(vol / VOLUME_MAX);
		} catch (BasicPlayerException e) {
			System.out.println("Error en volumen");
		}
	}
}
