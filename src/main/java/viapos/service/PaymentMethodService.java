package viapos.service;

import org.springframework.stereotype.Component;
import viapos.model.PaymentMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class PaymentMethodService extends BaseService {

    public boolean updatePaymentMethods(List<PaymentMethod> paymentMethods) {
        for (PaymentMethod paymentMethod : paymentMethods) {
            paymentMethodDao.updatePaymentMethods(paymentMethod);
        }
        return true;
    }

    public PaymentMethod getPaymentMethod(String paymentMethodId) {
        return paymentMethodDao.getPaymentMethod(paymentMethodId);
    }

    public boolean createPaymentMethods(List<PaymentMethod> paymentMethods) {
        for (PaymentMethod paymentMethod : paymentMethods) {
            paymentMethod.setId(UUID.randomUUID().toString());
            paymentMethodDao.createPaymentMethod(paymentMethod);
        }
        return true;
    }

    public boolean deletePaymentMethods(List<PaymentMethod> paymentMethods) {
        for (PaymentMethod paymentMethod : paymentMethods) {
            paymentMethodDao.deletePaymentMethod(paymentMethod);
        }
        return true;
    }
}
