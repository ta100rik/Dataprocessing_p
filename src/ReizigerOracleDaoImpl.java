import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigerDao {

    @Override
    public List<Reiziger> findAll() {
        List<Reiziger> lijst = new ArrayList<>();

        try {
            Connection con = getConnection();
            Statement stmt = null;

            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from reiziger");
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            while (rs.next()) {

                Reiziger persoon = new Reiziger();
                persoon.setReizigerid(rs.getString("REIZIGERID"));
                persoon.setVoornaam(rs.getString("Voorletters"));
                persoon.setTussenvoegsel(rs.getString("TUSSENVOEGSEL"));
                persoon.setAchternaam(rs.getString("ACHTERNAAM"));;
                persoon.setGbdatum(rs.getString("GEBORTEDATUM"));
                if(persoon != null){
                    lijst.add(persoon);
                }
            }
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lijst;
    }
    public Reiziger save(Reiziger reiziger){
        try {
            Connection con = getConnection();
            Statement stmt = null;
            stmt = con.createStatement();
            String query = " insert into REIZIGER (VOORLETTERS, TUSSENVOEGSEL,ACHTERNAAM, GEBORTEDATUM)"
                    + " values (?, ?, ?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            System.out.println(reiziger);
            preparedStmt.setString (1, reiziger.getVoornaam());
            preparedStmt.setString (2, reiziger.getTussenvoegsel());
            preparedStmt.setString (3, reiziger.getAchternaam());
            preparedStmt.setString  (4, reiziger.getGbdatum());
            preparedStmt.execute();

            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reiziger;
    }
    public Reiziger update(Reiziger reiziger){
        try
        {
            Connection con = getConnection();
            String query = "update users set VOORLETTERS = ? , TUSSENVOEGSEL = ?, ACHTERNAAM = ?, GEBORTEDATUM = ?  where REIZIGERID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString   (1, reiziger.getVoornaam());
            preparedStmt.setString   (2, reiziger.getTussenvoegsel());
            preparedStmt.setString   (3, reiziger.getAchternaam());
            preparedStmt.setString   (4, reiziger.getGbdatum());
            preparedStmt.setString   (5, reiziger.getReizigerid());




            preparedStmt.executeUpdate();

            closeConnection();

        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return reiziger;
    }

}
