package br.una.veiculos.resource.excepetions;

import java.io.Serializable;
import java.time.LocalDate;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer status;
	private String msg;
	private LocalDate dataHora;


	public StandardError(Integer status, String msg, LocalDate dataHora) {
		this.status = status;
		this.msg = msg;
		this.dataHora = dataHora;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public LocalDate getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDate dataHora) {
		this.dataHora = dataHora;
	}
	

}
