package com.mycompany.datacustomerapp;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class connection {
    private static final String URL = "mongodb://localhost:27017";
    private static final String NAMA_DB = "users";
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static boolean connect() {
        try {
            mongoClient = MongoClients.create(URL); // ← perbaikan di sini
            database = mongoClient.getDatabase(NAMA_DB);
            System.out.println("Koneksi Berhasil...");
            return true;
        } catch (Exception e) {
            System.out.println("Gagal Koneksi...");
            e.printStackTrace(); // supaya tahu penyebab gagalnya
            return false;
        }
    }

    public static MongoDatabase getDatabase() {
        if (database == null) {
            throw new IllegalStateException("Belum terhubung ke database. Panggil connect() terlebih dahulu.");
        }
        return database;
    }
}
