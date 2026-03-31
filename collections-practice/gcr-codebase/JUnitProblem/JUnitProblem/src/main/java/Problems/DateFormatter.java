package Problems;
public class DateFormatter {
    public String formatDate(String inputDate) {
        if (inputDate == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        try {
            java.text.SimpleDateFormat input =
                    new java.text.SimpleDateFormat("yyyy-MM-dd");
            input.setLenient(false);

            java.text.SimpleDateFormat output =
                    new java.text.SimpleDateFormat("dd-MM-yyyy");

            java.util.Date date = input.parse(inputDate);
            return output.format(date);

        } catch (java.text.ParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }
    }
}
