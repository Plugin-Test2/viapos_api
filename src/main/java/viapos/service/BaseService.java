package viapos.service;

import org.springframework.beans.factory.annotation.Autowired;
import viapos.external.cardconnect.service.CardConnectService;
import viapos.external.clover.service.CloverService;

public class BaseService {
    @Autowired
    CloverService cloverService;
    @Autowired
    CardConnectService cardConnectService;
}
