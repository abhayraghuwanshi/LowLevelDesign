package tinder;

class Client {

    public static void main(String[] args) {

        TinderUserContext context = TinderUserContext.getInstance();
        // Handle only matches
        TinderMatchContext matchContext = TinderMatchContext.getInstance();

        //handles only chats
        TinderChatContext chatContext = TinderChatContext.getInstance();

        //handles only rightSwips
        TinderRightSwipeContext rightSwipeContext = TinderRightSwipeContext.getInstance();

        TinderUser a = new TinderUser("a");
        TinderUser b = new TinderUser("b");
        TinderUser c = new TinderUser("c");

        context.addUser(a);
        context.addUser(b);
        context.addUser(c);


        //for user a build 
        RecommendedSystem recommendedSystem = new BasicRecommendedSystem(context);

        UserContext userContextA = new BasicUserContextCreationFactory(a, recommendedSystem, context,rightSwipeContext, matchContext, chatContext);
        UserContext userContextB = new BasicUserContextCreationFactory(b, recommendedSystem, context, rightSwipeContext, matchContext, chatContext);


        userContextA.swipeRight(); // Suppose b is first you swipe b right
        userContextB.swipeRight(); // suppose a is first you match with a

        matchContext.addMatch(a, b);


        Message msg = new Message(a, b, "hello");

        chatContext.addMessage(a, b, msg);
        chatContext.setAllTinderChatsState(a, b, ChatState.BLOCKED);



    }
}