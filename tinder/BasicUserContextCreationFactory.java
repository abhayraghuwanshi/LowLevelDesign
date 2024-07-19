package tinder;

import java.util.Queue;

public class BasicUserContextCreationFactory implements UserContext {

    private final TinderUser tinderUser;
    private final RecommendedSystem recommendedSystem;
    private final TinderUserContext tinderUserContext;
    private final TinderRightSwipeContext tinderRightSwipeContext;
    private final TinderMatchContext tinderMatchContext;
    private  final TinderChatContext tinderChatContext;

    Queue<TinderUser> recommendUsers;


    public BasicUserContextCreationFactory(TinderUser a, RecommendedSystem recommendedSystem,
                                           TinderUserContext tinderUserContext1,
                                           TinderRightSwipeContext tinderRightSwipeContext1, TinderMatchContext tinderMatchContext1, TinderChatContext tinderChatContext) {
        this.tinderUser = a;
        this.recommendedSystem = recommendedSystem;
        this.tinderUserContext = tinderUserContext1;
        this.tinderRightSwipeContext = tinderRightSwipeContext1;
        this.tinderMatchContext = tinderMatchContext1;
        this.tinderChatContext = tinderChatContext;
        buildProfile();
    }

    void buildProfile(){
        recommendUsers = recommendedSystem.recommend(this.tinderUser);
    }


    @Override
    public void notifyUsers(String msg) {

    }

    @Override
    public void swipeRight() {
        TinderUser b = recommendUsers.poll();
        boolean isItAMatch = this.tinderRightSwipeContext.swipe(this.tinderUser, b);
        if (isItAMatch){
            this.tinderMatchContext.addMatch(this.tinderUser, b);
            notifyUser(this.tinderUser, b, "Matched " + this.tinderUser.getUser() + " and " + b.getUser());
        }

    }


    @Override
    public void swipeLeft() {

    }

    @Override
    public void notifyUser(TinderUser a, TinderUser b, String msg) {
        
    }
}
