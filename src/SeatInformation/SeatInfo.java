/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SeatInformation;

/**
 *
 * @author User
 */
public class SeatInfo {

    private int seatInfoId;
    private int firstclassAmount;
    private int businessClassAmount;
    private int EconomyClassAmount;
    private int firstclassseatprice;
    private int businessclassseatprice;
    private int economyclassseatprice;
    private String flightNumber;

    public SeatInfo(int seatInfoId, int firstclassAmount, int businessClassAmount, int EconomyClassAmount, int firstclassseatprice, int businessclassseatprice, int economyclassseatprice, String flightNumber) {
        this.seatInfoId = seatInfoId;
        this.firstclassAmount = firstclassAmount;
        this.businessClassAmount = businessClassAmount;
        this.EconomyClassAmount = EconomyClassAmount;
        this.firstclassseatprice = firstclassseatprice;
        this.businessclassseatprice = businessclassseatprice;
        this.economyclassseatprice = economyclassseatprice;
        this.flightNumber = flightNumber;
    }

    public SeatInfo(int firstclassAmount, int businessClassAmount, int EconomyClassAmount, int firstclassseatprice, int businessclassseatprice, int economyclassseatprice, String flightNumber) {
        this.firstclassAmount = firstclassAmount;
        this.businessClassAmount = businessClassAmount;
        this.EconomyClassAmount = EconomyClassAmount;
        this.firstclassseatprice = firstclassseatprice;
        this.businessclassseatprice = businessclassseatprice;
        this.economyclassseatprice = economyclassseatprice;
        this.flightNumber = flightNumber;
    }

    public SeatInfo() {
    }

    public int getSeatInfoId() {
        return seatInfoId;
    }

    public void setSeatInfoId(int seatInfoId) {
        this.seatInfoId = seatInfoId;
    }

    public int getFirstclassAmount() {
        return firstclassAmount;
    }

    public void setFirstclassAmount(int firstclassAmount) {
        this.firstclassAmount = firstclassAmount;
    }

    public int getBusinessClassAmount() {
        return businessClassAmount;
    }

    public void setBusinessClassAmount(int businessClassAmount) {
        this.businessClassAmount = businessClassAmount;
    }

    public int getEconomyClassAmount() {
        return EconomyClassAmount;
    }

    public void setEconomyClassAmount(int EconomyClassAmount) {
        this.EconomyClassAmount = EconomyClassAmount;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getFirstclassseatprice() {
        return firstclassseatprice;
    }

    public void setFirstclassseatprice(int firstclassseatprice) {
        this.firstclassseatprice = firstclassseatprice;
    }

    public int getBusinessclassseatprice() {
        return businessclassseatprice;
    }

    public void setBusinessclassseatprice(int businessclassseatprice) {
        this.businessclassseatprice = businessclassseatprice;
    }

    public int getEconomyclassseatprice() {
        return economyclassseatprice;
    }

    public void setEconomyclassseatprice(int economyclassseatprice) {
        this.economyclassseatprice = economyclassseatprice;
    }

     
}
