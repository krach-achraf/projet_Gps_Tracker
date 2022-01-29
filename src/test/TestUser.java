/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.User;
import service.UserService;
import sécurite.Hash;

/**
 *
 * @author HP
 */
public class TestUser {

    public static void main(String[] args) {
        UserService us = new UserService();
        String password1 = Hash.encrypt("123456");
        String password2 = Hash.encrypt("123456789");
        String password3 = Hash.encrypt("987654321");
        us.create(new User("krach", "achraf", "achrafKr","krachachraf98@gmail.com", password1));
        us.create(new User("marouan", "mohammed", "mMarouan","marouan@gmail.com", password2));
        us.create(new User("bennani", "ahmed", "bennaniAhmed","bennani@gmail.com", password3));
    }
}
