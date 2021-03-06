package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.domain.Fornecedores;
import javax.annotation.PostConstruct;

@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {
	private ListDataModel<Fornecedores> itens;
//GET e SET de itens
	public ListDataModel<Fornecedores> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Fornecedores> itens) {
		this.itens = itens;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			
			ArrayList<Fornecedores>lista = fdao.listar();
			itens = new ListDataModel<Fornecedores>(lista);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		}
	} 

