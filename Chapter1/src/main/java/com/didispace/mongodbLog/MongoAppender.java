package com.didispace.mongodbLog;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Data;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * 重写log4j的日志代理
 */
@Data
public class MongoAppender extends AppenderSkeleton {

    private MongoClient mongoClient = null;
    private MongoDatabase mongoDatabase;
    private MongoCollection<BasicDBObject> logsCollection;

    private String connectionUrl;
    private String databaseName;
    private String collectionName;

    @Override
    protected void append(LoggingEvent event) {
        try {
            if(mongoDatabase == null) {
                MongoClientURI connectionString = new MongoClientURI(connectionUrl);
                mongoClient = new MongoClient(connectionString);
                mongoDatabase = mongoClient.getDatabase(databaseName);
                logsCollection = mongoDatabase.getCollection(collectionName, BasicDBObject.class);
            }
            logsCollection.insertOne((BasicDBObject) event.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void close() {

        if(mongoClient != null) {
            mongoClient.close();
        }
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
