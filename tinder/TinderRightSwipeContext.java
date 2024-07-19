package tinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TinderRightSwipeContext {
    private final Map<TinderUser, List<TinderUser>> allTinderRightSwipe;
    private static TinderRightSwipeContext tinderRightSwipeContext;

    private TinderRightSwipeContext() {
        allTinderRightSwipe = new HashMap<>();
    }

    public static TinderRightSwipeContext getInstance() {
        if (tinderRightSwipeContext == null) {
            tinderRightSwipeContext = new TinderRightSwipeContext();
        }
        return tinderRightSwipeContext;
    }

    boolean swipe(TinderUser a, TinderUser b){
        allTinderRightSwipe.getOrDefault(a, new ArrayList<>()).add(b);
        if (checkIfMatched(a, b)){
            notifyUsers();
            return true;
        }

        return false;
    }

    private void notifyUsers() {
        System.out.println("Notifying a and b");
    }

    boolean checkIfMatched(TinderUser a, TinderUser b){
        if (allTinderRightSwipe.get(a).contains(b) && allTinderRightSwipe.get(b).contains(a)){
            return true;
        } else {
            return false;
        }
    }




}
