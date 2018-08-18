/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DB4OUtil.DB4OUtil_StockHistory;
import business.Customer.Customer;
import business.Customer.CustomerDirectory;
import business.Employee.Employee;
import business.Enterprise.Enterprise;
import business.Enterprise.ExpertEnterprise;
import business.Enterprise.FinancialEnterprise;
import business.Enterprise.GovernmentEnterprise;
import business.Enums.Country;
import business.Enums.EnterpriseNames;
import business.Enums.FirstNames;
import business.Enums.LastNames;
import business.Enums.Offices_Germany;
import business.Enums.Offices_India;
import business.Enums.Offices_USA;
import business.Enums.Sex;
import business.Expert.SpeakerSession;
import business.Investment.Investment;
import business.Investment.InvestmentItem;
import business.Network.Network;
import business.Network.NetworkDirectory;
import business.Organisation.ExpertOrganization;
import business.Organisation.GovernmentOrganization;
import business.Organisation.InvestmentAndRiskOrganization;
import business.Organisation.Organisation;
import business.Organisation.RegulatroyOrganization;
import business.Role.CustomerRole;
import business.Role.EmployeeInvestmentAndRiskRole;
import business.Role.EmployeeRegulatoryRole;
import business.Role.EnterpriseAdminRole;
import business.Role.ExpertRole;
import business.Role.GovermentRole;
import business.Role.Roles;
import business.Role.SystemAdminRole;
import business.Stock.Risk;
import business.Stock.Stock;
import business.Useraccount.UserAccount;
import business.WorkQueue.AdviceWorkRequest;
import business.WorkQueue.GovernmentWorkRequest;
import business.WorkQueue.InvestmentWorkRequest;
import business.WorkQueue.WorkRequest;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class Configure {

    static private EcoSystem system = EcoSystem.getInstance();
    private static Random rm = new Random();
    static String mobilePrefix = "85712";
    static Sex sex[] = Sex.values();
    static FirstNames[] fname = FirstNames.values();
    static LastNames[] lname = LastNames.values();
    static Risk risk[] = Risk.values();
    static NetworkDirectory nd = system.getNetworkDirectory();
    static CustomerDirectory cd = system.getCustomerDirectory();

    public static EcoSystem configure() throws ParseException {

        UserAccount u = new UserAccount();
        Employee emp = new Employee(1);
        u.setPerson(emp);
        emp.setUserAccount(u);

        u.setPerson(emp);
        u.setUserName("admin");
        u.setPassword("admin");
        u.setRole(new SystemAdminRole());

        emp.setUserAccount(u);
        emp.setAge(rm.nextInt((90 - 18) + 1) + 18);
        emp.setRole(Roles.RoleType.EnterpriseAdmin);
        emp.setSex("Male");
        emp.setImgIcon(getPofilePic("Male"));
        emp.setFirstName("admin");
        emp.setLastName("admin");
        emp.setEmailId("admin@gmail.com");
        emp.setMobileNumber(987654321);
        system.getUserDirectory().addUserAccount(u);
        loadCustomer();
        genNetworks();
        EnterpriseRequests();

        return system;
    }

    private static void genNetworks() {

        DB4OUtil_StockHistory dB4OUtilSC = DB4OUtil_StockHistory.getInstance();
        Country[] country = Country.values();
        for (int i = 0; i < 3; i++) {
            Network n = new Network();
            n.setCountry(country[i]);
            n.setStockCatalog(dB4OUtilSC.retrieveSC(country[i].getStockMarket().toLowerCase()));
            for (Stock s : n.getStockCatalog().getStockList()) {
                s.setNetwork(n);
            }
            system.getNetworkDirectory().addNetwork(n);
            genFinEnterprise(n);
            genExpertEnterprise(n);
            genGovEnterprise(n);
        }

    }

    private static void genGovEnterprise(Network n) {

        Enterprise e = new GovernmentEnterprise("Gov");
        e.setInNetwork(n);
        n.getEnterpriseDirectory().addEnterprise(e);
        //enterprise admin
        UserAccount u = new UserAccount();
        Employee emp = new Employee(1);

        u.setPerson(emp);
        u.setUserName(e.getName().toLowerCase() + n.getId());
        u.setPassword(e.getName().toLowerCase() + n.getId());
        u.setRole(new EnterpriseAdminRole());

        emp.setUserAccount(u);
        emp.setAge(rm.nextInt((90 - 18) + 1) + 18);
        emp.setRole(Roles.RoleType.EnterpriseAdmin);
        emp.setSex(sex[rm.nextInt(sex.length)].name());
        emp.setImgIcon(getPofilePic(emp.getSex()));
        String f = fname[rm.nextInt(fname.length)].name();
        String l = lname[rm.nextInt(lname.length)].name();
        emp.setFirstName(f);
        emp.setLastName(l);
        emp.setEmailId(f + "_" + l + "@gmail.com");
        emp.setMobileNumber(Long.parseLong(mobilePrefix + rm.nextInt(99999)));
        e.getUserDirectory().addUserAccount(u);
        //---enterprise admin end

        //generate employees
        genEmployee(e);
        genGovOrg(e);

    }

    private static void genExpertEnterprise(Network n) {

        Enterprise e = new ExpertEnterprise("Expert");
        e.setInNetwork(n);
        n.getEnterpriseDirectory().addEnterprise(e);
        //enterprise admin
        UserAccount u = new UserAccount();
        Employee emp = new Employee(1);

        u.setPerson(emp);
        u.setUserName(e.getName().toLowerCase() + n.getId());
        u.setPassword(e.getName().toLowerCase() + n.getId());
        u.setRole(new EnterpriseAdminRole());

        emp.setUserAccount(u);
        emp.setAge(rm.nextInt((90 - 18) + 1) + 18);
        emp.setRole(Roles.RoleType.EnterpriseAdmin);
        emp.setSex(sex[rm.nextInt(sex.length)].name());
        emp.setImgIcon(getPofilePic(emp.getSex()));
        String f = fname[rm.nextInt(fname.length)].name();
        String l = lname[rm.nextInt(lname.length)].name();
        emp.setFirstName(f);
        emp.setLastName(l);
        emp.setEmailId(f + "_" + l + "@gmail.com");
        emp.setMobileNumber(Long.parseLong(mobilePrefix + rm.nextInt(99999)));
        e.getUserDirectory().addUserAccount(u);
        //---enterprise admin end

        //generate employees
        genEmployee(e);
        genExpertOrg(e);

    }

    private static void genFinEnterprise(Network n) {
        EnterpriseNames[] eNames = EnterpriseNames.values();

        for (int i = 0; i < eNames.length; i++) {
            Enterprise e = new FinancialEnterprise(eNames[i].name());
            e.setInNetwork(n);
            n.getEnterpriseDirectory().addEnterprise(e);
            //enterprise admin
            UserAccount u = new UserAccount();
            Employee emp = new Employee(1);

            u.setPerson(emp);
            u.setUserName(e.getName().substring(0, e.getName().indexOf('_')).toLowerCase() + n.getId());
            u.setPassword(e.getName().substring(0, e.getName().indexOf('_')).toLowerCase() + n.getId());
            u.setRole(new EnterpriseAdminRole());

            emp.setUserAccount(u);
            emp.setAge(rm.nextInt((90 - 18) + 1) + 18);
            emp.setRole(Roles.RoleType.EnterpriseAdmin);
            emp.setSex(sex[rm.nextInt(sex.length)].name());
            emp.setImgIcon(getPofilePic(emp.getSex()));
            String f = fname[rm.nextInt(fname.length)].name();
            String l = lname[rm.nextInt(lname.length)].name();
            emp.setFirstName(f);
            emp.setLastName(l);
            emp.setEmailId(f + "_" + l + "@gmail.com");
            emp.setMobileNumber(Long.parseLong(mobilePrefix + rm.nextInt(99999)));
            e.getUserDirectory().addUserAccount(u);
            //---enterprise admin end

            //generate employees
            genEmployee(e);
            genInvestmentOrg(e);
            genRegulatoryOrg(e);

        }

    }

    private static void genEmployee(Enterprise e) {
        int type = e.getType().getId();
        int emptype = -1;
        switch (type) {
            case 1:
                emptype = 4;
                break;
            case 2:
                emptype = 3;
                break;
            case 3:
                emptype = 2;
                break;
        }

        for (int i = 0; i < 10; i++) {
            //switch to 5 if type is 1
            if (type == 1 && i == 5) {
                emptype = 5;
            }

            Employee emp = new Employee(emptype);

            emp.setAge(rm.nextInt((90 - 18) + 1) + 18);

            emp.setSex(sex[rm.nextInt(sex.length)].name());
            emp.setImgIcon(getPofilePic(emp.getSex()));
            String f = fname[rm.nextInt(fname.length)].name();
            String l = lname[rm.nextInt(lname.length)].name();
            emp.setFirstName(f);
            emp.setLastName(l);
            emp.setEmailId(f + "_" + l + "@gmail.com");
            emp.setMobileNumber(Long.parseLong(mobilePrefix + rm.nextInt(99999)));
            e.getEmployeeDirectory().addEmployee(emp);
        }
    }

    static void genInvestmentOrg(Enterprise e) {

        Organisation o = new InvestmentAndRiskOrganization("InvestAndRisk");
        o.setInEnterprise(e);
        e.getOrganisationDirectory().addOrganisation(o);
        if (e.getInNetwork().getCountry().name().equals("India")) {
            Offices_India[] office = Offices_India.values();
            o.setOffice(office[rm.nextInt(office.length)].name());
        } else if (e.getInNetwork().getCountry().name().equals("USA")) {
            Offices_USA[] office = Offices_USA.values();
            o.setOffice(office[rm.nextInt(office.length)].name());
        } else {
            Offices_Germany[] office = Offices_Germany.values();
            o.setOffice(office[rm.nextInt(office.length)].name());
        }
        List<Employee> empList = e.getEmployeeDirectory().getEmployeeList();
        for (int i = 0; i < empList.size() / 2; i++) {

            Employee emp = empList.get(i);
            UserAccount u = getUserAccount(o, emp.getFirstName(), emp.getLastName());
            u.setPerson(emp);
            u.setRole(new EmployeeInvestmentAndRiskRole());
            emp.setUserAccount(u);
            o.getUserDirectory().addUserAccount(u);
        }
    }

    static void genRegulatoryOrg(Enterprise e) {

        Organisation o = new RegulatroyOrganization("Regulatory");
        o.setInEnterprise(e);
        e.getOrganisationDirectory().addOrganisation(o);
        if (e.getInNetwork().getCountry().name().equals("India")) {
            Offices_India[] office = Offices_India.values();
            o.setOffice(office[rm.nextInt(office.length)].name());
        } else if (e.getInNetwork().getCountry().name().equals("USA")) {
            Offices_USA[] office = Offices_USA.values();
            o.setOffice(office[rm.nextInt(office.length)].name());
        } else {
            Offices_Germany[] office = Offices_Germany.values();
            o.setOffice(office[rm.nextInt(office.length)].name());
        }
        List<Employee> empList = e.getEmployeeDirectory().getEmployeeList();
        for (int i = empList.size() / 2; i < empList.size(); i++) {

            Employee emp = empList.get(i);
            UserAccount u = getUserAccount(o, emp.getFirstName(), emp.getLastName());
            u.setPerson(emp);
            u.setRole(new EmployeeRegulatoryRole());
            emp.setUserAccount(u);
            o.getUserDirectory().addUserAccount(u);
        }
    }

    static void genExpertOrg(Enterprise e) {

        Organisation o = new ExpertOrganization("Expert Organisation");
        o.setInEnterprise(e);
        e.getOrganisationDirectory().addOrganisation(o);
        if (e.getInNetwork().getCountry().name().equals("India")) {
            Offices_India[] office = Offices_India.values();
            o.setOffice(office[rm.nextInt(office.length)].name());
        } else if (e.getInNetwork().getCountry().name().equals("USA")) {
            Offices_USA[] office = Offices_USA.values();
            o.setOffice(office[rm.nextInt(office.length)].name());
        } else {
            Offices_Germany[] office = Offices_Germany.values();
            o.setOffice(office[rm.nextInt(office.length)].name());
        }
        List<Employee> empList = e.getEmployeeDirectory().getEmployeeList();
        for (int i = 0; i < empList.size(); i++) {

            Employee emp = empList.get(i);
            UserAccount u = getUserAccount(o, emp.getFirstName(), emp.getLastName());
            u.setPerson(emp);
            u.setRole(new ExpertRole());
            emp.setUserAccount(u);
            o.getUserDirectory().addUserAccount(u);
        }
    }

    static void genGovOrg(Enterprise e) {

        Organisation o = new GovernmentOrganization("Government Organisation");
        o.setInEnterprise(e);
        e.getOrganisationDirectory().addOrganisation(o);
        if (e.getInNetwork().getCountry().name().equals("India")) {
            Offices_India[] office = Offices_India.values();
            o.setOffice(office[rm.nextInt(office.length)].name());
        } else if (e.getInNetwork().getCountry().name().equals("USA")) {
            Offices_USA[] office = Offices_USA.values();
            o.setOffice(office[rm.nextInt(office.length)].name());
        } else {
            Offices_Germany[] office = Offices_Germany.values();
            o.setOffice(office[rm.nextInt(office.length)].name());
        }
        List<Employee> empList = e.getEmployeeDirectory().getEmployeeList();
        for (int i = 0; i < empList.size(); i++) {

            Employee emp = empList.get(i);
            UserAccount u = getUserAccount(o, emp.getFirstName(), emp.getLastName());
            u.setPerson(emp);
            u.setRole(new GovermentRole());
            emp.setUserAccount(u);
            o.getUserDirectory().addUserAccount(u);
        }
    }

    private static void loadCustomer() {

        for (int i = 0; i < 20; i++) {
            Customer c = new Customer();
            c.setAge(rm.nextInt((90 - 18) + 1) + 18);
            c.setRole(Roles.RoleType.Customer);
            c.setSex(sex[rm.nextInt(sex.length)].name());
            c.setImgIcon(getPofilePic(c.getSex()));
            String f = fname[rm.nextInt(fname.length)].name();
            String l = lname[rm.nextInt(lname.length)].name();
            c.setFirstName(f);
            c.setLastName(l);
            c.setEmailId(f + "_" + l + "@gmail.com");
            c.setMobileNumber(Long.parseLong(mobilePrefix + rm.nextInt(99999)));
            UserAccount u = new UserAccount();
            String userName = (l.substring(0, 4) + "." + f.substring(0, 1)).toLowerCase();
            int j = 2;
            while (system.getCustomerDirectory().searchCustomerByUserName(userName) != null) {
                userName = (l.substring(0, 4) + "." + f.substring(0, j++)).toLowerCase();
            }
            u.setUserName(userName);
            u.setPassword(userName + "123");
            u.setIsActive(true);
            u.setRole(new CustomerRole());
            u.setPerson(c);
            c.setUserAccount(u);
            system.getCustomerDirectory().addCustomer(c);
        }

    }

    private static UserAccount getUserAccount(Organisation o, String f, String l) {
        UserAccount u = new UserAccount();
        String userName = (l.substring(0, 4) + "." + f.substring(0, 1)).toLowerCase();
        int i = 2;
        while (o.getUserDirectory().findUser(userName) != null) {
            userName = (l.substring(0, 4) + "." + f.substring(0, i++)).toLowerCase();
        }
        u.setUserName(userName);
        u.setPassword(userName +o.getOrganisationId());

        return u;
    }

    static void EnterpriseRequests() throws ParseException {

        for (Network n : nd.getNetworkList()) {
            for (Enterprise enter : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (enter instanceof GovernmentEnterprise) {
                    GovEnt(enter);
                }
            }
        }

        for (Network n : nd.getNetworkList()) {
            for (Enterprise enter : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (enter instanceof FinancialEnterprise) {
                    FinEnt(enter);
                }
            }
        }
        for (Network n : nd.getNetworkList()) {
            for (Enterprise enter : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (enter instanceof ExpertEnterprise) {
                    ExpEnt(enter);
                }
            }
        }
    }

    private static void ExpEnt(Enterprise ee) {

        Organisation exp = null;
        for (Organisation o : ee.getOrganisationDirectory().getOrganisationList()) {
            if (o instanceof ExpertOrganization) {
                exp = o;
                break;
            }
        }

        for (int i = 0; i < 50; i++) {

            AdviceWorkRequest wr = new AdviceWorkRequest();
            exp.getWorkQueue().addWorkRequest(wr);
            wr.setOrganisation(exp);
            Customer c = cd.getCustomerList()
                    .get(rm.nextInt(cd.getCustomerList().size()));
            c.getWorkQueue().addWorkRequest(wr);
            wr.setSender(c.getUserAccount());
            wr.setRequestDate(generateDate());
            wr.setRisk(risk[rm.nextInt(risk.length)]);

            switch (rm.nextInt(3)) {
                case 0:
                    wr.setStatus("Requested");
                    break;
                case 1:
                    wr.setReceiver(exp.getUserDirectory().getUserAccountList()
                            .get(rm.nextInt(exp.getUserDirectory().getUserAccountList().size())));
                    wr.setStatus("Processing");
                    break;
                case 2:
                    wr.setReceiver(exp.getUserDirectory().getUserAccountList()
                            .get(rm.nextInt(exp.getUserDirectory().getUserAccountList().size())));
                    wr.setResolveDate(futureDate(wr.getRequestDate()));
                    wr.setStatus("Completed");

                    List<Stock> ls = wr.getStockList();
                    List<Network> ln = wr.getNetworks();

                    Network n = ee.getInNetwork();
                    ln.add(n);
                    int j = 0;
                    do {
                        Stock s = n.getStockCatalog().getStockList().get(rm.nextInt(n.getStockCatalog().getStockList().size()));
                        if (ls.contains(s)) {
                            continue;
                        }
                        ls.add(s);
                        j++;
                    } while (j <= 10);

                    break;
            }
        }

    }

    private static void GovEnt(Enterprise ge) throws ParseException {
        Organisation gov = null;
        for (Organisation o : ge.getOrganisationDirectory().getOrganisationList()) {
            if (o instanceof GovernmentOrganization) {
                gov = o;
                break;
            }
        }

        for (int i = 0; i < 100; i++) {

            GovernmentWorkRequest wr = new GovernmentWorkRequest();
            gov.getWorkQueue().addWorkRequest(wr);
            wr.setOrganisation(gov);
            Customer c = cd.getCustomerList()
                    .get(rm.nextInt(cd.getCustomerList().size()));
            Employee emp = ge.getEmployeeDirectory().getEmployeeList()
                    .get(rm.nextInt(ge.getEmployeeDirectory().getEmployeeList().size()));
            genSpeakerSessions(emp, ge.getInNetwork());
            wr.setSender(emp.getUserAccount());
            wr.setRequestDate(generateDate());
            wr.setCustomer(c);
            wr.setStatus("Processing");
            for (Enterprise e : ge.getInNetwork().getEnterpriseDirectory().getEnterpriseList()) {
                if (e instanceof FinancialEnterprise) {
                    for (Organisation o : e.getOrganisationDirectory().getOrganisationList()) {
                        if (o instanceof RegulatroyOrganization) {
                            o.getWorkQueue().addWorkRequest(wr);
                            wr.getEnterpriseInvestMap().put(e, null);
                            break;
                        }
                    }
                }
            }
        }

    }

    private static void genSpeakerSessions(Employee e, Network n) {

        for (int j = 0; j < 10; j++) {
            SpeakerSession s = new SpeakerSession();
            n.getSpeakerSessionList().add(s);
            s.setCapacity(rm.nextBoolean() ? 50 : 100);
            s.setDate(rm.nextBoolean() ? futureDate(new Date()) : generateDate());
            s.setStartTime(genTime());
            s.setEndTime(after(s.getStartTime()));
            s.setStatus("Active");
            s.setSpeaker(e);

            for (int i = 0; i < rm.nextInt(10); i++) {

                Customer c = cd.getCustomerList()
                        .get(rm.nextInt(cd.getCustomerList().size()));
                s.getRegisteredCustomerList().add(c);
                c.getRegisteredSessionsList().add(s);
            }
        }
    }

    private static void FinEnt(Enterprise fe) {

        Organisation invest = null;
        for (Organisation o : fe.getOrganisationDirectory().getOrganisationList()) {
            if (o instanceof InvestmentAndRiskOrganization) {
                invest = o;
                break;
            }
        }
        //AdviceWorkRequest
        for (int i = 0; i < 50; i++) {

            AdviceWorkRequest wr = new AdviceWorkRequest();
            invest.getWorkQueue().addWorkRequest(wr);
            wr.setOrganisation(invest);
            Customer c = cd.getCustomerList()
                    .get(rm.nextInt(cd.getCustomerList().size()));
            c.getWorkQueue().addWorkRequest(wr);
            wr.setSender(c.getUserAccount());
            wr.setRequestDate(generateDate());
            wr.setRisk(risk[rm.nextInt(risk.length)]);
            NetworkList(wr);
            switch (rm.nextInt(3)) {
                case 0:
                    wr.setStatus("Requested");
                    break;
                case 1:
                    wr.setReceiver(invest.getUserDirectory().getUserAccountList()
                            .get(rm.nextInt(invest.getUserDirectory().getUserAccountList().size())));
                    wr.setStatus("Processing");
                    break;
                case 2:
                    wr.setReceiver(invest.getUserDirectory().getUserAccountList()
                            .get(rm.nextInt(invest.getUserDirectory().getUserAccountList().size())));
                    wr.setResolveDate(futureDate(wr.getRequestDate()));
                    wr.setStatus("Completed");
                    stock(wr);
                    break;
            }
        }
        //InvestmentWorkRequest
        for (int i = 0; i < 50; i++) {

            InvestmentWorkRequest wr = new InvestmentWorkRequest(rm.nextInt(2));
            invest.getWorkQueue().addWorkRequest(wr);
            wr.setOrganisation(invest);
            Customer c = cd.getCustomerList()
                    .get(rm.nextInt(cd.getCustomerList().size()));
            c.getWorkQueue().addWorkRequest(wr);
            wr.setSender(c.getUserAccount());
            wr.setRequestDate(generateDate());
            wr.getInvestment().setFromCountry(fe.getInNetwork().getCountry());
            wr.getInvestment().setCustomer(c);

            UserAccount u = invest.getUserDirectory().getUserAccountList()
                    .get(rm.nextInt(invest.getUserDirectory().getUserAccountList().size()));
            switch (rm.nextInt(3)) {
                case 0:
                    wr.setStatus("Requested");
                    break;
                case 1:
                    wr.setStatus("Processing");
                    wr.setReceiver(u);
                    wr.getInvestment().setEmployee((Employee) u.getPerson());
                    break;
                case 2:
                    wr.setResolveDate(futureDate(wr.getRequestDate()));
                    wr.setStatus("Completed");
                    wr.setReceiver(u);
                    wr.getInvestment().setEmployee((Employee) u.getPerson());
                    wr.getInvestment().setDate(wr.getResolveDate());
                    break;
            }
            genInvestment(wr);
            wr.getInvestment().setCustomer(c);
            if (wr.getStatus().equals("Completed")) {
                c.addInvestment(wr.getInvestment());
                Employee emp = (Employee) u.getPerson();
                emp.addInvestment(wr.getInvestment());
            }

        }

        invest = null;
        for (Organisation o : fe.getOrganisationDirectory().getOrganisationList()) {
            if (o instanceof RegulatroyOrganization) {
                invest = o;
                break;
            }
        }
        //GovernmentWorkRequest

        GovernmentWorkRequest gwr;
        for (WorkRequest wr : invest.getWorkQueue().getWorkRequestList()) {
            if (wr instanceof GovernmentWorkRequest) {

                if (rm.nextBoolean()) {
                    List<Investment> toSend = new ArrayList<>();
                    gwr = (GovernmentWorkRequest) wr;
                    Customer c = gwr.getCustomer();
                    for (Employee e : fe.getEmployeeDirectory().getEmployeeList()) {
                        for (Investment invested : e.getInvestmentList()) {
                            if (invested.getCustomer() == c) {
                                toSend.add(invested);
                            }
                        }
                    }
                    gwr.putMap(fe, toSend);
                }

            }

        }

    }

    private static void genInvestment(InvestmentWorkRequest wr) {

        Investment inv = wr.getInvestment();
        List<Stock> ls = new ArrayList<>();

        int k = rm.nextInt(3) + 1;
        for (int i = 0; i < k; i++) {
            Network n = nd.getNetworkList().get(i);

            int j = 0;
            do {

                Stock s = n.getStockCatalog().getStockList().get(rm.nextInt(n.getStockCatalog().getStockList().size()));
                if (ls.contains(s)) {
                    continue;
                }
                InvestmentItem item = new InvestmentItem();
                item.setStock(s);
                item.setQuantity(rm.nextInt(500) + 100);

                if (wr.getStatus().equals("Completed")) {
                    double price = 0;
                    Network enterpriseNetwork = wr.getOrganisation().getInEnterprise().getInNetwork();
                    Network stockNetwork = s.getNetwork();
                    try {
                        price = item.getStock().getStockHistoryList().get(0).getPrice();
                    } catch (Exception e) {
                        System.out.println("failed price for: " + item.getStock().getSymbol());
                    }
                    if (stockNetwork != enterpriseNetwork) {
                        price *= Utilities.getConversionRate(stockNetwork.getCountry().getValue(), enterpriseNetwork.getCountry().getValue());
                    }

                    item.setPrice(price);
                }

                inv.addInvestmentItem(item);
                ls.add(s);
                j++;
            } while (j <= 10);

        }

    }

    private static void NetworkList(AdviceWorkRequest wr) {

        List<Network> ln = new ArrayList<>();
        wr.setNetworks(ln);
        int k = rm.nextInt(3) + 1;
        for (int i = 0; i < k; i++) {
            Network n = nd.getNetworkList().get(i);
            ln.add(n);

        }
    }

    private static void stock(AdviceWorkRequest wr) {
        int j = 0;
        List<Stock> ls = wr.getStockList();

        for (Network n : wr.getNetworks()) {
            do {
                Stock s = n.getStockCatalog().getStockList().get(rm.nextInt(n.getStockCatalog().getStockList().size()));
                if (ls.contains(s)) {
                    continue;
                }
                ls.add(s);
                j++;
            } while (j <= 10);
        }
    }

    private static Date generateDate() {
        LocalDate localDate;
        try {

            localDate = LocalDate.now().minus(Period.ofDays((rm.nextInt(50))));

            SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
            String date = localDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US) + " " + localDate.getDayOfMonth() + ", " + localDate.getYear();
            return sdf.parse(date);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error while parsing date. Kindly check the data being loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    static Date futureDate(Date d) {
        LocalDate parsedDate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate addedDate = parsedDate.plusDays(rm.nextInt(4));
        Date date = Date.from(addedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return date;
    }

    public static Time genTime() {
        DateFormat formatter = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String str_date1 = "17-June-18 08:00:00";
        String str_date2 = "17-June-18 23:00:00";

        try {
            cal.setTime(formatter.parse(str_date1));
        } catch (ParseException ex) {
            Logger.getLogger(Configure.class.getName()).log(Level.SEVERE, null, ex);
        }
        Long value1 = cal.getTimeInMillis();

        try {
            cal.setTime(formatter.parse(str_date2));
        } catch (ParseException ex) {
            Logger.getLogger(Configure.class.getName()).log(Level.SEVERE, null, ex);
        }
        Long value2 = cal.getTimeInMillis();

        long value3 = (long) (value1 + new Random().nextInt((int) (value2 - value1)));
        cal.setTimeInMillis(value3);
        return new Time(cal.getTimeInMillis());

    }

    public static Time after(Date date) {

        DateFormat formatter = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String str_date1 = "15-June-18 " + date.toString();
        String str_date2 = "15-June-19 23:59:59";
        try {
            cal.setTime(formatter.parse(str_date1));
        } catch (ParseException ex) {
            Logger.getLogger(Configure.class.getName()).log(Level.SEVERE, null, ex);
        }
        Long value1 = cal.getTimeInMillis();

        try {
            cal.setTime(formatter.parse(str_date2));
        } catch (ParseException ex) {
            Logger.getLogger(Configure.class.getName()).log(Level.SEVERE, null, ex);
        }
        Long value2 = cal.getTimeInMillis();

        long value3 = (long) (value1 + Math.random() * (value2 - value1));
        cal.setTimeInMillis(value3);
        return new Time(cal.getTimeInMillis());

    }

    private static ImageIcon getPofilePic(String sex) {
        ImageIcon icon = null;
        int bound = 0;
        if (sex.equals("Male")) {
            bound = 18;
        } else {
            bound = 13;
        }
        int select = rm.nextInt(bound) + 1;
        String FILENAME = System.getProperty("user.dir") + "\\png\\" + sex + " (" + select + ").png"; // path to the data store`
        File file = new File(FILENAME);

        try {

            Image i = ImageIO.read(file);
            i=i.getScaledInstance(40,40, Image.SCALE_SMOOTH);
            icon = new ImageIcon(i);

        } catch (IOException ex) {
            
            System.out.println("problem accessing file" + ex.getMessage());
        }
        if(icon==null)
            System.out.println();
        return icon;

    }
}
