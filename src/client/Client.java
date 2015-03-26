package client;

import java.util.ArrayList;

public class Client {
	
	ServerConnection serverConenction;
	
	protected Client(){
		
	}
	
	protected String browseMedia(){
		return null;
		
	}
	
	protected boolean streamMedia(String filename){
		return false;
		
	}
	
	
	protected boolean downloadMedia(String filename){
		return false;
		
	}
	
	protected boolean uploadMedia(String filename){
		return false;
	}
	
	protected ArrayList<String> searchMedia(String filename){
		return null;
		
	}
	
	
	
}
