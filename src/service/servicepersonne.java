package service;

import entite.Personne;
import java.util.List;
import utils.Datasource;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class servicepersonne implements Iservice<Personne>{
    private Connection conn;
    public servicepersonne(){
        conn=Datasource.getInstance().getCnx();
    }


    @Override
    public void insert(Personne t) {
        String requete = "insert into personne (nom,prenom,age) values "
                + "('" + t.getNom() + "','" + t.getPrenom() + "'," + t.getAge() + ")";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(servicepersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Personne t) {
        String requete3 = "DELETE FROM personne WHERE id=" + t.getId();
        try {
            Statement st = conn.createStatement();
            st.execute(requete3);
            System.out.println(" personne  supprimé !");

        } catch (SQLException ex) {
            Logger.getLogger(servicepersonne.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void update(Personne t) {
        String requete2 =
        " UPDATE personne SET " + " nom = ?,prenom=?," +
                " age = ?  WHERE id= " + t.getId();
        try {
            PreparedStatement pst = conn.prepareStatement(requete2);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setInt(3, t.getAge());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(servicepersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Personne> readall() {
        List<Personne> list=new ArrayList<>();
        String requete="select * from personne";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(requete);
            while(rs.next()){
                Personne p=new Personne(rs.getInt("id"), rs.getString(2),
                        rs.getString("prenom"), rs.getInt("age"));
                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(servicepersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Personne ReadById(int id) {
        Personne p0=new Personne();
        String requete0="select * from personne WHERE id="+id;
        try {

            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(requete0);
            rs.next();
            Personne p=new Personne(rs.getInt("id"), rs.getString(2),
                    rs.getString("prenom"), rs.getInt("age"));
            p0=p;
        } catch (SQLException ex) {
            Logger.getLogger(servicepersonne.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p0;
    }
}
