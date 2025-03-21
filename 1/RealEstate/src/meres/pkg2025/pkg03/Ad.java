/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meres.pkg2025.pkg03;

/**
 *
 * @author tarodib.20d
 */
public class Ad {
    private int id;
    private String description;
    private int rooms;
    private int area;
    private int floors;
    private Category category;
    private Seller seller;
    private boolean freeOfCharge;
    private String imageUrl;
    private String latLong;
    private String createAt;

    public Ad(int id, String description, int rooms, int area, int floors, Category category, Seller seller,
              boolean freeOfCharge, String imageUrl, String latLong, String createAt) {
        this.id = id;
        this.description = description;
        this.rooms = rooms;
        this.area = area;
        this.floors = floors;
        this.category = category;
        this.seller = seller;
        this.freeOfCharge = freeOfCharge;
        this.imageUrl = imageUrl;
        this.latLong = latLong;
        this.createAt = createAt;
    }

    public int getFloors() {
        return floors;
    }

    public int getArea() {
        return area;
    }

    public boolean isFreeOfCharge() {
        return freeOfCharge;
    }

    public Seller getSeller() {
        return seller;
    }

    public String getLatLong() {
        return latLong;
    }
    
    public int getRooms() {
        return rooms;
    }

    // Távolság számítása Pitagorasz-tétellel
    public double calculateDistance(double targetLat, double targetLon) {
        String[] coordinates = latLong.split(",");
        double lat = Double.parseDouble(coordinates[0]);
        double lon = Double.parseDouble(coordinates[1]);
        return Math.sqrt(Math.pow(targetLat - lat, 2) + Math.pow(targetLon - lon, 2));
    }
}

