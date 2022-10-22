package com.api.doacaopontos.usuarioTeste;

import com.api.doacaopontos.dtos.UsuarioDtoEntrada;
import com.api.doacaopontos.model.UsuarioModel;
import com.api.doacaopontos.repository.UsuarioRepository;
import com.api.doacaopontos.services.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@SpringBootTest
public class TesteUsuariService {

    @Mock
    UsuarioService usuarioService;

    @MockBean
    UsuarioRepository usuarioRepository;

    private UsuarioModel usuarioModel;

    @BeforeEach
    private void inicializadora(){

        MockitoAnnotations.openMocks(this);
         usuarioModel = new UsuarioModel(1L,"William", "will@zup.com", "123", 0L);
    }

    @Test
    void exibierUsuariosTest(){
        List<UsuarioDtoEntrada> todosUsuarios = usuarioService.buscarTodos();
        Assertions.assertTrue((todosUsuarios.isEmpty()));
    }

    @Test
    void exibierUsuarioIdTest(){
        usuarioRepository.findById(1L);
        Mockito.verify(usuarioRepository,Mockito.times(1)).findById(1L);
    }

    @Test
    void testCadastro(){
        Mockito.when(usuarioRepository.existsById(Mockito.anyLong())).thenReturn(true);
        usuarioRepository.save(usuarioModel);
         Mockito.verify(usuarioRepository, Mockito.times(1)).save(usuarioModel);
    }
}
