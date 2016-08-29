package fr.afcepf.al28.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// une nouvelle annotation personnalisée se programme comme une interface spéciale avec @

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
//RetentionPolicy.RUNTIME = Annotation accessible à l'execution (90% des cas)
//RetentionPolicy.SOURCE = Annotation seulement visible par le pré-compilateur APT (Annotation Processing Tool)
public @interface MyId {

}
