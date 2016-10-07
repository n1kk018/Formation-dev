La configuration de activiti peut s'effectuer avec ou sans Spring
(et dans un contexte "standalone" ou bien "webApp").

Sans spring , le fichier de configuration d'activiti est activiti.cfg.xml
et on peut coder un test unitaire (JUnit4) en s'appuyant sur @Deployement et ActivitiRule

Avec spring , la configuration d'activiti est intégrée dans celle de Spring
et un test unitaire doit être effectué en se basant sur JUnit + Spring-test

Attention: un test unitaire est censé être simple et rapide
mais un processus bpmn2 asynchrone est potentiellement long