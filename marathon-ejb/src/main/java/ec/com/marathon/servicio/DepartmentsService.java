/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.marathon.servicio;

import ec.com.marathon.ejb.Departments;
import ec.com.marathon.ejb.database.DepartmentsDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author esteb
 */
@Stateless
@LocalBean
public class DepartmentsService {

    @EJB
    private DepartmentsDAO departmentDAO;

    /**
     * List
     *
     * @return
     * @throws Exception
     */
    public List<Departments> listAll() throws Exception {
        return departmentDAO.findAll();
    }

    /**
     * Create
     *
     * @param departments
     * @throws Exception
     */
    public void create(Departments departments) throws Exception {
        departmentDAO.create(departments);
    }

    /**
     * Update
     *
     * @param departments
     * @throws Exception
     */
    public void update(Departments departments) throws Exception {
        departmentDAO.edit(departments);
    }

}
