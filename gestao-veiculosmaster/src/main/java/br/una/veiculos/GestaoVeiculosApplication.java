package br.una.veiculos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.una.veiculos.model.AnimalEstimacao;
import br.una.veiculos.model.Cidade;
import br.una.veiculos.model.Condominio;
import br.una.veiculos.model.Endereco;
import br.una.veiculos.model.Estado;
import br.una.veiculos.model.Morador;
import br.una.veiculos.model.UnidadeHabitacional;
import br.una.veiculos.model.Usuario;
import br.una.veiculos.model.Veiculo;
import br.una.veiculos.repository.AnimalEstimacaoRepository;
import br.una.veiculos.repository.CidadeRepository;
import br.una.veiculos.repository.CondominioRepository;
import br.una.veiculos.repository.EnderecoRepository;
import br.una.veiculos.repository.EstadoRepository;
import br.una.veiculos.repository.MoradorRepository;
import br.una.veiculos.repository.UnidadeHabitacionalRepository;
import br.una.veiculos.repository.VeiculoRepository;

@SpringBootApplication
public class GestaoVeiculosApplication implements CommandLineRunner {

	@Autowired
	private VeiculoRepository veiculoRepo;
	@Autowired
	private EstadoRepository estadoRepo;
	@Autowired
	private CidadeRepository cidadeRepo;
	@Autowired
	private AnimalEstimacaoRepository animaisRepo;
	@Autowired
	private CondominioRepository condominiosRepo;
	@Autowired
	private EnderecoRepository enderecoRepo;
	@Autowired
	private MoradorRepository moradorRepo;
	@Autowired
	private UnidadeHabitacionalRepository unidadeHabRepo;
	

	public static void main(String[] args) {
		SpringApplication.run(GestaoVeiculosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		
		Estado est1 = new Estado(1L, "MG");
		Estado est2 = new Estado(2L, "GO");
		estadoRepo.saveAll(Arrays.asList(est1, est2));
		
		Cidade c1 = new Cidade(1L, "Uberlândia", est1);
		Cidade c2 = new Cidade(2L, "Araguari", est1);
		Cidade c3 = new Cidade(3L, "Caldas Novas", est2);
		Cidade c4 = new Cidade(4L, "Catalão", est2);
		
		cidadeRepo.saveAll(Arrays.asList(c1, c2, c3, c4));
		
		Endereco end1 = new Endereco(1L, "Rua Quintino Bocaiuva", 234, "Casa1", "Centro", "38405-234", c1);
		end1 = enderecoRepo.save(end1);
		
		Condominio cond1 = new Condominio (1L, "Parque dos Ipês", false, end1);
		condominiosRepo.save(cond1);	
				
		String t1 =  "34 99586-5674";
		String t2 =  "11 4858-4573";
		String t3 =  "11 98675-2345";		
		
		List<String> listaTelefones = new ArrayList<String>();
		listaTelefones.add(t1);
		listaTelefones.add(t2);
		listaTelefones.add(t3);
		
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
		df.setLenient (false);
		
		Date data = df.parse("12/12/1984");
		
		UnidadeHabitacional un1 =  new UnidadeHabitacional(1L, "AP103", "A9", true);
		unidadeHabRepo.save(un1);
		
		List<UnidadeHabitacional> unidades = new ArrayList<>();
		unidades.add(un1);

		Morador m2 = new Morador(2L, "gulima", "Thxe3458frm", false, false, "Gustavo Lima", "245.786.123-09", data,  listaTelefones, cond1,  unidades);
		m2 = moradorRepo.save(m2);
		
		Veiculo vei1 = new Veiculo(1L, "HPG-0272", "Sandero", "Renault", "2014", m2);
		Veiculo vei2 = new Veiculo(2L, "OTG-7854", "Hornet", "Honda", "2018", m2);
		veiculoRepo.saveAll(Arrays.asList(vei1, vei2));
				
        df.setLenient (false);		
		data = df.parse("05/05/2018");
		
		AnimalEstimacao an1 = new AnimalEstimacao(1L, "Chester", "Pug", "Pequeno",  data, m2);
		
		df.setLenient (false);		
		data = df.parse("12/04/2018");
		
	    AnimalEstimacao an2 = new AnimalEstimacao(2L, "Rex", "Pintcher","Pequeno", data, m2);
		animaisRepo.saveAll(Arrays.asList(an1, an2));	
		
	}

}
