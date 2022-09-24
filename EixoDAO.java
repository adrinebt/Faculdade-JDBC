package br.ifam.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.ifam.model.bean.Eixo;

public class EixoDAO {
	
	private Connection conexao;

	public EixoDAO(Connection conexao) {
		this.conexao=conexao;
	}

	
	public boolean cadastrar (Eixo eixo)throws SQLException{
		String SQL="INSERT INTO eixo (codigo,nome,tipo,turma,observacao,curso) values (?,?,?,?,?,?)";
		PreparedStatement pstmt = conexao.prepareStatement(SQL) ; 
		pstmt.setLong(1, eixo.getCodigo());
		pstmt.setString(2, eixo.getNome());
		pstmt.setString(3, eixo.getTipo());
		pstmt.setString(4, eixo.getTurma());
		pstmt.setString(5, eixo.getObservacao());
		pstmt.setString(6, eixo.getCurso());
		
		boolean x =pstmt.execute();
		pstmt.close(); 
		return !x;
	}
	
	public Eixo editar (Eixo eixo)throws SQLException{
			String SQL = "UPDATE eixo SET nome = ?,tipo = ?,turma = ?,observacao = ?,curso = ? WHERE codigo = ?";  
			PreparedStatement pstmt = conexao.prepareStatement(SQL) ; 
			pstmt.setString(1, eixo.getNome());
			pstmt.setString(2, eixo.getTipo());
			pstmt.setString(3, eixo.getTurma());
			pstmt.setString(4, eixo.getObservacao());
			pstmt.setString(5, eixo.getCurso());
			pstmt.setLong(6, eixo.getCodigo());
			pstmt.executeUpdate(); //pega todos os dados e atualiza 
			pstmt.close();
			return null; 	
	}
	
	public Eixo buscar (Long codigo)throws SQLException{
		Eixo eixoRetorno = null;
		String SQL = "SELECT * FROM eixo WHERE codigo = ?";
		PreparedStatement stmt = conexao.prepareStatement(SQL); 
		stmt.setLong(1, codigo); 
		ResultSet rs = stmt.executeQuery(); 		   
		if (rs.next()) {  
			eixoRetorno = new Eixo();  
			eixoRetorno.setCodigo(rs.getLong("codigo")); 
			eixoRetorno.setNome(rs.getString("nome"));
			eixoRetorno.setTipo("tipo");
			eixoRetorno.setTurma("turma");
			eixoRetorno.setObservacao(rs.getString("observacao"));
			eixoRetorno.setCurso(rs.getString("curso"));
		} 
		rs.close(); 
		stmt.close(); 
		return eixoRetorno;
	}		
	
	public boolean excluir (Eixo eixo)throws SQLException{
		String SQL = "DELETE FROM eixo WHERE codigo = ?"; 
		PreparedStatement pstmt = conexao.prepareStatement(SQL) ; 
		pstmt.setLong(1, eixo.getCodigo());
		pstmt.executeUpdate(); 
		pstmt.close();
		
		
		boolean x =pstmt.execute();
		pstmt.close(); 
		return !x;
	}
	
	public List<Eixo> listar()throws SQLException{
			List<Eixo> listEixo = new ArrayList<Eixo>(); 
			String SQL = "SELECT * FROM eixo"; 
			PreparedStatement stmt = conexao.prepareStatement(SQL);
			ResultSet rs = stmt.executeQuery(); 
			while (rs.next()) {  
				Eixo eixo = new Eixo();  
				eixo.setCodigo(rs.getLong("codigo")); 
				eixo.setNome(rs.getString("nome"));
				eixo.setTipo(rs.getString("tipo"));
				eixo.setTurma(rs.getString("turma"));
				eixo.setObservacao(rs.getString("observacao"));
				eixo.setCurso(rs.getString("curso"));
				listEixo.add(eixo); //add na lista para exibir todos depois
			}  
			rs.close(); 
			stmt.close();
			return listEixo; 
	}

}
