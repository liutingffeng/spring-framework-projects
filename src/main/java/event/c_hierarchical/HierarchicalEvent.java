package event.c_hierarchical;

import org.springframework.context.ApplicationEvent;

public class HierarchicalEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public HierarchicalEvent(Object source) {
        super(source);
    }
}
