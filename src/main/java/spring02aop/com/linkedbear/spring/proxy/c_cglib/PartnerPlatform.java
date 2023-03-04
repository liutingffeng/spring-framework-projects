package spring02aop.com.linkedbear.spring.proxy.c_cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import spring02aop.com.linkedbear.spring.proxy.Partner;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class PartnerPlatform {

    private static List<Partner> partners = new ArrayList<>();

    static {
        partners.add(new Partner("肖洁洁"));
        partners.add(new Partner("田苟"));
        partners.add(new Partner("高总裁"));
    }

    /**
     * 由陪玩平台根据预算推荐陪玩
     * @param money 预算
     * @return
     */
    public static Partner getPartner(int money) {
        Partner partner = partners.remove(0);
        return (Partner) Enhancer.create(partner.getClass(), new MethodInterceptor() {
            private int budget = money;
            private boolean status = false;

            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                // 如果在付钱时没给够，则标记budget为异常值
                if (method.getName().equals("receiveMoney")) {
                    int money = (int) objects[0];
                    this.status = money >= budget;
                }
                if (status) {
                    if (o instanceof Partner) {
                        System.out.println(true);
                    }
                    return methodProxy.invokeSuper(o, objects);
//                    return method.invoke(o, objects);
                }
                return null;
            }
        });
    }
}
