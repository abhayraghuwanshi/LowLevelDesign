package tinder;

class TinderUser {

    private final String user;

    protected TinderUser(String user) {
        this.user = user;
    }

    void notifyMe(String msg);

    public String getUser() {
        return user;
    }
}
