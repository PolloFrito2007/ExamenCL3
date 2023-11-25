package com.bd.productos.servicios;

import java.util.List;

import com.bd.productos.modelo.ClassProducto;

public interface IProductoServicio {

	public List<ClassProducto> ListadoProductos();
	public void RegistrarProducto(ClassProducto claprod);
	public void EliminarProducto(Integer id);
	public ClassProducto BuscarPorId(Integer id);
	
}
