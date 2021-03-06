package com.example.fi.rinkkasatiainen.model.schedule;

import com.example.fi.rinkkasatiainen.model.EventStore;
import com.example.fi.rinkkasatiainen.model.SessionUUID;
import com.example.fi.rinkkasatiainen.model.session.Session;
import com.example.fi.rinkkasatiainen.model.session.SessionDetails;
import com.example.fi.rinkkasatiainen.model.session.events.SessionCreated;
import com.example.fi.rinkkasatiainen.model.session.projections.SessionFeedbackResult;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Schedule {
    private final Supplier<SessionUUID> supplier;
    private final EventStore eventStore;

    public Schedule(Supplier<SessionUUID> supplier, EventStore eventStore) {
        this.supplier = supplier;
        this.eventStore = eventStore;
    }

    public SessionUUID newSessionUUID() {
        return supplier.get();
    }

    public Session findSession(SessionUUID uuid) {
        // Step 1: find all events related to UUID from the EventStore

        // Step 2: load a new Session
        return null;
    }



    public SessionFeedbackResult findSessionFeeback(SessionUUID uuid) {
        // Step 1: find all events related to UUID from the EventStore

        // Step 2: create a Projection from the events
        return null;
    }

















    public List<SessionDetails> findAllSessions() {
        // Step 1: get UUIDs of all the sessions
        getSessionUUIDS();
        // Step 2: find all UUID -> List<Event> from event store

        // Step 3: map entryset to SessionDetails - load(entry.getValue())

//         This would be a perfect place to build a reactive stream.
        return new ArrayList<>();
    }










//        return all.entrySet().stream().map( entry -> SessionDetails.load(entry.getValue())).collect(Collectors.toList());


    private List<SessionUUID> getSessionUUIDS() {
        List<SessionCreated> allSessionCreatedEvents = eventStore.findAllByType(SessionCreated.class);
        return allSessionCreatedEvents.stream().map(e -> e.uuid).collect(Collectors.toList());
    }
}
