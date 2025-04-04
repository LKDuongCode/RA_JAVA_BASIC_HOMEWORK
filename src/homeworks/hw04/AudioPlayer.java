package homeworks.hw04;

public class AudioPlayer implements MediaPlayer {
    private MediaAdapter adapter;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        } else if (audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("vlc")) {
            adapter = new MediaAdapter(audioType);
            adapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported.");
        }
    }
}
