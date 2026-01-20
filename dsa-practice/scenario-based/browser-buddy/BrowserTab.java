class BrowserTab {
    HistoryNode current;
    void visitPage(String url) {
        HistoryNode newNode = new HistoryNode(url);

        if (current != null) {
            current.next = null;
            current.next = newNode;
            newNode.prev = current;
        }
        current = newNode;
        System.out.println("Visited: " + url);
    }
    void goBack() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Back to: " + current.url);
        } else {
            System.out.println("No previous page!");
        }
    }
    void goForward() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Forward to: " + current.url);
        } else {
            System.out.println("No forward page!");
        }
    }
    String currentPage() {
        return current == null ? "No page opened" : current.url;
    }
}
