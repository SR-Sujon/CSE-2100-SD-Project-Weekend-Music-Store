/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

/**
 *
 * @author Sujon
 */
import java.sql.Date;

public class payment {
    int trxid;
    int pid;
    String pname;
    int quantity;
    String user_name;
    String cardholder;
    String cardnumber;
    Date expirydate;
    int pin;
    double amount;
    
    public payment(int trxID, int pid, String pname, int quantity, String username, String cardholder, String cardno, Date eDate,  double amount) {
        this.trxid = trxID;
        this.pid = pid;
        this.pname = pname;
        this.quantity = quantity;
        this.user_name = username;
        this.cardholder = cardholder;
        this.expirydate = eDate;
        this.cardnumber = cardno;
        this.amount = amount;
    }

    public String getCardholder() {
        return cardholder;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    public int getTrxid() {
        return trxid;
    }

    public void setTrxid(int trxid) {
        this.trxid = trxid;
    }



    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
