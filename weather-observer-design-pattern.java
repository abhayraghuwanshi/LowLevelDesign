/*

Problem: Let us Imagine a scenario where the weather station is observed by various smart devices. 
The weather station maintains a list of registered devices. When there’s a change in weather conditions, 
the weather station notifies all devices about the update.

Solution: Observer Design pattern

*/

public interface WeatherStation {

    void notifiesUsers(String message);
    void addUsers(Observer user);
    void removeUsers(Observer user):

}


public class WeatherStationImpl implements WeatherStation {

    private List<Observer> users = new ArrayList<Observer>();
    private String currState;

    @overide
    void notifiesUsers(String message){
        for (Observer user: users){
            user.sendMessage(message);
        }
    }

    @overide
    void addUsers(Observer user) {
        users.add(user)
    }
    
    @overide
    void removeUsers(Observer user) {
        users.remove(user)
    }

    void setCurrState(String state){
        this.currState = state;
        notifiesUsers(state);
    }

} 

public interface Observer {

    void sendMessage(String msg);

}

public class ObserverImpl implements Observer {

    private User user;

    public ObserverImpl(User user){
        this.user = user;
    }

    @overide
    void sendMessage(String msg){
        log.info("Sending to  -"+ user.name)
        log.info("Current weather -"+ user.name)
    }

}

public class User {

    private String name;
    private int id;

    public User(String name, int id){
        this.name = name;
        this.id = id;
    }

}


User a = User("TV", "1")
Observer ob = new ObserverImpl(user);
WeatherStation ws = new WeatherStation();
ws.addUsers(a);
ws.notifiesUsers("hello testing");
