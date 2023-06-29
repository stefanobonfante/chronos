package it.addvalue.chronos.service;

import it.addvalue.chronos.core.exception.EsecuzioneErrataException;
import it.addvalue.chronos.model.dto.StimeDTO;
import it.addvalue.chronos.model.dto.carichiDTO;
import it.addvalue.chronos.model.entity.*;
import it.addvalue.chronos.model.mapper.StimeMapper;
import it.addvalue.chronos.repository.StimeRrepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StimeTest {

    @InjectMocks
    public StimeService service;

    @Mock
    public StimeRrepository stimeRrepository;

    @Mock
    public StimeMapper mapper;



    @Test
    public void testRecuperoTask() throws EsecuzioneErrataException {
        List<StimeEntity> listaStimeEntity = dammiUnaListaEntity();
        StimeEntity stimaEn = dammiUnaListaEntity().get(0);

        // Configura il comportamento simulato del repository
        when(stimeRrepository.getTask("a")).thenReturn(listaStimeEntity);

        // Configura il comportamento simulato del mapper
        when(mapper.FromEntityToProjection(listaStimeEntity.get(0))).thenReturn(dammiUnaListaProjection().get(0));
        // Chiama il metodo da testare
        List<StimeProjection> result = service.recuperoTask("a");

        // Verifica il risultato
        assertEquals(1, result.size());
        StimeDTO expectedDto = dammiUnaListaDto().get(0);
        StimeProjection stimeProjection1 = result.get(0);
        assertEquals(expectedDto.getCodTask(), stimeProjection1.getCodTask());
        // Effettua le verifiche per gli altri campi del DTO
    }
    @Test
    public void testGetTaskFailed() throws EsecuzioneErrataException {
        List<StimeEntity> listaStimeEntity = dammiUnaListaEntity();
        StimeEntity stimaEn = dammiUnaListaEntity().get(0);

        assertThatThrownBy(() -> service.recuperoTask("a")).isInstanceOf(EsecuzioneErrataException.class);
    }

    @Test
    public void testRecuperoSubTask() throws EsecuzioneErrataException {
        List<StimeEntity> listaStimeEntity = dammiUnaListaEntity();
        StimeEntity stimaEn = dammiUnaListaEntity().get(0);

        // Configura il comportamento simulato del repository
        when(stimeRrepository.getSubTask("a","a")).thenReturn(listaStimeEntity);

        // Configura il comportamento simulato del mapper
        when(mapper.FromEntityToProjectionSubTask(listaStimeEntity.get(0))).thenReturn(dammiUnaListaProjectionSubTask().get(0));
        // Chiama il metodo da testare
        List<StimeProjectionSubTask> result = service.recuperoSubTask("a", "a");

        // Verifica il risultato
        assertEquals(1, result.size());
        StimeDTO expectedDto = dammiUnaListaDto().get(0);
        StimeProjectionSubTask stimeProjectionSubTask = result.get(0);
        assertEquals(expectedDto.getCodSubtask(), stimeProjectionSubTask.getCodTask());
        // Effettua le verifiche per gli altri campi del DTO
    }
    @Test
    public void testGetSubTaskFailed() throws EsecuzioneErrataException {
        List<StimeEntity> listaStimeEntity = dammiUnaListaEntity();
        StimeEntity stimaEn = dammiUnaListaEntity().get(0);

        assertThatThrownBy(() -> service.recuperoSubTask("a","a")).isInstanceOf(EsecuzioneErrataException.class);
    }


    public List<StimeEntity> dammiUnaListaEntity() {
        return Arrays.asList(
                new StimeEntity("a", "a", "a", "a", "a", "a", "a", "a", "a", "a", 2, "a", "a", "a"));
    }

    public List<StimeDTO> dammiUnaListaDto() {
        return Arrays.asList(
                new StimeDTO("a", "a", "a", "a", "a", "a", "a", "a", "a", 2, "a", "a", "a", "a"));
    }

    public List<StimeProjection> dammiUnaListaProjection() {
        return Arrays.asList(new StimeProjection("a", "a", "a"));
    }

    public List<StimeProjectionSubTask> dammiUnaListaProjectionSubTask() {
        return Arrays.asList(new StimeProjectionSubTask("a", "a", "a", "a"));
    }

}
