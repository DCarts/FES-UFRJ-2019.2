package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import database.Conexao;

public class Disciplina {

  public String descricao;
  public String nome;

  public Disciplina(ResultSet rs) throws SQLException {
    try {
      this.nome = rs.getString("nome");
      this.descricao = rs.getString("descricao");

    } catch (SQLException e) {
      e.printStackTrace();
      throw new SQLException(e);
    }
  }

  public Disciplina(String nome, String descricao) {
    this.nome = nome;
    this.descricao = descricao;
  }

  public String toString() {
    return this.nome;
  }

  public boolean save() throws SQLException {
    Connection conn = Conexao.getConnection();
    PreparedStatement statement = conn.prepareStatement("INSERT INTO disciplina (nome, descricao) VALUES (?, ?)");
    statement.setString(1, this.nome);
    statement.setString(2, this.descricao);
    boolean executed = statement.execute();
    statement.close();

    conn.close();
    return executed;
  }

  public boolean update() throws SQLException {
    Connection conn = Conexao.getConnection();
    PreparedStatement statement = conn.prepareStatement("UPDATE disciplina SET descricao = ? WHERE nome=?");
    statement.setString(1, this.descricao);
    statement.setString(2, this.nome);
    boolean executed = statement.execute();
    statement.close();
    conn.close();
    return executed;
  }

  public boolean delete() throws SQLException {
    Connection conn = Conexao.getConnection();
    PreparedStatement statement = conn.prepareStatement("DELETE FROM disciplina WHERE nome=?");
    statement.setString(1, this.nome);

    boolean executed = statement.execute();
    statement.close();
    conn.close();
    return executed;
  }

  public static ArrayList<Disciplina> all() throws SQLException {
    ArrayList<Disciplina> result = new ArrayList<Disciplina>();
    Connection conn = Conexao.getConnection();
    PreparedStatement statement = conn.prepareStatement("SELECT * FROM disciplina");
    ResultSet rs = statement.executeQuery();

    while(rs.next()) {
      result.add(new Disciplina(rs));
    }
    return result;
  }

  public static Disciplina findById(String nome) throws SQLException {
    Connection conn = Conexao.getConnection();
    PreparedStatement statement = conn.prepareStatement("SELECT * FROM disciplina WHERE nome=?");
    statement.setString(1, nome);
    ResultSet rs = statement.executeQuery();
    if (rs.first()) {
      return new Disciplina(rs);
    }
    return null;
  }
}