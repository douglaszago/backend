package com.senac.pizzademo.controller;

import com.senac.pizzademo.dto.CardapioDTO;
import com.senac.pizzademo.model.Cardapio;
import com.senac.pizzademo.model.Pizza;
import com.senac.pizzademo.repository.CardapioRepository;
import com.senac.pizzademo.repository.PizzaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CardapioControllerTest {
    @Mock
    private CardapioRepository cardapioRepository;
    @Mock
    private PizzaRepository pizzaRepository;

    private CardapioController cardapioController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cardapioController = new CardapioController(cardapioRepository, pizzaRepository);
    }

    @Test
    void testUpdateCardapio_PutMapping() {
        // Setup original Cardapio and Pizza
        Pizza pizza = new Pizza();
        pizza.setId(1L);
        pizza.setSabor("Calabresa");
        Cardapio original = new Cardapio();
        original.setValor(30.0f);
        original.setTamanho("M");
        original.setPizza(pizza);

        // Setup CardapioDTO for update
        CardapioDTO dto = new CardapioDTO();
        CardapioDTO.PizzaDTO pizzaDTO = new CardapioDTO.PizzaDTO();
        pizzaDTO.setNome("Calabresa");
        dto.setPizza(pizzaDTO);
        dto.setPreco(40.0f);
        dto.setTamanho("G");

        Cardapio updated = new Cardapio();
        updated.setValor(40.0f);
        updated.setTamanho("G");
        updated.setPizza(pizza);

        when(cardapioRepository.findById(1L)).thenReturn(Optional.of(original));
        when(pizzaRepository.findAll()).thenReturn(List.of(pizza));
        when(cardapioRepository.save(any(Cardapio.class))).thenReturn(updated);

        Cardapio result = cardapioController.updateCardapio(1L, dto);
        assertEquals(40.0f, result.getValor());
        assertEquals("G", result.getTamanho());
        assertEquals("Calabresa", result.getPizza().getSabor());
        verify(cardapioRepository, times(1)).findById(1L);
        verify(cardapioRepository, times(1)).save(any(Cardapio.class));
        verify(pizzaRepository, times(1)).findAll();
    }
}
