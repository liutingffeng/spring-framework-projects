package spring02aop.com.linkedbear.spring.proxy.b_jdk;

public class Client {
    public static void main(String[] args) {
        Player player = new Player("郝武辽");
        Partner partner = PartnerPlatform.getPartner(50);

        partner.receiveMoney(51);
        partner.playWith(player);
    }
}
