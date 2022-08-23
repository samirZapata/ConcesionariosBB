package model;

import controller.Cola;
import controller.Listas;
import controller.Pila;
import controller.inventarioCarrosCr;
import controller.productoscreate;
import controller.userCreate;
import java.awt.HeadlessException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.Registrarse;

/**
 *
 * @author yonier
 */
public class registro {

    private Listas<userCreate> lista;
    private Pila<inventarioCarrosCr> pila;
    private Cola<productoscreate> cola;
    Conexion c = new Conexion();
    Statement sta;
    String sql;
    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    private userCreate usuario;
    private productoscreate producto;
    private inventarioCarrosCr carros;

    public registro() {
        this.lista = new Listas<>();
        this.pila = new Pila<>();
        this.cola = new Cola<>();
    }

    public Listas<userCreate> listaUsuarios() {
        return lista;
    }

    public Pila<inventarioCarrosCr> listaInventario() {
        return pila;
    }

    public Cola<productoscreate> listaProductos() {
        return cola;
    }

    /**
     * METODO PARA REGISTRAR USUARIO
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
     * @return
     */
    public boolean registrar(String nombresYapellidos, String direccion, String telefono, String email, String cedula, String ciudad, String user, String pass, String rol) {

        sql = "INSERT INTO Registrar(NombresyApellidos, direccion, telefono, email, Cedula, ciudad, usuario, contraseña, rol)" + "VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            cn = c.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombresYapellidos);
            ps.setString(2, direccion);
            ps.setString(3, telefono);
            ps.setString(4, email);
            ps.setString(5, cedula);
            ps.setString(6, ciudad);
            ps.setString(7, user);
            ps.setString(8, pass);
            ps.setString(9, rol);
            // ps.setString(10, );
            //lista.agregar((userCreate) ps);
            boolean prueba = ps.execute();
            if (prueba == true) {
                JOptionPane.showMessageDialog(null, "Registro Completo!!");
            } else {

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Uppss, Datos Erroneos, intenta de nuevo!");
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
            return false;
        }
        return true;
    }
    
    
    
    
     /**
     * METODO PARA REGISTRAR USUARIO
     *
     * @param nombresYapellidos
     * @param direccion
     * @param telefono
     * @param email
     * @param cedula
     * @param ciudad
     * @param user
     * @param pass
     * @param rol@return
     */
    public boolean registrar1(String nombresYapellidos, String direccion, String telefono, String email, String cedula, String ciudad, String user, String pass, String rol) {

        sql = "INSERT INTO Registrar(NombresyApellidos, direccion, telefono, email, Cedula, ciudad, usuario, contraseña, rol)" + "VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            cn = c.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombresYapellidos);
            ps.setString(2, direccion);
            ps.setString(3, telefono);
            ps.setString(4, email);
            ps.setString(5, cedula);
            ps.setString(6, ciudad);
            ps.setString(7, user);
            ps.setString(8, pass);
            ps.setString(9, rol);
            // ps.setString(10, );
            //lista.agregar((userCreate) ps);
            boolean prueba = ps.execute();
            if (prueba == true) {
                JOptionPane.showMessageDialog(null, "Registro Completo!!");
            } else {

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Uppss, Datos Erroneos, intenta de nuevo!");
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
            return false;
        }
        return true;
    }
    
    
    
    
    
