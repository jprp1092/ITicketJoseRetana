/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iticket.Service;

import com.iticket.Entity.Conciertos;
import com.iticket.Repository.ConciertosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joser
 */
@Service
public class ConciertosService implements IConciertosService{
    
    @Autowired
    private ConciertosRepository conciertosRepository;

    @Override
    public List<Conciertos> getAllConciertos() {
        return (List<Conciertos>)conciertosRepository.findAll();
    }

    @Override
    public Conciertos getConciertosById(long id) {
        return conciertosRepository.findById(id).orElse(null);
    }

    @Override
    public void saveConciertos(Conciertos conciertos) {
        conciertosRepository.save(conciertos);
    }

    @Override
    public void delete(long id) {
        conciertosRepository.deleteById(id);
    }
    
}
