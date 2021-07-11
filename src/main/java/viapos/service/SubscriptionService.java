package viapos.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.dao.LocationsDao;
import viapos.dao.SubscriptionDao;
import viapos.helper.SubscriptionHelper;
import viapos.model.Location;
import viapos.model.Subscription;
import viapos.model.SubscriptionTriggerRequest;
import viapos.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class SubscriptionService extends BaseService {

    @Autowired
    SubscriptionDao subscriptionDao;

    public boolean updateSubscriptions(List<Subscription> subscriptions) {
        for (Subscription subscription : subscriptions) {
            subscriptionDao.updateSubscription(subscription);
        }
        return true;
    }

    public ArrayList<Subscription> getSubscriptions() {
        return subscriptionDao.getSubscriptions();
    }

    public Subscription getSubscription(String subscriptionId) {
        return subscriptionDao.getSubscription(subscriptionId);
    }

    public boolean createSubscriptions(List<Subscription> subscriptions) {
        for (Subscription subscription : subscriptions) {
            subscription.setId(UUID.randomUUID().toString());
            subscriptionDao.createSubscription(subscription);
        }
        return true;
    }

    public boolean deleteSubscriptions(List<Subscription> subscriptions) {
        for (Subscription subscription : subscriptions) {
            subscriptionDao.deleteSubscription(subscription);
        }
        return true;
    }

    public void triggerSubscriptions(SubscriptionTriggerRequest subscriptionTriggerRequest) {
        List<Subscription> subscriptions = subscriptionDao.getDueSubscriptions(subscriptionTriggerRequest);
        for (Subscription subscription: subscriptions) {
            Transaction transaction = SubscriptionHelper.convertToTransaction(subscription);
            cardConnectService.authorizeTransaction(transaction, subscription.getMerchantId());
        }
    }
}
