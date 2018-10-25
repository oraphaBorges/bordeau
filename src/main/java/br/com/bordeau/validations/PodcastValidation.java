package br.com.bordeau.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.bordeau.trash.Podcast;

public class PodcastValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Podcast.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		String required = "field.required";
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"titulo", required);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"descricao", required);
	}

}
