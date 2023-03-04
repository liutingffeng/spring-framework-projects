package spring02aop.com.linkedbear.spring.proxy;

public class Client {

    public static void main(String[] args) {
        Player player = new Player("郝武辽");
        Partner partner = new Partner("肖洁洁");

        partner.receiveMoney(200);
        partner.playWith(player);
    }
}
