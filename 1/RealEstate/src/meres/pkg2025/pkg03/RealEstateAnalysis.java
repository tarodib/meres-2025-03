/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meres.pkg2025.pkg03;

import java.util.List;

public class RealEstateAnalysis {

    public static void calculateAverageArea(List<Ad> ads) {
        double totalArea = 0.0;
        int count = 0;

        for (Ad ad : ads) {
            if (ad.getFloors() == 0) { // Földszinti ingatlan
                totalArea += ad.getArea();
                count++;
            }
        }

        if (count > 0) {
            double averageArea = totalArea / count;
            System.out.printf("1. Földszinti ingatlanok átlagos alapterülete: %.2f m2%n", averageArea);
        } else {
            System.out.println("Nincs földszinti ingatlan.");
        }
    }

    public static void findClosestFreeOfChargeAd(List<Ad> ads) {
        final double targetLat = 47.4164220114023; // Mesevár óvoda koordinátái
        final double targetLon = 19.066342425796986;

        Ad closestAd = null;
        double minDistance = Double.MAX_VALUE;

        for (Ad ad : ads) {
            if (ad.isFreeOfCharge()) { // Csak tehermentes ingatlanok
                double distance = ad.calculateDistance(targetLat, targetLon);
                if (distance < minDistance) {
                    minDistance = distance;
                    closestAd = ad;
                }
            }
        }

        if (closestAd != null) {
            System.out.println("2. Mesevár óvodához legközelebbi tehermentes ingatlan adatai:");
            System.out.println("   Eladó neve: " + closestAd.getSeller().getName());
            System.out.println("   Eladó telefonja: " + closestAd.getSeller().getPhone());
            System.out.println("   Alapterület: " + closestAd.getArea() + " m2");
            System.out.println("   Szobák száma: " + closestAd.getRooms());
        } else {
            System.out.println("Nincs tehermentes ingatlan.");
        }
    }
}

