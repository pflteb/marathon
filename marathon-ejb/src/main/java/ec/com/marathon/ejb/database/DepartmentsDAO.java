/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.marathon.ejb.database;

import ec.com.marathon.ejb.Departments;
import ec.com.marathon.ejb.db;
import javax.ejb.Stateless;

/**
 *
 * @author esteb
 */
@Stateless
public class DepartmentsDAO extends db<Departments> {

    public DepartmentsDAO() {
        super(Departments.class);
    }

}
