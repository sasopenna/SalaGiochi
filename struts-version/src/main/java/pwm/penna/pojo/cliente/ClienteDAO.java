package pwm.penna.pojo.cliente;

import java.util.List;

public interface ClienteDAO {
	public Cliente getCliente(int c);
	public List<Cliente> getLista();
	public List<Integer> getListaNotSoci();
	public Cliente creaCliente();
	public void loadRichieste(Cliente c);
}
