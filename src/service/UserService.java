/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connexion.Connexion;
import dao.IDao;
import entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class UserService implements IDao<User>{

    @Override
    public boolean create(User o) {
        try {
            String req1 = "select count(*) as total from user where login = ? and email = ?";
            PreparedStatement ps1 = Connexion.getConnection().prepareStatement(req1);
            ps1.setString(1, o.getLogin());
            ps1.setString(2, o.getEmail());
            ResultSet rs = ps1.executeQuery();
            if (rs.next() && rs.getInt("total") == 1)
                return false;
            else {
                String req2 = "insert into user values (null, ?, ?, ?, ?, ?)";
                PreparedStatement ps2 = Connexion.getConnection().prepareStatement(req2);
                ps2.setString(1, o.getNom());
                ps2.setString(2, o.getPrenom());
                ps2.setString(3, o.getLogin());
                ps2.setString(4, o.getEmail());
                ps2.setString(5, o.getPassword()); 
                if (ps2.executeUpdate() == 1)
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(User o) {
        try {
            String req = "delete from user where id = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, o.getId());
            if (pr.executeUpdate() == 1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(User o) {
        String req = "update user set nom = ?, prenom = ?, login = ?, email = ?, password = ? where id = ?";
        try {
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1, o.getNom());
            pr.setString(2, o.getPrenom());
            pr.setString(3, o.getLogin());
            pr.setString(4, o.getEmail());
            pr.setString(5, o.getPassword());
            pr.setInt(6, o.getId());
            if (pr.executeUpdate() == 1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findById(int id) {
        try {
            String req = "select * from user where id = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next())
                return new User(rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("login"),
                        rs.getString("email"),
                        rs.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList();
        try {
            String req = "select * from user";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next())
                users.add(new User(rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("login"),
                        rs.getString("email"),
                        rs.getString("password")));
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;    
    }
 
    public User findByLoginAndEmail(String login, String email) {
        try {
            String req = "select * from user where login = ? and email = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1,login);
            pr.setString(2,email);
            ResultSet rs = pr.executeQuery();
            if (rs.next())
                 return new User(rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("login"),
                        rs.getString("email"),
                        rs.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public User findByEmail(String email) {
        try {
            String req = "select * from user where email = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1,email);
            ResultSet rs = pr.executeQuery();
            if (rs.next())
                 return new User(rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("login"),
                        rs.getString("email"),
                        rs.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean updatePassword(String password, User user) {
        String req = "update user set password = ? where id = ?";
        try {
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1, password);
            pr.setInt(2, user.getId());
            if (pr.executeUpdate() == 1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
