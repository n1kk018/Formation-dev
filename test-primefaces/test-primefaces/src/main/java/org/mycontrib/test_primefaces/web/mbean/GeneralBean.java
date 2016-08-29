package org.mycontrib.test_primefaces.web.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.mycontrib.test_primefaces.web.data.Continent;
import org.mycontrib.test_primefaces.web.data.Departement;
import org.mycontrib.test_primefaces.web.data.Region;
import org.mycontrib.test_primefaces.web.data.User;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean
@SessionScoped
public class GeneralBean {
	
	private User user = new User();
	
	private List<String> listImageName; //for image switch effect
	private List<String> listPhotoName; //for galleria
	
	private List<Continent> listeContinents  = new ArrayList<Continent>();
	private List<Continent> selectedContinents  = new ArrayList<Continent>(); //for drag & drop selection
	private Continent currentSelectedCont ; //pour afficher details apres selection (apres drag/drop dataTable)
	
	private List<String> listePays = new ArrayList<String>();
	
	private TreeNode franceRoot = new DefaultTreeNode("France",null); 
	private TreeNode selectedNode ;
	private String message=null;
	
	private String codeCouleur;//pour p:colorPicker
	private String htmlText;//pour p:editor
	
	private String pays;
	
	private String txt1;

	public String  reInitContinents(){
		listeContinents.clear();
		listeContinents.add(new Continent("Europe","Europe.png",10180000L));
		listeContinents.add(new Continent("Afrique","Afrique.png",30415873L));
		listeContinents.add(new Continent("Asie","Asie.png",43810582L));
		listeContinents.add(new Continent("Amerique","Amerique.png",42189120L ));
		listeContinents.add(new Continent("Oceanie","Oceanie.png",9008458L));
		listeContinents.add(new Continent("Antarctique","Antarctique.png",14107637L));
		Continent atlantide = new Continent("Atlandite","Atlantide.png",0L); atlantide.setType("notExist");
		listeContinents.add(atlantide);
		
		selectedContinents.clear();
		currentSelectedCont=null;
		return null;
	}
	
	public GeneralBean(){
		listePays.add("France"); listePays.add("Allemagne"); listePays.add("Portugal");  listePays.add("Russie");
		listePays.add("Belgique"); listePays.add("Italie"); listePays.add("Espagne"); listePays.add("Royaumes unis");
		listePays.add("Finlande"); listePays.add("Suede"); listePays.add("Luxembourg"); listePays.add("USA");
		listePays.add("Suisse"); listePays.add("Pays bas"); listePays.add("Danemark"); listePays.add("Norvege");
		listePays.add("Ukraine"); listePays.add("Roumanie"); listePays.add("Pologne"); listePays.add("Autriche");
		//java.util.Collections.sort(listePays);//ne pas trier pour test orderList et autres
		
		TreeNode picardie = new DefaultTreeNode(new Region("Picardie"),franceRoot);
		TreeNode oise = new DefaultTreeNode(new Departement(60,"Oise","Beauvais"),picardie);
		TreeNode aisne = new DefaultTreeNode(new Departement(2,"Aisne","Laon"),picardie);
		TreeNode somme = new DefaultTreeNode(new Departement(80,"Somme","Amiens"),picardie);
		
		TreeNode idf = new DefaultTreeNode(new Region("Ile de France"),franceRoot);
		TreeNode paris = new DefaultTreeNode(new Departement(75,"Paris"),idf);
		TreeNode yvelines = new DefaultTreeNode(new Departement(78,"Yvelines"),idf);
		TreeNode hautsDeSeine = new DefaultTreeNode(new Departement(92,"HautsDeSeine"),idf);
		TreeNode autresDepIdf = new DefaultTreeNode(new Departement(0,"autres departements ..."),idf);
		
		TreeNode autresRegions = new DefaultTreeNode(new Region("Autres regions"),franceRoot);
		
		reInitContinents();
		
		listImageName = new ArrayList<String>();  
		listImageName.add("nature1.jpg");  
		listImageName.add("nature2.jpg");  
		listImageName.add("nature3.jpg");  
		listImageName.add("nature4.jpg");  
		
		listPhotoName = new ArrayList<String>();  		  
	        for(int i=1;i<=12;i++) {  
	        	listPhotoName.add("photo" + i + ".jpg");  
	        }  
	}
	
