package fr.afcepf.al28.ria.dao;

import java.util.List;

import javax.ejb.Local;

import fr.afcepf.al28.ria.entities.PetitChien;

public interface IDaoChien {
    List<PetitChien> getAllChiens();
    PetitChien findById(Integer id);
    void addChien(PetitChien chien);
}
