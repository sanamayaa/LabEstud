/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.estudiante.session;

import co.edu.unipiloto.estudiante.entry.Estudiantecurso;
import co.edu.unipiloto.estudiante.entry.EstudiantecursoPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Santiago Amaya
 */
@Stateless
public class EstudiantecursoFacade extends AbstractFacade<Estudiantecurso> implements EstudiantecursoFacadeLocal {

    @PersistenceContext(unitName = "estudiantePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudiantecursoFacade() {
        super(Estudiantecurso.class);
    }
    
    @Override
    public void insertarEstudianteCurso(int codeCurso, int studenidEstudiante, Double nota)
    {
        EstudiantecursoPK pk = new EstudiantecursoPK(codeCurso, studenidEstudiante);
        if (consultarEstudiantecurso(pk)!= null) {
            
        } else {
            Estudiantecurso ec = new Estudiantecurso(pk,nota);
            em.persist(ec);
            
        }
    }

    @Override
    public Estudiantecurso consultarEstudiantecurso(EstudiantecursoPK pk) {
        return em.find(Estudiantecurso.class,pk);
    }
    
}
