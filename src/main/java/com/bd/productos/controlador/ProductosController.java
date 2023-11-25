package com.bd.productos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.productos.modelo.ClassProducto;
import com.bd.productos.servicios.IProductoServicio;

@Controller
@RequestMapping("/ControlProducto")
public class ProductosController {

	@Autowired
	private IProductoServicio iprodservicio;
	
	// Listar
	@GetMapping("/ListadoProductos")
	public String ListadoProductos(Model modelo) {
		List<ClassProducto> listar = iprodservicio.ListadoProductos();
		modelo.addAttribute("listadoproducto", listar);
		return "Vistas/Producto/ListadoProductos";
	}
	
	// Registrar
	@GetMapping("/Registrar")
	public String RegistrarProducto(Model modelo) {
		ClassProducto claprod = new ClassProducto();
		modelo.addAttribute("regprod", claprod);
		return "Vistas/Producto/FrmRegistrarProducto";
	}
	
	@PostMapping("/Guardar")
	public String GuardarAuto(@ModelAttribute ClassProducto claprod) {
		iprodservicio.RegistrarProducto(claprod);
		return "redirect:/ControlProducto/ListadoProductos";
	}
	
	// Editar
	@GetMapping("/Editar/{id}")
	public String Editar(@PathVariable("id") Integer idprod, Model modelo) {
		ClassProducto claprod = iprodservicio.BuscarPorId(idprod);
		modelo.addAttribute("regprod", claprod);
		return "Vistas/Producto/FrmRegistrarProducto";
	}
	
	// Eliminar
	@GetMapping("/Eliminar/{id}")
	public String Eliminar(@PathVariable("id") Integer idprod, Model modelo) {
		iprodservicio.EliminarProducto(idprod);
		List<ClassProducto> listado = iprodservicio.ListadoProductos();
		modelo.addAttribute("listadoproducto", listado);
		return "redirect:/ControlProducto/ListadoProductos";
	}
	
}
