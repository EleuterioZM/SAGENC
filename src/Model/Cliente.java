package Model;

/**
 *
 * @author Eleuterio_Mabecuane
 */
public class Cliente {

    private String nome;
    private int id;
    private String email;
    private String telefone;
    private String genero;
       private String imagem;

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", id=" + id + ", email=" + email + ", telefone=" + telefone + ", genero=" + genero + ", imagem=" + imagem + '}';
    }
       
       
       
    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
