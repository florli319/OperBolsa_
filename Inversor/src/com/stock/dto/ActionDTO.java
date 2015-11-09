package com.stock.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ActionDTO {

	private String empresa;
	private int cantidad;
	private Double precioVenta;
	private Double precioCompra;
	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}
	/**
	 * @param empresa the empresa to set
	 */
	@XmlElement
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the precioVenta
	 */
	public Double getPrecioVenta() {
		return precioVenta;
	}
	/**
	 * @param precioVenta the precioVenta to set
	 */
	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}
	/**
	 * @return the precioCompra
	 */
	public Double getPrecioCompra() {
		return precioCompra;
	}
	/**
	 * @param precioCompra the precioCompra to set
	 */
	public void setPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
	}
	
}
