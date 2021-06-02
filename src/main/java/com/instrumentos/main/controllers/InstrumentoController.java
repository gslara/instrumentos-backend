package com.instrumentos.main.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instrumentos.main.entities.Instrumento;
import com.instrumentos.main.services.InstrumentoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/instrumentos")
public class InstrumentoController {
	
	@Autowired
	private InstrumentoService service;
	
	
	@GetMapping("/")
	@Transactional
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"Error. Registro no encontrado.\"}");
		}
	}
	
	
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"Error. Instrumento no encontrado.\"}");
		}
	}
	
	
	@PostMapping("/")
	@Transactional
	public ResponseEntity<?> post(@RequestBody Instrumento inst) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.save(inst));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error. No se pudo guardar la información.\"}");
		}
	}
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Instrumento inst) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.update(id, inst));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error. No se pudo actualizar la información.\"}");
		}
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error. Instrumento no encontrado.\"}");
		}
	}
	

}