    /**
     * VALIDAR USUARIOS
     *
     * @param user
     * @return
     */
    public String validarUser(String user) {
        String resultado = null;
        sql = "SELECT usuario FROM Registrar WHERE usuario=?";
        try {
            cn = c.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    resultado = rs.getString(7);
                }
            }
            return resultado;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Uppss, Datos no encontrados!");
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return null;
    }

    /**
     * Mostrar usuarios method
     *
     * @return
     */
    public Listas<userCreate> mostrar() {
        try {
            cn = c.getConnection();
            // sql = "SELECT * FROM Registrar WHERE NombresyApellidos=?";
            ps = cn.prepareStatement("SELECT * FROM Registrar WHERE rol=2");
            //ps.setString(1, dato);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {

                    //Obtengo los datos y los asigno a los nodos
                    usuario = new userCreate();
                    usuario.setNombresYapellidos(rs.getString(1));
                    usuario.setDireccion(rs.getString(2));
                    usuario.setTelefono(rs.getString(3));
                    usuario.setEmail(rs.getString(4));
                    usuario.setCedula(rs.getInt(5));
                    usuario.setCiudad(rs.getString(6));
                    usuario.setUser(rs.getString(7));
                    usuario.setPass(rs.getString(8));
                    usuario.setRol(rs.getInt(9));
                    lista.addFirst(usuario);
                }
            }
            // System.out.println(usuario.getNombresYapellidos());

            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!");
            System.err.format("SQL State: %s\n%s ", e.getSQLState(), e.getMessage());
        }
        return null;
    }

    public Listas<userCreate> mostrarAdmin() {
        try {
            cn = c.getConnection();
            // sql = "SELECT * FROM Registrar WHERE NombresyApellidos=?";
            ps = cn.prepareStatement("SELECT * FROM Registrar WHERE rol=1");
            //ps.setString(1, dato);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {

                    //Obtengo los datos y los asigno a los nodos
                    usuario = new userCreate();
                    usuario.setNombresYapellidos(rs.getString(1));
                    usuario.setDireccion(rs.getString(2));
                    usuario.setTelefono(rs.getString(3));
                    usuario.setEmail(rs.getString(4));
                    usuario.setCedula(rs.getInt(5));
                    usuario.setCiudad(rs.getString(6));
                    usuario.setUser(rs.getString(7));
                    usuario.setPass(rs.getString(8));
                    usuario.setRol(rs.getInt(9));
                    lista.addFirst(usuario);
                }
            }
            // System.out.println(usuario.getNombresYapellidos());

            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!");
            System.err.format("SQL State: %s\n%s ", e.getSQLState(), e.getMessage());
        }
        return null;
    }

    /**
     * METODO PARA CONSULTAR USUARIOS
     *
     * @param User
     * @return lista
     */
    public Listas<userCreate> consultarUsuarios(String User) {
        try {
            cn = c.getConnection();
            ps = cn.prepareStatement("SELECT * FROM Registrar WHERE Usuario = ?");
            System.out.println(User);
            ps.setString(1, User);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    userCreate data = new userCreate();
                    data.setNombresYapellidos(rs.getString(1));
                    data.setDireccion(rs.getString(2));
                    data.setTelefono(rs.getString(3));
                    data.setEmail(rs.getString(4));
                    data.setCedula(rs.getInt(5));
                    data.setCiudad(rs.getString(6));
                    data.setUser(rs.getString(7));
                    data.setPass(rs.getString(8));
                    data.setRol(rs.getInt(9));
                    lista.addFirst(data);
                    System.out.println(data.getNombresYapellidos());
                }

            }

            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!");
            System.err.format("SQL State: %s\n%s ", e.getSQLState(), e.getMessage());
        }
        return null;

    }

    /**
     * METODO PARA ELIMINAR USUARIO
     *
     * @param Usuario
     * @return
     * @throws java.sql.SQLException
     */
    public Listas<userCreate> eliminarUser(String Usuario) throws SQLException {
        try {
            cn = c.getConnection();
            ps = cn.prepareStatement("DELETE FROM Registrar WHERE Usuario=?");
            ps.setString(1, Usuario);
            ps.executeUpdate();
            if (rs != null) {
                while (rs.next()) {
                    usuario = new userCreate();
                    usuario.setNombresYapellidos(rs.getString(1));
                    usuario.setDireccion(rs.getString(2));
                    usuario.setTelefono(rs.getString(3));
                    usuario.setEmail(rs.getString(4));
                    usuario.setCedula(rs.getInt(5));
                    usuario.setCiudad(rs.getString(6));
                    usuario.setUser(rs.getString(7));
                    usuario.setPass(rs.getString(8));
                    usuario.setRol(rs.getInt(9));
                    lista.addFirst(usuario);
                    System.out.println(usuario.getNombresYapellidos());
                }
                JOptionPane.showMessageDialog(null, "El usuario se ha eliminado con exito!!", "Eliminando...!", JOptionPane.INFORMATION_MESSAGE);
                return lista;
            } else {
                JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!", "Error desde la BD", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Upss, no se ha podido esta vez!", "Error desde la BD", JOptionPane.ERROR_MESSAGE);
            System.err.format("SQL State: %s\n%s ", e.getSQLState(), e.getMessage());
        }
        // return true;
        return null;
    }

    /**
     * METODO PARA COLSULTAR USUARIOS Y MODIFICARLOS
     *
     * @param Usuario
     * @return
     */
    public Listas<userCreate> consultarUsuarioss(String Usuario) {
        try {

            cn = c.getConnection();
            ps = cn.prepareStatement("SELECT * FROM Registrar WHERE Usuario=?"); //ps.setString(1, NombresyApellidos);
            ps.setString(1, Usuario);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    //Obtengo los datos y los asigno a los nodos
                    userCreate usuario = new userCreate();
                    usuario.setNombresYapellidos(rs.getString(1));
                    usuario.setDireccion(rs.getString(2));
                    usuario.setTelefono(rs.getString(3));
                    usuario.setEmail(rs.getString(4));
                    usuario.setCedula(rs.getInt(5));
                    usuario.setCiudad(rs.getString(6));
                    usuario.setUser(rs.getString(7));
                    usuario.setPass(rs.getString(8));
                    usuario.setRol(rs.getInt(9));
                    lista.addFirst(usuario);
                }
            }
            return lista;
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!");
            System.err.format("SQL State: %s\n%s ", e.getSQLState(), e.getMessage());
        }
        return null;
    }

    /**
     * METODO PARA MODIFICAR USUARIOS
     *
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
     * @return
     */
    public boolean modificarUser(String nombresYapellidos, String direccion, String telefono, String email, int cedula, String ciudad, String user, String pass, int rol) {
        try {
            cn = c.getConnection();
            ps = cn.prepareStatement("UPDATE Registrar SET NombresyApellidos=?,Direccion=?,Telefono=?,Email=?,Cedula=?,Ciudad=?,Usuario=?,Contraseña=?,rol=? WHERE Usuario='" + user + "'");
            ps.setString(1, nombresYapellidos);
            ps.setString(2, direccion);
            ps.setString(3, telefono);
            ps.setString(4, email);
            ps.setInt(5, cedula);
            ps.setString(6, ciudad);
            ps.setString(7, user);
            ps.setString(8, pass);
            ps.setInt(9, rol);

            int res = ps.executeUpdate();
            if (res > 0) {
                //System.out.println(usuario.getNombresYapellidos());
                //System.out.println(usuario.getRol());
                JOptionPane.showMessageDialog(null, "El usuario se ha modificado con exito!!");

            } else {
                JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!", "Error de la BD", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, e.getMessage());
        }
        return true;
    }

    public Listas<userCreate> modifyUser(String dato) {
        try {
            cn = c.getConnection();
            ps = cn.prepareStatement("UPDATE Registrar SET NombresyApellidos=?, Direccion=?, Telefono=?, Email=?, Cedula=?, Ciudad=?, rol=? WHERE Usuario=?");
            ps.setString(1, dato);
            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                /*
                while (rs.next()) {
                    usuario = new userCreate();
                    usuario.setNombresYapellidos(rs.getString(1));
                    usuario.setDireccion(rs.getString(2));
                    usuario.setTelefono(rs.getString(3));
                    usuario.setEmail(rs.getString(4));
                    //usuario.setCedula(rs.getInt(5));
                    usuario.setCiudad(rs.getString(6));
                    usuario.setUser(rs.getString(7));
                    usuario.setPass(rs.getString(8));
                    usuario.setRol(rs.getInt(9));
                    lista.addFirst(usuario);
                }*/
                JOptionPane.showMessageDialog(null, "¡El usuario se ha modificado con exito!!", "Modify", JOptionPane.INFORMATION_MESSAGE);
                //return lista;
            } else {
                JOptionPane.showMessageDialog(null, "¡Error, estamos trabajando en ello!", "Modify", JOptionPane.INFORMATION_MESSAGE);
                ///return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡Error, estamos trabajando en ello!", "Modify", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, e.getMessage());

        }
        //return true;
        return null;
    }

    /**
     * METODO PARA REGISTRAR INVENTARIOS
     *
     * @param placa
     * @param modelo
     * @param color
     * @param NoMotor
     * @param ciudad
     * @param Marca
     * @param Tipoc
     * @param indice
     * @return
     */
    public boolean registrarInventario(String placa, String modelo, String color, String NoMotor, String ciudad, String Marca, String Tipoc, String indice) {

        sql = "INSERT INTO registroinventario (placa, modelo, color, ciudad, NoMotor, marca, Tipoc, indice)" + "VALUES(?,?,?,?,?,?,?,?)";

        try {
            cn = c.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, placa);
            ps.setString(2, modelo);
            ps.setString(3, color);
            ps.setString(4, NoMotor);
            ps.setString(5, ciudad);
            ps.setString(6, Marca);
            ps.setString(7, Tipoc);
            //ps.setBinaryStream(8, imagen);
            ps.setString(8, indice);
            boolean prueba = ps.execute();
            if (prueba != false) {
                JOptionPane.showMessageDialog(null, "Registro Completo!!", "¡Exito!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Uppss, Datos Erroneos, intenta de nuevo!");
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
            return false;
        }
        return true;
    }

    /**
     * METODO PARA MOSTRAR INVENTARIO PILAS
     *
     * @return
     */
    public Pila<inventarioCarrosCr> mostrarinventario() {
        try {

            cn = c.getConnection();
            ps = cn.prepareStatement("select * from registroinventario where indice=2");

            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    //Obtengo los datos y los asigno a los nodos
                    inventarioCarrosCr inventario = new inventarioCarrosCr();
                    inventario.setPlaca(rs.getString(1));
                    inventario.setModelo(rs.getString(2));
                    inventario.setColor(rs.getString(3));
                    inventario.setNoMotor(rs.getString(4));
                    inventario.setCiudad(rs.getString(5));
                    inventario.setMarca(rs.getString(6));
                    inventario.setTipoc(rs.getString(7));
                    //inventario.setImagen(rs.getBinaryStream(8));
                    pila.push(inventario);
                }
            }
            return pila;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!");
            System.err.format("SQL State: %s\n%s ", e.getSQLState(), e.getMessage());
        }
        return null;
    }

    /**
     * METODO PARA CONSULTAR PRODUCTOS
     *
     * @param placa
     * @return
     */
    public Pila<inventarioCarrosCr> consultarInventario(String placa) {
        try {
            cn = c.getConnection();
            ps = cn.prepareStatement("SELECT * FROM registroinventario WHERE placa = ?");
            System.out.println(placa);
            ps.setString(1, placa);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    carros = new inventarioCarrosCr();

                    carros.setPlaca(rs.getString(1));
                    carros.setModelo(rs.getString(2));
                    carros.setColor(rs.getString(3));
                    carros.setNoMotor(rs.getString(4));
                    carros.setCiudad(rs.getString(5));
                    carros.setMarca(rs.getString(6));
                    carros.setTipoc(rs.getString(7));
                    pila.push(carros);
                    //System.out.println(producto.setReferencia());
                }
            }
            return pila;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!");
            System.err.format("SQL State: %s\n%s ", e.getSQLState(), e.getMessage());
        }
        return null;
    }

    /**
     * MODIFICAR INVENTARIO
     *
     * @param placa
     * @param modelo
     * @param color
     * @param motor
     * @param ciudad
     * @param marca
     * @param tipo
     * @return
     */
    public boolean modificarInventario(String placa, String modelo, String color, String motor, String ciudad, String marca, String tipo) {
        try {
            cn = c.getConnection();
            ps = cn.prepareStatement("UPDATE registroinventario SET placa=?,modelo=?,color=?,NoMotor=?,ciudad=?,Marca=?,Tipoc=? WHERE placa='" + placa + "'");
            ps.setString(1, placa);
            ps.setString(2, modelo);
            ps.setString(3, color);
            ps.setString(4, motor);
            ps.setString(5, ciudad);
            ps.setString(6, marca);
            ps.setString(7, tipo);

            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Los datos se han modificado con exito!!");
            } else {
                JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!", "Error de la BD", JOptionPane.ERROR_MESSAGE);
           // Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, e.getMessage());
        }
        return true;
    }

    /**
     * METODO PARA ELIMINAR CARRO
     *
     * @param placa
     * @return
     */
    public Pila<inventarioCarrosCr> eliminarInventario(String placa) {
        try {
            cn = c.getConnection();
            ps = cn.prepareStatement("DELETE FROM registroinventario WHERE placa=?");
            ps.setString(1, placa);
            ps.executeUpdate();
            if (rs != null) {
                while (rs.next()) {
                    carros = new inventarioCarrosCr();
                    carros.setPlaca(rs.getString(1));
                    carros.setModelo(rs.getString(2));
                    carros.setColor(rs.getString(3));
                    carros.setNoMotor(rs.getString(4));
                    carros.setCiudad(rs.getString(5));
                    carros.setMarca(rs.getString(6));
                    carros.setTipoc(rs.getString(7));
                    carros.setPlaca(rs.getString(8));
                    pila.push(carros);
                    //System.out.println(usuario.getNombresYapellidos());
                }
                JOptionPane.showMessageDialog(null, "El carro se ha eliminado con exito!!", "Eliminando...!", JOptionPane.INFORMATION_MESSAGE);
                return pila;
            } else {
                JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!", "Error desde la BD", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Upss, no se ha podido esta vez!", "Error desde la BD", JOptionPane.ERROR_MESSAGE);
            System.err.format("SQL State: %s\n%s ", e.getSQLState(), e.getMessage());
        }
        // return true;
        return null;
    }

    /**
     * REGISTRAR PRODUCTOS COLAS
     *
     * @param referencia
     * @param nombre
     * @param marca
     * @param tipoprod
     * @param aplicacion
     * @param cantidadprod
     * @param precio
     * @return
     */
    public boolean registrarproducto(String referencia, String nombre, String marca, String tipoprod, String aplicacion, int cantidadprod, double precio) {

        sql = "INSERT INTO registrarProducto (referencia, nombre, marca, tipoprod, aplicacion, cantidadprod, precio)" + "VALUES(?,?,?,?,?,?,?)";

        try {
            cn = c.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, referencia);
            ps.setString(2, nombre);
            ps.setString(3, marca);
            ps.setString(4, tipoprod);
            ps.setString(5, aplicacion);
            ps.setInt(6, cantidadprod);
            ps.setDouble(7, precio);
            //ps.setBinaryStream(8, imagenprod);
            //ps.setString(8, indice);
            boolean prueba = ps.execute();
            if (prueba == true) {
                JOptionPane.showMessageDialog(null, "Registro Completo!!", "Registro exitoso!", JOptionPane.INFORMATION_MESSAGE);
            } else {

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Uppss, Datos Erroneos, intenta de nuevo!", "Error en la insercion de la BD", JOptionPane.ERROR_MESSAGE);
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
            return false;
        }
        return true;
    }

    /**
     * MOSTRAR PRODUCTOS COLAS
     *
     * @return
     */
    public Cola<productoscreate> mostrarproducto() {
        try {

            cn = c.getConnection();
            // sql = "SELECT * FROM Registrar WHERE NombresyApellidos=?";
            ps = cn.prepareStatement("SELECT * FROM registrarProducto");

            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    //Obtengo los datos y los asigno a los nodos
                    productoscreate inventario = new productoscreate();
                    inventario.setReferencia(rs.getInt(1));
                    inventario.setNombre(rs.getString(2));
                    inventario.setMarca(rs.getString(3));
                    inventario.setTipoprod(rs.getString(4));
                    inventario.setAplicacion(rs.getString(5));
                    inventario.setCantidadprod(rs.getInt(6));
                    inventario.setPrecio(rs.getDouble(7));
                    //inventario.setImagenprod(rs.getBinaryStream(8));
                    cola.enqueue(inventario);
                }
            }
            return cola;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!");
            System.err.format("SQL State: %s\n%s ", e.getSQLState(), e.getMessage());
        }
        return null;
    }

    /**
     * METODO PARA ELIMINAR PRODUCTOS
     *
     * @param referencia
     * @return
     * @throws java.sql.SQLException
     */
    public Cola<productoscreate> eliminarProduct(int referencia) throws SQLException {
        try {
            cn = c.getConnection();
            ps = cn.prepareStatement("DELETE FROM registrarproducto WHERE referencia=?");
            ps.setInt(1, referencia);
            ps.executeUpdate();
            if (rs != null) {
                while (rs.next()) {
                    producto = new productoscreate();

                    producto.setReferencia(rs.getInt(1));
                    producto.setNombre(rs.getString(2));
                    producto.setMarca(rs.getString(3));
                    producto.setTipoprod(rs.getString(4));
                    producto.setAplicacion(rs.getString(5));
                    producto.setCantidadprod(rs.getInt(6));
                    producto.setPrecio(rs.getDouble(7));
                    cola.enqueue(producto);
                    System.out.println(usuario.getNombresYapellidos());
                }
                JOptionPane.showMessageDialog(null, "El usuario se ha eliminado con exito!!", "¡Eliminado!", JOptionPane.INFORMATION_MESSAGE);
                return cola;
            } else {
                JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!", "¡Eliminado!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Upss, no se ha podido esta vez!", "Error desde la BD", JOptionPane.ERROR_MESSAGE);
            System.err.format("SQL State: %s\n%s ", e.getSQLState(), e.getMessage());
        }
        // return true;
        return null;
    }

    /**
     * METODO PARA CONSULTAR PRODUCTOS
     *
     * @param ref
     * @return
     */
    public Cola<productoscreate> consultarProduct(String ref) {
        try {
            cn = c.getConnection();
            ps = cn.prepareStatement("SELECT * FROM registrarproducto WHERE referencia = ?");
            System.out.println(ref);
            ps.setString(1, ref);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    producto = new productoscreate();

                    producto.setReferencia(rs.getInt(1));
                    producto.setNombre(rs.getString(2));
                    producto.setMarca(rs.getString(3));
                    producto.setTipoprod(rs.getString(4));
                    producto.setAplicacion(rs.getString(5));
                    producto.setCantidadprod(rs.getInt(6));
                    producto.setPrecio(rs.getDouble(7));
                    cola.enqueue(producto);
                    //System.out.println(producto.setReferencia());
                }
            }
            return cola;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!");
            System.err.format("SQL State: %s\n%s ", e.getSQLState(), e.getMessage());
        }
        return null;
    }

    /**
     * METODO PARA MODIFICAR PRODUCTOS
     *
     * @param referencia
     * @param nombre
     * @param marca
     * @param tipo
     * @param aplicacion
     * @param cantidad
     * @param precio
     * @return
     */
    public boolean modificarproduct(int referencia, String nombre, String marca, String tipo, String aplicacion, int cantidad, double precio) {
        try {
            cn = c.getConnection();
            ps = cn.prepareStatement("UPDATE registrarproducto SET referencia=?,nombre=?,marca=?,tipoprod=?,aplicacion=?,cantidadprod=?,precio=? WHERE referencia='" + referencia + "'");
            ps.setInt(1, referencia);
            ps.setString(2, nombre);
            ps.setString(3, marca);
            ps.setString(4, tipo);
            ps.setString(5, aplicacion);
            ps.setInt(6, cantidad);
            ps.setDouble(7, precio);

            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "El producto se ha modificado con exito!!");
            } else {
                JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!", "Error de la BD", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!", "Error de la BD", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, e.getMessage() + e.getSQLState());
        }
        return true;
    }

    /**
     * CONSULTAR DATOS FOR Log-in
     *
     * @param user
     * @param pass
     * @return
     */
    //u.NombresyApellidos, u.Direccion, u.Telefono, u.Email, u.Cedula, u.Ciudad, u.Usuario, u.Contraseña, u.rol t.Usuario FROM Registrar AS u "
    //+ "INNER JOIN tipoUser AS t ON u.rol_tipo=t.id   WHERE Usuario = ?
    //@SuppressWarnings({"serial", "empty-statement"})
    public userCreate loginn(String user, String pass) {
        String permisos;

        sql = "SELECT * FROM Registrar WHERE Usuario=? AND Contraseña=?";
        //Usuario='" + user + "' && Contraseña '" + pass + "'"
        cn = c.getConnection();
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);

            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {

                    usuario = new userCreate();
                    usuario.setNombresYapellidos(rs.getString(1));
                    usuario.setDireccion(rs.getString(2));
                    usuario.setTelefono(rs.getString(3));
                    usuario.setEmail(rs.getString(4));
                    usuario.setCedula(rs.getInt(5));
                    usuario.setCiudad(rs.getString(6));
                    usuario.setUser(rs.getString(7));
                    usuario.setPass(rs.getString(8));
                    usuario.setRol(rs.getInt(9));
                    lista.addFirst(usuario);

                }
            }
            //System.out.println("Usuario de entrada  " + user + " Contraseña de entrada  " + pass);
            //System.out.println("Usuario que entra de la BD  " + usuario.getUser() + " Contraseña de la BD  " + usuario.getPass());
            return usuario;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "¡Usuario o Contraseña inexistentes!", "Error de login", JOptionPane.INFORMATION_MESSAGE);
            //Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * LOG-IN
     *
     * @param user
     * @return
     */
    public boolean login(userCreate user) {
        sql = "SELECT Usuario,Contraseña,FROM Registrar WHERE Usuario = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, user.getUser());
            rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    if (user.getPass().equals(rs.getString(8))) {
                        user.setUser(rs.getString(7));
                        user.setRol(rs.getInt(9));
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "¡Usuario o Contraseña incorrectos!", "Error de login", JOptionPane.INFORMATION_MESSAGE);
            //Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * *****************************************
     * //INICIO METODOS REESTABLECER CONTRASEÑA
     * /*******************************************
     *
     * VERIFICAR E-MAIL
     *
     * @param correo
     * @return
     */
    public userCreate verificarEmail(String correo) {
        try {
            cn = c.getConnection();
            ps = cn.prepareStatement("SELECT Email FROM  Registrar WHERE Email='"+correo+"'");
            ps.setString(1, correo);
            rs = ps.executeQuery();

            while (rs.next()) {
                usuario = new userCreate();
                usuario.setNombresYapellidos(rs.getString(1));
                usuario.setDireccion(rs.getString(2));
                usuario.setTelefono(rs.getString(3));
                usuario.setEmail(rs.getString(4));
                usuario.setCedula(rs.getInt(5));
                usuario.setCiudad(rs.getString(6));
                usuario.setUser(rs.getString(7));
                usuario.setPass(rs.getString(8));
                usuario.setRol(rs.getInt(9));
                lista.addFirst(usuario);
            }
            return usuario;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡Error, estamos trabajando en ello!", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, e);

        }
        return null;
    }

    /**
     * RECUPERAR PASSWORD
     *
     * @param dato
     * @param codigo
     * @return
     */
    public boolean recuperarPass(userCreate dato, String codigo) {
        try {
            cn = c.getConnection();
            ps = cn.prepareStatement("UPDATE Registrar SET Contraseña=?  WHERE Email=?");
            ps.setString(1, codigo);
            ps.setString(2, dato.getEmail());
            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "¡La contraseña se ha modificado con exito!", "Recuperar contraseña", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "¡Error, estamos trabajando en ello!", "Recuperar contraseña", JOptionPane.INFORMATION_MESSAGE);
                return false;

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡Error, estamos trabajando en ello!", "Recuperar contraseña", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, e);

        }
        return true;
    }

    /**
     * OBTENER CODIGO DE RECUPERACION
     *
     * @param codigo
     * @return
     */
    public userCreate codigoPass(String codigo) {
        try {
            cn = c.getConnection();
            ps = cn.prepareStatement("SELECT * FROM Registrar WHERE Contraseña=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {

                    usuario = new userCreate();
                    usuario.setNombresYapellidos(rs.getString(1));
                    usuario.setDireccion(rs.getString(2));
                    usuario.setTelefono(rs.getString(3));
                    usuario.setEmail(rs.getString(4));
                    usuario.setCedula(rs.getInt(5));
                    usuario.setCiudad(rs.getString(6));
                    usuario.setUser(rs.getString(7));
                    usuario.setPass(rs.getString(8));
                    usuario.setRol(rs.getInt(9));
                    lista.addFirst(usuario);
                }
            }
            return usuario;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡Error, estamos trabajando en ello!", "Recuperar contraseña", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     * MODIFY PASSWORS METHOD
     *
     * @param dato
     * @param codigo
     * @return
     */
    public boolean modifyPass(userCreate dato, String codigo) {
        try {
            cn = c.getConnection();
            ps = cn.prepareStatement("UPDATE Registrar SET Contraseña=? WHERE Email=?");
            ps.setString(1, codigo);
            ps.setString(2, dato.getEmail());

            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "¡La contraseña se ha modificado con exito!", "Recuperar contraseña", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "¡Error, estamos trabajando en ello!", "Recuperar contraseña", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "¡Error, estamos trabajando en ello!", "Recuperar contraseña", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    /**
     * REESTABLECER PASSWORD METHOD
     *
     * @param dato
     * @param pass
     * @return
     */
    public boolean reestablecerPass(userCreate dato, String pass) {
        try {
            cn = c.getConnection();
            ps = cn.prepareStatement("UPDATE Registrar SET Contraseña=? WHERE Usuario=?");
            ps.setString(1, pass);
            ps.setString(2, dato.getUser());
            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "¡La contraseña se ha reestablecido con exito!", "Recuperar contraseña", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "¡Error, estamos trabajando en ello!", "Recuperar contraseña", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, e);
        }
        return true;
    }
    //********************************************
    //FIN METODOS DE REESTABLECER CONTRASEÑA
    //********************************************

}
