package it.addvalue.chronos.service;

import it.addvalue.chronos.model.entity.CarichiEntity;
import it.addvalue.chronos.repository.CarichiRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static java.util.Arrays.asList;

@RunWith(MockitoJUnitRunner.class)
public class PresenzaCarichiTest {
  @InjectMocks CarichiService carichiService;
  @Mock CarichiRepository carichiRepository;

  @Test
  public void test() {

    Mockito.when(carichiRepository.queryPresenzaCarichi(1999, 3, 1, "abatif", "a"))
        .thenReturn(queryPresenzaCarichi(1999, 3, 1, "abatif", "a"));

    carichiService.presenzaCarichi(1999, 3, 1, "abatif", "a");

    Assert.assertFalse(queryPresenzaCarichi(1999, 3, 1, "abatif", "a").isEmpty());
  }

  private List<CarichiEntity> queryPresenzaCarichi(
      int anno, int mese, int giorno, String codiceUtente, String codJob) {
    return asList(
        new CarichiEntity(
            "a", "abatif", 1999, 3, 1, "a", "a", "a", "a", "a", "18:00", "N", 8, "a", "N", "a",
            "18:00", "a", "N"));
  }
}
