package co.javiermantilla.pgp.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.springframework.stereotype.Component;

@Component
public class PGPFileProcessor {
	
	
    private boolean asciiArmored = false;

    private boolean integrityCheck = true;
    
    
    public boolean encrypt(String keyFile,String inputFile,String outputFile) throws Exception {
        FileInputStream keyIn = new FileInputStream(getClass().getResource(keyFile).getFile());        
        //String rutaFileOut=getClass().getResource("/").getPath().concat(outputFile);
        //String rutaFileIn=getClass().getResource("/").getPath().concat(inputFile);
        FileOutputStream out = new FileOutputStream(outputFile);
        
        PGPUtil.encryptFile(out, inputFile, PGPUtil.readPublicKey(keyIn),asciiArmored, integrityCheck);
        out.close();
        keyIn.close();
        return true;
    }

    public boolean decrypt(String rutaLlavePrivada,String claveCertificado,String archivoCifrado,String archivoDescifrado ) throws Exception {    	
    	  FileInputStream in = new FileInputStream(archivoCifrado);
    	  FileInputStream keyIn = new FileInputStream(getClass().getResource(rutaLlavePrivada).getFile());
          FileOutputStream out = new FileOutputStream(archivoDescifrado);
          PGPUtil.decryptFile(in, out, keyIn, claveCertificado.toCharArray());
          in.close();
          out.close();
          keyIn.close();
          return true;
    }

    public boolean isAsciiArmored() {
        return asciiArmored;
    }

    public void setAsciiArmored(boolean asciiArmored) {
        this.asciiArmored = asciiArmored;
    }

    public boolean isIntegrityCheck() {
        return integrityCheck;
    }

    public void setIntegrityCheck(boolean integrityCheck) {
        this.integrityCheck = integrityCheck;
    }

  

   
}
