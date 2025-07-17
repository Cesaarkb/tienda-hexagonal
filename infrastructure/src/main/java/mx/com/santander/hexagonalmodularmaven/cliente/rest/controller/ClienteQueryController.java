package mx.com.santander.hexagonalmodularmaven.cliente.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.ClienteDto;
import mx.com.santander.hexagonalmodularmaven.cliente.query.ClienteByIdHandler;
import mx.com.santander.hexagonalmodularmaven.cliente.query.ClienteGetAllHandler;


@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteQueryController {

    private final ClienteByIdHandler clienteByIdHandler;
    private final ClienteGetAllHandler clienteGetAllHandler;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable("id") Long  id) {
        return ResponseEntity.ok(clienteByIdHandler.execute(id));
    }
    
    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAllClientes(){
    	return ResponseEntity.ok(clienteGetAllHandler.execute());
    }

}
