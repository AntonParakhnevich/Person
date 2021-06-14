package ITAcademy;

import ITAcademy.DAO.DAOManagerImpl;
import ITAcademy.DAO.DAOShopImpl;
import ITAcademy.Entity.Address;
import ITAcademy.Entity.Manager;
import ITAcademy.Entity.Shop;
import ITAcademy.Service.ServiceManager;
import ITAcademy.Service.ServiceShop;
import ITAcademy.Util.SessionUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Session session = SessionUtil.getSession().openSession();

        LocalDateTime data1 = LocalDateTime.of(2005, Month.APRIL, 20, 20, 25);
        LocalDateTime data2 = LocalDateTime.of(2021, Month.MARCH, 10, 5, 30);
        LocalDateTime data3 = LocalDateTime.of(2010, Month.SEPTEMBER, 27, 14, 50);

        List<String> lastNamesCriterion = Arrays.asList("Petrov","Ivanov","Sidorov");

        Shop shop1 = Shop.builder().name("21vek").date(data2).proceeds(1_000_000).build();
        Shop shop2 = Shop.builder().name("onliner").date(data1).proceeds(10_000).build();
        Shop shop3 = Shop.builder().name("giper").date(data3).proceeds(100_000).build();

        Manager manager1 = Manager.builder().firstName("Aleksey").lastName("Protos").surname("Artemovich").salary(300).build();
        Manager manager2 = Manager.builder().firstName("Sidr").lastName("Sidorov").surname("Sidorovich").salary(700).build();
        Manager manager3 = Manager.builder().firstName("Alex").lastName("Mirov").surname("Andreevich").salary(500).build();
        Manager manager4 = Manager.builder()
                .firstName("Anton")
                .lastName("Parakhnevich")
                .surname("Viktotovich")
                .salary(2000)
                .build();
        Manager manager5 = Manager.builder()
                .firstName("Ivan")
                .lastName("Ivanov")
                .surname("Petrovich")
                .salary(1500)
                .build();
        Manager manager6 = Manager.builder()
                .firstName("Petr")
                .lastName("Petrov")
                .surname("petrovich")
                .salary(600)
                .build();

        Address address1 = Address.builder().street("batova").house(30).build();
        Address address2 = Address.builder().street("Pobediteley").house(59).build();
        Address address3 = Address.builder().street("Matusevicha").house(150).build();

        shop1.setAddress(address1);
        shop1.addManager(manager1);
        shop1.addManager(manager2);
        manager1.setShop(shop1);
        manager2.setShop(shop1);
        address1.setShop(shop1);

        shop2.addManager(manager3);
        shop2.addManager(manager6);
        shop2.setAddress(address2);
        manager3.setShop(shop2);
        manager6.setShop(shop2);
        address2.setShop(shop2);

        shop3.setAddress(address3);
        shop3.addManager(manager4);
        shop3.addManager(manager5);
        address3.setShop(shop3);
        manager4.setShop(shop3);
        manager5.setShop(shop3);


        ServiceManager serviceManager = new ServiceManager(session);
        ServiceShop serviceShop = new ServiceShop(session);

        serviceShop.save(shop1);
        serviceShop.save(shop2);
        serviceShop.save(shop3);

        serviceManager.printAllManagers();
        serviceShop.printAllShops();

        serviceManager.printManagersCriterionProceeds();
        serviceShop.printShopsWhereWorkingManagers(lastNamesCriterion);

        serviceManager.printLastNameAndSalary();

        SessionUtil.close();


    }
}
