package co.javiermantilla.pgp;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.javiermantilla.pgp.services.IPGPServices;

@SpringBootApplication
public class CertificadoPgpApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(CertificadoPgpApplication.class);
	
	@Autowired
	private IPGPServices pgpServices;
	 
	public static void main(String[] args) {
		SpringApplication.run(CertificadoPgpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		LOG.info("EXECUTING : command line runner");
		this.pgpServices.cifrarPGP();
		this.pgpServices.desCifrarPGP();
		
	}

}
