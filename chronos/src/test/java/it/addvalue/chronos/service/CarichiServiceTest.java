package it.addvalue.chronos.service;
import it.addvalue.chronos.ChronosApplication;
import it.addvalue.chronos.core.exception.EsecuzioneErrataException;
import it.addvalue.chronos.model.dto.carichiDTO;
import it.addvalue.chronos.model.entity.CarichiEntity;
import it.addvalue.chronos.model.entity.User;
import it.addvalue.chronos.model.mapper.CarichiDTOEntityMapper;
import it.addvalue.chronos.repository.CarichiRepository;
import it.addvalue.chronos.repository.IUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarichiServiceTest {

    @InjectMocks
    CarichiService servizio = new CarichiService();
    @Mock
    IUserRepository userRepository;

    @Mock
    CarichiRepository carichiRepository;

    @Mock
    CarichiDTOEntityMapper mapper;


    @Test
    public void testdelete() throws EsecuzioneErrataException {
        List<carichiDTO> carichiDTOS= dammiUnaListaDto();
        CarichiEntity caricoEntity= dammiUnaListaEntity().get(0);


        when(mapper.toEntities(carichiDTOS)).thenReturn(dammiUnaListaEntity());
        when(carichiRepository.existsById(caricoEntity.getIdCarico())).thenReturn(false);
        assertThatThrownBy(() -> servizio.delete(carichiDTOS)).isInstanceOf(EsecuzioneErrataException.class);

    }

    @Test
    public void testSalvataggio() throws EsecuzioneErrataException {
        List<carichiDTO> carichiDTOS= dammiUnaListaDto();
        CarichiEntity caricoEntity= dammiUnaListaEntity().get(0);
        when(mapper.toEntities(carichiDTOS)).thenReturn(dammiUnaListaEntity());
        when(userRepository.findByUserCode(caricoEntity.getCodUtente())).thenReturn(new User("s","s","s",99));

        assertThatThrownBy(() -> servizio.salvataggio(carichiDTOS)).isInstanceOf(EsecuzioneErrataException.class);
    }

    @Test
    public void testModifica() throws EsecuzioneErrataException {
        List<carichiDTO> carichiDTOS= dammiUnaListaDto();
        CarichiEntity caricoEntity= dammiUnaListaEntity().get(0);
        when(mapper.toEntities(carichiDTOS)).thenReturn(dammiUnaListaEntity());
        when(carichiRepository.findById(caricoEntity.getIdCarico())).thenReturn(Optional.of(caricoEntity));

        boolean esito= servizio.modificaElencoCarichi(carichiDTOS);
        assertTrue(esito);
        //assertThatThrownBy(() -> servizio.modificaElencoCarichi(carichiDTOS)).isInstanceOf(EsecuzioneErrataException.class);


    }

    public List<carichiDTO> dammiUnaListaDto(){
        ArrayList<carichiDTO> carichi=new ArrayList<>();
        carichi.add(new carichiDTO("a", "abatif", 1999, 3, 1, "a", "a", "a", "a", "a",
                "18:00", "N", 8, "a", "N", "a", "18:00", "a", "N"));
        return carichi;
    }

    public List<CarichiEntity> dammiUnaListaEntity(){
        return Arrays.asList(new CarichiEntity("", "abatif", 1999, 6, 1, "a", "a", "a", "a", "a",
                "18:00", "N", 8, "a", "N", "a", "18:00", "a", "N"));
    }





}