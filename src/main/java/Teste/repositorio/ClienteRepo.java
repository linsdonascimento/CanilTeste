package Teste.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import app.id.model.Cliente;
import app.id.model.dao.ClienteDAO;

public class ClienteRepo implements ClienteDAO<Cliente>{
	
	private static AtomicInteger serial = new AtomicInteger(0);
	private static List<Cliente> clientes = new ArrayList<Cliente>();
	
	@Override
	public Cliente inserir(Cliente t) {
		t.setIdCli(serial.incrementAndGet());
		clientes.add(t);
		return t;
	}

	public static List<Cliente> getClientes() {
		return clientes;
	}

	public static void setClientes(List<Cliente> clientes) {
		ClienteRepo.clientes = clientes;
	}

	@Override
	public void alterar(Cliente t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente recuperar(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Integer t) {
		Cliente achou = null;
		for(Cliente c : clientes){
			if(c.getIdCli() == t){
				achou = c;
				break;
			}
		}
		clientes.remove(achou);
	}

	public int total(){
		return clientes.size();
	}

	@Override
	public List<Cliente> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterarSenha(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

}
