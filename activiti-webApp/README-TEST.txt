pour utiliser et tester cette application il faut :
1) lancer (sous tomcat) avec ou sans eclipse l'application "wsCalculateur"

2)  pour tester le processus "activiti_incr_pers_age_via_ws.bpmn" qui appelle la méthode addition du
    web service soap "wsCalculateur" de façon à incrémenter l'age d'une personne
    avant de l'afficher et déterminer si cette personne est mineure ou majeure  , 
  il suffit de démarrer le test (javaApp/main) tp.test.IncrementPersWithWsTestApp
  [pour cette partie d'application en mode texte , il n'est pas nécessaire de lancer "activiti-webApp"
  sous tomcat ]

2) depuis un navigateur connecté à l'appli "wsCalculateur" , activer la partie JMS

3) pour tester le processus "test_async_activiti_jms.bpmn" qui envoie via JMS
  deux demandes de conges  et qui attend et affiche les réponses , 
  il suffit de démarrer le test (javaApp/main) tp.test.AsyncJmsTestApp
  [pour cette partie d'application en mode texte , il n'est pas nécessaire de lancer "activiti-webApp"
  sous tomcat MAIS IL FAUT QUE wsCalculateur.war soit lancé sous tomcat avec la partie Jms activée 
              ET avec le serveur activeMQ lancé en tâche de fond ]
  
4) pour tester les autres parties de l'application "activiti-webApp" , il faut que celle ci soit lancée/démarrée sous tomcat

5) pour tester le processus "inscription_activiti.bpmn" , il faut appeler via soap-ui (ou via la classe tp.test.CallWsInscription) la
   méthode "traiterInscription" du service Inscription (soap) de l'application web "activiti-webApp"
    (url wsdl : http://localhost:8080/activiti-webApp/services/serviceIncription?wsdl) 
    
   valeur importante pour le test : adresse email = "user1@localhost" 
    
6) le processus "inscription_activiti.bpmn" réagit en envoyant un mail à l'utilisateur user1 de localhost     
   et attend la réponse.
   Pour débloquer cette attente , il faut utiliser "Thunderbird" pour visualiser l'email reçu.
   Au sein du mail reçu , un lien hypertexte permet d'invoquer un web service "REST" sur l'application "activiti-webApp"
   Cette action déclenche un évènement qui fait avancer le processus "inscription_activiti.bpmn" jusqu'à sa fin.
   
7) Pour tester le processus "pers_activiti_user_task.bpmn" , il faut via un navigateur connecté à l'appli "activiti-webApp":
   * cliquer sur le lien hypertexte "admin activiti process et userTask"
   * "lister les processus"
   * "start" le process "persWithUserTask"
   * userTask (to claim /to complete)
   * "claim" , "UserTaskSaisirAge"
   * "perform" , "UserTaskSaisirAge"
   * saisir un age (inférieur ou supérieur à 18)
   * visualiser l'anvancée du processus bpmn dans la console (eclipse ou tomcat)
   * refaire éventuellement un nouvel essai (lister processus , re-démarrer "persWithUserTask" , ...)
   NB: l'autre processus visible (inscription) se démarre via un appel de WS soap (avec données en entrée).
       Tenter un démarrage (sans données) via l'ihm "lister les processus" provoque des exceptions
   
   
  
  