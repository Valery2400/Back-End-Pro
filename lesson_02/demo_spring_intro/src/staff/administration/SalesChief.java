package staff.administration;

import org.springframework.beans.factory.annotation.Autowired;
import staff.production.Merchandiser;
import staff.production.SalesManager;

public class SalesChief {
    @Autowired
    private SalesManager salesManager;
    @Autowired
    private Merchandiser merchandiser;

       public void giveOrders() {
        merchandiser.work();
        salesManager.work();
    }
}
