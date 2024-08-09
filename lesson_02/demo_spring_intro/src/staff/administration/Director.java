package staff.administration;

import org.springframework.beans.factory.annotation.Autowired;

public class Director {
    @Autowired
    private SalesChief salesChief;
    @Autowired
    private ProductionChief productionChief;

    public void setSalesChief(SalesChief salesChief) {
        this.salesChief = salesChief;
    }

    public void setProductionChief(ProductionChief productionChief) {
        this.productionChief = productionChief;
    }

    public void manageCompany() {
        salesChief.giveOrders();
        productionChief.giveOrders();
    }


}

