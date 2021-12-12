package vn.techmaster.shopingcart.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductReq {

    @Size(min = 3, max = 250, message = "{name_size_between_3_250}")
    private String name;

    @NotBlank(message = "{manufacturer_not_blank}")
    private String manufacturer;

    @NotNull(message = "{price_not_null}")
    private long price;

    private MultipartFile imageRequest;
}
