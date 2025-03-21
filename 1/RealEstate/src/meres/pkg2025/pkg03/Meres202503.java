/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package meres.pkg2025.pkg03;
import java.io.IOException;
import java.util.List;

public class Meres202503 {
    public static void main(String[] args) {
        try {
            // Adatok betöltése CSV fájlból
            List<Ad> ads = CsvLoader.loadFromCsv("realestates.csv");

            // Földszinti ingatlanok átlagos alapterületének kiszámítása
            RealEstateAnalysis.calculateAverageArea(ads);

            // Legközelebbi tehermentes ingatlan keresése
            RealEstateAnalysis.findClosestFreeOfChargeAd(ads);
        } catch (IOException e) {
            System.err.println("Hiba történt az adatok betöltése során: " + e.getMessage());
        }
    }
}

