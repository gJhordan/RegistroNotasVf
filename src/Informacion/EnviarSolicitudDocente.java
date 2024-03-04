
package Informacion;



public class EnviarSolicitudDocente {
    
    private String curso;
    private String seccion;
    private String motivo;
    private String CodDocente;

    public String getCodDocente() {
        return CodDocente;
    }

    public void setCodDocente(String CodDocente) {
        this.CodDocente = CodDocente;
    }
    

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
}
