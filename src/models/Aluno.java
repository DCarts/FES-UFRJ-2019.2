package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import database.Conexao;

public class Aluno {

  public String nome;
  public String cpf;
  public String email;
  public String endereco;
  public Date data_nascimento;

  public Aluno(ResultSet rs) throws SQLException {
    try {
      this.nome = rs.getString("nome");
      this.cpf = rs.getString("cpf");
      this.email = rs.getString("email");
      this.endereco = rs.getString("endereco");
      this.data_nascimento = rs.getDate("data_nascimento");

    } catch (SQLException e) {
      e.printStackTrace();
      throw new SQLException(e);
    }
  }

  public Aluno(String nome, String cpf, String email, String endereco, Date data_nascimento) {
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
    this.endereco = endereco;
    this.data_nascimento = data_nascimento;
  }

  public String toString() {
    return this.nome;
  }

  public boolean save() throws SQLException {
    Connection conn = Conexao.getConnection();
    PreparedStatement statement = conn.prepareStatement("INSERT INTO pessoa (nome, cpf, email, endereco, data_nascimento) VALUES (?, ?, ?, ?, ?)");
    statement.setString(1, this.nome);
    statement.setString(2, this.cpf);
    statement.setString(3, this.email);
    statement.setString(4, this.endereco);
    statement.setDate(5, this.data_nascimento);
    boolean executed = statement.execute();
    statement.close();

    PreparedStatement statement2 = conn.prepareStatement("SELECT id FROM pessoa WHERE cpf = ?");
    statement2.setString(1, this.cpf);
    ResultSet rs = statement2.executeQuery();

    if (rs.next()) {
      long id = rs.getLong(1);
      PreparedStatement statement3 = conn.prepareStatement("INSERT INTO aluno VALUES (?)");
      statement3.setLong(1, id);
      statement3.execute();
      statement3.close();
    }
    statement2.close();

    conn.close();
    return executed;
  }

  public boolean update() throws SQLException {
    Connection conn = Conexao.getConnection();
    PreparedStatement statement = conn.prepareStatement("UPDATE pessoa SET nome = ?, email = ?, endereco = ?, data_nascimento = ? WHERE cpf=?");
    statement.setString(1, this.nome);
    statement.setString(2, this.email);
    statement.setString(3, this.endereco);
    statement.setDate(4, this.data_nascimento);
    statement.setString(5, this.cpf);
    boolean executed = statement.execute();
    statement.close();
    conn.close();
    return executed;
  }

  public boolean delete() throws SQLException {
    Connection conn = Conexao.getConnection();
    PreparedStatement statement = conn.prepareStatement("DELETE FROM pessoa WHERE cpf=?");
    statement.setString(1, this.cpf);

    boolean executed = statement.execute();
    statement.close();
    conn.close();
    return executed;
  }

  public static ArrayList<Aluno> all() throws SQLException {
    ArrayList<Aluno> result = new ArrayList<Aluno>();
    Connection conn = Conexao.getConnection();
    PreparedStatement statement = conn.prepareStatement("SELECT * FROM pessoa");
    ResultSet rs = statement.executeQuery();

    while(rs.next()) {
      result.add(new Aluno(rs));
    }
    return result;
  }

  public static Aluno findById(String cpf) throws SQLException {
    Connection conn = Conexao.getConnection();
    PreparedStatement statement = conn.prepareStatement("SELECT * FROM pessoa WHERE cpf=?");
    statement.setString(1, cpf);
    ResultSet rs = statement.executeQuery();
    if (rs.first()) {
      return new Aluno(rs);
    }
    return null;
  }
}