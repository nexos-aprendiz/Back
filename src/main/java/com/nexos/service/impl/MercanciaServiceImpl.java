package com.nexos.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.nexos.constants.Constants;
import com.nexos.domain.AuditoriaSitioWebDTO;
import com.nexos.model.Empleado;
import com.nexos.repository.AuditoriaSitioWebRepository;
import com.nexos.repository.EmpleadoRepository;
import com.nexos.translator.TranslateAuditoriaSitioWeb;
import com.nexos.translator.TranslateMercancia;
import com.nexos.translator.TranslateMercanciaDTO;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.domain.MercanciaDTO;
import com.nexos.model.Mercancia;
import com.nexos.repository.MercanciaRepository;
import com.nexos.service.MercanciaService;

@Log4j2
@Service
@Transactional
public class MercanciaServiceImpl implements MercanciaService {

  @Autowired
  private TranslateMercancia translateMercancia;
  
  @Autowired
  private TranslateMercanciaDTO translateMercanciaDTO;

  @Autowired
  private TranslateAuditoriaSitioWeb translateAuditoriaSitioWeb;

  @Autowired
  private MercanciaRepository mercanciaRepository;

  @Autowired
  private EmpleadoRepository empleadoRepository;

  @Autowired
  private AuditoriaSitioWebRepository auditoriaSitioWebRepository;

  @Override
  public Mercancia create(Mercancia mercancia) {
    return mercanciaRepository.save(mercancia);
  }

  @Override
  public List<Mercancia> findAll() {
    return mercanciaRepository.findAll();
  }

  @Override
  public List<Mercancia> getAllMercancia() {
    return mercanciaRepository.findAll();
  }

  @Override
  public Optional<Mercancia> findById(Long id) {
    return mercanciaRepository.findById(id);
  }

  @Override
  public List<Mercancia> findByNombre(String nombre) {
    return mercanciaRepository.findByNombreContainingIgnoreCase(nombre);
  }

  @Override
  public Boolean deleteById(Long id) {
    if (mercanciaRepository.existsById(id)) {
      mercanciaRepository.deleteById(id);
      return true;
    }
    return false;
  }

  @Override
  public void delete(Mercancia entity) {
    mercanciaRepository.delete(entity);
  }
    
  @Override
  public MercanciaDTO save(MercanciaDTO mercanciaDto) {
    Mercancia mercanciaIsExist = mercanciaRepository.findByNombre(mercanciaDto.getNombre());
    if (mercanciaIsExist == null) {
        log.info("El nombre de la mercancía no existe, se puede crear");

      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      LocalDate now = LocalDate.now();
      mercanciaDto.setFecha_ingreso(dtf.format(now));
      Optional<Empleado> empleado = empleadoRepository.findById(mercanciaDto.getId_empleado());
     // Optional<Empleado> empleado = empleadoRepository.findById(mercanciaDto.getId_empleado().getId());
      auditoriaSitioWebRepository.save(
          translateAuditoriaSitioWeb
              .translate(AuditoriaSitioWebDTO
                  .builder()
                  .id(null)
                  .nombre_mercancia(mercanciaDto.getNombre())
                  .nombre_empleado(empleado.isPresent() ? empleado.get().getNombre() : "N/A")
                  .operacion(Constants.CREATED)
                  .fecha(now)
                  .build()
              )
      );
      return translateMercanciaDTO.translate(mercanciaRepository.save(translateMercancia.translate(mercanciaDto)));
    } else {
        log.info("El nombre de la mercancía existe, NO se puede crear");
      return null;
    }
  }

  @Override
  public MercanciaDTO updateMercanciaDTO (MercanciaDTO mercanciaDTO) {
    Optional<Mercancia> mercancia = this.mercanciaRepository.findById(mercanciaDTO.getId());
    if (mercancia.get().getId_empleado().equals(mercanciaDTO.getId_empleado())) {
      mercanciaDTO.setId_empleado(mercanciaDTO.getId_empleado());
      log.info("El usuario tiene permisos para editar este objeto");

      mercanciaDTO.setNombre(mercanciaDTO.getNombre());
      mercanciaDTO.setCantidad(mercanciaDTO.getCantidad());
      LocalDate now = LocalDate.now();
      mercanciaDTO.getFecha_modificacion();
      //Optional<Empleado> empleado = empleadoRepository.findById(mercanciaDTO.getId_empleado().getId());
      Optional<Empleado> empleado = empleadoRepository.findById(mercanciaDTO.getId_empleado());
      auditoriaSitioWebRepository.save(
          translateAuditoriaSitioWeb
              .translate(AuditoriaSitioWebDTO
                  .builder()
                  .id(null)
                  .nombre_mercancia(mercanciaDTO.getNombre())
                  .nombre_empleado(empleado.isPresent() ? empleado.get().getNombre() : "N/A")
                  .operacion(Constants.UPTADE)
                  .fecha(now)
                  .build()
              )
      );
      return translateMercanciaDTO.translate(mercanciaRepository.save(translateMercancia.translate(mercanciaDTO)));
    } else {
        log.info("El usuario NO tiene permisos para editar este objeto");
    return null;
    }
  }
  @Override
  public void deleteById(long id, Long id_empleado) {
    Optional<Mercancia> mercancia = mercanciaRepository.findById(id);
    Optional<Empleado> empleado = empleadoRepository.findById(id_empleado);
    if (mercancia.isPresent()) {
      if (mercancia.get().getId_empleado().equals(id_empleado)) {
        LocalDate now = LocalDate.now();
        
        log.info("El usuario tiene permisos para borrar este objeto");
        mercanciaRepository.deleteById(id);
        auditoriaSitioWebRepository.save(
            translateAuditoriaSitioWeb
                .translate(AuditoriaSitioWebDTO
                    .builder()
                    .id(null)
                    .nombre_mercancia(mercancia.get().getNombre())
                    .nombre_empleado(empleado.isPresent() ? empleado.get().getNombre() : "N/A")
                    .operacion(Constants.DELETE)
                    .fecha(now)
                    .build()
                )
        );
      } else {
          log.info("El usuario NO tiene permisos para borrar este objeto");
      }
    } else {
        log.info("No existe");
    }
  }
}