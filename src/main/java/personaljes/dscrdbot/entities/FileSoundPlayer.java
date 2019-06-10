package personaljes.dscrdbot.entities;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;

public class FileSoundPlayer {

    private AudioPlayerManager playerManager;
    private AudioPlayer audioPlayer;

    public FileSoundPlayer(){
        this.init();
    }

    public void init() {
        playerManager = new DefaultAudioPlayerManager();
        AudioSourceManagers.registerRemoteSources(playerManager);
        audioPlayer = playerManager.createPlayer();
    }

    public AudioPlayerManager getPlayerManager() {
        return playerManager;
    }

    public AudioPlayer getAudioPlayer() {
        return audioPlayer;
    }
}
