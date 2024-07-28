package org.example;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class Actor1 extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("start", msg -> {
                    System.out.println("Received by Actor1: " + msg);
                    ActorRef actor2 = getContext().actorSelection("akka://remoteSystem@localhost:2552/user/actor2").anchor();
                    actor2.tell("Hi from Actor1", getSelf());
                })
                .build();
    }

    public static Props props() {
        return Props.create(Actor1.class);
    }
}
