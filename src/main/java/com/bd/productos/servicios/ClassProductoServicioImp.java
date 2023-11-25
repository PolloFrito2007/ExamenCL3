package com.bd.productos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.productos.modelo.ClassProducto;
import com.bd.productos.repositorio.IProducto;

@Service
public class ClassProductoServicioImp implements IProductoServicio{
	
	@Autowired
	private IProducto iproductorepository;

	@Override
	public List<ClassProducto> ListadoProductos() {
		return (List<ClassProducto>) iproductorepository.findAll();
	}

	@Override
	public void RegistrarProducto(ClassProducto claprod) {
		iproductorepository.save(claprod);		
	}

	@Override
	public void EliminarProducto(Integer id) {
		iproductorepository.deleteById(id);		
	}

	@Override
	public ClassProducto BuscarPorId(Integer id) {
		return iproductorepository.findById(id).orElse(null);
	}
	
}
