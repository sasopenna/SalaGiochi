package pwm.penna.salagiochi.form.mapper;

import org.mapstruct.*;
import pwm.penna.salagiochi.form.dto.DirigenteForm;
import pwm.penna.salagiochi.form.mapper.base.BaseMapper;
import pwm.penna.salagiochi.model.dirigente.Dirigente;

@Mapper(componentModel = "spring", uses = {DipendenteMapper.class})
public interface DirigenteMapper extends BaseMapper<Dirigente, DirigenteForm> {

    @Mapping(source = "sale", target = "saleGiochi")
    DirigenteForm toForm(Dirigente dirigente);

    @Mapping(source = "saleGiochi", target = "sale")
    Dirigente toEntity(DirigenteForm form);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "saleGiochi", target = "sale")
    void updateEntityFromForm(DirigenteForm form, @MappingTarget Dirigente dirigente);
}