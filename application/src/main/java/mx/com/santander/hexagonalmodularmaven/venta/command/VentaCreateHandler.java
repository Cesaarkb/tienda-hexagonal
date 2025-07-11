package mx.com.santander.hexagonalmodularmaven.venta.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.venta.mapper.ManualDomToDtoMapper;
import mx.com.santander.hexagonalmodularmaven.venta.model.dto.VentaDto;
import mx.com.santander.hexagonalmodularmaven.venta.model.dto.command.VentaCreateCommand;
import mx.com.santander.hexagonalmodularmaven.venta.service.VentaCreateService;

@RequiredArgsConstructor
@Component
public class VentaCreateHandler {

    private final VentaCreateService ventaCreateService;
    private final ManualDomToDtoMapper manualDomToDtoMapper;

    public VentaDto execute(VentaCreateCommand command){

        return manualDomToDtoMapper.toDto(ventaCreateService.execute(command));
        
    }



}
