package org.cdibook.chapter9.interceptor;

import org.cdibook.chapter9.annotations.Transactional;

import javax.annotation.Resource;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.Status;
import javax.transaction.UserTransaction;

@Transactional
@Interceptor
public class TransactionInterceptor {

    @Resource
    UserTransaction userTrans;

    @AroundInvoke
    public Object manageTransaction(InvocationContext context) throws Exception {
        boolean transactionPresent = false;
        if (userTrans.getStatus() == Status.STATUS_NO_TRANSACTION) {
            userTrans.begin();
        } else {
            transactionPresent = true;
        }

        Object result;

        try {
            result = context.proceed();
        } catch (Exception e) {
            userTrans.rollback();
            throw e;
        }

        if (userTrans.getStatus() == Status.STATUS_MARKED_ROLLBACK) {
            userTrans.rollback();
        } else if (userTrans.getStatus() != Status.STATUS_ROLLEDBACK) {
            if (!transactionPresent) {
                userTrans.commit();
            }
        }

        return result;
    }
}
