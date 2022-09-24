package br.ifam.controller;

import java.util.List;
import br.ifam.model.DAO.EixoDAO;
import br.ifam.model.bean.Eixo;
import java.sql.Connection;
import java.sql.SQLException;



public class ControleEixo{
	private EixoDAO eixoDAO;
	
	public  ControleEixo(Connection conexao){
		eixoDAO = new EixoDAO(conexao);
	}
	
	public boolean cadastrar (Eixo eixo) throws SQLException{
		return eixoDAO.cadastrar(eixo);
	}
	public Eixo editar (Eixo eixo)throws SQLException{
		return eixoDAO.editar(eixo);
	}
	public Eixo buscar (
			Long codigo)throws SQLException{
		return eixoDAO.buscar(codigo);
	}
	public boolean excluir (Eixo eixo)throws SQLException{
		return eixoDAO.excluir(eixo);
	}
	public List<Eixo> listar()throws SQLException{
		return eixoDAO.listar();
	}
}
