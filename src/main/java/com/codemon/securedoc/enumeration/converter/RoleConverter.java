package com.codemon.securedoc.enumeration.converter;
import com.codemon.securedoc.enumeration.Authority;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;

/*
    * This class will convert the role to the string and vice versa
 */
@Converter(autoApply = true) // This will make sure to automatically run this converter when loading this class
public class RoleConverter implements AttributeConverter<Authority, String> {

    @Override
    public String convertToDatabaseColumn(Authority authority) {
        if(authority == null){
            return null;

        }
        return authority.getValue();
    }

    @Override
    public Authority convertToEntityAttribute(String code) {
       if (code == null) {
            return null;
        }
        return Stream.of(Authority.values())
                .filter(authority -> authority.getValue().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
