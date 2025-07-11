package mx.com.santander.hexagonalmodularmaven.venta.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.venta.adapter.mapper.VentaCreateReqToCommandMapper;
import mx.com.santander.hexagonalmodularmaven.venta.adapter.mapper.mappermanual.ManualVentaMapper;
import mx.com.santander.hexagonalmodularmaven.venta.command.VentaCreateHandler;
import mx.com.santander.hexagonalmodularmaven.venta.model.dto.VentaDto;
import mx.com.santander.hexagonalmodularmaven.venta.model.dto.command.VentaCreateCommand;
import mx.com.santander.hexagonalmodularmaven.venta.rest.controller.dto.VentaCreateRequest;


@RestController
@RequestMapping("/ventas")
@RequiredArgsConstructor
public class VentaCommandController {

    private final VentaCreateHandler ventaCreateHandler;
    private final VentaCreateReqToCommandMapper ventaCreateReqToCommandMapper;
    private final ManualVentaMapper manualVentaMapper; 

    @PostMapping()
    public ResponseEntity<VentaDto> createVenta(@Valid @RequestBody VentaCreateRequest request) {
       VentaCreateCommand command = manualVentaMapper.toCommand(request);
       return new ResponseEntity<>(ventaCreateHandler.execute(command), HttpStatus.CREATED);
    }
    


}
