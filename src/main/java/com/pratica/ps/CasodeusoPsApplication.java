package com.pratica.ps;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pratica.ps.domain.Categoria;
import com.pratica.ps.domain.Cidade;
import com.pratica.ps.domain.Cliente;
import com.pratica.ps.domain.Endereco;
import com.pratica.ps.domain.Estado;
import com.pratica.ps.domain.Produto;
import com.pratica.ps.domain.enums.TipoCliente;
import com.pratica.ps.repositories.CategoriaRepositoriry;
import com.pratica.ps.repositories.CidadeRepository;
import com.pratica.ps.repositories.ClienteRepository;
import com.pratica.ps.repositories.EnderecoRepository;
import com.pratica.ps.repositories.EstadoRepository;
import com.pratica.ps.repositories.ProdutoRepository;

@SpringBootApplication
public class CasodeusoPsApplication implements CommandLineRunner{
	@Autowired
	private CategoriaRepositoriry categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	public static void main(String[] args) {
		SpringApplication.run(CasodeusoPsApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null,"Impresora", 800.00);
		Produto p3 = new Produto(null,"Computador", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategoria().addAll(Arrays.asList(cat1));
		p2.getCategoria().addAll(Arrays.asList(cat1,cat2));
		p3.getCategoria().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlandia", est1);
		Cidade c2 = new Cidade(null,"São Paulo", est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidade().addAll(Arrays.asList(c1));
		est2.getCidade().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","36378912377",TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323","92838993"));
		
		Endereco e1 = new Endereco(null,"Rua FLores","300","Apto 303", "Jardis","38220834",cli1,c1);
		Endereco e2 = new Endereco(null, "Avenida Matos","105","sala 800", "Centro","38220834",cli1,c2);
		
		cli1.getEndereco().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}

}
