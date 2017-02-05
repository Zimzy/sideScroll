package events;

import com.google.common.eventbus.EventBus;

public enum EventSingleton {
    OTTO;

    private EventBus bus;

    private EventSingleton() {
        this.bus = new EventBus();
    }

    public EventBus getEventBus() {
        return bus;
    }
}