package com.api.doacaopontos.itemDoadoTeste;

import com.api.doacaopontos.dtos.ItemSaidaDto;
import com.api.doacaopontos.model.ItemDoado;
import com.api.doacaopontos.repository.ItemDoadoRepository;
import com.api.doacaopontos.services.ItemDoadosService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class ItemDoadoServiceTeste {

    @Mock
    ItemDoadosService itemDoadosService;

    @MockBean
    ItemDoadoRepository itemDoadoRepository;

    private ItemDoado itemDoado;

    @BeforeEach
    private void inicializadora(){
        MockitoAnnotations.openMocks(this);

        LocalDate data1 = LocalDate.parse("2022-10-10");
        LocalDate data2 = LocalDate.parse("2022-10-11");
        itemDoado = new ItemDoado(1L, "bicicleta", "nova", 1L, "aberta,", data1,data2, 2L, 30L, 50L );
    }

     /*@Test
   void exibierItemsTest(){
        List<ItemSaidaDto> todosUsuarios = itemDoadosService.buscarTodos();
        Assertions.assertTrue((todosUsuarios.isEmpty()));
}*/

    @Test
    void exibierItemIdTest(){
        itemDoadoRepository.findById(1L);
        Mockito.verify(itemDoadoRepository,Mockito.times(1)).findById(1L);
}

    @Test
    void testCadastro(){
        Mockito.when(itemDoadoRepository.existsById(Mockito.anyLong())).thenReturn(true);
        itemDoadoRepository.save(itemDoado);
        Mockito.verify(itemDoadoRepository, Mockito.times(1)).save(itemDoado);
    }
}
