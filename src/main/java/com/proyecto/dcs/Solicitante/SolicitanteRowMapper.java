package com.proyecto.dcs.Solicitante;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SolicitanteRowMapper implements RowMapper<Solicitante> {

    @Override
    public Solicitante mapRow(ResultSet rs, int rowNum) throws SQLException {

        Solicitante soli = new Solicitante();
        soli.setId(rs.getLong("ID"));
        soli.setNombre(rs.getString("NOMBRE"));
        soli.setCorreo(rs.getString("CORREO"));
        soli.setAutoBuscado(rs.getString("AUTOBUSCADO"));
        soli.setEstadoSolicitud(rs.getString("ESTADOSOLICITUD"));
        soli.setDineroEntregado(rs.getString("DINEROENTREGADO"));
        soli.setFechaSolicitud(rs.getTimestamp("FECHASOLICITUD").toLocalDateTime());


        return soli;

    }
}
