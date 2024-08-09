package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import staff.administration.Director;
import staff.administration.ProductionChief;
import staff.administration.SalesChief;
import staff.production.MachineOperator;
import staff.production.Merchandiser;
import staff.production.SalesManager;
import staff.production.StoreKeeper;

@Configuration

public class AppConfiguration {
    @Bean
    public MachineOperator machineOperator() {
        return new MachineOperator();

    }
    @Bean
    public StoreKeeper storeKeeper() {
        return new StoreKeeper();
    }
    @Bean
    public SalesManager salesManager() {
        return new SalesManager();
    }
    @Bean
public Merchandiser merchendiser() {
        return new Merchandiser();
}
@Bean
public ProductionChief productionChief() {
        return new ProductionChief();
}
@Bean
public SalesChief salesChief() {
        return new SalesChief();
}

@Bean
public Director director() {
        return new Director();
}

}
