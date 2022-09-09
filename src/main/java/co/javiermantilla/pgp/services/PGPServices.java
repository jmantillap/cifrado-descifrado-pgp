package co.javiermantilla.pgp.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.javiermantilla.pgp.utils.PGPFileProcessor;

@Service
public class PGPServices implements IPGPServices {

	
	private static Logger LOG = LoggerFactory.getLogger(PGPServices.class);
	
	@Autowired
	private PGPFileProcessor fileProcessor;
	
	@Value("${rutaCertificado}")
	private String rutaCertificado;
	
	@Value("${rutaLlavePrivada}")
	private String rutaLlavePrivada;
	
	@Value("${claveCertificado}")
	private String claveCertificado;
	
	@Value("${rutaFilePrueba}")
	private String rutaFilePrueba;
	
	@Value("${archivoCifrado}")
	private String archivoCifrado;
	
	@Value("${archivoDesCifrado}")
	private String archivoDesCifrado;

	@Override
	public void cifrarPGP() {
		try {			
			fileProcessor.encrypt(this.rutaCertificado,this.rutaFilePrueba,this.archivoCifrado);
            LOG.info("El archivo se cifro-->"+ this.archivoCifrado);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
	}

	@Override
	public void desCifrarPGP() {
		try {         
			fileProcessor.decrypt(this.rutaLlavePrivada,this.claveCertificado,this.archivoCifrado,this.archivoDesCifrado);
			LOG.info("El archivo se desencripto-->"+this.archivoDesCifrado);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	 
}
