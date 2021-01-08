package viapos.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.dao.LocationsDao;
import viapos.dao.PaymentPlanDao;
import viapos.model.Location;
import viapos.model.PaymentPlan;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class PaymentPlanService extends BaseService {

    @Autowired
    PaymentPlanDao paymentPlanDao;

    public boolean updatePaymentPlans(List<PaymentPlan> paymentPlans) {
        for (PaymentPlan paymentPlan : paymentPlans) {
            paymentPlanDao.updatePaymentPlans(paymentPlan);
        }
        return true;
    }

    public ArrayList<PaymentPlan> getPaymentPlans() {
        return paymentPlanDao.getPaymentPlans();
    }

    public PaymentPlan getPaymentPlan(String paymentPlanId) {
        return paymentPlanDao.getPaymentPlan(paymentPlanId);
    }

    public boolean createPaymentPlans(List<PaymentPlan> paymentPlans) {
        for (PaymentPlan paymentPlan : paymentPlans) {
            paymentPlan.setId(UUID.randomUUID().toString());
            paymentPlanDao.createPaymentPlans(paymentPlan);
        }
        return true;
    }

    public boolean deletePaymentPlans(List<PaymentPlan> paymentPlans) {
        for (PaymentPlan paymentPlan : paymentPlans) {
            paymentPlanDao.deletePaymentPlan(paymentPlan);
        }
        return true;
    }
}
