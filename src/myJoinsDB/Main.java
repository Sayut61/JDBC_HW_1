package myJoinsDB;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FirstDBWorker dbWorker = new FirstDBWorker();
        List<FirstRequest> firstRequests = dbWorker.getFirstRequest();
        System.out.println();
        for (FirstRequest firstRequest: firstRequests) {
            System.out.println(firstRequest);
        }
    }
}
