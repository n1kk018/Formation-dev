package org.mycontrib.test_primefaces.web.mbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
  

@ManagedBean
@SessionScoped
public class FileUploadController {  
  
    public void handleFileUpload(FileUploadEvent event) { 
    	String sMsg = event.getFile().getFileName() + " is uploaded.";
    	//...
    	System.out.println(sMsg);
        FacesMessage msg = new FacesMessage("Succesful", sMsg);  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
}  
         
