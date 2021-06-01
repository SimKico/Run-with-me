package com.app.rwm.mappers;

import java.util.Collection;

import com.app.rwm.dto.BasicRunnerDataDTO;
import com.app.rwm.dto.InjuryDTO;
import com.app.rwm.enums.GENDER;
import com.app.rwm.model.RunnerData;

public class BasicRunnerDataMapper {
	public static BasicRunnerDataDTO toDTO(RunnerData runnerData) {
		Collection<InjuryDTO> injuries;
		return new BasicRunnerDataDTO(runnerData.getYears(), runnerData.getHeight(),runnerData.getWeight(),
				runnerData.getGender());
	}
	
	public static RunnerData toRunnerData(BasicRunnerDataDTO runnerDataDTO) {
		return new RunnerData(runnerDataDTO.getYears(), runnerDataDTO.getHeight(), runnerDataDTO.getWeight(),
				runnerDataDTO.getGender());
	}
}
