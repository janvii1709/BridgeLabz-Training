package Problems;

import java.util.List;

public class ListManager {
	public void addElement(List<Integer> list, int element) {
        if (list != null) {
            list.add(element);
        }
    }
    public void removeElement(List<Integer> list, int element) {
        if (list != null) {
            // Remove first occurrence of element
            list.remove(Integer.valueOf(element));
        }
    }

    public int getSize(List<Integer> list) {
        if (list == null) return 0;
        return list.size();
    }
}
