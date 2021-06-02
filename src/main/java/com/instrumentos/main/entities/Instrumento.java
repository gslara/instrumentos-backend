package com.instrumentos.main.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "instrumento")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Instrumento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String instrumento, marca, modelo, imagen;
	
	@Column(columnDefinition = "TEXT")
	private String descripcion;
	
	private Double precio;
	
	@Column(name = "costo_envio")
	private Double costoEnvio;
	
	@Column(name = "cantidad_vendida")
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
		if(costoEnvio.toUpperCase().equals("G")) {
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
