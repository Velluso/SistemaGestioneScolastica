package gq.velluso.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "materie")
public class Materie {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;


    @Column(name = "materia")
    private String materia;


   // @Column(name = "")

}
