    package it.addvalue.chronos.service;

    import it.addvalue.chronos.model.dto.StimeDTO;
    import it.addvalue.chronos.model.entity.StimeEntity;
    import it.addvalue.chronos.model.entity.StimeProjection;
    import it.addvalue.chronos.model.mapper.StimeMapper;
    import it.addvalue.chronos.repository.StimeRrepository;
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.mockito.InjectMocks;
    import org.mockito.Mock;
    import org.mockito.runners.MockitoJUnitRunner;

    import java.util.Arrays;
    import java.util.List;

    import static org.mockito.Mockito.when;

    @RunWith(MockitoJUnitRunner.class)
    public class StimeTest {

        @InjectMocks
        public StimeService service;

        @Mock
        public StimeRrepository stimeRrepository;

        @Mock
        public StimeMapper mapper;

        @Mock
        public StimeProjection stimeProjection;

        @Test
        public void testRecuperoTask(){
            List<StimeEntity> listaStimeEntity=dammiUnaListaEntity();
            StimeEntity stimaEn=dammiUnaListaEntity().get(0);
            
            when(stimeRrepository.getTask())
        }

        public List<StimeEntity> dammiUnaListaEntity(){
            return Arrays.asList(new StimeEntity("a", "a", "a", "a", "a",
                    "a", "a", "a", "a",
                    "a", 2, "a", "a", "a"));
        }
        public List<StimeDTO> dammiUnaListaDto(){
            return Arrays.asList(new StimeDTO("a", "a", "a", "a", "a",
                    "a", "a", "a", "a",
                    2,"a" , "a", "a", "a"));
        }

        public List<StimeProjection> dammiUnaListaProjection(){
            return Arrays.asList(new StimeProjection("a", "a", "a"));
        }
    }
