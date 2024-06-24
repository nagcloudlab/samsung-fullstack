package com.example.strategy;

import java.util.ArrayList;
import java.util.List;

public
class Playlist {

    private List<Track> tracks = new ArrayList<>();
    private NextTrackStrategy strategy;

    public Playlist(NextTrackStrategy strategy) {
        this.strategy = strategy;
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public void setStrategy(NextTrackStrategy strategy) {
        this.strategy = strategy;
    }

    public Track playNext() {
        return strategy.getNextTrack(tracks);
    }
}
