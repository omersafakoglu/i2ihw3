package org.example;

import akka.actor.ActorSystem;
import akka.actor.Props;

public class App1 {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("localSystem");
        system.actorOf(Props.create(Actor1.class), "actor1");
        system.actorSelection("/user/actor1").tell("start", null);
    }
}
