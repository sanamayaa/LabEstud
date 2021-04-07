/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.estudiante.session;

import co.edu.unipiloto.estudiante.entry.Estudiantecurso;
import co.edu.unipiloto.estudiante.entry.EstudiantecursoPK;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Santiago Amaya
 */
@Local
public interface EstudiantecursoFacadeLocal {

    void create(Estudiantecurso estudiantecurso);

    void edit(Estudiantecurso estudiantecurso);

    void remove(Estudiantecurso estudiantecurso);

    Estudiantecurso find(Object id);

    List<Estudiantecurso> findAll();

    List<Estudiantecurso> findRange(int[] range);

    int count();
    
    void insertarEstudianteCurso(int codeCurso, int studenidEstudiante, Double nota);
    
    Estudiantecurso consultarEstudiantecurso(EstudiantecursoPK pk);
    
    
}
