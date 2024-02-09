package DAO;

import Model.Cliente;
import Utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteDAO {
    private Connection connection = Conexao.getConexao();

    public void save(Cliente cliente) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO clientes (nome, id, email, telefone, genero, imagem) VALUES (?,?,?,?,?,?)");
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getId());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getTelefone());
            ps.setString(5, cliente.getGenero());
            ps.setString(6, cliente.getImagem());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Cliente cliente) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE clientes SET nome=?, email=?, telefone=?, genero=?, imagem=? WHERE id=?");
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getGenero());
            ps.setString(5, cliente.getImagem());
            ps.setInt(6, cliente.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM clientes WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente getById(int id) {
        Cliente cliente = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM clientes WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setGenero(rs.getString("genero"));
                cliente.setImagem(rs.getString("imagem"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    public List<Cliente> getAll() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM clientes");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setGenero(rs.getString("genero"));
                cliente.setImagem(rs.getString("imagem"));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
}
