package tinder;

import java.util.Queue;

public interface RecommendedSystem {

    Queue<TinderUser> recommend(TinderUser user);
}
