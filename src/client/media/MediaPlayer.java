package client.media;

public abstract class MediaPlayer {
	
	public abstract boolean play();
	
	public abstract boolean pause();
	
	public abstract boolean stop();
	
	public abstract boolean close();
	
	public abstract boolean Accept(MediaVisitor mediaVisitor);
}
