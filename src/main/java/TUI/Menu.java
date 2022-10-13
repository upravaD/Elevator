package TUI;

public class Menu {

    private final String head;
    private final String generalView;

    public Menu() {
        head = "OFFICE ELEVATOR SIMULATION";
        generalView = "General view of the building: ";
    }

    public void getHead() {
        System.out.println("==========================");
        System.out.println(head);
        System.out.println("==========================\n");
    }

    public void getGeneralView(){
        System.out.println(generalView);
    }

}
