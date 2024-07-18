import java.util.*;

interface UserContext {
    void addSwipeRightByOther(UserContext t);
    void addSwipeRightByMe(UserContext t);
    void addChatContext(ChatContext chatContext);
    void notifiesUsers(UserContext p);
    ChatContext getChatContext(User userB);
}

interface BasicCommand {
    void swipeRight();
    void swipeLeft();
}

interface PremiumCommand {
    void superSwipe();
}

public class UserContextImpl implements UserContext, BasicCommand {

    private final User user;
    private Queue<UserContext> profileContext;
    private List<UserContext> allSwipeRightByMe;
    private List<UserContext> allSwipeRightByOthers;
    private List<ChatContext> myChatContext;

    public UserContextImpl(User user, Queue<TinderUserContext> profileContext) {
        this.user = user;
        this.profileContext = profileContext;
        this.allSwipeRightByMe = new ArrayList<>();
        this.allSwipeRightByOthers = new ArrayList<>();
        this.myChatContext = new ArrayList<>();
    }

    @Override
    public void swipeRight() {
        UserContext p = profileContext.poll(); // Use poll() to get and remove the head of the queue

        if (p != null) {
            if (allSwipeRightByOther.contains(p)) {
                notifiesUsers(p);
                System.out.println("Matched");
                ChatContext newChatContext = new ChatContext(user, ((BasicTinderContextForUserImpl) p).getUser());
                p.addChatContext(newChatContext);
                this.addChatContext(newChatContext);
            }
            addSwipeRightByMe(p);
            p.allSwipeRightByOthers(this);
        }
    }

    @Override
    public void swipeLeft() {
        profileContext.poll(); // Assuming you want to remove the profile from the queue
        // Implement what happens when swipe left
    }

    @Override
    public void addSwipeRightByOther(UserContext t) {
        allSwipeRightByOthers.add(t);
    }

    @Override
    public void addSwipeRightByMe(UserContext t) {
        allSwipeRightByMe.add(t);
    }

    @Override
    public void notifiesUsers(TinderUserContext p) {
        System.out.println("Matched with " + ((BasicTinderContextForUserImpl) p).getUser().getName());
    }

    @Override
    public void addChatContext(ChatContext context) {
        this.myChatContext.add(context);
    }

    @Override
    public ChatContext getChatContext(User userB) {
        for (ChatContext context : this.myChatContext) {
            if (context.getUserB().equals(userB)) {
                return context;
            }
        }
        return null;
    }

    public User getUser() {
        return user;
    }
}

class TinderContext {

    private Map<User, UserContext> availableUserContext;
    private static TinderContext tinderContext;

    private TinderContext() {
        allUsersOfTinder = new HashMap<>();
    }

    public static TinderContext getInstance() {
        if (tinderContext == null) {
            tinderContext = new TinderContext();
        }
        return tinderContext;
    }

    public void addUser(User user) {
        allUsersOfTinder.put(user, createUserContext(user));
    }

    private UserContext createUserContext(User user) {
        // Some logic to get the profile filter for this user and build the recommendation system for this user
        Queue<TinderUserContext> profileQueue = new LinkedList<>(); // Assuming a queue of profiles for this user
        return new BasicTinderContextForUserImpl(user, profileQueue);
    }

    public TinderUserContext getContext(User user) {
        return allUsersOfTinder.get(user);
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Client {

    public static void main(String[] args) {
        TinderContext context = TinderContext.getInstance();

        User a = new User("a");
        User b = new User("b");
        User c = new User("c");

        context.addUser(a);
        context.addUser(b);
        context.addUser(c);

        // User A
        TinderUserContext userContext = context.getContext(a);

        userContext.swipeLeft();
        userContext.swipeRight(); // matched with B

        ChatContext chatContext = ((BasicTinderContextForUserImpl) userContext).getChatContext(b);
        if (chatContext != null) {
            chatContext.send("hello");
        }
    }
}


interface ChatState {
    void sendMessage(String msg);
}

class ActiveChatStateContextImpl implements ChatState {

    @Override
    public void sendMessage(String msg) {
        System.out.println("Sending message: " + msg);
    }
}

class BlockedChatStateContextImpl implements ChatState {

    @Override
    public void sendMessage(String msg) {
        System.out.println("Can't send message: " + msg);
    }
}

class ChatContext {

    private ChatState currState;
    private List<String> messages;
    private final User userA;
    private final User userB;

    public ChatContext(User userA, User userB) {
        this.currState = new ActiveChatStateContextImpl();
        this.messages = new ArrayList<>();
        this.userA = userA;
        this.userB = userB;
    }

    public void setState(ChatState state) {
        this.currState = state;
    }

    public void send(String message) {
        messages.add(message);
        currState.sendMessage(message);
    }

    public void notifiesUsers() {
        System.out.println("New message from " + userA.getName());
    }

    public User getUserB() {
        return userB;
    }

    public User getUserA() {
        return userA;
    }
}
