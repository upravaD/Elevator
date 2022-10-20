package UI;

public class Menu {

    private final String head;
    private final String generalView;

    public Menu() {
        head = "OFFICE ELEVATOR SIMULATION";
        generalView = "\u001B[34m" + "General view of the building: " + "\u001B[0m";
    }

    public void getHead() {
        System.out.println("\n==========================");
        System.out.println(head);
        System.out.println("==========================\n\n");
    }

    public void getGeneralView(){
        System.out.println(generalView);
    }

}
