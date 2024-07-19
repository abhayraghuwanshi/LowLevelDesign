package tinder;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TinderChatContext {
    private final Map<TinderUser, HashMap<TinderUser, List<Message>>> allTinderChats;
    private static TinderChatContext tinderChatContext;

    private final Map<TinderUser, HashMap<TinderUser, ChatState>> allTinderChatsState;

    private TinderChatContext() {
        allTinderChats = new HashMap<>();
    }

    public static TinderChatContext getInstance() {
        if (tinderChatContext == null) {
            tinderChatContext = new TinderChatContext();
        }
        return tinderChatContext;
    }

    void addMessage(TinderUser a, TinderUser b, Message msg){
        allTinderChats.get(a).get(b).add(msg);
    }

    void setAllTinderChatsState(TinderUser tinderUser, TinderUser tinderUser1, ChatState chatState){
        allTinderChatsState.get(tinderUser).put(tinderUser1, chatState) ;
    }

}
