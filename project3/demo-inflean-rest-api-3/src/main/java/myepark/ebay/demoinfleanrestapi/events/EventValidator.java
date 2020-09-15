package myepark.ebay.demoinfleanrestapi.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;

@Component
public class EventValidator {

    // reject() : field 에러에 들어가게 된다.
    // rejectValue() : global 에러에 들어가게 된다.

    public void validate(EventDto eventDto, Errors errors) {
        if(eventDto.getBasePrice() > eventDto.getMaxPrice() && eventDto.getMaxPrice() != 0) {
            errors.reject("wrongPrices", "Values for Prices are wrong.");
        }

        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();
        if(endEventDateTime.isBefore(eventDto.getBeginEventDateTime()) ||
                endEventDateTime.isBefore(eventDto.getCloseEnrollmentDateTime()) ||
                endEventDateTime.isBefore(eventDto.getBeginEnrollmentDateTime())) {
            errors.rejectValue("endEventDateTime", "wrongValue", "endEventDateTime is wrong.");
        }

        LocalDateTime beginEventDateTime = eventDto.getBeginEventDateTime();
        if(beginEventDateTime.isBefore(eventDto.getEndEventDateTime()) ||
                beginEventDateTime.isBefore(eventDto.getCloseEnrollmentDateTime())) {
            errors.rejectValue("beginEventDateTime", "wrongValue", "beginEventDateTime is wrong.");
        }

        LocalDateTime closeEnrollmentDateTime = eventDto.getCloseEnrollmentDateTime();
        if(closeEnrollmentDateTime.isBefore(eventDto.getBeginEnrollmentDateTime()) ||
                closeEnrollmentDateTime.isBefore(eventDto.getBeginEventDateTime())) {
            errors.rejectValue("closeEnrollmentDateTime", "wrongValue", "closeEnrollmentDateTime is wrong.");
        }

    }
}

