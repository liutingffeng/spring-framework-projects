package service.impl;
import dao.DemoDao;
import service.DemoService;
import servlet.BeanFactory;

import java.util.List;

public class DemoServiceImpl implements DemoService {
    private DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");

    public DemoServiceImpl() {
        for (int i = 0; i < 10; i++) {
            System.out.println(BeanFactory.getBean("demoDao"));
        }
    }
    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
}
