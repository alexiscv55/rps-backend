package rockpaperscissors.app.dto.mapper;

import rockpaperscissors.app.dto.ResultResponse;
import rockpaperscissors.domain.model.Result;

/**
 * Map enums between app and domain layer.
 * 
 * For current implementation we assume enums will hold same values between layers.
 * Probably change implementation if complexity increases.
 */
public class ResultMapper {
    public static ResultResponse to(Result result) {
        return ResultResponse.valueOf(result.name());
    }
}
