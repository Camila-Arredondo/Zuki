package com.example.zuki.Controller;

import com.example.zuki.DTO.InfoUsuario;
import com.example.zuki.DTO.Login;
import com.example.zuki.DTO.NuevoUsuario;
import com.example.zuki.Entity.*;
import com.example.zuki.ServiceImplement.*;
import com.example.zuki.Utils.Encriptar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "*") // Permitir cualquier origen solo para este método
@RequestMapping("/api")
public class UsuarioRestController {
    @Autowired
    UsuarioServiceImp service;

    @Autowired
    TipoMascotaServiceImpl serviceTipoMascota;

    @Autowired
    MascotaServiceImpl serviceMascota;

    @Autowired
    PuntosGanadosServiceImpl servicePuntosGanados;

    @Autowired
    NivelServiceImpl serviceConfigNivel;


    @GetMapping("/verificarToken")
    public ResponseEntity<?> VerificarToken(@RequestHeader("token") String token) throws Exception {

        Long id = null;

        String descriptar = Encriptar.Desencriptar(token, "YmbI4jJnOaXLPaoe55jL7A==");
        id = Long.parseLong(descriptar);


        InfoUsuario info = new InfoUsuario();

        Usuario usuario = service.buscarPorId(id);


        if(usuario != null){
            List<PuntosGanados> puntos = servicePuntosGanados.obtenerPuntosMascota(usuario.getMascota());
            Integer guardarPuntos = 0;
            for(int i=0; i< puntos.size() ; i++){
                PuntosGanados item = puntos.get(i);
                guardarPuntos = item.getPuntosExperiencia() + guardarPuntos;
            }

            Integer nivelActual = 0;
            if(guardarPuntos == 0)
            {
                nivelActual = 1;
            }
            else
            {
                Nivel nivelActualDB = serviceConfigNivel.encontrarNivel(guardarPuntos);
                nivelActual = nivelActualDB.getNivel();
            }

            Nivel sigNivel = serviceConfigNivel.sigNivel(nivelActual);


            info.setNombreUsuario(usuario.getUsuario());
            info.setNombreMascota(usuario.getMascota().getNombre());
            info.setTipoMascota(usuario.getMascota().getTipoMascota());
            info.setNivel(nivelActual);
            info.setExpTotal(guardarPuntos);
            info.setExpSigNivel(sigNivel.getExperiencia());

            String idString = Long.toString(usuario.getUsuarioId());
            String encriptado = Encriptar.Encriptar(idString, "YmbI4jJnOaXLPaoe55jL7A==");
            info.setToken(encriptado);
            return ResponseEntity.ok(info);
        }
        else {
            return ResponseEntity.badRequest().body("Correo o contraseña invalidos");
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody Login login) throws Exception {
        InfoUsuario info = new InfoUsuario();

        Usuario usuario = service.IniciarSesion(login.getCorreo(), login.getClave());



        if(usuario != null){
            List<PuntosGanados> puntos = servicePuntosGanados.obtenerPuntosMascota(usuario.getMascota());
            Integer guardarPuntos = 0;
            for(int i=0; i< puntos.size() ; i++){
                PuntosGanados item = puntos.get(i);
                guardarPuntos = item.getPuntosExperiencia() + guardarPuntos;
            }

            Integer nivelActual = 0;
            if(guardarPuntos == 0)
            {
                nivelActual = 1;
            }
            else
            {
                Nivel nivelActualDB = serviceConfigNivel.encontrarNivel(guardarPuntos);
                nivelActual = nivelActualDB.getNivel();
            }

            Nivel sigNivel = serviceConfigNivel.sigNivel(nivelActual);


            info.setNombreUsuario(usuario.getUsuario());
            info.setNombreMascota(usuario.getMascota().getNombre());
            info.setTipoMascota(usuario.getMascota().getTipoMascota());
            info.setNivel(nivelActual);
            info.setExpTotal(guardarPuntos);
            info.setExpSigNivel(sigNivel.getExperiencia());

            String idString = Long.toString(usuario.getUsuarioId());
            String encriptado = Encriptar.Encriptar(idString, "YmbI4jJnOaXLPaoe55jL7A==");
            info.setToken(encriptado);
            return ResponseEntity.ok(info);
        }
        else {
            return ResponseEntity.badRequest().body("Correo o contraseña invalidos");
        }
    }


    @PostMapping("/usuario")
    public ResponseEntity<?>  guardar (@RequestBody NuevoUsuario nuevo) throws  Exception{


        Usuario existe = service.buscarPorCorreo(nuevo.getCorreo());
        if(existe != null){
            return ResponseEntity.badRequest().body("Ya existe un usuario registrado con el correo " + nuevo.getCorreo());
        }

        TipoMascota tipomascota = serviceTipoMascota.buscarPorId(nuevo.getTipoMascotaId()); // Obtenemos el Tipo de Mascota en base al ID de tipo de mascota recibido.
        if(tipomascota == null){
            return ResponseEntity.badRequest().body("No Existe el tipo de mascota seleccionado");
        }
        //creamos un nuevo usuario
        Usuario usuarionuevo = new Usuario();// creamos la instancia del nuevo usuario
        usuarionuevo.setCorreo(nuevo.getCorreo());//asignamos el correo que ingresamos
        usuarionuevo.setClave(nuevo.getClave());// asignamos la clave ingresada
        usuarionuevo.setUsuario(nuevo.getNombre());// asignamos el nombre ingresado
        //Se crea el usuario en la base de datos
        Usuario usuarioGuardar = service.guardar(usuarionuevo);

        //creamos nueva mascota
        Mascota mascotanueva = new Mascota(); //creamos la instancia de la nueva mascota
        mascotanueva.setNombre(nuevo.getNombreMascota());//ponemos el nombre que le asignamos a la mascota
        mascotanueva.setTipoMascota(tipomascota);//le asignamos el tio de mascota correspondiente al id seleccionado
        mascotanueva.setUsuario(usuarioGuardar);
        Mascota mascotaguardada = serviceMascota.guardar(mascotanueva);


        usuarioGuardar.setMascota(mascotaguardada);
        usuarioGuardar.setClave(null);// no mandamos devuelta el pwd
        Usuario usuario = service.buscarPorId(usuarioGuardar.getUsuarioId());

        InfoUsuario info = new InfoUsuario();

        if(usuario != null){
            List<PuntosGanados> puntos = servicePuntosGanados.obtenerPuntosMascota(usuario.getMascota());
            Integer guardarPuntos = 0;
            for(int i=0; i< puntos.size() ; i++){
                PuntosGanados item = puntos.get(i);
                guardarPuntos = item.getPuntosExperiencia() + guardarPuntos;
            }

            Integer nivelActual = 0;
            if(guardarPuntos == 0)
            {
                nivelActual = 1;
            }
            else
            {
                Nivel nivelActualDB = serviceConfigNivel.encontrarNivel(guardarPuntos);
                nivelActual = nivelActualDB.getNivel();
            }

            Nivel sigNivel = serviceConfigNivel.sigNivel(nivelActual);


            info.setNombreUsuario(usuario.getUsuario());
            info.setNombreMascota(usuario.getMascota().getNombre());
            info.setTipoMascota(usuario.getMascota().getTipoMascota());
            info.setNivel(nivelActual);
            info.setExpTotal(guardarPuntos);
            info.setExpSigNivel(sigNivel.getExperiencia());

            String idString = Long.toString(usuario.getUsuarioId());
            String encriptado = Encriptar.Encriptar(idString, "YmbI4jJnOaXLPaoe55jL7A==");
            info.setToken(encriptado);
            return ResponseEntity.ok(info);
        }
        else {
            return ResponseEntity.badRequest().body("Correo o contraseña invalidos");
        }
    }


    // @GetMapping("/usuario")
    // public List<Usuario> lista(){
    //     List<Usuario> mostrar = service.lista();
    //     return mostrar;
    // }
    // @GetMapping("/usuario/{id}")
    // public Usuario buscarPorId (@PathVariable Long id){
    //     Usuario mostrar = service.buscarPorId(id);
    //     return mostrar;
    // }
    // @PostMapping("/usuario")
    // public Usuario guardar (@RequestBody Usuario usuarioNuevo){
    //     Usuario usuarioGuardar= service.guardar(usuarioNuevo);
    //     return usuarioGuardar;
    // }
    // @DeleteMapping("/usuario/{id}")
    // public String borrarPorId (@PathVariable Long id){
    //     service.borrarPorId(id);
    //     return "El usuario ha sido borrrado";
    // }
    // @PutMapping("/usuario/{id}")
    // public Usuario editarPorId (@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
    //     Usuario estudianteEditado = service.editarPorId(id, usuarioActualizado);
    //     return estudianteEditado;
    // }

}
