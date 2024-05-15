package com.example.strategy;


import java.util.List;

public class App {

    public static void main(String[] args) {

        // Local Inner Class
        class FIFOStrategy implements NextTrackStrategy {
            @Override
            public Track getNextTrack(List<Track> tracks) {
                return tracks.remove(0);
            }
        }
        NextTrackStrategy fifoStrategy = new FIFOStrategy();

        // Anonymous Inner Class
        NextTrackStrategy lifoStrategy = new NextTrackStrategy() {
            @Override
            public Track getNextTrack(List<Track> tracks) {
                return tracks.remove(tracks.size() - 1);
            }
        };

        //  Lambda Expression aka function ( later in depth )
        NextTrackStrategy randomStrategy = (tracks) -> {
            int index = (int) (Math.random() * tracks.size());
            return tracks.remove(index);
        };


        Playlist playlist = new Playlist(fifoStrategy);
        playlist.addTrack(new Track("Track 1", 10));
        playlist.addTrack(new Track("Track 2", 20));
        playlist.addTrack(new Track("Track 3", 30));

//        playlist.setStrategy(lifoStrategy);
        playlist.setStrategy(randomStrategy);

        Track track = playlist.playNext();
        System.out.println("Playing track: " + track.getName());

        track = playlist.playNext();
        System.out.println("Playing track: " + track.getName());

        track = playlist.playNext();
        System.out.println("Playing track: " + track.getName());

    }

}
