package aop.d_order;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void saveUser(String id) {
        System.out.println("UserService 保存用户" + id);
    }

    public void update(String id, String name) {
        ((UserService) AopContext.currentProxy()).get(id);
        System.out.println("修改指定id的name。。。");
    }

    public void get(String id) {
        System.out.println("获取指定id的user。。。");
    }
}
