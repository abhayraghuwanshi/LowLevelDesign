package tinder;

import java.util.Queue;

public class BasicRecommendedSystem implements RecommendedSystem {

    private TinderUserContext tinderUserContext;

    public BasicRecommendedSystem(TinderUserContext tinderUserContext) {
        this.tinderUserContext = tinderUserContext;
    }

    @Override
    public Queue<TinderUser> recommend(TinderUser user) {
        return (Queue<TinderUser>) tinderUserContext.getAllTinderUsers();
    }
}
