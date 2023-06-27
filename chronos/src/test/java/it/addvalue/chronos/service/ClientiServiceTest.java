package it.addvalue.chronos.service;

import it.addvalue.chronos.model.dto.clientiDTO;
import it.addvalue.chronos.model.entity.ClientiEntity;
import it.addvalue.chronos.model.mapper.ClientiMapper;
import it.addvalue.chronos.repository.ClientiRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.List;

import static java.util.Arrays.asList;

@RunWith(MockitoJUnitRunner.class)
public class ClientiServiceTest {
    @InjectMocks
    ClientiService clientiService;
    @Mock
    ClientiRepository clientiRepository;

    @Mock
    ClientiMapper clientiMapper;

    @Test
    public void test() {
        Mockito.when(clientiRepository.queryRecuperoClienti()).thenReturn(ottieniClienti());
        Mockito.when(clientiMapper.toDtosRidotto(ottieniClienti().get(0))).thenReturn(mapper());


        List<clientiDTO> clientiDTOS = clientiService.recuperaClienti();

        Mockito.verify(clientiMapper).toDtosRidotto(ottieniClienti().get(0));
        Assert.assertEquals(mapper(),clientiDTOS.get(0));
    }

    private List<ClientiEntity> ottieniClienti() {
        return asList(new ClientiEntity("2321","ewre",1231,"ciao"));
    }
    private clientiDTO mapper() {
        return new clientiDTO("2321","ewre",1231,"ciao");
    }

}