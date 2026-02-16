package DesignPatternsPractice.interviewLearn;

import java.rmi.ServerError;
import java.util.Objects;

interface PaymentType{
    public void pay(double amount);
}

class PayPalPayment implements PaymentType{

    @Override
    public void pay(double amount) {
        System.err.println("Amount "+amount+" payed by user via Paypal");
    }
}

class RozzerPay implements PaymentType{
    @Override
    public void pay(double amount) {
        System.err.println("Amount "+amount+" payed by user via RozarPay");
    }
}
// adding adapter pattern

class MobileBankingAPI
{
    public void execute(double amount, String accountNumber)
    {
        System.out.println("User is payed amount\t"+amount+" to "+accountNumber+"via mobile banking");
    }
}

class MobileBankingAdapter implements PaymentType
{
    private MobileBankingAPI mobileBankingAPI;
    private String accountNumber;

    MobileBankingAdapter(MobileBankingAPI mobileBankingAPI, String accountNumber)
    {
        this.mobileBankingAPI=mobileBankingAPI;
        this.accountNumber=accountNumber;
    }


    @Override
    public void pay(double amount) {
        mobileBankingAPI.execute(amount,accountNumber);
    }
}

class ProxyPaymentGateWay implements PaymentType{

    private PaymentType paymentStrategy;

    ProxyPaymentGateWay(PaymentType paymentStrategy)
    {
        this.paymentStrategy=paymentStrategy;
    }

    @Override
    public void pay(double amount) {
        if(amount<0)
        {
            throw new IllegalArgumentException("Invalid Amount");

        }
        System.err.println("User is  trying to pay amount: "+amount);
        paymentStrategy.pay(amount);
    }
}

class DiscountDecorator implements PaymentType{

    private PaymentType realPayment;
    private double discountPercent;

    DiscountDecorator(PaymentType realPayment, double discount)
    {
        this.realPayment=realPayment;
        this.discountPercent=discount;
    }


    @Override
    public void pay(double amount) {
        double discountAmount = amount * (discountPercent / 100.0);
        double discounted = amount - discountAmount;
        System.err.println("discounted amount \t"+discountAmount);
        realPayment.pay(discounted);
    }
}

public class EcommerceClient {
    public static void main(String[] args) {

        PaymentType payment = new PayPalPayment();
        payment= new RozzerPay();

        // now using adapter pattern to add new functonality
        payment= new MobileBankingAdapter(new MobileBankingAPI(),"S12WERT89");

        ProxyPaymentGateWay proxyPaymentGateWay = new ProxyPaymentGateWay(payment);
//            proxyPaymentGateWay.pay(100.0);


        DiscountDecorator ds= new DiscountDecorator(proxyPaymentGateWay,10.0);
        ds.pay(100.0);
    }
}
