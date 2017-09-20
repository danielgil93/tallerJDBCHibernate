package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCApplication {

	public static void main(String[] args) {
		System.out.println("-------- Test de conexión con MySQL ------------");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver en el Classpath");
			e.printStackTrace();
			return;
		}

		System.out.println("Driver instalado y funcionando");
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic","root", "Everis2017");
			if (connection != null)
				System.out.println("Conexión establecida");
			
			/*Consulta 1*/
			/*
			statement = connection.createStatement();
			String sql = "SELECT * FROM owners";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
			         int id = rs.getInt("id");
			         String firstName = rs.getString("first_name");
			         String lastName = rs.getString("last_name");
			         String address = rs.getString("address");
			         String city = rs.getString("city");
			         String telephone = rs.getString("telephone");
			         
			         System.out.print("Id: " + id);
			         System.out.print(", Nombre: " + firstName);
			         System.out.print(", Apellidos: " + lastName);
			         System.out.print(", Dirección: " + address);
			         System.out.print(", Ciudad: " + city);
			         System.out.println(", Teléfono: " + telephone);
			         
			}
			rs.close();
			*/
			
			/*Consulta 2*/
			/*
			statement = connection.createStatement();
			//String sql = "INSERT IGNORE INTO owners VALUES ('11', 'Daniel', 'Gil', 'Avenida Santa Marta', 'Huelva', '657123456');";
			String sql = "insert into owners (first_name, last_name, address, city, telephone) values ('Daniel', 'Gil', 'Avenida Santa Marta', 'Huelva', '657123456')";
			statement.executeUpdate(sql);
			*/
			
			/*Consulta 3*/
			/*
			statement = connection.createStatement();
			String sql = "UPDATE owners SET city = 'Sevilla' WHERE first_name = 'Daniel' AND last_name = 'Gil'";
			statement.executeUpdate(sql);
			*/
			
			/*Consulta 4*/
			/*
			String cadena="an";
			String sql = "SELECT * FROM owners WHERE first_name LIKE ? OR last_name LIKE ?";
			String termino = "%" + cadena + "%";
			preparedStatement statment = connection.prepareStatement(sql);
			statement.setString(1,termino);
			statement.setString(2,termino);
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
			         int id = rs.getInt("id");
			         String firstName = rs.getString("first_name");
			         String lastName = rs.getString("last_name");
			         String address = rs.getString("address");
			         String city = rs.getString("city");
			         String telephone = rs.getString("telephone");
			         
			         System.out.print("Id: " + id);
			         System.out.print(", Nombre: " + firstName);
			         System.out.print(", Apellidos: " + lastName);
			         System.out.print(", Dirección: " + address);
			         System.out.print(", Ciudad: " + city);
			         System.out.println(", Teléfono: " + telephone);
			         
			}
			rs.close();
			*/
			
			/*Consulta 5*/
			/*
			String[] valores;
			valores = new String[] {"Marcos", "Ginel", "Mi casa", "Sevilla", "666666666"};
			String sql = "INSERT INTO owners (first_name, last_name, address, city, telephone)  VALUES(?,?,?,?,?)";

			preparedStatement = connection.prepareStatement(sql);
			for(int i=0; i < valores.length; i++)
			   preparedStatement.setString(i+1, valores[i]);

			int numeroDeFilasModificadas = preparedStatement.executeUpdate();
			*/
			
			
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(statement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}
	}

}
