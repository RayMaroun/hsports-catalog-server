package io.swagger.api;

import io.swagger.model.InlineResponse500;
import io.swagger.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-31T00:41:04.542Z[GMT]")
@RestController
public class ProductsApiController implements ProductsApi {

    private static final Logger log = LoggerFactory.getLogger(ProductsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private ProductService productService;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Product>> productsGet(@Parameter(in = ParameterIn.QUERY, description = "Page number to return" ,schema=@Schema()) @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber, @Max(100) @Parameter(in = ParameterIn.QUERY, description = "Number of results in the page" ,schema=@Schema(allowableValues={  }, maximum="100"
    )) @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<Product>>(this.productService.getProducts(), HttpStatus.OK);
    }

    public ResponseEntity<Void> productsPost(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody Product body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Product> productsProductIdGet(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("productId") Integer productId,@Parameter(in = ParameterIn.HEADER, description = "" ,schema=@Schema()) @RequestHeader(value="customer-security-header", required=false) Integer customerSecurityHeader) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Product>(this.productService.getProduct(productId), HttpStatus.OK);
    }

}
