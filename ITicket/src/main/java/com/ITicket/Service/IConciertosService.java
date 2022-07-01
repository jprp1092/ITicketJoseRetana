/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.iticket.Service;

import com.iticket.Entity.Conciertos;
import java.util.List;

/**
 *
 * @author joser
 */
public interface IConciertosService {

    public List<Conciertos> getAllConciertos();

    public Conciertos getConciertosById(long id);

    public void saveConciertos(Conciertos conciertos);

    public void delete(long id);
}
