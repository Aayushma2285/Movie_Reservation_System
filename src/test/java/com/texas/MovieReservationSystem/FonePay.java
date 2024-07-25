package com.texas.MovieReservationSystem;


interface FonePay {
    public void pay();
}

class Esewa implements FonePay{
    public void pay() {
        System.out.println("Pays using Esewa wallet.");
    }
}

class Khalti implements FonePay{
    public void pay() {
        System.out.println("Pays using Khalti wallet.");
    }
}

class EndUser{
    private FonePay fonepay;

    public EndUser(FonePay fonePay){
        this.fonepay = fonePay;
    }

    public void doOnlinePayment(){
        fonepay.pay();
    }
}

class Main{
    public static void main(String[] args) {
        EndUser endUser = new EndUser(new Khalti());
        endUser.doOnlinePayment();
    }
}
