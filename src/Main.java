import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args){
        ReizigerOracleDaoImpl dao = new ReizigerOracleDaoImpl();
        List<Reiziger> allpersons = dao.findAll();
        Reiziger newperson = new Reiziger();
        newperson.setVoornaam("Zyad");
        newperson.setAchternaam("Osseyran");
        newperson = dao.save(newperson);


    }
}

