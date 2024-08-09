import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import staff.administration.Director;
import staff.production.MachineOperator;


public class Main {
    public static void main(String[] args) {
//        MachineOperator machineOperator = new MachineOperator();
//        StoreKeeper storeKeeper = new StoreKeeper();
//        SalesManager salesManager = new SalesManager();
//        Merchandiser merchandiser = new Merchandiser();
//
//        ProductionChief productionChief = new ProductionChief();
//
//
//        SalesChief salesChief = new SalesChief();
//        salesChief.setSalesManager(salesManager);
//        salesChief.setMerchandiser(merchandiser);
//
//        Director director = new Director();
//        director.setProductionChief(productionChief);
//        director.setSalesChief(salesChief);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(".configuration");
//        Director director = context.getBean(Director.class);

        Director director = (Director) context.getBean("director");

        director.manageCompany();
    }
}
