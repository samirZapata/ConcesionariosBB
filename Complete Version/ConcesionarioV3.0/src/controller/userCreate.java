package controller;

/**
 *
 * @author yonier
 */
public class userCreate {

    private String nombresYapellidos;
    private String direccion;
    private String telefono;
    private String email;
    private int cedula;
    private String ciudad;
    private String user;
    private String pass;
    private int rol;

    /**
     *
     * @param nombresYapellidos
     * @param direccion
     * @param telefono
     * @param email
     * @param cedula
     * @param ciudad
     * @param user
     * @param pass
     * @param rol
     */
    public userCreate(String nombresYapellidos, String direccion, String telefono, String email, int cedula, String ciudad, String user, String pass, int rol) {
        this.nombresYapellidos = nombresYapellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.cedula = cedula;
        this.ciudad = ciudad;
        this.user = user;
        this.pass = pass;
        this.rol = rol;

    }

    public String getNombresYapellidos() {
        return nombresYapellidos;
    }

    public void setNombresYapellidos(String nombresYapellidos) {
        this.nombresYapellidos = nombresYapellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public userCreate() {

    }

    @Override
    public String toString() {
        return "userCreate{" + "nombresYapellidos=" + nombresYapellidos + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + ", cedula=" + cedula + ", ciudad=" + ciudad + ", user=" + user + ", pass=" + pass + ", rol=" + rol + '}';
    }

}
