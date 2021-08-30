package com.ynero.ss.analytics_service.migration;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import lombok.extern.log4j.Log4j2;
import org.bson.Document;

@ChangeLog(order = "001")
@Log4j2
public class DBChangelog001 {

    @ChangeSet(order = "001", systemVersion = "001", id = "insert port's data record v1", author = "ynero")
    public void insertAdminUser(MongoDatabase mongo) {
        log.info("mongo: {}, v-1",mongo.getName());
    }
}
