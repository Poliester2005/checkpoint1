package br.com.fiap.checkpoint1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do cliente é obrigatório")
    private String clienteNome;

    private LocalDate dataPedido;

    @PositiveOrZero(message = "O valor total não pode ser negativo")
    private double valorTotal;

    @PrePersist
    public void preencherData() {
        this.dataPedido = LocalDate.now();
    }
}
