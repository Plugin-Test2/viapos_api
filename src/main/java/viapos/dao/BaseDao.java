package viapos.dao;

import com.mongodb.*;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mongodb.client.MongoDatabase;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

abstract class BaseDao {

//    MongoClientURI uri;
//    MongoClient mongoClient;
//    MongoDatabase database;
    MongoClientSettings clientSettings;
    String username = "viapos";
    String password = "yBCeAzibqT1ixSbC";


    public BaseDao() {

//        uri = new MongoClientURI("mongodb+srv://<username>:<password>@viaposcluster.s3ays.mongodb.net/<dbname>?retryWrites=true&w=majority");
//        mongoClient = new MongoClient(uri);
//        database = mongoClient.getDatabase("test");
        String uri = "mongodb+srv://" + username + ":" + password + "@viaposcluster.s3ays.mongodb.net/<dbname>?retryWrites=true&w=majority";
        ConnectionString connectionString = new ConnectionString(uri);
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();

    }

}
