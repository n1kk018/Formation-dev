package fr.afcepf.al28.bank.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al28.bank.dao.impl.IDaoCompte;
import fr.afcepf.al28.bank.dao.impl.IDaoUtilisateur;
import fr.afcepf.al28.bank.entity.Compte;
import fr.afcepf.al28.bank.entity.Operation;
import fr.afcepf.al28.bank.entity.Utilisateur;

@Service
public class BizClient implements IBizClient {
	private IDaoUtilisateur dao;
	private IDaoCompte daoCpt;
	
	@Autowired
	public void setDao(IDaoUtilisateur dao){
		this.dao = dao;
	}
	@Autowired
	public void setDaoCpt(IDaoCompte dao){
		this.daoCpt = dao;
	}
	@Override
	public Utilisateur Login(Utilisateur u) {
		return this.dao.getByLoginAndMdp(u.getEmail(),u.getMdp());
	}
	@Override
	public List<Operation> getOperationsByIdCompte(Integer id) {
		return this.daoCpt.getOperationsByIdCompte(id);
	}

}
