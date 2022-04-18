package br.com.alura.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.Status;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		List<Pedido> pedidos = pedidoRepository.findAll();
		if(pedidos.isEmpty() || pedidos.size() == 0) {
			return "listaVazia.html";
		}
		model.addAttribute("listaPedidos", pedidos);
		model.addAttribute("pedido", pedido);
		return "home.html";
		
	}
	
	@GetMapping("/home/aprovado")
	public String aprovado(Model model) {
			
		List<Pedido> pedidos = pedidoRepository.findByStatus(Status.APROVADO);
		if(pedidos.isEmpty() || pedidos.size() == 0) {
			return "listaVazia.html";
		}
		model.addAttribute("listaPedidos", pedidos);
		return "home.html";
	}
	@GetMapping("/home/aguardando")
	public String aguardando(Model model) {
			
		List<Pedido> pedidos = pedidoRepository.findByStatus(Status.AGUARDANDO);
		if(pedidos.isEmpty() || pedidos.size() == 0) {
			return "listaVazia.html";
		}
		model.addAttribute("listaPedidos", pedidos);
		
		return "home.html";
	}
	
	@GetMapping("/home/entregue")
	public String entregue(Model model) {
			
		List<Pedido> pedidos = pedidoRepository.findByStatus(Status.ENTREGUE);
		if(pedidos.isEmpty() || pedidos.size() == 0) {
			return "listaVazia.html";
		}
		model.addAttribute("listaPedidos", pedidos);
		return "home.html";
	}
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
