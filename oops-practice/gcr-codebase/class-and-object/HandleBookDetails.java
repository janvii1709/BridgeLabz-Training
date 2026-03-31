class HandleBookDetails {
    String Title, Author;
    double Price;
    void Display() {
        System.out.println("Title of the book: " + Title);
        System.out.println("Author of the book: " + Author);
        System.out.println("Price of the book: " + Price);
    }
    public static void main(String[] args) {
        HandleBookDetails B1 = new HandleBookDetails();
        B1.Title = "2States";
        B1.Author = "Chetan Bhagat";
        B1.Price = 500.0;

        HandleBookDetails B2 = new HandleBookDetails();
        B2.Title = "Wings Of Fire";
        B2.Author = "Abdul kalam.A.P.J";
        B2.Price = 500.0;

        B1.Display();
        B2.Display();
    }
}