package com.ruhuna.kavinda.core;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/24/2018
 */

public class Sim {

    private int simNumber;
//    private BigDecimal currentBill;

    public Sim(int simNumber) {
        this.simNumber = simNumber;
//        this.currentBill = BigDecimal.ZERO;
    }

    public int getSimNumber() {
        return simNumber;
    }

//    public BigDecimal getCurrentBill() {
//        return currentBill;
//    }
//
//    public void addToCurrentBill(BigDecimal amount) {
//        this.currentBill =this.currentBill.add(amount);
//    }
//
//    public void substractFromCurrentBill(BigDecimal amount){
//        this.currentBill = this.currentBill.subtract(amount);
//    }
}
