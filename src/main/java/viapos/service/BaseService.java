package viapos.service;

import org.springframework.beans.factory.annotation.Autowired;
import viapos.dao.CustomerDao;
import viapos.dao.PaymentMethodDao;
import viapos.external.cardconnect.service.CardConnectService;
import viapos.external.clover.service.CloverService;

public class BaseService {
    @Autowired
    CloverService cloverService;
    @Autowired
    CardConnectService cardConnectService;
    @Autowired
    CustomerDao customerDao;
    @Autowired
    PaymentMethodDao paymentMethodDao;
}
