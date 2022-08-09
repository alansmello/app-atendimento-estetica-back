package com.estetica.atendimento.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Image {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
    @Lob
	private byte[] dados;
    
	private String tipo;
	
	private String name;

    @OneToOne()
	private Attendance attendance;


    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
    
    

    public byte[] getDados() {
        return this.dados;
    }

    public void setDados(byte[] dados) {
      this.dados = dados;
    }

    public Attendance getAttendance() {
        return this.attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

	public Image() {
		super();
	}

	public Image(Integer id, byte[] dados, String tipo, String name, Attendance attendance) {
		super();
		this.id = id;
		this.dados = dados;
		this.tipo = tipo;
		this.name = name;
		this.attendance = attendance;
	}
    
    

    
}
