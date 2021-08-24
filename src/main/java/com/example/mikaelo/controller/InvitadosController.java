package com.example.mikaelo.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.mikaelo.entity.Invitado;
import com.example.mikaelo.sevice.InvitadosService;

@RestController
@RequestMapping("invitados/")
public class InvitadosController {

	@Autowired
	InvitadosService invitadosService;
	
    @GetMapping("/{nombre}")
	public Invitado findByNombre(@PathVariable String nombre) {
    	System.out.println(nombre);
		return invitadosService.findByNombre(nombre);
	}
	
	@PostMapping("/altamasivacsv")
	public List<Invitado> altamMasivaCSV(@RequestParam("file") MultipartFile file) {

		try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			return invitadosService.altamMasivaCSV(reader);
		}catch(Exception e) {
			return null;
		}
	}
	
	@PostMapping("/confirmacion")
	public Invitado confirmaAsistencia(@RequestBody Invitado invitado){
		return invitadosService.confirmaAsistencia(invitado);
	}
	
	@PostMapping("/mensaje")
	public Invitado actualizaMensaje(@RequestBody Invitado invitado){
		return invitadosService.actualizaMensaje(invitado);
	}
	
	@GetMapping("/consulta")
	public List<Invitado> consultaTodo() {
		return invitadosService.consultaTodo();
	}
	
	@GetMapping(value="/generaqr/{nombre}", produces = MediaType.IMAGE_PNG_VALUE)
    public BufferedImage generaqr(@PathVariable("nombre") String nombre)
    throws Exception {
        return invitadosService.generaqr(nombre);
    }
}
