package com.codemon.securedoc.domain;


/*
    * This class is used to store the user id in the thread local variable.
    * This is used to get the user id in the @PrePersist method in the Auditable class.
 */
public class RequestContext {

    // Creating the ThreadLocal variable
    private static final ThreadLocal<Long> USER_ID = new ThreadLocal<>();

    // Private constructor
    private RequestContext() {}

    // Starting the thread
    public static void start(){
        USER_ID.remove();
    }
    // Setting the user id
    public static void setUserId(Long userId){
        USER_ID.set(userId);
    }

    // Getting the user id
    public static Long getUserId(){
        return USER_ID.get();
    }
}
