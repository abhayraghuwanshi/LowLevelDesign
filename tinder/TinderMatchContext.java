package tinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TinderMatchContext {
    private final Map<TinderUser, List<TinderUser>> allTinderMatches;
    private static TinderMatchContext tinderMatchContext;

    private TinderMatchContext() {
        allTinderMatches = new HashMap<>();
    }

    public static TinderMatchContext getInstance() {
        if (tinderMatchContext == null) {
            tinderMatchContext = new TinderMatchContext();
        }
        return tinderMatchContext;
    }

    void addMatch(TinderUser a, TinderUser b){
        allTinderMatches.getOrDefault(a, new ArrayList<>()).add(b);
        allTinderMatches.getOrDefault(b, new ArrayList<>()).add(a);
    }

    void removeMatch(TinderUser a, TinderUser b){
        allTinderMatches.get(a).remove(b);
        allTinderMatches.get(b).remove(a);
    }

}
