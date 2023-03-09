package spring_dao.transaction.e_spread;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class PointService {

    @Transactional(propagation = Propagation.REQUIRED)
    public void addPoint() {
        System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
        System.out.println("addPoint 添加积分 ......");
    }
}
