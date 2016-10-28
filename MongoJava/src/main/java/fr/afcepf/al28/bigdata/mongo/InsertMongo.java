package fr.afcepf.al28.bigdata.mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InsertMongo {
    private static final String HOST = "localhost";
    private static final int PORT = 27017;
    
    public static void main(String args[]) {
        MongoClient client = new MongoClient(HOST,PORT);
        MongoDatabase db = client.getDatabase("test");
        System.out.println("success!!");
        MongoCollection<Document>coll = db.getCollection("users");
        Document doc = new Document("name","Bob").append("age", 25).append("phone", "0680413240");
        coll.insertOne(doc);
    }
}
