package com.instrumentos.main.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class InstrumentoDTO {

	private Long id;
	private String instrumento, marca, modelo, imagen, descripcion;
	private Double precio, costoEnvio;
	private Integer cantidadVendida;
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setPrecio(String precio) {
		this.precio = Double.parseDouble(precio);
	}
		
	public void setCostoEnvio(String costoEnvio) {
		if(costoEnvio.toUpperCase() == "G") {
			this.costoEnvio = 0.0;
		}
		else {
			this.costoEnvio = Double.parseDouble(costoEnvio);
		}
	}

	public void setCantidadVendida(String cantidadVendida) {
		this.cantidadVendida = Integer.parseInt(cantidadVendida);
	}

}
