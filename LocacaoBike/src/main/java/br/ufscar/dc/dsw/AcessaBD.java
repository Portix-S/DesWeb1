package br.ufscar.dc.dsw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AcessaBD {

	public static void main(String[] args) {
		try {

			/* Setup para uso do banco de dados MySQL */
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/LocacaoBike";
			Connection con = (Connection) DriverManager.getConnection(url,
					"root", "Naoki678");

			/* Setup para uso do banco de dados Apache Derby */

			/*
			 * Class.forName("org.apache.derby.jdbc.ClientDriver");
             * String url = "jdbc:derby://localhost:1527/LocacaoBike";
			 * Connection con = (Connection) DriverManager.getConnection(url, 
			 *         "root", "root");
			 */

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from CLIENTE");
			while (rs.next()) {
				System.out.print(rs.getString("CPF"));
				System.out.print(", " + rs.getString("nome"));
				System.out.print(", " + rs.getInt("sexo"));
				System.out.println(", " + rs.getFloat("data_nascimento"));
			}
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("A classe do driver de conexão não foi encontrada!");
		} catch (SQLException e) {
			System.out.println("O comando SQL não pode ser executado!");
		}
	}
}