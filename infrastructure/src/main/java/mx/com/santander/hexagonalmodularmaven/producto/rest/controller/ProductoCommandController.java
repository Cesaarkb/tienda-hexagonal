package mx.com.santander.hexagonalmodularmaven.producto.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.adapter.mapper.ProductoCreateReqToCommandMapper;
import mx.com.santander.hexagonalmodularmaven.producto.adapter.mapper.ProductoUpdateReqToCommandMapper;
import mx.com.santander.hexagonalmodularmaven.producto.command.ProductoCreateHandler;
import mx.com.santander.hexagonalmodularmaven.producto.command.ProductoDeleteHandler;
import mx.com.santander.hexagonalmodularmaven.producto.command.ProductoUpdateHandler;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.ProductoDto;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.command.ProductoCreateCommand;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.command.ProductoUpdateCommand;
import mx.com.santander.hexagonalmodularmaven.producto.rest.controller.dto.ProductoCreateRequest;
import mx.com.santander.hexagonalmodularmaven.producto.rest.controller.dto.ProductoUpdateRequest;


@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoCommandController {

    private final ProductoCreateHandler productoCreateHandler;
    private final ProductoUpdateHandler productoUpdateHandler;
    private final ProductoDeleteHandler productoDeleteHandler;
    private final ProductoCreateReqToCommandMapper productoCreateReqToCommandMapper;
    private final ProductoUpdateReqToCommandMapper productoUpdateReqToCommandMapper;


    @PostMapping()
    public ResponseEntity<ProductoDto> createProducto(@Valid @RequestBody ProductoCreateRequest request) {
        ProductoCreateCommand command = productoCreateReqToCommandMapper.command(request);
        return new ResponseEntity<>(productoCreateHandler.execute(command), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> updateProducto(@Valid @RequestBody ProductoUpdateRequest request,
    		@PathVariable ("id") Long id){
    	ProductoUpdateCommand command = productoUpdateReqToCommandMapper.command(request);
    	command.setId(id);
    	return ResponseEntity.ok(productoUpdateHandler.execute(command));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable("id") Long id){
    	if(productoDeleteHandler.execute(id)) {
    		return ResponseEntity.noContent().build();
    	}
    	return ResponseEntity.badRequest().build();
    }

}
