package br.ufpr.ees2019.ees2019api.converter;

public interface Convertable<TDomain, TDto> {
	TDomain convertToDomain(TDto dto);
	TDto convertToDto(TDomain entity);
}
