package com.instrumentos.main.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instrumentos.main.entities.Instrumento;
import com.instrumentos.main.repositories.InstrumentoRepository;

@Service
public class InstrumentoService implements BaseService<Instrumento> {

	@Autowired
	private InstrumentoRepository repository;

	
	@Override
	@Transactional
	public List<Instrumento> findAll() throws Exception {
		try {
			return repository.findAll();
			
			/*for(Instrumento inst : instrumentos) {
				InstrumentoDTO dto = new InstrumentoDTO();
				
				dto.setId(inst.getId());
				dto.setInstrumento(inst.getInstrumento());
				dto.setMarca(inst.getMarca());
				dto.setModelo(inst.getModelo());
				dto.setImagen(inst.getImagen());
				dto.setPrecio(inst.getPrecio().toString());
				dto.setCostoEnvio(inst.getCostoEnvio().toString());
				dto.setCantidadVendida(inst.getCantidadVendida().toString());
				dto.setDescripcion(inst.getDescripcion());
				
			}
			return dtos;*/
		
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	

	@Override
	@Transactional
	public Instrumento findById(Long id) throws Exception {
		try {
			Optional<Instrumento> optional = repository.findById(id);
			return optional.get();
		
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	
	@Override
	@Transactional
	public Instrumento save(Instrumento inst) throws Exception {
		try {
			return repository.save(inst);
			
			/*Instrumento inst = new Instrumento();
			
			inst.setInstrumento(dto.getInstrumento());
			inst.setMarca(dto.getMarca());
			inst.setModelo(dto.getModelo());
			inst.setImagen(dto.getImagen());
			inst.setPrecio(dto.getPrecio().toString());
			inst.setCostoEnvio(dto.getCostoEnvio().toString());
			inst.setCantidadVendida(dto.getCantidadVendida().toString());
			inst.setDescripcion(dto.getDescripcion());*/

		} catch (Exception e) {
			throw new Exception(e.getMessage());	
		}
	}
	

	@Override
	@Transactional
	public Instrumento update(Long id, Instrumento instEditado) throws Exception {
		try {
			Optional<Instrumento> optional = repository.findById(id);
			Instrumento inst = optional.get();
			
			inst.setId(id);
			inst.setInstrumento(instEditado.getInstrumento());
			inst.setMarca(instEditado.getMarca());
			inst.setModelo(instEditado.getModelo());
			inst.setImagen(instEditado.getImagen());
			inst.setPrecio(instEditado.getPrecio().toString());
			inst.setCostoEnvio(instEditado.getCostoEnvio().toString());
			inst.setCantidadVendida(instEditado.getCantidadVendida().toString());
			inst.setDescripcion(instEditado.getDescripcion());
			
			return repository.save(inst);
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());	
		}
	}

	
	@Override
	@Transactional
	public boolean delete(Long id) throws Exception {
		try {
			if(repository.existsById(id)) {
				repository.deleteById(id);
				return true;
			
			} else {
				throw new Exception();
			}	
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());	
		}
	}

}
