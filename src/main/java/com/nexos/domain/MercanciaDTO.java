package com.nexos.domain;

//import com.nexos.model.Empleado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MercanciaDTO {
	
	private Long Id;
	private String nombre;
	private String cantidad;
	private String fecha_ingreso;
	private Long id_empleado;
	//private Empleado id_empleado;
	private String fecha_modificacion;

}
