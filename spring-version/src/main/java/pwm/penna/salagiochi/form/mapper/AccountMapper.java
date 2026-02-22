package pwm.penna.salagiochi.form.mapper;

import org.mapstruct.*;
import pwm.penna.salagiochi.form.dto.AccountForm;
import pwm.penna.salagiochi.form.mapper.base.BaseMapper;
import pwm.penna.salagiochi.model.account.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper extends BaseMapper<Account, AccountForm> {

    @Override
    AccountForm toForm(Account account);

    @Override
    @Mapping(target = "profilo", ignore = true)
    Account toEntity(AccountForm form);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "profilo", ignore = true)
    void updateEntityFromForm(AccountForm form, @MappingTarget Account account);
}
