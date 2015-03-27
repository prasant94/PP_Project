package client.media;

public abstract class MediaVisitor {
	
	abstract boolean visitAudioMedia(AudioPlayer audioPlayer);
	
	
	abstract boolean visitVideoMedia(VideoPlayer audioPlayer);
	
	
}
