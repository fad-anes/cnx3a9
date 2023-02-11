package service;

import entite.Personne;
import java.util.List;
import utils.Datasource;
import java.sql.Connection;

public class servicepersonne implements Iservice<Personne>{
    private Connection conn;
    public servicepersonne(){
        conn=Datasource.getInstance().getCnx();
    }


    @Override
    public void insert(Personne personne) {

    }

    @Override
    public void delete(Personne personne) {

    }

    @Override
    public void update(Personne personne) {

    }

    @Override
    public List<Personne> readall() {
        return null;
    }

    @Override
    public Personne ReadById(int id) {
        return null;
    }
}
