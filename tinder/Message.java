package tinder;

import java.time.Instant;

public class Message {
    private final TinderUser from;
    private final TinderUser to;
    private final String message;
    private final Instant currentTime;


    public Message(TinderUser from, TinderUser to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;
        this.currentTime = Instant.now();
    }

}
