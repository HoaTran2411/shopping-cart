package vn.techmaster.shopingcart.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import vn.techmaster.shopingcart.model.CreateProductReq;
import vn.techmaster.shopingcart.model.Product;
import vn.techmaster.shopingcart.service.CartService;
import vn.techmaster.shopingcart.service.ProductService;

@Controller
public class ProductController {
  @Autowired
  private ProductService productService;
  @Autowired
  private CartService cartService;

  @Autowired
  private MessageSource messageSource;

  @GetMapping("/")
  public String showHomePage(HttpSession session, Model model) {
    List<Product> listProducts = productService.getAll();
    listProducts.stream().filter(product -> product.getImage() != null).forEach(product -> {
      try {
        product.convertByteArrToBase64();
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }
    });

    model.addAttribute("products", listProducts);
    model.addAttribute("cartCount", cartService.countItemInCart(session));
    return "index";
  }

  @GetMapping("/buy/{id}")
  public String buy(@PathVariable(name = "id") Long id, HttpSession session, Model model) {
    cartService.addToCart(id, session);
    return "redirect:/";
  }

  @GetMapping("/checkout")
  public String checkout(HttpSession session, Model model) {
    model.addAttribute("cart", cartService.getCart(session));
    return "checkout";
  }

  @GetMapping("/upload")
  public String uploadNewProduct(Model model) {
    model.addAttribute("product", new CreateProductReq());
    return "form";
  }

  @PostMapping(value = "/save", consumes = { "multipart/form-data" })
  public String saveNewProduct(@Valid @ModelAttribute("product") CreateProductReq product, BindingResult result,
      Model model) throws IOException {

    Locale locale = LocaleContextHolder.getLocale();

    // xử lý validation với file, thêm đa ngôn ngữ
    if (product.getImageRequest().getOriginalFilename().isEmpty()) {
      result.addError(new FieldError("product", "imageRequest",
          messageSource.getMessage("image.required", null, "Image required", locale)));
    }

    if (result.hasErrors()) {
      return "form";
    }

    productService.createProduct(product);
    return "redirect:/";
  }

}
