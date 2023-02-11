import utils.Datasource;
import entite.Personne;
import service.servicepersonne;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  {
        Datasource ds1= new Datasource().getInstance();
        System.out.println(ds1);
        Personne p=new Personne("3a9", "test", 23);
        Personne p1=new Personne("3a9", "test1", 20);
        Personne p2=new Personne(5,"3", "0", 2);
        servicepersonne ps=new servicepersonne();
       // ps.insert(p);
       // ps.insert(p1);
       // ps.insert(p2);
        //ps.readall().forEach(System.out::println);
        //ps.delete(p2);
        //ps.readall().forEach(System.out::println);
        ps.update(p2);

    }
}