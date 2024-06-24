package com.example.strategy;

import java.util.List;

public interface NextTrackStrategy {
    public Track getNextTrack(List<Track> tracks);
}
