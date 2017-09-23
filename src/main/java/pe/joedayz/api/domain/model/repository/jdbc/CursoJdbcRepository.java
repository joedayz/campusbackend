package pe.joedayz.api.domain.model.repository.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.joedayz.api.dto.CursoDto;


@Repository
public class CursoJdbcRepository implements CursoCustomRepository {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(CursoJdbcRepository.class);

	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	CursoJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private static final String SEARCH_CURSOS_DESTACADOS_BY_CODE = "select c.destacado_home as \"destacadoHome\",\n"
			+ "  c.status as \"status\",\n" + "  c.titulo_curso as \"tituloCurso\",\n" + "  c.titulo_footer_curso as \"tituloFooterCurso\",\n"
			+ "  c.key_curso as \"keyCurso\",\n" 
			+ "  c.tipo_curso as \"tipoCursoId\",\n"
			+ "  SUBSTRING(dat.descripcion_curso,1, 400) as \"descripcionCurso\",\n"
			+ "  det.duracion_curso as \"duracionCurso\", \n"
			+ "  det.horarios_curso as \"horariosCurso\" \n"
			+ "  from curso c inner join tipo_curso tc on tc.tipo_curso_id = c.tipo_curso and tc.code=:code and  c.status='A' and tc.status='A' \n"
			+ " inner join datos_curso dat on dat.curso_id = c.curso_id \n"
			+ " inner join detalles_curso det on det.curso_id = c.curso_id \n"
			+ " where c.destacado_home='Y'";

	
	private static final String SEARCH_CURSOS_BY_CODE = "select c.destacado_home as \"destacadoHome\",\n"
			+ "  c.status as \"status\",\n" + "  c.titulo_curso as \"tituloCurso\",\n" + "  c.titulo_footer_curso as \"tituloFooterCurso\",\n"
			+ "  c.key_curso as \"keyCurso\",\n" 
			+ "  c.tipo_curso as \"tipoCursoId\"\n"
			+ " from curso c inner join tipo_curso tc on tc.tipo_curso_id = c.tipo_curso and tc.code=:code and c.status='A' and tc.status='A'\n"
			+ " order by c.titulo_curso";

	private static final String SEARCH_DATOS_CURSO_BY_KEY_CURSO = "select c.curso_id as \"cursoId\",\n"
			+ " c.titulo_curso as \"tituloCurso\",\n"
			+ " c.titulo_footer_curso as \"tituloFooterCurso\",\n" 
			+ " c.status as \"status\",\n" 
			+ " c.destacado_home as \"destacadoHome\",\n"
			+ " c.key_curso as \"keyCurso\",\n"
			+ " dc.descripcion_curso as \"descripcionCurso\",\n"
			+ " dc.temas_curso as \"temasCurso\",\n"
			+ " dc.requisitos_curso as \"preRequisitosCurso\",\n"
			+ " dc.participantes_curso as \"participantesCurso\",\n"
			+ " dc.metodologia_curso as \"metodologiaCurso\",\n"
			+ " dc.syllabus_curso as \"syllabusCurso\",\n"
			+ " dc.instructor_curso as \"instructor_curso\",\n"
			+ " det.duracion_curso as \"duracionCurso\",\n"
			+ " det.horarios_curso as \"horariosCurso\",\n"
			+ " det.fecha_inscripcion_curso as \"fechaInscripcionCurso\",\n"
			+ " det.numero_participantes as \"numeroParticipantes\",\n"
			+ " det.costo as \"costo\",\n"
			+ " det.membresiaAnual as \"membresiaAnual\" \n"
			+ " from curso c \n"
			+ " inner join datos_curso dc on dc.curso_id=c.curso_id  \n"
			+ " inner join detalles_curso det on det.curso_id=c.curso_id \n"
			+ " where c.key_curso = :keyCurso and c.status='A'";
	
	
	
	@Override
	public List<CursoDto> findCursosByCode(String code) {
		LOGGER.info("Finding cursos presenciales");

		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("code", code);

        List<CursoDto> searchResults = jdbcTemplate.query(SEARCH_CURSOS_BY_CODE,
                queryParams,
                new BeanPropertyRowMapper<>(CursoDto.class)
        );
        LOGGER.info("Found {} cursos presenciales", searchResults.size());

        return searchResults;
	}


	@Override
	public CursoDto getDatosCurso(String keyCurso) {
	
		LOGGER.info("Finding curso, datos, detalles dado el keyCurso = " + keyCurso);

		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("keyCurso", keyCurso);

	    List<CursoDto> searchResults = jdbcTemplate.query(SEARCH_DATOS_CURSO_BY_KEY_CURSO,
                queryParams,
                new BeanPropertyRowMapper<>(CursoDto.class)
        );
        LOGGER.info("Found {} datos para el curso ", searchResults.size());


        if (searchResults.size() > 0) {
            return searchResults.get(0);
        }
        
        return null;
	}


	@Override
	public List<CursoDto> findCursosDestacados(String code) {
		LOGGER.info("Finding cursos presenciales destacados");

		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("code", code);

        List<CursoDto> searchResults = jdbcTemplate.query(SEARCH_CURSOS_DESTACADOS_BY_CODE,
                queryParams,
                new BeanPropertyRowMapper<>(CursoDto.class)
        );
        LOGGER.info("Found {} cursos presenciales destacados", searchResults.size());

        return searchResults;
	}



}
