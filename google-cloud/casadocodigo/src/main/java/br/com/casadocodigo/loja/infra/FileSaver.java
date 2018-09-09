package br.com.casadocodigo.loja.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.PredefinedAcl;
import com.google.cloud.storage.StorageOptions;

@Component
public class FileSaver {

	/*@Autowired
	private HttpServletRequest request;*/
	
	private static Storage storage = StorageOptions.getDefaultInstance().getService();

	public String write(MultipartFile file) {
		try {
			/*File arquivo = new File(request.getServletContext().getRealPath(
					"/resources/imagens"), file.getOriginalFilename());
			file.transferTo(arquivo);
			
			return file.getOriginalFilename();*/
			
			BlobInfo blobInfo = storage.create(BlobInfo.newBuilder("xxxx",
                    file.getOriginalFilename()).build(),
                    file.getBytes(),
            BlobTargetOption.predefinedAcl(PredefinedAcl.PUBLIC_READ));
			
			return blobInfo.getMediaLink();
			
		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}









