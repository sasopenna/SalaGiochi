package pwm.penna.salagiochi.form.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import pwm.penna.salagiochi.form.dto.ClienteForm;
import pwm.penna.salagiochi.model.cliente.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteForm toForm(Cliente entity);

    Cliente toEntity(ClienteForm form);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromForm(ClienteForm form, @MappingTarget Cliente entity);
}
