/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.estudiante.entry;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santiago Amaya
 */
@Entity
@Table(name = "ESTUDIANTECURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiantecurso.findAll", query = "SELECT e FROM Estudiantecurso e")
    , @NamedQuery(name = "Estudiantecurso.findByCodeCurso", query = "SELECT e FROM Estudiantecurso e WHERE e.estudiantecursoPK.codeCurso = :codeCurso")
    , @NamedQuery(name = "Estudiantecurso.findByStudenidEstudiante", query = "SELECT e FROM Estudiantecurso e WHERE e.estudiantecursoPK.studenidEstudiante = :studenidEstudiante")
    , @NamedQuery(name = "Estudiantecurso.findByNota", query = "SELECT e FROM Estudiantecurso e WHERE e.nota = :nota")})
public class Estudiantecurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstudiantecursoPK estudiantecursoPK;
    @Column(name = "NOTA")
    private Double nota;
    @JoinColumn(name = "CODE_CURSO", referencedColumnName = "CODE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "STUDENID_ESTUDIANTE", referencedColumnName = "STUDENTID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiante estudiante;

    public Estudiantecurso() {
    }

    public Estudiantecurso(EstudiantecursoPK estudiantecursoPK) {
        this.estudiantecursoPK = estudiantecursoPK;
    }

    public Estudiantecurso(EstudiantecursoPK estudiantecursoPk, double nota) {
        this.estudiantecursoPK = estudiantecursoPk;
        this.nota=nota;
    }

    public EstudiantecursoPK getEstudiantecursoPK() {
        return estudiantecursoPK;
    }

    public void setEstudiantecursoPK(EstudiantecursoPK estudiantecursoPK) {
        this.estudiantecursoPK = estudiantecursoPK;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudiantecursoPK != null ? estudiantecursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantecurso)) {
            return false;
        }
        Estudiantecurso other = (Estudiantecurso) object;
        if ((this.estudiantecursoPK == null && other.estudiantecursoPK != null) || (this.estudiantecursoPK != null && !this.estudiantecursoPK.equals(other.estudiantecursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.estudiante.entry.Estudiantecurso[ estudiantecursoPK=" + estudiantecursoPK + " ]";
    }
    
}
