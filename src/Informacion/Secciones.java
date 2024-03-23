package Informacion;

public class Secciones {

    private int CicloSeccion, SeccionID, DocenteSeccion, PeriodoSeccionIP;
    private String PeriodoSeccion, NombreSeccion, EstadoSeccion, CodigoDocenteSeccion;
    private String NotasNombres[] = new String[4];
    private String NotasTipos[] = new String[4];
    private int NotasPorcentajes[] = new int[4];

    public String[] getNotasTiposG() {
        return NotasTipos;
    }

    public void setNotasTiposG(String[] NotasTipos) {
        this.NotasTipos = NotasTipos;
    }

    
     public String getNotasTip(int indice) {
        if (indice >= 0 && indice < NotasTipos.length) {
            return NotasTipos[indice];
        }
        return "nada";
    }

    public void setNotasTip(int indice, String valor) {
        if (indice >= 0 && indice < NotasTipos.length) {
            NotasTipos[indice] = valor;
        }
    }

    
    public int getPeriodoSeccionIP() {
        return PeriodoSeccionIP;
    }

    public void setPeriodoSeccionIP(int PeriodoSeccionIP) {
        this.PeriodoSeccionIP = PeriodoSeccionIP;
    }

    public int getCicloSeccion() {
        return CicloSeccion;
    }

    public String getCodigoDocenteSeccion() {
        return CodigoDocenteSeccion;
    }

    public void setCodigoDocenteSeccion(String CodigoDocenteSeccion) {
        this.CodigoDocenteSeccion = CodigoDocenteSeccion;
    }

    public int getDocenteSeccion() {
        return DocenteSeccion;
    }

    public void setDocenteSeccion(int DocenteSeccion) {
        this.DocenteSeccion = DocenteSeccion;
    }

    public void setCicloSeccion(int CicloSeccion) {
        this.CicloSeccion = CicloSeccion;
    }

    public int getSeccionID() {
        return SeccionID;
    }

    public void setSeccionID(int SeccionID) {
        this.SeccionID = SeccionID;
    }

    public String getPeriodoSeccion() {
        return PeriodoSeccion;
    }

    public void setPeriodoSeccion(String PeriodoSeccion) {
        this.PeriodoSeccion = PeriodoSeccion;
    }

    public String getNombreSeccion() {
        return NombreSeccion;
    }

    public void setNombreSeccion(String NombreSeccion) {
        this.NombreSeccion = NombreSeccion;
    }

    public String getEstadoSeccion() {
        return EstadoSeccion;
    }

    public void setEstadoSeccion(String EstadoSeccion) {
        this.EstadoSeccion = EstadoSeccion;
    }

    public String[] getNotasNombres() {
        return NotasNombres;
    }

    public void setNotasNombres(String[] NotasNombres) {
        this.NotasNombres = NotasNombres;
    }

    public int[] getNotasPorcentajes() {
        return NotasPorcentajes;
    }

    public void setNotasPorcentajes(int[] NotasPorcentajes) {
        this.NotasPorcentajes = NotasPorcentajes;
    }

}
