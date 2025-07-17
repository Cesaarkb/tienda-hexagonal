package mx.com.santander.hexagonalmodularmaven.producto.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.model.dto.ProductoDto;
import mx.com.santander.hexagonalmodularmaven.producto.query.ProductoByIdHandler;
import mx.com.santander.hexagonalmodularmaven.producto.query.ProductoGetAllHandler;


@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoQueryController {

private final ProductoByIdHandler productoByIdHandler;
private final ProductoGetAllHandler productoGetAllHandler;

@GetMapping("/{id}")
public ResponseEntity<ProductoDto> getProductoById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(productoByIdHandler.execute(id));
}

@GetMapping
public ResponseEntity<List<ProductoDto>> getallProduct(){
	return ResponseEntity.ok(productoGetAllHandler.execute());
}


}
    