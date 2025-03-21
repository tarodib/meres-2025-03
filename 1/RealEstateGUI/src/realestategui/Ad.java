/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package realestategui;

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
    private boolean freeOfCharge;
    private String latLong;
    private Seller seller;

    public Ad(int id, String description, int rooms, int area, int floors,
              boolean freeOfCharge, String latLong, Seller seller) {
        this.id = id;
        this.description = description;
        this.rooms = rooms;
        this.area = area;
        this.floors = floors;
        this.freeOfCharge = freeOfCharge;
        this.latLong = latLong;
        this.seller = seller;
    }

    public Seller getSeller() {
        return seller;
    }

    public boolean isFreeOfCharge() {
        return freeOfCharge;
    }

    public int getArea() {
        return area;
    }

    public int getFloors() {
        return floors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getLatLong() {
        return latLong;
    }

    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }

    
}

