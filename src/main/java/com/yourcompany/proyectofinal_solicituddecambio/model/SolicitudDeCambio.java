package com.yourcompany.proyectofinal_solicituddecambio.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

enum Prioridad {
    ALTO("Alto"),
    MEDIO("Medio"),
    BAJO("Bajo");

    private final String nombre;

    private Prioridad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

enum TipoRequ {
    CAMBIOS_DEL_SISTEMA("Cambio del sistema"),
    MEJORAS_AL_SISTEMA("Mejoras al sistema"),
    CONSULTAS_O_REPORTES("Consultas o reportes"),
	CASOS_DE_ERROR("Casos de error"),
	APROBAR_SOFTWARE_DE_TERCEROS("Aprobar software de terceros");
	
    private final String nombre;

    private TipoRequ(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudDeCambio {

	@Id
	@Required
    private String numeroRFC;

    @ManyToOne
    @Required
    private Usuario solicitante;
    @Required
    private String departamento;
    
    @ManyToOne
    @Required
    private Usuario  aprobador;
    
    @ManyToOne
    @Required
    private SistemaInformatico sistemaInformaticoAfectado;
    
    @Stereotype("TEXT_AREA")
    @Required
    private String descripcionDelRequerimiento;
    
    @Stereotype("TEXT_AREA")
    @Required
    private String beneficiosEsperados;
    
    @Enumerated(EnumType.STRING)
    @Required
    private TipoRequ tipoDeRequerimientos;
    
    @Required
    private Prioridad prioridad;
    
    @Stereotype("TEXT_AREA")
    @Required
    private String impactoEnCasoDeNoAtenderElCambio;
    
    @Stereotype("FILE")
    private byte[] documentoAdjunto;


    
    

}

