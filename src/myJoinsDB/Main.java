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

        System.out.println("-------------------------------------------------------------");

        SecondDBWorker secondDBWorker = new SecondDBWorker();
        List<SecondRequest> secondRequests = secondDBWorker.getSecondRequest();
        System.out.println();
        for (SecondRequest secondRequest : secondRequests){
            System.out.println(secondRequest);
        }

        System.out.println("-------------------------------------------------------------");

        ThirdDBWorker thirdDBWorker = new ThirdDBWorker();
        List<ThirdRequest> thirdRequests = thirdDBWorker.getThirdRequest();
        System.out.println();
        for (ThirdRequest thirdRequest : thirdRequests){
            System.out.println(thirdRequest);
        }
    }
}
