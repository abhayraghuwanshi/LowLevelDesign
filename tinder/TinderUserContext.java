package tinder;

import java.util.ArrayList;
import java.util.List;

public class TinderUserContext {

    private final List<TinderUser> allTinderUsers;
    private static TinderUserContext tinderContext;


    private TinderContext() {
        allTinderUsers = new ArrayList<>();
    }

    public static TinderUserContext getInstance() {
        if (tinderContext == null) {
            tinderContext = new TinderUserContext();
        }
        return tinderContext;
    }

    public void addUser(TinderUser user) {
        allTinderUsers.add(user);
    }

    public List<TinderUser> getAllTinderUsers(){
        return  allTinderUsers;
    }
}
