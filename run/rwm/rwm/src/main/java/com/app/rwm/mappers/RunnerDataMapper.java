package com.app.rwm.mappers;

import java.util.Collection;

import com.app.rwm.dto.InjuryDTO;
import com.app.rwm.dto.RunnerDataDTO;
import com.app.rwm.model.RunnerData;

public class RunnerDataMapper {

	public static RunnerDataDTO toDTO(RunnerData runnerData) {
		Collection<InjuryDTO> injuries;
		return new RunnerDataDTO(runnerData.getId(),runnerData.getYears(), runnerData.getHeight(),runnerData.getWeight(),
				runnerData.getGender(),runnerData.getPhysicalFitness(), null, runnerData.getDistance());
	}
	
	public static RunnerData toRunnerData(RunnerDataDTO runnerDataDTO) {
		return new RunnerData(runnerDataDTO.getId(), runnerDataDTO.getYears(), runnerDataDTO.getHeight(), runnerDataDTO.getWeight(),
				runnerDataDTO.getGender(), runnerDataDTO.getPhysicalFitness(), null, false, runnerDataDTO.getDistance());
	}
}
