package transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import transaction.aspect.Transactional;
import transaction.dao.FinanceDao;

@Component
public class FinanceService {

    @Autowired
    private FinanceDao financeDao;

    @Transactional
    public void transfer(Long source, Long target, int money) {
        financeDao.subtractMoney(source, money);
        int i = 1 / 0;
        financeDao.addMoney(target, money);
    }
}
