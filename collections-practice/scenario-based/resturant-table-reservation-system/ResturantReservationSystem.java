import java.util.*;
public class ResturantReservationSystem {
    private Map<Integer, Table> tables = new HashMap<>();
    private List<Reservation> reservations = new ArrayList<>();
    public void addTable(Table table) {
        tables.put(table.getTableNumber(), table);
    }
    public void reserveTable(int tableNumber, String customerName, String timeSlot)
            throws TableAlreadyReservedException {
        if (!tables.containsKey(tableNumber)) {
            System.out.println("Table does not exist!");
            return;
        }
        for (Reservation r : reservations) {
            if (r.getTableNumber() == tableNumber && r.getTimeSlot().equalsIgnoreCase(timeSlot)) {
                throw new TableAlreadyReservedException("Table " + tableNumber + " is already reserved for " + timeSlot);
            }
        }
        reservations.add(new Reservation(tableNumber, customerName, timeSlot));
        System.out.println("Reservation successful!");
    }
    public void cancelReservation(int tableNumber, String timeSlot) {
        Iterator<Reservation> iterator = reservations.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Reservation r = iterator.next();
            if (r.getTableNumber() == tableNumber && r.getTimeSlot().equalsIgnoreCase(timeSlot)) {
                iterator.remove();
                found = true;
                System.out.println("✅ Reservation cancelled successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println(" No reservation found!");
        }
    }
    public void showAvailableTables(String timeSlot) {
        System.out.println("Available tables for " + timeSlot + ":");
        for (Table table : tables.values()) {
            boolean reserved = false;
            for (Reservation r : reservations) {
                if (r.getTableNumber() == table.getTableNumber() && r.getTimeSlot().equalsIgnoreCase(timeSlot)) {
                    reserved = true;
                    break;
                }
            }
            if (!reserved) {
                System.out.println("Table " + table.getTableNumber()
                        + " (Capacity: " + table.getCapacity() + ")");
            }
        }
    }
}
