/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.estudiante.entry;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Santiago Amaya
 */
@Embeddable
public class EstudiantecursoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CODE_CURSO")
    private int codeCurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDENID_ESTUDIANTE")
    private int studenidEstudiante;

    public EstudiantecursoPK() {
    }

    public EstudiantecursoPK(int codeCurso, int studenidEstudiante) {
        this.codeCurso = codeCurso;
        this.studenidEstudiante = studenidEstudiante;
    }

    public int getCodeCurso() {
        return codeCurso;
    }

    public void setCodeCurso(int codeCurso) {
        this.codeCurso = codeCurso;
    }

    public int getStudenidEstudiante() {
        return studenidEstudiante;
    }

    public void setStudenidEstudiante(int studenidEstudiante) {
        this.studenidEstudiante = studenidEstudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codeCurso;
        hash += (int) studenidEstudiante;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudiantecursoPK)) {
            return false;
        }
        EstudiantecursoPK other = (EstudiantecursoPK) object;
        if (this.codeCurso != other.codeCurso) {
            return false;
        }
        if (this.studenidEstudiante != other.studenidEstudiante) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.estudiante.entry.EstudiantecursoPK[ codeCurso=" + codeCurso + ", studenidEstudiante=" + studenidEstudiante + " ]";
    }
    
}
