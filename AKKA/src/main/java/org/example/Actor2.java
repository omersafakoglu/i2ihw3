package org.example;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class Actor2 extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("Hi from Actor1", msg -> {
                    System.out.println("Received by Actor2: " + msg);
                    ActorRef actor1 = getContext().actorSelection("akka://localSystem@localhost:2551/user/actor1").anchor();
                    actor1.tell("Hi from Actor2", getSelf());
                })
                .build();
    }

    public static Props props() {
        return Props.create(Actor2.class);
    }
}
