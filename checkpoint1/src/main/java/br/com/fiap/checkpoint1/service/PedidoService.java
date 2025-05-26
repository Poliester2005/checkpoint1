package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.model.Pedido;
import br.com.fiap.checkpoint1.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Optional<Pedido> atualizar(Long id, Pedido novoPedido) {
        return pedidoRepository.findById(id).map(p -> {
            p.setClienteNome(novoPedido.getClienteNome());
            p.setValorTotal(novoPedido.getValorTotal());
            return pedidoRepository.save(p);
        });
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}
