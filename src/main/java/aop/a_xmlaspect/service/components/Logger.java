package aop.a_xmlaspect.service.components;

public class Logger {
    public void beforePrint() {
        System.out.println("Logger beforePrint run ......");
    }

    public void afterPrint() {
        System.out.println("Logger afterPrint run ......");
    }

    public void afterReturningPrint() {
        System.out.println("Logger afterReturningPrint run ......");
    }

    public void afterThrowingPrint() {
        System.out.println("Logger afterThrowingPrint run ......");
    }

}
