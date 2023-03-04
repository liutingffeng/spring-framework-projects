package spring02aop.com.linkedbear.spring.proxy;

import java.util.ArrayList;
import java.util.List;

public class PartnerPlatform {

    private static List<Partner> partners = new ArrayList<>();

    static {
        partners.add(new Partner("肖洁洁"));
        partners.add(new Partner("田苟"));
        partners.add(new Partner("高总裁"));
    }

    public static Partner getPartner(int money) {
        Partner partner = partners.remove(0);
        return partner;
    }
}
