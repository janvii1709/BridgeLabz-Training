class MobilePhoneDetails {
    String Brand, Model;
    double Price;
    void Display() {
        System.out.println("Brand of mobile: " + Brand);
        System.out.println("Model of mobile: " + Model);
        System.out.println("Price of mobile: " + Price);
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
        MobilePhoneDetails M1 = new MobilePhoneDetails();
        M1.Brand="VIVO"; M1.Model="VIVO V29"; M1.Price=15999.0;

        MobilePhoneDetails M2 = new MobilePhoneDetails();
        M2.Brand="ONE PLUS"; M2.Model="ONE PLUS nord4"; M2.Price=39999.0;

        MobilePhoneDetails M3 = new MobilePhoneDetails();
        M3.Brand="APPLE"; M3.Model="iphone pro16"; M3.Price=79999.0;

        M1.Display(); M2.Display(); M3.Display();
    }
}