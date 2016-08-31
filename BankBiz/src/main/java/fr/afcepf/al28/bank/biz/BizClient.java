package fr.afcepf.al28.bank.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al28.bank.dao.IDaoUtilisateur;
import fr.afcepf.al28.bank.entity.Utilisateur;

@Service
public class BizClient implements IBizClient {
	private IDaoUtilisateur dao;
	
	@Autowired
	public void setDao(IDaoUtilisateur dao){
		this.dao = dao;
	}
	@Override
	public Utilisateur Login(Utilisateur u) {
		return this.dao.getByLoginAndMdp(u.getEmail(),u.getMdp());
	}

}
