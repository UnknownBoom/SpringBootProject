package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class Specification_furniture_Ids  implements Serializable {


    private Product_types product_type;


    private Furniture_types furniture;

}
