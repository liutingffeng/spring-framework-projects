package basic_dl.a_quickstart_byname;

import basic_dl.a_quickstart_byname.bean.Person;
import basic_dl.a_quickstart_byname.dao.DemoDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuickstartByNameApplication {

    public static void main(String[] args) throws Exception{
        BeanFactory factory = new ClassPathXmlApplicationContext("basic_all/quickstart-bytype.xml");
        DemoDao demoDao = factory.getBean(DemoDao.class);
        System.out.println(demoDao.findAll());
    }
}
