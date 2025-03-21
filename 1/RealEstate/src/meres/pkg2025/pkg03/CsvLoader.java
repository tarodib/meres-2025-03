/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meres.pkg2025.pkg03;

/**
 *
 * @author tarodib.20d
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvLoader {

    public static List<Ad> loadFromCsv(String filePath) throws IOException {
        List<Ad> ads = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        
        // Fejléc kihagyása
        br.readLine();
        
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            
            int id = Integer.parseInt(parts[0]);
            int rooms = Integer.parseInt(parts[1]);
            String latLong = parts[2];
            int floors = Integer.parseInt(parts[3]);
            int area = Integer.parseInt(parts[4]);
            String description = parts[5];
            boolean freeOfCharge = parts[6].equals("1");
            String imageUrl = parts[7];
            String createAt = parts[8];
            
            int sellerId = Integer.parseInt(parts[9]);
            String sellerName = parts[10];
            String sellerPhone = parts[11];
            
            int categoryId = Integer.parseInt(parts[12]);
            String categoryName = parts[13];
            
            Seller seller = new Seller(sellerId, sellerName, sellerPhone);
            Category category = new Category(categoryId, categoryName);
            
            ads.add(new Ad(id, description, rooms, area, floors, category, seller,
                    freeOfCharge, imageUrl, latLong, createAt));
        }
        
        br.close();
        return ads;
    }
}

