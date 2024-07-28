package org.example;

import akka.actor.ActorSystem;
import akka.actor.Props;

public class App2 {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("remoteSystem");
        system.actorOf(Props.create(Actor2.class), "actor2");
    }
}
