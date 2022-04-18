package br.com.alura.mvc.mudi.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.Status;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("novo")
	public String formulario(RequisicaoNovoPedido requisicaoNovoPedido) {
		return "pedido/novo.html";
	}

	@PostMapping("/cadastrar")
	public String cadastrar(@Valid RequisicaoNovoPedido requisicaoNovoPedido, BindingResult result) {
	
		if(result.hasErrors()) {
			return "pedido/novo.html";
		}else {
			Pedido pedido = requisicaoNovoPedido.toPedido();
			pedidoRepository.save(pedido);
			return "redirect:/home";
		}
		
	}
	
	@PostMapping("/excluir")
	public String excluir(Pedido pedido, BindingResult result) {
	
		if(result.hasErrors()) {
			return "pedido/excluir.html";
		}else {
			pedidoRepository.delete(pedido);
			return "redirect:/home";
		}
		
	}

	@GetMapping("atualizar/{id}")
	public String atualizarPedido(@PathVariable("id")  Integer id, Model model) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		
		
		if (pedido.isEmpty()) {
			throw new IllegalArgumentException("Pedido inválido");
		} else {
			model.addAttribute("pedido", pedido);
		}
		return "pedido/atualizar.html";
	}
	
	@GetMapping("excluir/{id}")
	public String excluirPedido(@PathVariable("id")  Integer id, Model model) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		
		
		if (pedido.isEmpty()) {
			throw new IllegalArgumentException("Pedido inválido");
		} else {
			model.addAttribute("pedido", pedido);
		}
		return "pedido/excluir.html";
	}
	
	@PostMapping("/recadastrar")
	public String recadastrar(Pedido pedido, BindingResult result) {
	
		if(result.hasErrors()) {
			return "pedido/atualizar.html";
		}else {
			pedidoRepository.save(pedido);
			return "redirect:/home";
		}
		
	}
}
