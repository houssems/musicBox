package org.issat.outils;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ws.rs.core.Application;


import org.issat.search.Artist;
import org.issat.search.Movies;
import org.issat.search.Youtube;
import org.issat.session.ContactResource;
import org.issat.session.CountryResource;
import org.issat.session.NewsResource;
import org.issat.session.UserResource;


@Stateless
public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(CountryResource.class);
        s.add(ContactResource.class);
        s.add(UserResource.class);
        s.add(NewsResource.class);
        s.add(Artist.class);
        s.add(Movies.class);
        s.add(Youtube.class);
        return s;
    }
}
