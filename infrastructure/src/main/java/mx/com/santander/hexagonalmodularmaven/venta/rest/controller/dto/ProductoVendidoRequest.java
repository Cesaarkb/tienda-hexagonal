/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mx.com.santander.hexagonalmodularmaven.venta.rest.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoVendidoRequest {

    @NotNull(message = "El ID es obligatorio")
    private Long idProducto;
    @NotNull(message="La cantidad no puede estar vacia")
    @Min(value=1, message="La cantidad debe ser mínimo de 1")
    private Integer cantidad;


}                                                                                                                                      
