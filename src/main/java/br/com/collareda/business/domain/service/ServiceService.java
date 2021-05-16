package br.com.collareda.business.domain.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.collareda.business.domain.exception.NegocioException;
import br.com.collareda.business.domain.model.PartnerEntity;
import br.com.collareda.business.domain.model.ServiceBranchEntity;
import br.com.collareda.business.domain.model.ServiceEntity;
import br.com.collareda.business.domain.repository.ServiceBranchRepository;
import br.com.collareda.business.domain.repository.ServiceRepository;
import br.com.collareda.business.domain.util.GenerateGUIDFile;
import br.com.collareda.business.jwt.JwtTokenUtil;

@Service
public class ServiceService {
	private static final Logger log = LoggerFactory.getLogger(ServiceService.class);

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private ServiceBranchRepository serviceBranchRepository;

	@Autowired
	private AmazonS3Service amazonService;

	@Autowired
	private JwtTokenUtil jwt;

	public ServiceEntity createService(ServiceEntity service, String token) throws NegocioException {
		serviceIsValid(service);

		service.setPartner(new PartnerEntity());
		service.getPartner().setId(jwt.getPartnerID(token));
		service.setCreateDate(LocalDateTime.now());
		service.setIdUserCreate(jwt.getUserID(token));
		ServiceEntity serviceReturn = serviceRepository.saveAndFlush(service);
		
		for (ServiceBranchEntity branchEntity : service.getBranchs()) {
			branchEntity.setIdService(service.getId());
			serviceBranchRepository.updateIdService(branchEntity.getIdService() , branchEntity.getId());
		}

		return serviceReturn;
	}

	private String verifyImage(MultipartFile multipartfile, Long partnerId) throws IOException {
		if (multipartfile == null || multipartfile.getInputStream() == null) {
			throw new NegocioException("A Imagem está nula");
		}
		String nameFile = GenerateGUIDFile.generateImageId(partnerId);
		String[] fileFrags = multipartfile.getOriginalFilename().split("\\.");
		amazonService.putObjectAmazon(nameFile + "." + fileFrags[1], multipartfile.getInputStream());

		return nameFile + "." + fileFrags[1];
	}

	public void serviceIsValid(ServiceEntity service) throws NegocioException {
		if (service.getBranchs() == null || service.getBranchs().isEmpty()) {
			log.info("O Ramo deve ser informado");
			throw new NegocioException("O Ramo deve ser informado");
		}

		if (service.getPartner() == null || service.getPartner().getId() == null) {
			log.info("O Parceiro deve ser informado");
			throw new NegocioException("O Parceiro deve ser informado");
		}
	}

	public void addImg(MultipartFile file, Long serviceId) {
		try {
			String nameFile = verifyImage(file, serviceId);
			Optional<ServiceEntity> entity = serviceRepository.findById(serviceId);
			if (entity.isPresent()) {
				entity.get().setImgUrl(nameFile);
				serviceRepository.save(entity.get());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
