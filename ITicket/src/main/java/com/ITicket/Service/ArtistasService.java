/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iticket.Service;

import com.iticket.Entity.Artistas;
import com.iticket.Repository.ArtistasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joser
 */
@Service
public class ArtistasService implements IArtistasService {

    @Autowired
    private ArtistasRepository artistasRepository;

    @Override
    public List<Artistas> listArtistas() {
        return (List <Artistas>)artistasRepository.findAll();
    }

}
