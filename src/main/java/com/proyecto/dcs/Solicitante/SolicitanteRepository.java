package com.proyecto.dcs.Solicitante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository
public class SolicitanteRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Solicitante soli) {
        return jdbcTemplate.update(
                "insert into solicitante (nombre,correo,autoBuscado,dineroEntregado,estadoSolicitud,fechaSolicitud) values(?,?,?,?,?,?)",
                soli.getNombre(), soli.getCorreo(),soli.getAutoBuscado(),soli.getDineroEntregado(),soli.getEstadoSolicitud(), soli.getFechaSolicitud());
    }

    public Solicitante findBySoliId(Long id) {

        String sql = "SELECT * FROM SOLICITANTE WHERE ID = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new SolicitanteRowMapper());

    }

    public void updateSolicitante(Solicitante soli){
        String sql = "UPDATE  SOLICITANTE SET estadoSolicitud = '" +soli.getEstadoSolicitud()+ "' WHERE ID = "+ soli.getId();
        jdbcTemplate.execute(sql);

    }


    public List<Solicitante> findAll() {

        String sql = "SELECT * FROM SOLICITANTE";

        List<Solicitante> solis = new ArrayList<>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map row : rows) {
            Solicitante obj = new Solicitante();

            obj.setId(((Integer) row.get("ID")).longValue());
            obj.setNombre((String) row.get("NOMBRE"));
            obj.setCorreo(((String) row.get("CORREO")));
            obj.setAutoBuscado(((String) row.get("AUTOBUSCADO")));
            obj.setDineroEntregado(((String) row.get("DINEROENTREGADO")));
            obj.setEstadoSolicitud((String) row.get("ESTADOSOLICITUD"));
            obj.setFechaSolicitud(((Timestamp) row.get("FECHASOLICITUD")).toLocalDateTime());

            solis.add(obj);
        }

        return solis;
    }





}
