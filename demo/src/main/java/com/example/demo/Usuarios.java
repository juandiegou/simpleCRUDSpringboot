/**
 * Representa a un usuario en el sistema.
*/

package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Usuarios {

    // Identificador único del usuario.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre del usuario.
    private String nombre;

    // Tipo de documento del usuario (DNI, pasaporte, etc.).
    private EnumTipoDocumento tipoDocumento;

    // Número del documento del usuario.
    private String numeroDocumento;

    // Categoría del usuario (estándar, premium, etc.).
    private EnumCategoria categoria;

    // Indica si el usuario posee tarjeta (true) o no (false).
    private boolean tarjeta;

    // Fecha y hora de creación del usuario.
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaHora;

    /**
     * Constructor vacío necesario para entidades JPA.
     */
    public Usuarios() {
    }

    /**
     * Constructor para crear un nuevo usuario.
     *
     * @param nombre         Nombre del usuario.
     * @param tipoDocumento  Tipo de documento del usuario.
     * @param numeroDocumento  Número del documento del usuario.
     * @param categoria      Categoría del usuario.
     * @param tarjeta        Indica si el usuario posee tarjeta (true) o no (false).
     * @param fechaHora      Fecha y hora de creación del usuario.
     */
    public Usuarios(String nombre, EnumTipoDocumento tipoDocumento, String numeroDocumento, EnumCategoria categoria, boolean tarjeta, LocalDateTime fechaHora) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.categoria = categoria;
        this.tarjeta = tarjeta;
        this.fechaHora = fechaHora;
    }

    // Métodos de acceso y modificadores para las propiedades.

    /**
     * Obtiene el identificador único del usuario.
     *
     * @return El identificador único del usuario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del usuario.
     *
     * @param id El identificador único del usuario a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nombre del usuario a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el tipo de documento del usuario.
     *
     * @return El tipo de documento del usuario.
     */
    public EnumTipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Establece el tipo de documento del usuario.
     *
     * @param tipoDocumento El tipo de documento del usuario a establecer.
     */
    public void setTipoDocumento(EnumTipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * Obtiene el número del documento del usuario.
     *
     * @return El número del documento del usuario.
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * Establece el número del documento del usuario.
     *
     * @param numeroDocumento El número del documento del usuario a establecer.
     */
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * Obtiene la categoría del usuario.
     *
     * @return La categoría del usuario.
     */
    public EnumCategoria getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del usuario.
     *
     * @param categoria La categoría del usuario a establecer.
     */
    public void setCategoria(EnumCategoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Verifica si el usuario posee tarjeta.
     *
     * @return true si el usuario tiene tarjeta, false en caso contrario.
     */
    public boolean isTarjeta() {
        return tarjeta;
    }

    /**
     * Establece si el usuario posee tarjeta o no.
     *
     * @param tarjeta true si el usuario tiene tarjeta, false en caso contrario.
     */
    public void setTarjeta(boolean tarjeta) {
        this.tarjeta = tarjeta;
    }

    /**
     * Obtiene la fecha y hora de creación del usuario.
     *
     * @return La fecha y hora de creación del usuario.
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de creación del usuario.
     *
     * @param fechaHora La fecha y hora de creación del usuario a establecer.
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Agrega una tarjeta al usuario.
     */
    public void agregarTarjeta() {
        this.tarjeta = true;
    }

    /**
     * Cambia la categoría del usuario por una nueva categoría.
     *
     * @param nuevaCategoria La nueva categoría del usuario.
     */
    public void cambiarCategoria(EnumCategoria nuevaCategoria) {
        this.categoria = nuevaCategoria;
    }

    /**
     * Sobrescribe el método equals para comparar dos objetos Usuarios.
     *
     * @param o El objeto a comparar con esta instancia de Usuarios.
     * @return true si los objetos son iguales (mismo id), false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuarios)) return false;
        Usuarios usuarios = (Usuarios) o;
        return id.equals(usuarios.id);
    }

    /**
     * Sobrescribe el método hashCode para generar un código hash basado en el id del usuario.
     *
     * @return El código hash basado en el id del usuario.
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    /**
     * Genera una representación en formato de cadena de texto del objeto Usuarios.
     *
     * @return La representación en formato de cadena de texto del objeto Usuarios.
     */
    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipoDocumento=" + tipoDocumento +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", categoria=" + categoria +
                ", tarjeta=" + tarjeta +
                ", fechaHora=" + fechaHora +
                '}';
    }
}
