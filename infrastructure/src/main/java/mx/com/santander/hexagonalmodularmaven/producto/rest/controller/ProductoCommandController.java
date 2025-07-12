package mx.com.santander.hexagonalmodularmaven.producto.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.adapter.mapper.ProductoCreateReqToCommandMapper;
import mx.com.santander.hexagonalmodularmaven.producto.command.ProductoCreateHandler;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.ProductoDto;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.command.ProductoCreateCommand;
import mx.com.santander.hexagonalmodularmaven.producto.rest.controller.dto.ProductoCreateRequest;


@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoCommandController {

    private final ProductoCreateHandler productoCreateHandler;
    private final ProductoCreateReqToCommandMapper productoCreateReqToCommandMapper;


    @PostMapping()
    public ResponseEntity<ProductoDto> createProducto(@Valid @RequestBody ProductoCreateRequest request) {
        ProductoCreateCommand command = productoCreateReqToCommandMapper.command(request);
        return new ResponseEntity<>(productoCreateHandler.execute(command), HttpStatus.CREATED);
    }

}
