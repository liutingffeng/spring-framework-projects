package event.c_hierarchical;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HierarchicalEventApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext parentCtx = new AnnotationConfigApplicationContext();
        parentCtx.addApplicationListener(new HierarchicalEventListener());

        AnnotationConfigApplicationContext childCtx = new AnnotationConfigApplicationContext();
        childCtx.setParent(parentCtx);
        childCtx.addApplicationListener(new HierarchicalEventListener());

        parentCtx.refresh();
        childCtx.refresh();

        parentCtx.publishEvent(new HierarchicalEvent("父容器发布的HierarchicalEvent"));
        childCtx.publishEvent(new HierarchicalEvent("子容器发布的HierarchicalEvent"));
    }
}
