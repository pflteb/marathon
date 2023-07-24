package com.ec.mthonec.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author esteb
 */
@ViewScoped
@Named
public class GeneralBean implements Serializable {


    @PostConstruct
    public void init() {

    }

}
