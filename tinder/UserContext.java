package tinder;

public interface UserContext {
    void notifyUsers(String msg);

    void swipeRight();
    void swipeLeft();

    void notifyUser();
}
