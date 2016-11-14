package fr.afcepf.al28.ria.services;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest")
public class RestContext extends Application {
    
        @Override
        public Set<Class<?>> getClasses()
        {
            final Set<Class<?>> classes = new HashSet<Class<?>>();
            classes.add(new Premierservice().getClass());
            return super.getClasses();
        }
}
