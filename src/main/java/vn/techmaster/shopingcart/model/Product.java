package vn.techmaster.shopingcart.model;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Product")
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with", toBuilder = true)
public class Product implements Serializable{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_product")
  private long id;

  @Column(name = "name_product")
  private String name;

  @Column(name = "manufacturer_product")
  private String manufacturer;

  @Column(name = "price_product")
  private long price;

  @Column(name = "photo_product")
  private String photo;

  @Column(name = "image_product")
  @Lob
  private byte[] image;

  @Transient
  private String base64Img;

  public void convertByteArrToBase64() throws UnsupportedEncodingException{
    this.setBase64Img(new String(Base64.getEncoder().encode(this.getImage()), "UTF-8"));
  };
  
}
