import controller.LiftController;
import model.Building;
import service.LiftService;

public class LiftTest {

    public static void main(String[] args){

        LiftService liftService = new LiftService(new Building(10,3));
        LiftController liftController = new LiftController(liftService);

        System.out.println(liftController.addRequest(1,3));
        System.out.println(liftController.addRequest(2,4));
    }
}