	//tree valueChangeListener:
	public void onSelectedNodeChange(NodeSelectEvent event){
		if(event != null){
			this.selectedNode = event.getTreeNode();
		    if(this.selectedNode==null)
				message = null;
			else message = this.selectedNode.getData().toString();
		}
	}
	
	public void onDrop(DragDropEvent event) {  
        Continent cont = (Continent) event.getData();
        if(!selectedContinents.contains(cont)){
        	selectedContinents.add(cont);
        	listeContinents.remove(cont);
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(cont.getNom() + " added"));  
        }
    }  
	

	public List<String> completePays(String p){
		List<String> suggestions = new ArrayList<String>();
		String uP = p.substring(0, 1).toUpperCase();
		if(p.length()>1) uP+=p.substring(1);
		/*
		//test temporaire : pause de 2s pour simuler traitement long
		//et visualiser "ajaxStatus"
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		for(String s : listePays){
			if(s.startsWith(uP))
				suggestions.add(s);
		}
		return suggestions;
	}
	
	public List<String> completeTextDemo(String text){
		List<String> suggestions = new ArrayList<String>();
		for(int i=0;i<10;i++){
			suggestions.add(text+i);
		}			
		return suggestions;
	}
	
	//action for test_validation
	public String saveUser(){
		return null;
	}
	
	   
	     //actionListener pour test p:contextMenu
	    public void save(ActionEvent actionEvent) {  
	    	System.out.println("GeneralBean.save");
	        addMessage("Data saved");  
	    }  
	    
	    //actionListener pour test p:contextMenu 
	    public void update(ActionEvent actionEvent) {
	    	System.out.println("GeneralBean.update");
	        addMessage("Data updated");  
	    }  	      
	      
	    public void addMessage(String summary) {  
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);  
	        FacesContext.getCurrentInstance().addMessage(null, message);  
	    }  

	//pour tester affichage via p:messages
	 public void generateInfoWarnErrorFatal(ActionEvent actionEvent) {  
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample info message", "tout va bien"));  
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Sample warn message", "attention, attention"));  
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample error message", "internal error , retry later")); 
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Sample fatal message", "Fatal Error in System"));  
	    }  
	
	
	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}
	
	public TreeNode getFranceRoot() {
		return franceRoot;
	}



	public TreeNode getSelectedNode() {
		return selectedNode;
	}



	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}

	public String getCodeCouleur() {
		return codeCouleur;
	}

	public void setCodeCouleur(String codeCouleur) {
		this.codeCouleur = codeCouleur;
	}

	public List<Continent> getListeContinents() {
		return listeContinents;
	}

	public void setListeContinents(List<Continent> listeContinents) {
		this.listeContinents = listeContinents;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getHtmlText() {
		return htmlText;
	}

	public void setHtmlText(String htmlText) {
		this.htmlText = htmlText;
	}

	public List<String> getListImageName() {
		return listImageName;
	}

	public List<Continent> getSelectedContinents() {
		return selectedContinents;
	}

	public void setSelectedContinents(List<Continent> selectedContinents) {
		this.selectedContinents = selectedContinents;
	}

	public List<String> getListPhotoName() {
		return listPhotoName;
	}

	public List<String> getListePays() {
		return listePays;
	}

	public void setListePays(List<String> listePays) {
		this.listePays = listePays;
	}

	public void setFranceRoot(TreeNode franceRoot) {
		this.franceRoot = franceRoot;
	}

	public Continent getCurrentSelectedCont() {
		return currentSelectedCont;
	}

	public void setCurrentSelectedCont(Continent currentSelectedCont) {
		this.currentSelectedCont = currentSelectedCont;
	}

	
	
}
