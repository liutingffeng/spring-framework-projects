package spring02aop.com.linkedbear.spring.proxy;

public class Partner {

    private String name;

    public Partner(String name) {
        this.name = name;
    }

    public Partner() {
    }

    /**
     * 收钱
     * @param money
     */
    public void receiveMoney(int money) {
        System.out.println(name + "收到佣金：" + money + "元 ~ ");
    }

    /**
     * 陪玩
     * @param player
     */
    public void playWith(Player player) {
        System.out.println(name + "与" + player.getName() + "一起愉快地玩耍 ~ ");
    }
}
