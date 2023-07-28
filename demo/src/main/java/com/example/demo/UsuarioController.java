package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeanUtils;


import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para manejar las operaciones relacionadas con los usuarios.
 */
@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioController {

    // Repositorio de usuarios que maneja la persistencia de los datos.
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Obtiene todos los usuarios almacenados en la base de datos.
     *
     * @return Una lista de todos los usuarios en la base de datos.
     */
    @GetMapping("/")
    public List<Usuarios> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    /**
     * Obtiene un usuario específico por su identificador (ID).
     *
     * @param id El identificador único del usuario a obtener.
     * @return El usuario con el ID especificado o null si no se encuentra en la base de datos.
     */
    @GetMapping("/{id}")
    public Usuarios getUsuarioById(@PathVariable Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    /**
     * Crea un nuevo usuario y lo guarda en la base de datos.
     *
     * @param usuario El objeto Usuarios que contiene la información del nuevo usuario.
     * @return El usuario creado y almacenado en la base de datos.
     */
    @PostMapping("/")
    public Usuarios createUsuario(@RequestBody @Validated Usuarios usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Actualiza todos los atributos de un usuario existente en la base de datos.
     *
     * @param id      El identificador único del usuario a actualizar.
     * @param usuario El objeto Usuarios que contiene los nuevos datos para el usuario.
     * @return El usuario actualizado y almacenado en la base de datos.
     */
    @PutMapping("/{id}")
    public Usuarios updateAllUsuario(@PathVariable Long id, @RequestBody @Validated Usuarios usuario) {
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    /**
     * Actualiza solo los atributos no nulos de un usuario existente en la base de datos.
     *
     * @param id             El identificador único del usuario a actualizar.
     * @param usuarioRequest El objeto Usuarios que contiene los nuevos datos para el usuario.
     * @return El usuario actualizado y almacenado en la base de datos.
     */
    @PatchMapping("/{id}")
    public Usuarios updateUsuario(@PathVariable Long id, @RequestBody Usuarios usuarioRequest) {
        Usuarios usuarioActual = usuarioRepository.findById(id).orElse(null);

        if (usuarioActual != null) {
            // Copia solo los atributos no nulos del usuarioRequest al usuarioActual.
            BeanUtils.copyProperties(usuarioRequest, usuarioActual, getNullPropertyNames(usuarioRequest));
            return usuarioRepository.save(usuarioActual);
        }

        return null;
    }

    /**
     * Elimina un usuario de la base de datos por su identificador (ID).
     *
     * @param id El identificador único del usuario a eliminar.
     */
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }

    /**
     * Obtiene el nombre de las propiedades nulas de un objeto.
     *
     * @param source El objeto del que se desean obtener las propiedades nulas.
     * @return Un arreglo de cadenas que contiene el nombre de las propiedades nulas.
     */
    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] propertyDescriptors = wrappedSource.getPropertyDescriptors();
        List<String> nullProperties = new ArrayList<>();
        for (java.beans.PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String propertyName = propertyDescriptor.getName();
            if (wrappedSource.getPropertyValue(propertyName) == null) {
                nullProperties.add(propertyName);
            }
        }
        return nullProperties.toArray(new String[0]);
    }
}
