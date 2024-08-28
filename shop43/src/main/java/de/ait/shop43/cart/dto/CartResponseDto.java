package de.ait.shop43.cart.dto;

import de.ait.shop43.product.dto.ResponseProductDTO;
import lombok.*;

import java.util.List;
@RequiredArgsConstructor

@Data
@Getter
@Setter
public class CartResponseDto {
    private Long id;
    private List<ResponseProductDTO> products;

}
