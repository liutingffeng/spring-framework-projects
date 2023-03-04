package spring02aop.com.linkedbear.spring.proxy.c_cglib;

import spring02aop.com.linkedbear.spring.proxy.Partner;
import spring02aop.com.linkedbear.spring.proxy.Player;

public class Client {

    public static void main(String[] args) throws Exception {
        Player player = new Player("郝武辽");
        // 此处的Partner是a_basic包下的，不是接口 是类
        Partner partner = PartnerPlatform.getPartner(50);

        partner.receiveMoney(20);
        partner.playWith(player);

        partner.receiveMoney(200);
        partner.playWith(player);
    }
}
