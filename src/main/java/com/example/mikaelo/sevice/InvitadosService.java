package com.example.mikaelo.sevice;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.example.mikaelo.entity.Invitado;
import com.example.mikaelo.model.InvtadosArchivo;
import com.example.mikaelo.repository.InvitadosRepository;
import com.example.mikaelo.util.Constantes;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class InvitadosService {

	@Autowired
	InvitadosRepository invitadosRepository;

	public Invitado findByNombre(String nombre){
		return invitadosRepository.findByNombre(nombre);
	}

	public List<Invitado> altamMasivaCSV(Reader reader) {
		CsvToBean<InvtadosArchivo> csvToBean =null;
		try {
			csvToBean = new CsvToBeanBuilder<InvtadosArchivo>(reader)
	                .withType(InvtadosArchivo.class)
	                .withIgnoreLeadingWhiteSpace(true)
	                .build();
		}catch(Exception e) {
		}
		List<Invitado> listInvitado = altaCsv(csvToBean);
		

		return listInvitado;
	}
	
	private List<Invitado> altaCsv(CsvToBean<InvtadosArchivo> csvToBean) {
		List<Invitado> listInvitado= new ArrayList<>();
		List<InvtadosArchivo> archivo = csvToBean.parse();
		Invitado invitado;
		for(InvtadosArchivo arch : archivo) {
			invitado = new Invitado();
			//Valores asignados
			invitado.setNombre(arch.getNombre());
			invitado.setGrupo(arch.getGrupo());
			invitado.setNumeroInvitado(arch.getNumero());
			invitado.setMesa(arch.getMesa());
			invitado.setNombreCompleto(arch.getNombreCompleto());
			invitado.setViaje(arch.isViaja());
			invitado.setMensaje(arch.getMensaje());
			invitado.setInvitadoDe(arch.getInvitadoDe());
			listInvitado.add(invitado);
		}

		try {
			invitadosRepository.saveAll(listInvitado);
		}catch(Exception e) {
	    	return null;
		}
		return listInvitado;
	}

	public List<Invitado> consultaTodo() {
		
		return invitadosRepository.findAll();
	}
	
	
	public BufferedImage generaqr(String cadena) throws IOException{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			BitMatrix matrix = new MultiFormatWriter().encode(Constantes.URL_INVITADOS+cadena, BarcodeFormat.QR_CODE, 350, 350);
			MatrixToImageWriter.writeToStream(matrix, MediaType.IMAGE_PNG.getSubtype(), baos, new MatrixToImageConfig());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		 ByteArrayInputStream bis = new ByteArrayInputStream(baos.toByteArray());
		return ImageIO.read(bis);
	}

	public Invitado confirmaAsistencia(Invitado invitado) {
		invitadosRepository.confirmaAsistencia(invitado);
		return invitado;
	}

	public Invitado actualizaMensaje(Invitado invitado) {
		invitadosRepository.actualizaMensaje(invitado);
		return invitado;
	}
	
	
}
